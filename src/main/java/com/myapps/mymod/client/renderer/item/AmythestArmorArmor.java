package com.myapps.mymod.client.renderer.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.Identifier;
import net.minecraft.client.resources.model.EquipmentClientInfo;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

import com.myapps.mymod.init.MymodModItems;
import com.myapps.mymod.init.MymodModArmorModels;

@Environment(EnvType.CLIENT)
public class AmythestArmorArmor {
	public static void clientLoad() {
		MymodModArmorModels.ARMOR_MODELS.put(MymodModItems.AMYTHEST_ARMOR_HELMET, new MymodModArmorModels.ArmorModel() {
			@Override
			public Identifier getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, Identifier _default) {
				return Identifier.parse("mymod:textures/models/armor/amethyst_layer_1.png");
			}
		});
		MymodModArmorModels.ARMOR_MODELS.put(MymodModItems.AMYTHEST_ARMOR_CHESTPLATE, new MymodModArmorModels.ArmorModel() {
			@Override
			public Identifier getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, Identifier _default) {
				return Identifier.parse("mymod:textures/models/armor/amethyst_layer_1.png");
			}
		});
		MymodModArmorModels.ARMOR_MODELS.put(MymodModItems.AMYTHEST_ARMOR_LEGGINGS, new MymodModArmorModels.ArmorModel() {
			@Override
			public Identifier getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, Identifier _default) {
				return Identifier.parse("mymod:textures/models/armor/amethyst_layer_2.png");
			}
		});
		MymodModArmorModels.ARMOR_MODELS.put(MymodModItems.AMYTHEST_ARMOR_BOOTS, new MymodModArmorModels.ArmorModel() {
			@Override
			public Identifier getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, Identifier _default) {
				return Identifier.parse("mymod:textures/models/armor/amethyst_layer_1.png");
			}
		});
	}
}