package com.kingrealzyt.terrariareloaded.entities.yoyo;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import net.minecraft.util.ResourceLocation;

public enum YoyoType {

    //=========PRE_HARDMODE=========
    AMAZON(TerrariaReloaded.rlTexture("items/yoyo_amazon.png")),
    ARTERY(TerrariaReloaded.rlTexture("items/yoyo_artery.png")),
    MALAISE(TerrariaReloaded.rlTexture("items/yoyo_malaise.png")),
    RALLY(TerrariaReloaded.rlTexture("items/yoyo_rally.png")),
    WOODEN(TerrariaReloaded.rlTexture("items/yoyo_wooden.png")),
    CODE_1(TerrariaReloaded.rlTexture("items/yoyo_code_1.png")),
    VALOR(TerrariaReloaded.rlTexture("items/yoyo_valor.png")),
    CASCADE(TerrariaReloaded.rlTexture("items/yoyo_cascade.png")),

    //=========HARDMODE=========
    FORMAT_C(TerrariaReloaded.rlTexture("items/yoyo_format_c.png")),
    CHICK(TerrariaReloaded.rlTexture("items/yoyo_chick.png")),
    GRADIENT(TerrariaReloaded.rlTexture("items/yoyo_gradient.png")),
    HEL_FIRE(TerrariaReloaded.rlTexture("items/yoyo_hel_fire.png")),
    AMAROK(TerrariaReloaded.rlTexture("items/yoyo_amarok.png")),
    CODE_2(TerrariaReloaded.rlTexture("items/yoyo_code_2.png")),
    YELETS(TerrariaReloaded.rlTexture("items/yoyo_yelets.png")),
    REDS_THROW(TerrariaReloaded.rlTexture("items/yoyo_reds_throw.png")),
    VALKYRIE_YOYO(TerrariaReloaded.rlTexture("items/yoyo_valkyrie_yoyo.png")),
    KRAKEN(TerrariaReloaded.rlTexture("items/yoyo_kraken.png")),
    THE_EYE_OF_CTHULU(TerrariaReloaded.rlTexture("items/yoyo_the_eye_of_cthulu.png")),
    TERRARIAN(TerrariaReloaded.rlTexture("items/yoyo_terrarian.png"));

    private final ResourceLocation texture;

    YoyoType(ResourceLocation texture) {
        this.texture = texture;
    }

    public ResourceLocation getTexture() {
        return texture;
    }
}
