package com.myapps.mymod;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.ClientModInitializer;

import com.myapps.mymod.init.MymodModBlocksRenderers;
import com.myapps.mymod.init.MymodModArmorModels;

@Environment(EnvType.CLIENT)
public class MymodModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// Start of user code block mod constructor
		// End of user code block mod constructor
		MymodModBlocksRenderers.clientLoad();
		MymodModArmorModels.clientLoad();
		// Start of user code block mod init
		// End of user code block mod init
	}
	// Start of user code block mod methods
	// End of user code block mod methods
}