package com.kingrealzyt.terrariareloaded.client.renderer.entities;

import com.kingrealzyt.terrariareloaded.entities.projectiles.BombEntity;
import com.kingrealzyt.terrariareloaded.entities.projectiles.DynamiteEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderBomb extends SpriteRenderer<BombEntity> {
    public RenderBomb(EntityRendererManager rendererManager){
        super(rendererManager, Minecraft.getInstance().getItemRenderer(), 1.0f, true);
    }
}
