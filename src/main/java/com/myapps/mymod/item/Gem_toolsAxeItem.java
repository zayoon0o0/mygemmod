package com.myapps.mymod.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.AxeItem;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class Gem_toolsAxeItem extends AxeItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 9900, 30f, 0, 14, TagKey.create(Registries.ITEM, ResourceLocation.parse("mymod:gem_tools_axe_repair_items")));

	public Gem_toolsAxeItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 59f, -1f, properties);
	}
}