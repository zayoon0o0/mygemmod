package com.myapps.mymod.item;

import net.minecraft.item.Item;
import net.minecraft.util.Rarity;

public class RedGemItemItem extends Item {
	public RedGemItemItem(Item.Settings properties) {
		super(properties.rarity(Rarity.RARE).fireproof());
	}
}