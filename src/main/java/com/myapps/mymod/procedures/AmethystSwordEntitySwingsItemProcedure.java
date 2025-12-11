package com.myapps.mymod.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

public class AmethystSwordEntitySwingsItemProcedure {
	public static void execute(Entity target, Entity attacker) {
		if (target == null)
			return;
		if (target instanceof LivingEntity living && !living.level().isClientSide()) {
			living.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 200, 1));
		}
	}
}
