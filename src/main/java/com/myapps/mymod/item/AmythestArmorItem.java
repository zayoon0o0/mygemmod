package com.myapps.mymod.item;

import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;

import java.util.Map;

public abstract class AmythestArmorItem extends Item {
	public static ArmorMaterial ARMOR_MATERIAL = new ArmorMaterial(1, Map.of(ArmorType.BOOTS, 10, ArmorType.LEGGINGS, 20, ArmorType.CHESTPLATE, 40, ArmorType.HELMET, 10, ArmorType.BODY, 40), 30,
			BuiltInRegistries.SOUND_EVENT.wrapAsHolder(BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.amethyst_block.chime"))), 3f, 0.1f,
			TagKey.create(Registries.ITEM, ResourceLocation.parse("mymod:amythest_armor_repair_items")), ResourceKey.create(EquipmentAssets.ROOT_ID, ResourceLocation.parse("mymod:amythest_armor")));

	private AmythestArmorItem(Item.Properties properties) {
		super(properties);
	}

	public static class Helmet extends AmythestArmorItem {
		public Helmet(Item.Properties properties) {
			super(properties.humanoidArmor(ARMOR_MATERIAL, ArmorType.HELMET));
		}
	}

	public static class Chestplate extends AmythestArmorItem {
		public Chestplate(Item.Properties properties) {
			super(properties.humanoidArmor(ARMOR_MATERIAL, ArmorType.CHESTPLATE));
		}
	}

	public static class Leggings extends AmythestArmorItem {
		public Leggings(Item.Properties properties) {
			super(properties.humanoidArmor(ARMOR_MATERIAL, ArmorType.LEGGINGS));
		}
	}

	public static class Boots extends AmythestArmorItem {
		public Boots(Item.Properties properties) {
			super(properties.humanoidArmor(ARMOR_MATERIAL, ArmorType.BOOTS));
		}
	}
}