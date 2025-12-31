package com.myapps.mymod.mixin;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Mixin;
import java.util.ArrayList;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RepairItemRecipe;
import net.minecraft.recipe.input.CraftingRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import com.google.common.collect.Lists;

@Mixin(RepairItemRecipe.class)
public abstract class RepairItemRecipeMixin {
	@Inject(method = "assemble(Lnet/minecraft/world/item/crafting/CraftingInput;Lnet/minecraft/core/HolderLookup$Provider;)Lnet/minecraft/world/item/ItemStack;", at = @At("HEAD"), cancellable = true)
	public void assemble(CraftingRecipeInput craftingInput, RegistryWrapper.WrapperLookup provider, CallbackInfoReturnable<ItemStack> cir) {
		ItemStack itemStack3;
		ItemStack itemStack;
		ArrayList<ItemStack> list = Lists.newArrayList();
		for (int i = 0; i < craftingInput.getStackCount(); ++i) {
			ItemStack itemStack2;
			itemStack = craftingInput.getStackInSlot(i);
			if (itemStack.isEmpty())
				continue;
			list.add(itemStack);
		}
	}
}