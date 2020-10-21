package com.kingrealzyt.terrariareloaded.client.renderer.entities;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.client.model.EOC2Model;
import com.kingrealzyt.terrariareloaded.entities.boss.EOC2Entity;
import com.kingrealzyt.terrariareloaded.entities.boss.EOCEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class EOC2Renderer extends MobRenderer<EOC2Entity, EOC2Model<EOC2Entity>> {


    protected static final ResourceLocation TEXTURE = new ResourceLocation(TerrariaReloaded.MOD_ID, "textures/entity/eye_of_cthulhu2.png");
    public EOC2Renderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new EOC2Model<>(), 1.1f);

    }

    @Override
    public ResourceLocation getEntityTexture(EOC2Entity entity) {
        return TEXTURE;
    }

}
