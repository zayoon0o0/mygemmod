package com.myapps.mymod.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class Gem_toolsSwordItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 9500, 6f, 0, 14, TagKey.create(Registries.ITEM, ResourceLocation.parse("mymod:gem_tools_sword_repair_items")));

	public Gem_toolsSwordItem(Item.Properties properties) {
		super(properties.sword(TOOL_MATERIAL, 59f, -1f));
	}
}