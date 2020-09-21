package com.kingrealzyt.terrariareloaded.shop;

import com.kingrealzyt.terrariareloaded.world.capability.PlayerCoinStorage;
import net.minecraft.nbt.CompoundNBT;

public class Price {

    public final PlayerCoinStorage.Coin coinType;
    public final int price;

    private Price(PlayerCoinStorage.Coin coinType, int price) {
        this.coinType = coinType;
        this.price = price;
    }

    public CompoundNBT getNbtTag() {
        CompoundNBT tag = new CompoundNBT();
        tag.putInt("CoinType", coinType.ordinal());
        tag.putInt("Price", price);
        return tag;
    }

    public static Price read(CompoundNBT tag) {
        PlayerCoinStorage.Coin coin = PlayerCoinStorage.Coin.values()[tag.getInt("CoinType")];
        int price = tag.getInt("Price");
        return create(coin, price);
    }

    public static Price create(PlayerCoinStorage.Coin coin, int price) {
        return new Price(coin, price);
    }

}
