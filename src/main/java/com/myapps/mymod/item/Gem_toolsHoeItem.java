package com.myapps.mymod.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.HoeItem;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class Gem_toolsHoeItem extends HoeItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 9900, 300f, 0, 14, TagKey.create(Registries.ITEM, ResourceLocation.parse("mymod:gem_tools_hoe_repair_items")));

	public Gem_toolsHoeItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 3f, -1f, properties);
	}
}