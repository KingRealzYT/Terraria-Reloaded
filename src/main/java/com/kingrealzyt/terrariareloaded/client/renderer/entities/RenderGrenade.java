package com.kingrealzyt.terrariareloaded.client.renderer.entities;

import com.kingrealzyt.terrariareloaded.entities.projectiles.DynamiteEntity;
import com.kingrealzyt.terrariareloaded.entities.projectiles.GrenadeEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderGrenade extends SpriteRenderer<GrenadeEntity> {
    public RenderGrenade(EntityRendererManager rendererManager){
        super(rendererManager, Minecraft.getInstance().getItemRenderer(), 1.0f, true);
    }
}
