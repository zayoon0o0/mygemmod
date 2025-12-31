package com.myapps.mymod.item;

import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class AmethystAxeItem extends AxeItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 44, 60f, 0, 30, TagKey.of(RegistryKeys.ITEM, Identifier.of("mymod:amethyst_axe_repair_items")));

	public AmethystAxeItem(Item.Settings properties) {
		super(TOOL_MATERIAL, 12f, -3f, properties);
	}
}