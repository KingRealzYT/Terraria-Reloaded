package com.kingrealzyt.terrariareloaded.client.renderer.entities;

import com.kingrealzyt.terrariareloaded.entities.projectiles.IceboltProjectileEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderIceboltProjectile extends SpriteRenderer<IceboltProjectileEntity> {
    public RenderIceboltProjectile(EntityRendererManager rendererManager){
        super(rendererManager, Minecraft.getInstance().getItemRenderer(), 1.0f, true);
    }
}
