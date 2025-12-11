package com.myapps.mymod.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class AmethystSwordItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 30, 20f, 0, 30, TagKey.create(Registries.ITEM, ResourceLocation.parse("mymod:amethyst_sword_repair_items")));

	public AmethystSwordItem(Item.Properties properties) {
		super(properties.sword(TOOL_MATERIAL, 74f, 16f));
	}
}