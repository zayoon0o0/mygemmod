package com.myapps.mymod;

import org.jetbrains.annotations.Nullable;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Pair;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.api.EnvType;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;

import java.lang.invoke.MethodType;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandle;

import com.myapps.mymod.init.MymodModTrades;
import com.myapps.mymod.init.MymodModTabs;
import com.myapps.mymod.init.MymodModItems;
import com.myapps.mymod.init.MymodModFeatures;
import com.myapps.mymod.init.MymodModBlocks;

public class MymodMod implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger(MymodMod.class);
	public static final String MODID = "mymod";

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing MymodMod");
		MymodModTabs.load();
		MymodModFeatures.load();
		MymodModBlocks.load();
		MymodModItems.load();
		MymodModTrades.registerTrades();
		tick();
	}

	private static final Collection<Pair<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

	public static void queueServerWork(int tick, Runnable action) {
		workQueue.add(new Pair<>(action, tick));
	}

	private void tick() {
		ServerTickEvents.END_SERVER_TICK.register((server) -> {
			List<Pair<Runnable, Integer>> actions = new ArrayList<>();
			workQueue.forEach(work -> {
				work.setRight(work.getRight() - 1);
				if (work.getRight() == 0)
					actions.add(work);
			});
			actions.forEach(e -> e.getLeft().run());
			workQueue.removeAll(actions);
		});
	}

	private static Object minecraft;
	private static MethodHandle playerHandle;

	@Nullable
	public static PlayerEntity clientPlayer() {
		if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
			try {
				if (minecraft == null || playerHandle == null) {
					Class<?> minecraftClass = Class.forName("net.minecraft.client.Minecraft");
					minecraft = MethodHandles.publicLookup().findStatic(minecraftClass, "getInstance", MethodType.methodType(minecraftClass)).invoke();
					playerHandle = MethodHandles.publicLookup().findGetter(minecraftClass, "player", Class.forName("net.minecraft.client.player.LocalPlayer"));
				}
				return (PlayerEntity) playerHandle.invoke(minecraft);
			} catch (Throwable e) {
				LOGGER.error("Failed to get client player", e);
				return null;
			}
		} else {
			return null;
		}
	}
}