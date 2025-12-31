package com.myapps.mymod.mixin;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Final;
import net.minecraft.client.model.Model;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.equipment.EquipmentModel;
import net.minecraft.client.render.entity.equipment.EquipmentModelLoader;
import net.minecraft.client.render.entity.equipment.EquipmentRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.DyedColorComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.trim.ArmorTrim;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import java.util.function.Function;
import java.util.List;

import com.myapps.mymod.init.MymodModArmorModels;

@Mixin(EquipmentRenderer.class)
public abstract class EquipmentLayerRendererMixin {
	@Shadow
	@Final
	private EquipmentModelLoader equipmentAssets;
	@Shadow
	@Final
	private Function<EquipmentRenderer.LayerTextureKey, Identifier> layerTextureLookup;
	@Shadow
	@Final
	private Function<EquipmentRenderer.TrimSpriteKey, Sprite> trimSpriteLookup;

	@Shadow
	private static int getColorForLayer(EquipmentModel.Layer layer, int i) {
		return 0;
	}

	@Inject(method = "Lnet/minecraft/client/renderer/entity/layers/EquipmentLayerRenderer;renderLayers(Lnet/minecraft/client/resources/model/EquipmentClientInfo$LayerType;Lnet/minecraft/resources/ResourceKey;Lnet/minecraft/client/model/Model;Lnet/minecraft/world/item/ItemStack;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/resources/Identifier;)V", at = @At("HEAD"), cancellable = true)
	public void renderLayers(EquipmentModel.LayerType layerType, RegistryKey<EquipmentAsset> resourceKey, Model model, ItemStack itemStack, MatrixStack poseStack, VertexConsumerProvider multiBufferSource, int i, Identifier Identifier,
			CallbackInfo ci) {
		if (MymodModArmorModels.ARMOR_MODELS.containsKey(itemStack.getItem())) {
			MymodModArmorModels.ArmorModel armorModel = MymodModArmorModels.ARMOR_MODELS.get(itemStack.getItem());
			if (armorModel.getHumanoidArmorModel(itemStack, layerType, model) != null)
				model = armorModel.getGenericArmorModel(itemStack, layerType, model);
			List<EquipmentModel.Layer> list = this.equipmentAssets.get(resourceKey).getLayers(layerType);
			if (list.isEmpty()) {
				ci.cancel();
			}
			int j = DyedColorComponent.getColor(itemStack, 0);
			boolean bl = itemStack.hasGlint();
			for (EquipmentModel.Layer layer : list) {
				int k = getColorForLayer(layer, j);
				if (k == 0)
					continue;
				Identifier Identifier2 = layer.usePlayerTexture() && Identifier != null ? Identifier : this.layerTextureLookup.apply(new EquipmentRenderer.LayerTextureKey(layerType, layer));
				Identifier2 = armorModel.getArmorTexture(itemStack, layerType, layer, Identifier2);
				VertexConsumer vertexConsumer = ItemRenderer.getArmorGlintConsumer(multiBufferSource, RenderLayer.getArmorCutoutNoCull(Identifier2), bl);
				model.render(poseStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, k);
				bl = false;
			}
			ArmorTrim armorTrim = itemStack.get(DataComponentTypes.TRIM);
			if (armorTrim != null) {
				Sprite textureAtlasSprite = this.trimSpriteLookup.apply(new EquipmentRenderer.TrimSpriteKey(armorTrim, layerType, resourceKey));
				VertexConsumer vertexConsumer2 = textureAtlasSprite.getTextureSpecificVertexConsumer(multiBufferSource.getBuffer(TexturedRenderLayers.getArmorTrims(armorTrim.pattern().value().decal())));
				model.render(poseStack, vertexConsumer2, i, OverlayTexture.DEFAULT_UV);
			}
			ci.cancel();
		}
	}
}