package com.kingrealzyt.terrariareloaded.entities.npc;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import net.minecraft.item.MerchantOffers;
import net.minecraft.util.ResourceLocation;

public enum ShopType {

    //If you create a new shop npc type, add the type here
    MERCHANT("Merchant", ShopOffersList.MERCHANT, textureRL("npc_merchant")),
    GUIDE("Guide", ShopOffersList.GUIDE, textureRL("npc_guide")),
    DYE_TRADER("Dye Trader", ShopOffersList.DYE_TRADER, textureRL("npc_dye_trader")),
    DEMOLITIONIST("Demolitionist", ShopOffersList.DEMOLITIONIST, textureRL("npc_demolitionist")),
    DRYAD("Dryad", ShopOffersList.DRYAD, textureRL("npc_dryad")),
    ;


    private String npcName;
    private MerchantOffers offers;
    private ResourceLocation texture;

    ShopType(String npcName, MerchantOffers offers, ResourceLocation texture) {
        this.npcName = npcName;
        this.texture = texture;
        this.offers = offers;
    }

    private static ResourceLocation textureRL(String name) {
        return TerrariaReloaded.rlTexture("entity/npc/" + name + ".png");
    }

    public String getNpcName() {
        return npcName;
    }

    public MerchantOffers getOffers() {
        return offers;
    }

    public ResourceLocation getTexture() {
        return texture;
    }
}
