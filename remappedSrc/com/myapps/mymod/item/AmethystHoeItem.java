package com.myapps.mymod.item;

import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class AmethystHoeItem extends HoeItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 44, 50f, 0, 30, TagKey.of(RegistryKeys.ITEM, Identifier.of("mymod:amethyst_hoe_repair_items")));

	public AmethystHoeItem(Item.Settings properties) {
		super(TOOL_MATERIAL, 5f, -3f, properties);
	}
}