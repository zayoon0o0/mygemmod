package com.myapps.mymod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

public class AmethystSwordToolInHandTickProcedure {
	public static boolean eventResult = true;

	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double distance = 0;
		Vec3 targetPosition = Vec3.ZERO;
		Vec3 sourcePosition = Vec3.ZERO;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
			_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 1000, 1, false, false));
		}
	}
}