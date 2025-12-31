package com.myapps.mymod.item;

import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class Gem_toolsHoeItem extends HoeItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 5000, 300f, 0, 14, TagKey.of(RegistryKeys.ITEM, Identifier.of("mymod:gem_tools_hoe_repair_items")));

	public Gem_toolsHoeItem(Item.Settings properties) {
		super(TOOL_MATERIAL, 3f, -1f, properties);
	}
}