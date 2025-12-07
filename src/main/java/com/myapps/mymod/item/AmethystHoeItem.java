package com.myapps.mymod.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.HoeItem;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class AmethystHoeItem extends HoeItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 44, 50f, 0, 30, TagKey.create(Registries.ITEM, ResourceLocation.parse("mymod:amethyst_hoe_repair_items")));

	public AmethystHoeItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 39f, -3f, properties);
	}
}