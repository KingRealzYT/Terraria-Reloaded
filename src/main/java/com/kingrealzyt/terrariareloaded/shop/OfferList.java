package com.kingrealzyt.terrariareloaded.shop;

import com.google.common.collect.Lists;
import com.kingrealzyt.terrariareloaded.init.ModItems;
import com.kingrealzyt.terrariareloaded.world.capability.PlayerCoinStorage;
import net.minecraft.item.Item;
import net.minecraft.nbt.CompoundNBT;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class OfferList {

    public static final OfferList TEST = new OfferList(Lists.newArrayList(new Offer(Price.create(PlayerCoinStorage.Coin.BRONZE, 10), ModItems.AMAZON_YOYO.get()),
            new Offer(Price.create(PlayerCoinStorage.Coin.SILVER, 2), ModItems.MAGIC_MIRROR.get())));

    private final List<Offer> offers;

    public OfferList(List<Offer> offers) {
        this.offers = offers;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    @Nullable
    public Offer getOfferByOutput(Item item) {
        for(Offer offer : offers)
            if(offer.getOutput() == item)
                return offer;
        return null;
    }

    public void write(CompoundNBT tag) {
        int i = 0;
        offers.forEach(offer -> tag.put("Offer_" + i, offer.getNbtTag()));
        tag.putInt("Size", i);
    }

    public static OfferList read(CompoundNBT tag) {
        int size = tag.getInt("Size");
        List<Offer> l = new ArrayList<>(size);
        for(int i = 0; i < size; i++)
            l.add(Offer.read(tag.getCompound("Offer_" + i)));
        return new OfferList(l);
    }

}
