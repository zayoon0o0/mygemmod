package com.myapps.mymod.item;

import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class AmethystPickaxeItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 44, 80f, 0, 30, TagKey.of(RegistryKeys.ITEM, Identifier.of("mymod:amethyst_pickaxe_repair_items")));

	public AmethystPickaxeItem(Item.Settings properties) {
		super(properties.pickaxe(TOOL_MATERIAL, 5f, -3f));
	}
}