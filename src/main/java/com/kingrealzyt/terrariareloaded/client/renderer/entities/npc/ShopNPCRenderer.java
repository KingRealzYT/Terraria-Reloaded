package com.kingrealzyt.terrariareloaded.client.renderer.entities.npc;

import com.kingrealzyt.terrariareloaded.entities.npc.ShopNPCEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

public class ShopNPCRenderer<T extends ShopNPCEntity, M extends EntityModel<T>> extends MobRenderer<T, M> {

    public ShopNPCRenderer(EntityRendererManager renderManagerIn, M entityModelIn) {
        super(renderManagerIn, entityModelIn, 0.6F);
    }

    @Override
    public ResourceLocation getEntityTexture(T entity) {
        return entity.getShopType().getTexture();
    }
}
