package com.kingrealzyt.terrariareloaded.client.renderer.entities;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.client.model.EOCModel;
import com.kingrealzyt.terrariareloaded.entities.boss.EOCEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class EOCRenderer extends MobRenderer<EOCEntity, EOCModel<EOCEntity>> {


    protected static final ResourceLocation TEXTURE = new ResourceLocation(TerrariaReloaded.MOD_ID, "textures/entity/eye_of_cthulhu.png");
    public EOCRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new EOCModel<>(), 1.1f);

    }

    @Override
    public ResourceLocation getEntityTexture(EOCEntity entity) {
        return TEXTURE;
    }

}
