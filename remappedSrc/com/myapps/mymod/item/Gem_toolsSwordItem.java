package com.myapps.mymod.item;

import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class Gem_toolsSwordItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 9500, 6f, 0, 14, TagKey.of(RegistryKeys.ITEM, Identifier.of("mymod:gem_tools_sword_repair_items")));

	public Gem_toolsSwordItem(Item.Settings properties) {
		super(properties.sword(TOOL_MATERIAL, 8f, -1f));
	}
}