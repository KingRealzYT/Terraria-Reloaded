package com.kingrealzyt.terrariareloaded.client.renderer.entities;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.client.model.WOFEyeModel;
import com.kingrealzyt.terrariareloaded.client.model.WOFMouthModel;
import com.kingrealzyt.terrariareloaded.entities.boss.WOFMouthEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class WOFMouthRenderer extends MobRenderer<WOFMouthEntity, WOFMouthModel<WOFMouthEntity>> {


    protected static final ResourceLocation TEXTURE = new ResourceLocation(TerrariaReloaded.MOD_ID, "textures/entity/wall_of_flesh_mouth.png");
    public WOFMouthRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new WOFMouthModel<>(), 1.6f);

    }

    @Override
    public ResourceLocation getEntityTexture(WOFMouthEntity entity) {
        return TEXTURE;
    }

}
