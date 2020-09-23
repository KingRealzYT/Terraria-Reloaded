package com.kingrealzyt.terrariareloaded.client.renderer.entities;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.client.model.MerchantNPCModel;
import com.kingrealzyt.terrariareloaded.client.model.WOFEyeModel;
import com.kingrealzyt.terrariareloaded.entities.boss.WOFEyeEntity;
import com.kingrealzyt.terrariareloaded.entities.npc.MerchantNPCEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class MerchantNPCRenderer extends MobRenderer<MerchantNPCEntity, MerchantNPCModel<MerchantNPCEntity>> {


    protected static final ResourceLocation TEXTURE = new ResourceLocation(TerrariaReloaded.MOD_ID, "textures/entity/npc/npc_merchant.png");
    public MerchantNPCRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new MerchantNPCModel<>(), 1.6f);

    }

    @Override
    public ResourceLocation getEntityTexture(MerchantNPCEntity entity) {
        return TEXTURE;
    }

}
