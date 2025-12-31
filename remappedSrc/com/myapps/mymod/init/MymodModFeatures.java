/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.myapps.mymod.init;

import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;

import java.util.function.Predicate;

import com.myapps.mymod.block.RedGemBlock;
import com.myapps.mymod.block.BlockOfRedGemBlock;
import com.myapps.mymod.MymodMod;

public class MymodModFeatures {
	public static void load() {
		register("red_gem", new OreFeature(OreFeatureConfig.CODEC), RedGemBlock.GENERATE_BIOMES, GenerationStep.Feature.UNDERGROUND_ORES);
		register("block_of_red_gem", new OreFeature(OreFeatureConfig.CODEC), BlockOfRedGemBlock.GENERATE_BIOMES, GenerationStep.Feature.UNDERGROUND_ORES);
	}

	private static void register(String registryname, Feature feature, Predicate<BiomeSelectionContext> biomes, GenerationStep.Feature stage) {
		register(registryname, feature);
		BiomeModifications.addFeature(biomes, stage, RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MymodMod.MODID, registryname)));
	}

	private static void register(String registryname, Feature feature) {
		Registry.register(Registries.FEATURE, Identifier.of(MymodMod.MODID, registryname), feature);
	}
}