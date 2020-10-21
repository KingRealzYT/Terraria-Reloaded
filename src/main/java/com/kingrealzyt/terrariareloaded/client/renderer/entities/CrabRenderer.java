package com.kingrealzyt.terrariareloaded.client.renderer.entities;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.client.model.CrabModel;
import com.kingrealzyt.terrariareloaded.client.model.GoldenRatModel;
import com.kingrealzyt.terrariareloaded.entities.enemy.CrabEntity;
import com.kingrealzyt.terrariareloaded.entities.passive.GoldenRatEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class CrabRenderer extends MobRenderer<CrabEntity, CrabModel<CrabEntity>> {


    protected static final ResourceLocation TEXTURE = new ResourceLocation(TerrariaReloaded.MOD_ID, "textures/entity/crab.png");
    public CrabRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new CrabModel<>(), 0.5f);

    }

    @Override
    public ResourceLocation getEntityTexture(CrabEntity entity) {
        return TEXTURE;
    }

}
