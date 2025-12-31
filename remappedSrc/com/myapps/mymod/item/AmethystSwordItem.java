package com.myapps.mymod.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import com.myapps.mymod.procedures.AmethystSwordEntitySwingsItemProcedure;


public class AmethystSwordItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(
			BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
			30,
			20f,
			0,
			30,
			TagKey.of(RegistryKeys.ITEM, Identifier.of("mymod:amethyst_sword_repair_items"))
	);

	public AmethystSwordItem(Item.Settings properties) {
		super(properties.sword(TOOL_MATERIAL, 11f, 16f));
	}

	@Override
	public void postDamageEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		AmethystSwordEntitySwingsItemProcedure.execute(target);
		if (attacker instanceof PlayerEntity player) {
			player.getItemCooldownManager().set(stack, 600);
		}
		super.postDamageEntity(stack, target, attacker);
	}
}