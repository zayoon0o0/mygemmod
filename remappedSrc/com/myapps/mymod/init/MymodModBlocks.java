/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.myapps.mymod.init;

import java.util.function.Function;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
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

	// Start of user code block custom blocks
	// End of user code block custom blocks
	private static <B extends Block> B register(String name, Function<AbstractBlock.Settings, B> supplier) {
		return (B) Blocks.register(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MymodMod.MODID, name)), (Function<AbstractBlock.Settings, Block>) supplier, AbstractBlock.Settings.create());
	}
}