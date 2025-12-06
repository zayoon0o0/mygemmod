package com.myapps.mymod.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class BlockOfRedGemBlock extends Block {
	public BlockOfRedGemBlock(BlockBehaviour.Properties properties) {
		super(properties.strength(2f, 10f).requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}