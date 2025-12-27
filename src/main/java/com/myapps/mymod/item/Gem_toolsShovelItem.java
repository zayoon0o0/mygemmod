package com.myapps.mymod.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

public class Gem_toolsShovelItem extends ShovelItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 9900, 300f, 0, 14, TagKey.create(Registries.ITEM, Identifier.parse("mymod:gem_tools_shovel_repair_items")));

	public Gem_toolsShovelItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 3f, -2f, properties);
	}
}