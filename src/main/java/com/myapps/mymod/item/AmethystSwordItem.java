package com.myapps.mymod.item;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.minecraft.client.renderer.item.properties.numeric.Cooldown;
import net.minecraft.world.item.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;
import com.myapps.mymod.procedures.AmethystSwordEntitySwingsItemProcedure;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.entity.player.Player;



public class AmethystSwordItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(
			BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
			30,
			20f,
			0,
			30,
			TagKey.create(Registries.ITEM, Identifier.parse("mymod:amethyst_sword_repair_items"))
	);

	public AmethystSwordItem(Item.Properties properties) {
		super(properties.sword(TOOL_MATERIAL, 11f, 16f));
	}

	@Override
	public void postHurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
		AmethystSwordEntitySwingsItemProcedure.execute(pTarget);
		super.postHurtEnemy(pStack, pTarget, pAttacker);
	}
}
