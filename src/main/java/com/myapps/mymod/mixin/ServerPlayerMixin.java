package com.myapps.mymod.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;

@Mixin(ServerPlayer.class)
public abstract class ServerPlayerMixin {
	@Inject(
			method = "drop(Z)V",
			at = @At("HEAD"),
			cancellable = true
	)
	private void onDrop(boolean dropStack, CallbackInfo ci) {
		ServerPlayer self = (ServerPlayer) (Object) this;
		Inventory inventory = self.getInventory();
		ItemStack itemStack = inventory.removeFromSelected(dropStack);
		self.containerMenu
				.findSlot(inventory, inventory.getSelectedSlot())
				.ifPresent(slot ->
						self.containerMenu.setRemoteSlot(slot, inventory.getSelectedItem())
				);
		if (!itemStack.isEmpty()) {
			self.drop(itemStack, false, true);
		}
		ci.cancel();
	}
}
