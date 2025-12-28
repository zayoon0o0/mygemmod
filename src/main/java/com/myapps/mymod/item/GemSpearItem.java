package com.myapps.mymod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;


public class GemSpearItem extends Item {
    private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            5000,
            5f,
            10,
            30,
            TagKey.create(Registries.ITEM, Identifier.parse("mymod:gem_tools_pickaxe_repair_items"))
    );
    public GemSpearItem(Item.Properties properties) {
        super(properties.spear(TOOL_MATERIAL, 0.5f, 10,0.5f,3,4,4,2,7f,0.5f));
    }
    @Override
    public void postHurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        super.postHurtEnemy(pStack, pTarget, pAttacker);
    }
}
