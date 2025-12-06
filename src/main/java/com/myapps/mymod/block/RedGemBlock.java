package com.myapps.mymod.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;

import java.util.function.Predicate;

public class RedGemBlock extends Block {
	public RedGemBlock(BlockBehaviour.Properties properties) {
		super(properties.strength(3f, 10f).requiresCorrectToolForDrops());
	}

	public static final Predicate<BiomeSelectionContext> GENERATE_BIOMES = BiomeSelectors.includeByKey(ResourceKey.create(Registries.BIOME, ResourceLocation.parse("small_end_islands")),
			ResourceKey.create(Registries.BIOME, ResourceLocation.parse("end_barrens")), ResourceKey.create(Registries.BIOME, ResourceLocation.parse("the_end")), ResourceKey.create(Registries.BIOME, ResourceLocation.parse("end_highlands")),
			ResourceKey.create(Registries.BIOME, ResourceLocation.parse("end_midlands")));

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}