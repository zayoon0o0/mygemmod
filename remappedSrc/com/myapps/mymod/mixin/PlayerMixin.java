package com.myapps.mymod.mixin;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Mixin;
import com.myapps.mymod.event.PlayerEvents;
import net.minecraft.entity.player.PlayerEntity;

@Mixin(PlayerEntity.class)
public abstract class PlayerMixin {
	@Inject(method = "giveExperiencePoints", at = @At("HEAD"))
	public void giveExperiencePoints(int amount, CallbackInfo ci) {
		PlayerEvents.XP_CHANGE.invoker().onXpChange((PlayerEntity) (Object) this, amount);
	}
	@Inject(method = "giveExperienceLevels", at = @At("HEAD"))
	public void giveExperienceLevels(int amount, CallbackInfo ci) {
		PlayerEvents.LEVEL_CHANGE.invoker().onLevelChange((PlayerEntity) (Object) this, amount);
	}
}