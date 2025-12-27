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
            30,
            20f,
            0,
            30,
            TagKey.create(Registries.ITEM, Identifier.parse("mymod:gem_tools_pickaxe_repair_items"))
    );

    public GemSpearItem(Item.Properties properties) {
        super(properties.spear(TOOL_MATERIAL, 2, 100,5,1,4,3,2,30,1));
    }
    @Override
    public void postHurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        super.postHurtEnemy(pStack, pTarget, pAttacker);
    }
}
