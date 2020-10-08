package com.kingrealzyt.terrariareloaded.client.renderer.entities;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.client.model.GoldenRatModel;
import com.kingrealzyt.terrariareloaded.entities.passive.GoldenRatEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class GoldenRatRenderer extends MobRenderer<GoldenRatEntity, GoldenRatModel<GoldenRatEntity>> {


    protected static final ResourceLocation TEXTURE = new ResourceLocation(TerrariaReloaded.MOD_ID, "textures/entity/golden_rat.png");
    public GoldenRatRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new GoldenRatModel<>(), 0.5f);

    }

    @Override
    public ResourceLocation getEntityTexture(GoldenRatEntity entity) {
        return TEXTURE;
    }

}
