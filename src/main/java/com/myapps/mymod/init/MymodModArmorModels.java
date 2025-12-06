/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.myapps.mymod.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.HumanoidModel;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

import java.util.Map;

import it.unimi.dsi.fastutil.objects.Reference2ObjectOpenHashMap;

import com.myapps.mymod.client.renderer.item.GemArmorArmor;
import com.myapps.mymod.client.renderer.item.AmythestArmorArmor;

@Environment(EnvType.CLIENT)
public class MymodModArmorModels {
	public static Map<Item, ArmorModel> ARMOR_MODELS = new Reference2ObjectOpenHashMap<>();

	public static class ArmorModel {
		public ArmorModel() {
		}

		public HumanoidModel getHumanoidArmorModel(ItemStack itemStack, EquipmentClientInfo.LayerType layerType, Model original) {
			return null;
		}

		public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
			return null;
		}

		public Model getGenericArmorModel(ItemStack itemStack, EquipmentClientInfo.LayerType layerType, Model original) {
			Model replacement = getHumanoidArmorModel(itemStack, layerType, original);
			if (replacement != original) {
				if (original instanceof HumanoidModel<?> originalHumanoid && replacement instanceof HumanoidModel<?> replacementHumanoid) {
					originalHumanoid.copyPropertiesTo((HumanoidModel) replacement);
					replacementHumanoid.head.visible = originalHumanoid.head.visible;
					replacementHumanoid.hat.visible = originalHumanoid.hat.visible;
					replacementHumanoid.body.visible = originalHumanoid.body.visible;
					replacementHumanoid.rightArm.visible = originalHumanoid.rightArm.visible;
					replacementHumanoid.leftArm.visible = originalHumanoid.leftArm.visible;
					replacementHumanoid.rightLeg.visible = originalHumanoid.rightLeg.visible;
					replacementHumanoid.leftLeg.visible = originalHumanoid.leftLeg.visible;
				}
				return replacement;
			}
			return original;
		}
	}

	public static void clientLoad() {
		GemArmorArmor.clientLoad();
		AmythestArmorArmor.clientLoad();
	}
}