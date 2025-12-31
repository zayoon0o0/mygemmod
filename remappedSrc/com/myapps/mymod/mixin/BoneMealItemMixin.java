package com.myapps.mymod.mixin;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Mixin;
import com.myapps.mymod.event.ItemEvents;
import net.minecraft.entity.Entity;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;

@Mixin(BoneMealItem.class)
public abstract class BoneMealItemMixin {
	@Inject(method = "useOn(Lnet/minecraft/world/item/context/UseOnContext;)Lnet/minecraft/world/InteractionResult;", at = @At("HEAD"), cancellable = true)
	public void useOn(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir) {
		if (context.getWorld() instanceof ServerWorld) {
			boolean result = ItemEvents.BONEMEAL_USED.invoker().onBonemealUsed(context.getBlockPos(), (Entity) context.getPlayer(), context.getStack(), context.getWorld().getBlockState(context.getBlockPos()));
			if (!result)
				cir.setReturnValue(ActionResult.FAIL);
		}
	}
}