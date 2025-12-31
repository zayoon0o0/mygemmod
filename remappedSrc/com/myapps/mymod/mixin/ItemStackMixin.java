package com.myapps.mymod.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import com.myapps.mymod.event.BlockEvents;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.world.item.*;

@Mixin(net.minecraft.world.item.Item.class)
public abstract class ItemStackMixin {
	@Inject(method = "useOn", at = @At("TAIL"), cancellable = true)
	private void mygemmod$useOn(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir) {
		PlayerEntity player = context.getPlayer();
		if (player == null) return;
		var level = player.getWorld();
		var pos = context.getBlockPos();
		var face = context.getSide();
		var targetPos = pos.offset(face);
		BlockState placedAgainst = level.getBlockState(targetPos);
		if (!level.isAir(targetPos)) {
			boolean allow = BlockEvents.BLOCK_MULTIPLACE.invoker().onMultiplaced(
					targetPos,
					(Entity) player,
					placedAgainst,
					level.getBlockState(pos)
			);
			if (!allow) {
				cir.setReturnValue(ActionResult.FAIL);
			}
		}
	}
}
