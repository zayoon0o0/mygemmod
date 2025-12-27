package com.myapps.mymod.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.AxeItem;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

public class AmethystAxeItem extends AxeItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 44, 60f, 0, 30, TagKey.create(Registries.ITEM, Identifier.parse("mymod:amethyst_axe_repair_items")));

	public AmethystAxeItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 12f, -3f, properties);
	}
}