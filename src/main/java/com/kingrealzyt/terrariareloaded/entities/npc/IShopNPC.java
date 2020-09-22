package com.kingrealzyt.terrariareloaded.entities.npc;

import com.kingrealzyt.terrariareloaded.shop.IBuyCallback;
import com.kingrealzyt.terrariareloaded.shop.Offer;
import com.kingrealzyt.terrariareloaded.shop.OfferList;

public interface IShopNPC {

    OfferList getOfferList();

    IBuyCallback buy(Offer offer, ShopNPC entity);

}
