package com.myapps.mymod.block;

import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;

import java.util.function.Predicate;

public class RedGemBlock extends Block {
	public RedGemBlock(AbstractBlock.Settings properties) {
		super(properties.strength(3f, 10f).requiresTool());
	}

	public static final Predicate<BiomeSelectionContext> GENERATE_BIOMES = BiomeSelectors.includeByKey(RegistryKey.of(RegistryKeys.BIOME, Identifier.of("small_end_islands")),
			RegistryKey.of(RegistryKeys.BIOME, Identifier.of("end_barrens")), RegistryKey.of(RegistryKeys.BIOME, Identifier.of("the_end")), RegistryKey.of(RegistryKeys.BIOME, Identifier.of("end_highlands")),
			RegistryKey.of(RegistryKeys.BIOME, Identifier.of("end_midlands")));

	@Override
	public int getOpacity(BlockState state) {
		return 15;
	}
}