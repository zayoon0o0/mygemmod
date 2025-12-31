package com.myapps.mymod.mixin;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Mixin;
import com.myapps.mymod.event.PlayerEvents;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;

@Mixin(ExperienceOrbEntity.class)
public abstract class ExperienceOrbMixin {
	@Inject(method = "playerTouch(Lnet/minecraft/world/entity/player/Player;)V", at = @At("HEAD"), cancellable = true)
	public void playerTouch(PlayerEntity player, CallbackInfo ci) {
		if (player instanceof ServerPlayerEntity serverPlayer)
			if (serverPlayer.experiencePickUpDelay == 0)
				if (!PlayerEvents.PICKUP_XP.invoker().onPickupXp(serverPlayer))
					ci.cancel();
	}
}