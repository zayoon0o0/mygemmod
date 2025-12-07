/*
* MCreator note: This file will be REGENERATED on each build.
*/
package com.myapps.mymod.init;

import org.jetbrains.annotations.NotNull;

import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.resources.ResourceLocation;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;

import java.util.Optional;

import com.myapps.mymod.MymodMod;

public class MymodModTrades {
	private static final ResourceLocation CUSTOM_WANDERING_TRADER_POOL = ResourceLocation.fromNamespaceAndPath(MymodMod.MODID, "custom_wandering_trader_pool");

	public static void registerTrades() {
		TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 2, builder -> {
			builder.add(new BasicTrade(new ItemStack(Items.EMERALD), ItemStack.EMPTY, new ItemStack(Items.AMETHYST_SHARD, 5), 200, 5, 0.005f));
		});
	}

	private record BasicTrade(ItemStack price, ItemStack price2, ItemStack offer, int maxTrades, int xp, float priceMult) implements VillagerTrades.ItemListing {
		@Override
		public @NotNull MerchantOffer getOffer(Entity entity, RandomSource random) {
			return new MerchantOffer(new ItemCost(price.getItem()), Optional.of(new ItemCost(price2.getItem())), offer, maxTrades, xp, priceMult);
		}
	}
}