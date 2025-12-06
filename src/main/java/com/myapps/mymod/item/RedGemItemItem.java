package com.myapps.mymod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class RedGemItemItem extends Item {
	public RedGemItemItem(Item.Properties properties) {
		super(properties.rarity(Rarity.RARE).fireResistant());
	}
}