package com.myapps.mymod.mixin;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Mixin;
import com.myapps.mymod.event.MiscEvents;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import com.mojang.brigadier.ParseResults;

@Mixin(CommandManager.class)
public abstract class CommandsMixin {
	@Inject(method = "performCommand(Lcom/mojang/brigadier/ParseResults;Ljava/lang/String;)V", at = @At("HEAD"), cancellable = true)
	public void performCommand(ParseResults<ServerCommandSource> parseResults, String string, CallbackInfo ci) {
		boolean result = MiscEvents.COMMAND_EXECUTE.invoker().onCommandExecuted(parseResults);
		if (!result)
			ci.cancel();
	}
}