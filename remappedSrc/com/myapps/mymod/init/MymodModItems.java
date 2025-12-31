/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.myapps.mymod.init;

import java.util.function.Function;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import com.myapps.mymod.item.*;
import com.myapps.mymod.MymodMod;

public class MymodModItems {
	public static Item RED_GEM;
	public static Item RED_GEM_ITEM;
	public static Item GEM_TOOLS_PICKAXE;
	public static Item GEM_TOOLS_AXE;
	public static Item GEM_TOOLS_SWORD;
	public static Item GEM_TOOLS_SHOVEL;
	public static Item GEM_TOOLS_HOE;
	public static Item GEM_ARMOR_HELMET;
	public static Item GEM_ARMOR_CHESTPLATE;
	public static Item GEM_ARMOR_LEGGINGS;
	public static Item GEM_ARMOR_BOOTS;
	public static Item BLOCK_OF_RED_GEM;
	public static Item AMYTHEST_ARMOR_HELMET;
	public static Item AMYTHEST_ARMOR_CHESTPLATE;
	public static Item AMYTHEST_ARMOR_LEGGINGS;
	public static Item AMYTHEST_ARMOR_BOOTS;
	public static Item AMETHYST_PICKAXE;
	public static Item AMETHYST_AXE;
	public static Item AMETHYST_SWORD;
	public static Item AMETHYST_SHOVEL;
	public static Item AMETHYST_HOE;

	public static void load() {
		RED_GEM = block(MymodModBlocks.RED_GEM, "red_gem", new Item.Settings().rarity(Rarity.RARE));
		RED_GEM_ITEM = register("red_gem_item", RedGemItemItem::new);
		GEM_TOOLS_PICKAXE = register("gem_tools_pickaxe", Gem_toolsPickaxeItem::new);
		GEM_TOOLS_AXE = register("gem_tools_axe", Gem_toolsAxeItem::new);
		GEM_TOOLS_SWORD = register("gem_tools_sword", Gem_toolsSwordItem::new);
		GEM_TOOLS_SHOVEL = register("gem_tools_shovel", Gem_toolsShovelItem::new);
		GEM_TOOLS_HOE = register("gem_tools_hoe", Gem_toolsHoeItem::new);
		GEM_ARMOR_HELMET = register("gem_armor_helmet", GemArmorItem.Helmet::new);
		GEM_ARMOR_CHESTPLATE = register("gem_armor_chestplate", GemArmorItem.Chestplate::new);
		GEM_ARMOR_LEGGINGS = register("gem_armor_leggings", GemArmorItem.Leggings::new);
		GEM_ARMOR_BOOTS = register("gem_armor_boots", GemArmorItem.Boots::new);
		BLOCK_OF_RED_GEM = block(MymodModBlocks.BLOCK_OF_RED_GEM, "block_of_red_gem", new Item.Settings().rarity(Rarity.EPIC));
		AMYTHEST_ARMOR_HELMET = register("amythest_armor_helmet", AmythestArmorItem.Helmet::new);
		AMYTHEST_ARMOR_CHESTPLATE = register("amythest_armor_chestplate", AmythestArmorItem.Chestplate::new);
		AMYTHEST_ARMOR_LEGGINGS = register("amythest_armor_leggings", AmythestArmorItem.Leggings::new);
		AMYTHEST_ARMOR_BOOTS = register("amythest_armor_boots", AmythestArmorItem.Boots::new);
		AMETHYST_PICKAXE = register("amethyst_pickaxe", AmethystPickaxeItem::new);
		AMETHYST_AXE = register("amethyst_axe", AmethystAxeItem::new);
		AMETHYST_SWORD = register("amethyst_sword", AmethystSwordItem::new);
		AMETHYST_SHOVEL = register("amethyst_shovel", AmethystShovelItem::new);
		AMETHYST_HOE = register("amethyst_hoe", AmethystHoeItem::new);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> I register(String name, Function<Item.Settings, ? extends I> supplier) {
		return (I) Items.register(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MymodMod.MODID, name)), (Function<Item.Settings, Item>) supplier);
	}

	private static Item block(Block block, String name) {
		return block(block, name, new Item.Settings());
	}

	private static Item block(Block block, String name, Item.Settings properties) {
		return Items.register(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MymodMod.MODID, name)), prop -> new BlockItem(block, prop), properties);
	}
}