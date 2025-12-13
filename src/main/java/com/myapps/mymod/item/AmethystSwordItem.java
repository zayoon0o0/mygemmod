package com.myapps.mymod.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import com.myapps.mymod.procedures.AmethystSwordEntitySwingsItemProcedure;
public class AmethystSwordItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 30, 20f, 0, 30, TagKey.create(Registries.ITEM, ResourceLocation.parse("mymod:amethyst_sword_repair_items")));
	public AmethystSwordItem(Item.Properties properties) {
		super(properties.sword(TOOL_MATERIAL, 11f, 16f));
	}
	@Override
	public void postHurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
		// applies poison 3 effect for 500 ticks
		AmethystSwordEntitySwingsItemProcedure.execute(pTarget);
		super.postHurtEnemy(pStack, pTarget, pAttacker);
	}
}