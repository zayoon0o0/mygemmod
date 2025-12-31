/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.myapps.mymod.init;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;

import com.myapps.mymod.MymodMod;

public class MymodModTabs {
	public static RegistryKey<ItemGroup> TAB_RED_GEM_TAB = RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(MymodMod.MODID, "red_gem_tab"));

	public static void load() {
		Registry.register(Registries.ITEM_GROUP, TAB_RED_GEM_TAB,
				FabricItemGroup.builder().displayName(Text.translatable("item_group.mymod.red_gem_tab")).icon(() -> new ItemStack(MymodModItems.RED_GEM_ITEM)).entries((parameters, tabData) -> {
					tabData.add(MymodModBlocks.RED_GEM.asItem());
					tabData.add(MymodModItems.RED_GEM_ITEM);
					tabData.add(MymodModItems.GEM_TOOLS_PICKAXE);
					tabData.add(MymodModItems.GEM_TOOLS_AXE);
					tabData.add(MymodModItems.GEM_TOOLS_SWORD);
					tabData.add(MymodModItems.GEM_TOOLS_SHOVEL);
					tabData.add(MymodModItems.GEM_TOOLS_HOE);
					tabData.add(MymodModItems.GEM_ARMOR_HELMET);
					tabData.add(MymodModItems.GEM_ARMOR_CHESTPLATE);
					tabData.add(MymodModItems.GEM_ARMOR_LEGGINGS);
					tabData.add(MymodModItems.GEM_ARMOR_BOOTS);
					tabData.add(MymodModBlocks.BLOCK_OF_RED_GEM.asItem());
					tabData.add(MymodModItems.AMETHYST_AXE);
					tabData.add(MymodModItems.AMETHYST_PICKAXE);
					tabData.add(MymodModItems.AMETHYST_HOE);
					tabData.add(MymodModItems.AMETHYST_SWORD);

				}).build());
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(tabData -> {
			tabData.add(MymodModBlocks.RED_GEM.asItem());
		});
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(tabData -> {
			tabData.add(MymodModItems.RED_GEM_ITEM);
			tabData.add(MymodModBlocks.BLOCK_OF_RED_GEM.asItem());
		});
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(tabData -> {
			tabData.add(MymodModItems.GEM_TOOLS_PICKAXE);
			tabData.add(MymodModItems.GEM_TOOLS_AXE);
			tabData.add(MymodModItems.GEM_TOOLS_SHOVEL);
			tabData.add(MymodModItems.GEM_TOOLS_HOE);
			tabData.add(MymodModItems.AMETHYST_PICKAXE);
			tabData.add(MymodModItems.AMETHYST_AXE);
			tabData.add(MymodModItems.AMETHYST_SHOVEL);
			tabData.add(MymodModItems.AMETHYST_HOE);
		});
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(tabData -> {
			tabData.add(MymodModItems.GEM_TOOLS_SWORD);
			tabData.add(MymodModItems.GEM_ARMOR_HELMET);
			tabData.add(MymodModItems.GEM_ARMOR_CHESTPLATE);
			tabData.add(MymodModItems.GEM_ARMOR_LEGGINGS);
			tabData.add(MymodModItems.GEM_ARMOR_BOOTS);
			tabData.add(MymodModItems.AMYTHEST_ARMOR_HELMET);
			tabData.add(MymodModItems.AMYTHEST_ARMOR_CHESTPLATE);
			tabData.add(MymodModItems.AMYTHEST_ARMOR_LEGGINGS);
			tabData.add(MymodModItems.AMYTHEST_ARMOR_BOOTS);
			tabData.add(MymodModItems.AMETHYST_SWORD);
		});
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(tabData -> {
			tabData.add(MymodModBlocks.BLOCK_OF_RED_GEM.asItem());
		});
	}
}