package com.myapps.mymod.procedures;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class AmethystSwordEntitySwingsItemProcedure {
	public static void execute(Entity target) {
		if (!(target instanceof LivingEntity living)) return;

		living.addEffect(new MobEffectInstance(MobEffects.POISON, 500, 2));
		living.level().levelEvent(2001, living.blockPosition(), 0);
	}
}
