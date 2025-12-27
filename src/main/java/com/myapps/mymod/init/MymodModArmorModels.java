package com.myapps.mymod.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.resources.Identifier;
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

		public HumanoidModel<?> getHumanoidArmorModel(ItemStack itemStack, EquipmentClientInfo.LayerType layerType, Model original) {
			return null;
		}

		public Identifier getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, Identifier _default) {
			return null;
		}

	}

	public static void clientLoad() {
		GemArmorArmor.clientLoad();
		AmythestArmorArmor.clientLoad();
	}
}
