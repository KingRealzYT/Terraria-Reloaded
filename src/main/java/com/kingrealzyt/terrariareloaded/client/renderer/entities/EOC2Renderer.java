package com.kingrealzyt.terrariareloaded.client.renderer.entities;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.client.model.EOC2Model;
import com.kingrealzyt.terrariareloaded.entities.boss.EOCEntity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class EOC2Renderer extends MobRenderer<EOCEntity, EOC2Model> {


    protected static final ResourceLocation TEXTURE = new ResourceLocation(TerrariaReloaded.MOD_ID, "textures/entity/eye_of_cthulhu2.png");
    public EOC2Renderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new EOC2Model(), 1.1f);

    }

    @Override
    public ResourceLocation getEntityTexture(EOCEntity entity) {
        return TEXTURE;
    }

}
