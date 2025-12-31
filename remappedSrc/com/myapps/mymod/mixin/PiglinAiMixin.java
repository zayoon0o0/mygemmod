package com.myapps.mymod.mixin;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.PiglinBrain;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PiglinBrain.class)
public abstract class PiglinAiMixin {
	@Inject(method = "isWearingSafeArmor(Lnet/minecraft/world/entity/LivingEntity;)Z", at = @At("HEAD"), cancellable = true)
	public static void isWearingSafeArmor(LivingEntity entity, CallbackInfoReturnable<Boolean> cir) {
		for (EquipmentSlot equipmentslot : AttributeModifierSlot.ARMOR) {
		}
	}
}