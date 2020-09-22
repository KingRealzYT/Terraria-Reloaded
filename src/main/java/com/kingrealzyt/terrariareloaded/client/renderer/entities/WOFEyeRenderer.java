package com.kingrealzyt.terrariareloaded.client.renderer.entities;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.client.model.WOFEyeModel;
import com.kingrealzyt.terrariareloaded.entities.boss.WOFEyeEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class WOFEyeRenderer extends MobRenderer<WOFEyeEntity, WOFEyeModel<WOFEyeEntity>> {


    protected static final ResourceLocation TEXTURE = new ResourceLocation(TerrariaReloaded.MOD_ID, "textures/entity/wall_of_flesh_eye.png");
    public WOFEyeRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new WOFEyeModel<>(), 1.6f);

    }

    @Override
    public ResourceLocation getEntityTexture(WOFEyeEntity entity) {
        return TEXTURE;
    }

}
