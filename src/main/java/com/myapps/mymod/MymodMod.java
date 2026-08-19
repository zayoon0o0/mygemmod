package com.myapps.mymod;

import org.jetbrains.annotations.Nullable;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.minecraft.world.entity.player.Player;

import net.fabricmc.loader.api.FabricLoader;
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

import com.myapps.mymod.init.MymodModTabs;
import com.myapps.mymod.init.MymodModItems;
import com.myapps.mymod.init.MymodModFeatures;
import com.myapps.mymod.init.MymodModBlocks;

public class MymodMod implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger(MymodMod.class);
	public static final String MODID = "mymod";

	@Override
	public void onInitialize() {
		LOGGER.info("BETTER GET LOOKIN IN THE END");
		MymodModTabs.load();
		MymodModFeatures.load();
		MymodModBlocks.load();
		MymodModItems.load();
		tick();
	}

	private static class WorkEntry {
		private final Runnable action;
		private int ticks;

		WorkEntry(Runnable action, int ticks) {
			this.action = action;
			this.ticks = ticks;
		}
	}

	private static final Collection<WorkEntry> workQueue = new ConcurrentLinkedQueue<>();

	public static void queueServerWork(int tick, Runnable action) {
		workQueue.add(new WorkEntry(action, tick));
	}

	private void tick() {
		ServerTickEvents.END_SERVER_TICK.register((server) -> {
			List<WorkEntry> actions = new ArrayList<>();

			workQueue.forEach(work -> {
				work.ticks--;

				if (work.ticks == 0)
					actions.add(work);
			});

			actions.forEach(work -> work.action.run());
			workQueue.removeAll(actions);
		});
	}

	private static Object minecraft;
	private static MethodHandle playerHandle;

	@Nullable
	public static Player clientPlayer() {
		if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
			try {
				if (minecraft == null || playerHandle == null) {
					Class<?> minecraftClass = Class.forName("net.minecraft.client.Minecraft");
					minecraft = MethodHandles.publicLookup()
							.findStatic(
									minecraftClass,
									"getInstance",
									MethodType.methodType(minecraftClass)
							)
							.invoke();

					playerHandle = MethodHandles.publicLookup()
							.findGetter(
									minecraftClass,
									"player",
									Class.forName("net.minecraft.client.player.LocalPlayer")
							);
				}

				return (Player) playerHandle.invoke(minecraft);
			} catch (Throwable e) {
				LOGGER.error("Failed to get client player", e);
				return null;
			}
		} else {
			return null;
		}
	}
}