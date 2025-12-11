/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.myapps.mymod.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;

import com.myapps.mymod.MymodMod;

public class MymodModTabs {
	public static ResourceKey<CreativeModeTab> TAB_RED_GEM_TAB = ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.fromNamespaceAndPath(MymodMod.MODID, "red_gem_tab"));

	public static void load() {
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, TAB_RED_GEM_TAB,
				FabricItemGroup.builder().title(Component.translatable("item_group.mymod.red_gem_tab")).icon(() -> new ItemStack(MymodModItems.RED_GEM_ITEM)).displayItems((parameters, tabData) -> {
					tabData.accept(MymodModBlocks.RED_GEM.asItem());
					tabData.accept(MymodModItems.RED_GEM_ITEM);
					tabData.accept(MymodModItems.GEM_TOOLS_PICKAXE);
					tabData.accept(MymodModItems.GEM_TOOLS_AXE);
					tabData.accept(MymodModItems.GEM_TOOLS_SWORD);
					tabData.accept(MymodModItems.GEM_TOOLS_SHOVEL);
					tabData.accept(MymodModItems.GEM_TOOLS_HOE);
					tabData.accept(MymodModItems.GEM_ARMOR_HELMET);
					tabData.accept(MymodModItems.GEM_ARMOR_CHESTPLATE);
					tabData.accept(MymodModItems.GEM_ARMOR_LEGGINGS);
					tabData.accept(MymodModItems.GEM_ARMOR_BOOTS);
					tabData.accept(MymodModBlocks.BLOCK_OF_RED_GEM.asItem());
					tabData.accept(MymodModItems.AMETHYST_AXE);
					tabData.accept(MymodModItems.AMETHYST_PICKAXE);
					tabData.accept(MymodModItems.AMETHYST_HOE);
					tabData.accept(MymodModItems.AMETHYST_SWORD);

				}).build());
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.NATURAL_BLOCKS).register(tabData -> {
			tabData.accept(MymodModBlocks.RED_GEM.asItem());
		});
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(tabData -> {
			tabData.accept(MymodModItems.RED_GEM_ITEM);
			tabData.accept(MymodModBlocks.BLOCK_OF_RED_GEM.asItem());
		});
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(tabData -> {
			tabData.accept(MymodModItems.GEM_TOOLS_PICKAXE);
			tabData.accept(MymodModItems.GEM_TOOLS_AXE);
			tabData.accept(MymodModItems.GEM_TOOLS_SHOVEL);
			tabData.accept(MymodModItems.GEM_TOOLS_HOE);
			tabData.accept(MymodModItems.AMETHYST_PICKAXE);
			tabData.accept(MymodModItems.AMETHYST_AXE);
			tabData.accept(MymodModItems.AMETHYST_SHOVEL);
			tabData.accept(MymodModItems.AMETHYST_HOE);
		});
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(tabData -> {
			tabData.accept(MymodModItems.GEM_TOOLS_SWORD);
			tabData.accept(MymodModItems.GEM_ARMOR_HELMET);
			tabData.accept(MymodModItems.GEM_ARMOR_CHESTPLATE);
			tabData.accept(MymodModItems.GEM_ARMOR_LEGGINGS);
			tabData.accept(MymodModItems.GEM_ARMOR_BOOTS);
			tabData.accept(MymodModItems.AMYTHEST_ARMOR_HELMET);
			tabData.accept(MymodModItems.AMYTHEST_ARMOR_CHESTPLATE);
			tabData.accept(MymodModItems.AMYTHEST_ARMOR_LEGGINGS);
			tabData.accept(MymodModItems.AMYTHEST_ARMOR_BOOTS);
			tabData.accept(MymodModItems.AMETHYST_SWORD);
		});
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(tabData -> {
			tabData.accept(MymodModBlocks.BLOCK_OF_RED_GEM.asItem());
		});
	}
}