package com.myapps.mymod.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import com.myapps.mymod.event.BlockEvents;
import net.minecraft.world.item.*;

@Mixin(Item.class)
public abstract class ItemStackMixin {
	@Inject(method = "useOn", at = @At("TAIL"), cancellable = true)
	private void mygemmod$useOn(UseOnContext context, CallbackInfoReturnable<InteractionResult> cir) {
		Player player = context.getPlayer();
		if (player == null) return;
		var level = player.level();
		var pos = context.getClickedPos();
		var face = context.getClickedFace();
		var targetPos = pos.relative(face);
		BlockState placedAgainst = level.getBlockState(targetPos);
		if (!level.isEmptyBlock(targetPos)) {
			boolean allow = BlockEvents.BLOCK_MULTIPLACE.invoker().onMultiplaced(
					targetPos,
					(Entity) player,
					placedAgainst,
					level.getBlockState(pos)
			);
			if (!allow) {
				cir.setReturnValue(InteractionResult.FAIL);
			}
		}
	}
}
