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
import net.minecraft.util.Identifier;

public abstract class AmythestArmorItem extends Item {
	public static ArmorMaterial ARMOR_MATERIAL = new ArmorMaterial(1, Map.of(EquipmentType.BOOTS, 18, EquipmentType.LEGGINGS, 20, EquipmentType.CHESTPLATE, 55, EquipmentType.HELMET, 20, EquipmentType.BODY, 40), 30,
			Registries.SOUND_EVENT.getEntry(Registries.SOUND_EVENT.get(Identifier.of("block.amethyst_block.chime"))), 3f, 0.1f,
			TagKey.of(RegistryKeys.ITEM, Identifier.of("mymod:amythest_armor_repair_items")), RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of("mymod:amythest_armor")));

	private AmythestArmorItem(Item.Settings properties) {
		super(properties);
	}

	public static class Helmet extends AmythestArmorItem {
		public Helmet(Item.Settings properties) {
			super(properties.armor(ARMOR_MATERIAL, EquipmentType.HELMET));
		}
	}

	public static class Chestplate extends AmythestArmorItem {
		public Chestplate(Item.Settings properties) {
			super(properties.armor(ARMOR_MATERIAL, EquipmentType.CHESTPLATE));
		}
	}

	public static class Leggings extends AmythestArmorItem {
		public Leggings(Item.Settings properties) {
			super(properties.armor(ARMOR_MATERIAL, EquipmentType.LEGGINGS));
		}
	}

	public static class Boots extends AmythestArmorItem {
		public Boots(Item.Settings properties) {
			super(properties.armor(ARMOR_MATERIAL, EquipmentType.BOOTS));
		}
	}
}