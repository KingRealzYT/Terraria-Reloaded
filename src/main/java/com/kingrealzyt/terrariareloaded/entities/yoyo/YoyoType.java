package com.kingrealzyt.terrariareloaded.entities.yoyo;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import net.minecraft.util.ResourceLocation;

import java.util.Arrays;
import java.util.Comparator;

public enum YoyoType {

    //=========PRE_HARDMODE=========
    AMAZON(0, TerrariaReloaded.rlTexture("items/yoyo_amazon.png")),
    ARTERY(1, TerrariaReloaded.rlTexture("items/yoyo_artery.png")),
    MALAISE(2, TerrariaReloaded.rlTexture("items/yoyo_malaise.png")),
    RALLY(3, TerrariaReloaded.rlTexture("items/yoyo_rally.png")),
    WOODEN(4, TerrariaReloaded.rlTexture("items/yoyo_wooden.png"));

    public static final YoyoType[] VALUES = values();
    public static final YoyoType[] BY_INDEX = Arrays.stream(VALUES).sorted(Comparator.comparingInt((yoyoType) -> yoyoType.id)).toArray(YoyoType[]::new);

    private final int id;
    private final ResourceLocation texture;

    YoyoType(int id, ResourceLocation texture) {
        this.id = id;
        this.texture = texture;
    }

    public int getId() {
        return id;
    }

    public ResourceLocation getTexture() {
        return texture;
    }
}
