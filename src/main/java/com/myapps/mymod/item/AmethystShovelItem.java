package com.myapps.mymod.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class AmethystShovelItem extends ShovelItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 44, 50f, 0, 30, TagKey.create(Registries.ITEM, ResourceLocation.parse("mymod:amethyst_shovel_repair_items")));

	public AmethystShovelItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 5f, -3f, properties);
	}
}