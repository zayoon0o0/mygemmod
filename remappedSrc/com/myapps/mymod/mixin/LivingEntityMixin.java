package com.myapps.mymod.mixin;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Mixin;
import com.myapps.mymod.event.LivingEntityEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.world.GameRules;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
	@Shadow
	protected int lastHurtByPlayerMemoryTime;

	@Shadow
	protected boolean isAlwaysExperienceDropper() {
		return false;
	}

	@Inject(method = "swing(Lnet/minecraft/world/InteractionHand;Z)V", at = @At("HEAD"))
	public void swing(Hand hand, boolean updateSelf, CallbackInfo ci) {
		ItemStack stack = ((LivingEntity) (Object) this).getStackInHand(hand);
		if (!stack.isEmpty()) {
		}
	}

	@Inject(method = "startUsingItem(Lnet/minecraft/world/InteractionHand;)V", at = @At("HEAD"))
	public void startUsingItem(Hand hand, CallbackInfo ci) {
		LivingEntity entity = (LivingEntity) (Object) this;
		ItemStack stack = entity.getStackInHand(hand);
		if (!stack.isEmpty() && !entity.isUsingItem()) {
			LivingEntityEvents.START_USE_ITEM.invoker().onStartUseItem(entity, stack);
		}
	}

	@Inject(method = "heal(F)V", at = @At("HEAD"), cancellable = true)
	public void heal(float amount, CallbackInfo ci) {
		if (!LivingEntityEvents.ENTITY_HEAL.invoker().onEntityHeal((LivingEntity) (Object) this, amount))
			ci.cancel();
	}

	@Inject(method = "applyItemBlocking(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/damagesource/DamageSource;F)F", at = @At("HEAD"), cancellable = true)
	public void applyItemBlocking(ServerWorld serverLevel, DamageSource damageSource, float f, CallbackInfoReturnable<Float> cir) {
		if (!LivingEntityEvents.ENTITY_BLOCK.invoker().onEntityBlock((LivingEntity) (Object) this, damageSource, (double) f))
			cir.cancel();
	}

	@Inject(method = "dropExperience(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/Entity;)V", at = @At("HEAD"), cancellable = true)
	public void dropExperience(ServerWorld serverLevel, Entity entity, CallbackInfo ci) {
		LivingEntity self = (LivingEntity) (Object) this;
		if (!self.isExperienceDroppingDisabled() && (this.isAlwaysExperienceDropper() || this.lastHurtByPlayerMemoryTime > 0 && self.shouldDropExperience() && serverLevel.getGameRules().getBoolean(GameRules.DO_MOB_LOOT))) {
			if (!LivingEntityEvents.ENTITY_DROP_XP.invoker().onEntityDropXp(self, self.getAttackingPlayer(), (double) self.getExperienceToDrop(serverLevel, entity)))
				ci.cancel();
		}
	}

	@Inject(method = "causeFallDamage(DFLnet/minecraft/world/damagesource/DamageSource;)Z", at = @At("HEAD"), cancellable = true)
	public void causeFallDamage(double d, float f, DamageSource damageSource, CallbackInfoReturnable<Boolean> cir) {
		if (!LivingEntityEvents.ENTITY_FALL.invoker().onEntityFall((LivingEntity) (Object) this, d, (double) f))
			cir.setReturnValue(false);
	}

	@Inject(method = "onItemPickup(Lnet/minecraft/world/entity/item/ItemEntity;)V", at = @At("HEAD"))
	public void onItemPickup(ItemEntity itemEntity, CallbackInfo ci) {
		LivingEntityEvents.ENTITY_PICKUP_ITEM.invoker().onEntityPickupItem(itemEntity.getOwner(), itemEntity.getStack());
	}

	@Inject(method = "jumpFromGround()V", at = @At("TAIL"))
	public void jumpFromGround(CallbackInfo ci) {
		LivingEntityEvents.ENTITY_JUMP.invoker().onEntityJump((LivingEntity) (Object) this);
	}
}