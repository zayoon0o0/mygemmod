package com.myapps.mymod.mixin;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerMixin {
	@Inject(method = "Lnet/minecraft/server/level/ServerPlayer;drop(Z)Z", at = @At("HEAD"), cancellable = true)
	public void drop(boolean dropStack, CallbackInfoReturnable<Boolean> cir) {
		ServerPlayerEntity self = (ServerPlayerEntity) (Object) this;
		PlayerInventory inventory = self.getInventory();
		ItemStack itemstack = inventory.dropSelectedItem(dropStack);
		self.currentScreenHandler.getSlotIndex(inventory, inventory.getSelectedSlot()).ifPresent(p_401732_ -> self.currentScreenHandler.setReceivedStack(p_401732_, inventory.getSelectedStack()));
		cir.setReturnValue(self.dropItem(itemstack, false, true) != null);
	}
}