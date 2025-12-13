package com.myapps.mymod.client.renderer.item;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

@Environment(EnvType.CLIENT)
public class AmythestArmorArmor {
	public static void clientLoad() {
		// Armor models are registered but texture handling is done via equipment JSON
		// The mixin will use the default texture paths from the equipment asset
	}
}