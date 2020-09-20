package com.kingrealzyt.terrariareloaded.client.renderer.entities;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import com.kingrealzyt.terrariareloaded.entities.projectiles.ThrowingKnifeEntity;

@OnlyIn(Dist.CLIENT)
public class RenderThrowingKnife extends SpriteRenderer<ThrowingKnifeEntity> {
    public RenderThrowingKnife(EntityRendererManager rendererManager){
        super(rendererManager, Minecraft.getInstance().getItemRenderer(), 1.0f, true);
    }
}
