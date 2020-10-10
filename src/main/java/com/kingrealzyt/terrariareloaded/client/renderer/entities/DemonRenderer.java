package com.kingrealzyt.terrariareloaded.client.renderer.entities;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.client.model.CrabModel;
import com.kingrealzyt.terrariareloaded.client.model.DemonModel;
import com.kingrealzyt.terrariareloaded.entities.enemy.CrabEntity;
import com.kingrealzyt.terrariareloaded.entities.enemy.DemonEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class DemonRenderer extends MobRenderer<DemonEntity, DemonModel<DemonEntity>> {


    protected static final ResourceLocation TEXTURE = new ResourceLocation(TerrariaReloaded.MOD_ID, "textures/entity/demon.png");
    public DemonRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new DemonModel<>(), 0.6f);

    }

    @Override
    public ResourceLocation getEntityTexture(DemonEntity entity) {
        return TEXTURE;
    }

}
