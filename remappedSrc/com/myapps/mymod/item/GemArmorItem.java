package com.myapps.mymod.item;

import java.util.Map;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public abstract class GemArmorItem extends Item {
	public static ArmorMaterial ARMOR_MATERIAL = new ArmorMaterial(130, Map.of(EquipmentType.BOOTS, 8, EquipmentType.LEGGINGS, 20, EquipmentType.CHESTPLATE, 50, EquipmentType.HELMET, 18, EquipmentType.BODY, 60), 40,
			Registries.SOUND_EVENT.getEntry(SoundEvents.INTENTIONALLY_EMPTY), 20f, 0f, TagKey.of(RegistryKeys.ITEM, Identifier.of("mymod:gem_armor_repair_items")),
			RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of("mymod:gem_armor")));

	private GemArmorItem(Item.Settings properties) {
		super(properties);
	}

	public static class Helmet extends GemArmorItem {
		public Helmet(Item.Settings properties) {
			super(properties.armor(ARMOR_MATERIAL, EquipmentType.HELMET));
		}
	}

	public static class Chestplate extends GemArmorItem {
		public Chestplate(Item.Settings properties) {
			super(properties.armor(ARMOR_MATERIAL, EquipmentType.CHESTPLATE));
		}
	}

	public static class Leggings extends GemArmorItem {
		public Leggings(Item.Settings properties) {
			super(properties.armor(ARMOR_MATERIAL, EquipmentType.LEGGINGS));
		}
	}

	public static class Boots extends GemArmorItem {
		public Boots(Item.Settings properties) {
			super(properties.armor(ARMOR_MATERIAL, EquipmentType.BOOTS));
		}
	}
}