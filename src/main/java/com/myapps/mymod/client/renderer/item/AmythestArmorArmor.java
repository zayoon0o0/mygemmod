package com.myapps.mymod.client.renderer.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.resources.model.EquipmentClientInfo;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

import com.myapps.mymod.init.MymodModItems;
import com.myapps.mymod.init.MymodModArmorModels;

@Environment(EnvType.CLIENT)
public class AmythestArmorArmor {
	public static void clientLoad() {
		// Armor models are registered but texture handling is done via equipment JSON
		// The mixin will use the default texture paths from the equipment asset
	}
}