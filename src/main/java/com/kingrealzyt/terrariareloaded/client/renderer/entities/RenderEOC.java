package com.kingrealzyt.terrariareloaded.client.renderer.entities;

import javax.annotation.Nullable;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.entities.boss.EOCEntity;
import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderEOC extends LivingRenderer<EOCEntity, EOCPhaseModel>
{   
    public RenderEOC(EntityRendererManager renderManagerIn)
    {
    	
        super(renderManagerIn, new EOCPhaseModel(), 4.0f);
    }
    
    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EOCEntity entitylivingbaseIn, float partialTickTime)
    {
        float f = 8;
        
        double radp = Math.toRadians(entitylivingbaseIn.rotationPitch);
        GlStateManager.translated(0, -Math.sin(radp)*2, Math.sin(radp)*5.5);
        GlStateManager.rotatef(entitylivingbaseIn.rotationPitch, 1, 0, 0);
        GlStateManager.translated(0, Math.sin(radp)*2-1, Math.sin(radp)*3);
    }
    
    @Nullable
	public ResourceLocation getEntityTexture(EOCEntity entity)
    {
    	return (EOCEntity.phase == 1) ? new ResourceLocation(TerrariaReloaded.MOD_ID, "textures/entity/eye_of_cthulhu.png") : new ResourceLocation(TerrariaReloaded.MOD_ID, "textures/entity/eye_of_cthulhu2.png");
    }
}
