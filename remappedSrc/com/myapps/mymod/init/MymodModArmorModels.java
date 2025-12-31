/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.myapps.mymod.init;

import net.minecraft.client.model.Model;
import net.minecraft.client.render.entity.equipment.EquipmentModel;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
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

		public BipedEntityModel getHumanoidArmorModel(ItemStack itemStack, EquipmentModel.LayerType layerType, Model original) {
			return null;
		}

		public Identifier getArmorTexture(ItemStack stack, EquipmentModel.LayerType type, EquipmentModel.Layer layer, Identifier _default) {
			return null;
		}

		public Model getGenericArmorModel(ItemStack itemStack, EquipmentModel.LayerType layerType, Model original) {
			Model replacement = getHumanoidArmorModel(itemStack, layerType, original);
			if (replacement != original) {
				if (original instanceof BipedEntityModel<?> originalHumanoid && replacement instanceof BipedEntityModel<?> replacementHumanoid) {
					originalHumanoid.copyTransforms((BipedEntityModel) replacement);
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