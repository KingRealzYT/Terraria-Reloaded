package com.kingrealzyt.terrariareloaded.client.renderer.entities;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.client.model.DemonEyeModel;
import com.kingrealzyt.terrariareloaded.client.model.SpelunkerCubeModel;
import com.kingrealzyt.terrariareloaded.entities.enemy.DemonEyeEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class SpelunkerCubeRenderer extends MobRenderer<SpelunkerCubeEntity, SpelunkerCubeModel<SpelunkerCubeEntity>> {


    protected static final ResourceLocation TEXTURE = new ResourceLocation(TerrariaReloaded.MOD_ID, "textures/entity/spelunker_cube.png");
    public SpelunkerCubeRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new SpelunkerCubeModel<>(), 0.0f);

    }

    @Override
    public ResourceLocation getEntityTexture(SpelunkerCubeEntity entity) {
        return TEXTURE;
    }

}
