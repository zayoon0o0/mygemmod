/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.myapps.mymod.init;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import java.util.function.Function;

import com.myapps.mymod.block.RedGemBlock;
import com.myapps.mymod.block.BlockOfRedGemBlock;
import com.myapps.mymod.MymodMod;

public class MymodModBlocks {
	public static Block RED_GEM;
	public static Block BLOCK_OF_RED_GEM;

	public static void load() {
		RED_GEM = register("red_gem", RedGemBlock::new);
		BLOCK_OF_RED_GEM = register("block_of_red_gem", BlockOfRedGemBlock::new);
	}

	private static <B extends Block> B register(String name, Function<BlockBehaviour.Properties, B> supplier) {
		return (B) Blocks.register(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MymodMod.MODID, name)), (Function<BlockBehaviour.Properties, Block>) supplier, BlockBehaviour.Properties.of());
	}
}