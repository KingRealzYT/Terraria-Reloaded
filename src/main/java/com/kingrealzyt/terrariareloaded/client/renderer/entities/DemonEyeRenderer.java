package com.kingrealzyt.terrariareloaded.client.renderer.entities;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.client.model.DemonEyeModel;
import com.kingrealzyt.terrariareloaded.entities.enemy.DemonEyeEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class DemonEyeRenderer extends MobRenderer<DemonEyeEntity, DemonEyeModel<DemonEyeEntity>> {


    protected static final ResourceLocation TEXTURE = new ResourceLocation(TerrariaReloaded.MOD_ID, "textures/entity/demon_eye.png");
    public DemonEyeRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new DemonEyeModel<>(), 0.3f);

    }

    @Override
    public ResourceLocation getEntityTexture(DemonEyeEntity entity) {
        return TEXTURE;
    }

}
