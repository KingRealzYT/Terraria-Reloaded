package com.kingrealzyt.terrariareloaded.shop;

import com.kingrealzyt.terrariareloaded.entities.npc.ShopNPC;

public interface IBuyCallback {

    void callback(Offer offer, ShopNPC entity);

}
