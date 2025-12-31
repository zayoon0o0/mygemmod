/*
* MCreator note: This file will be REGENERATED on each build.
*/
package com.myapps.mymod.init;

import org.jetbrains.annotations.NotNull;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.random.Random;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;
import java.util.Optional;

import com.myapps.mymod.MymodMod;

public class MymodModTrades {
	private static final Identifier CUSTOM_WANDERING_TRADER_POOL = Identifier.of(MymodMod.MODID, "custom_wandering_trader_pool");

	public static void registerTrades() {
		TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 2, builder -> {
			builder.add(new BasicTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(Items.AMETHYST_SHARD, 5), 200, 5, 0.005f));
		});
	}

	private record BasicTrade(ItemStack price, ItemStack price2, ItemStack offer, int maxTrades, int xp, float priceMult) implements TradeOffers.Factory {
		@Override
		public @NotNull TradeOffer create(Entity entity, Random random) {
			return new TradeOffer(new TradedItem(price.getItem()), Optional.of(new TradedItem(price2.getItem())), offer, maxTrades, xp, priceMult);
		}
	}
}