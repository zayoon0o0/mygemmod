package com.myapps.mymod.procedures;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class AmethystSwordEntitySwingsItemProcedure {
	public static void execute(Entity target) {
		if (!(target instanceof LivingEntity living)) return;
		living.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 12, 1));
	}
}

