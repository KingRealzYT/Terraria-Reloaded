package com.kingrealzyt.terrariareloaded.client.renderer.entities;

import com.kingrealzyt.terrariareloaded.entities.yoyo.YoyoEntity;
import com.kingrealzyt.terrariareloaded.items.weapons.melee.yoyo.IYoyo;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.LightType;

public class YoyoEntityRenderer extends EntityRenderer<YoyoEntity> {

    private final ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();

    public YoyoEntityRenderer(EntityRendererManager renderManager) {
        super(renderManager);
    }

    @Override
    public void render(YoyoEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        Minecraft.getInstance().getProfiler().startSection("renderYoyo");

        matrixStackIn.push();
        matrixStackIn.translate(0.0, entityIn.getHeight() / 2, 0.0);
        matrixStackIn.scale(.5F, .5F, .5F);
        Vec3d pointTo = entityIn.getPlayerHandPos(partialTicks).subtract(entityIn.getPosX(), entityIn.getPosY(), entityIn.getPosZ()).normalize();
        double yaw = Math.atan2(pointTo.x, pointTo.z) * -180 / Math.PI;

        if (entityIn.hasYoyo() && entityIn.getYoyo().getRenderOrientation(entityIn.getYoyoStack()) == IYoyo.RenderOrientation.HORIZONTAL) {
            matrixStackIn.rotate(Vector3f.XP.rotationDegrees(-90f));
        } else {
            matrixStackIn.rotate(Vector3f.YP.rotationDegrees(270f - (float) yaw));
        }
        matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(entityIn.getRotation(entityIn.ticksExisted, partialTicks)));
        IBakedModel ibakedmodel = itemRenderer.getItemModelWithOverrides(entityIn.getYoyoStack(), entityIn.getEntityWorld(), null);
        itemRenderer.renderItem(entityIn.getYoyoStack(), ItemCameraTransforms.TransformType.GROUND, false, matrixStackIn, bufferIn, packedLightIn, OverlayTexture.NO_OVERLAY, ibakedmodel);
        matrixStackIn.pop();

        renderLeash(entityIn, partialTicks, matrixStackIn, bufferIn, entityIn.getThrower());

        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        Minecraft.getInstance().getProfiler().endSection();
    }

    @Override
    public ResourceLocation getEntityTexture(YoyoEntity entity) {
        return entity.getYoyoType().getTexture();
    }

    private void renderLeash(YoyoEntity entityLivingIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, PlayerEntity leashHolder) {
        matrixStackIn.push();
        double d0 = (MathHelper.lerp(partialTicks * 0.5F, leashHolder.rotationYaw, leashHolder.prevRotationYaw) * ((float) Math.PI / 180F));
        double d1 = (MathHelper.lerp(partialTicks * 0.5F, leashHolder.rotationPitch, leashHolder.prevRotationPitch) * ((float) Math.PI / 180F));
        double d2 = Math.cos(d0);
        double d3 = Math.sin(d0);
        double d4 = Math.sin(d1);

        double d5 = Math.cos(d1);
        double d6 = MathHelper.lerp(partialTicks, leashHolder.prevPosX, leashHolder.getPosX()) - d2 * 0.7D - d3 * 0.5D * d5;
        double d7 = MathHelper.lerp(partialTicks, leashHolder.prevPosY + (double) leashHolder.getEyeHeight() * 0.7D, leashHolder.getPosY() + (double) leashHolder.getEyeHeight() * 0.7D) - d4 * 0.5D - 0.25D;
        double d8 = MathHelper.lerp(partialTicks, leashHolder.prevPosZ, leashHolder.getPosZ()) - d3 * 0.7D + d2 * 0.5D * d5;
        double d9 = (double) (MathHelper.lerp(partialTicks, entityLivingIn.renderYawOffset, entityLivingIn.prevRenderYawOffset) * ((float) Math.PI / 180F)) + (Math.PI / 2D);
        d2 = Math.cos(d9) * (double) entityLivingIn.getWidth() * 0.4D;
        d3 = Math.sin(d9) * (double) entityLivingIn.getWidth() * 0.4D;
        double d10 = MathHelper.lerp(partialTicks, entityLivingIn.prevPosX, entityLivingIn.getPosX()) + d2;
        double d11 = MathHelper.lerp(partialTicks, entityLivingIn.prevPosY, entityLivingIn.getPosY());
        double d12 = MathHelper.lerp(partialTicks, entityLivingIn.prevPosZ, entityLivingIn.getPosZ()) + d3;
        matrixStackIn.translate(d2, -(1.6D - (double) entityLivingIn.getHeight()) * 0.5D, d3);
        float f = (float) (d6 - d10);
        float f1 = (float) (d7 - d11);
        float f2 = (float) (d8 - d12);
        float f3 = 0.025F;
        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getLeash());
        Matrix4f matrix4f = matrixStackIn.getLast().getMatrix();
        float f4 = MathHelper.fastInvSqrt(f * f + f2 * f2) * 0.025F / 2.0F;
        float f5 = f2 * f4;
        float f6 = f * f4;
        int i = this.getBlockLight(entityLivingIn, partialTicks);
        int j = leashHolder.isBurning() ? 15 : leashHolder.world.getLightFor(LightType.BLOCK, new BlockPos(leashHolder.getEyePosition(partialTicks)));
        int k = entityLivingIn.world.getLightFor(LightType.SKY, new BlockPos(entityLivingIn.getEyePosition(partialTicks)));
        int l = entityLivingIn.world.getLightFor(LightType.SKY, new BlockPos(leashHolder.getEyePosition(partialTicks)));
        MobRenderer.renderSide(ivertexbuilder, matrix4f, f, f1, f2, i, j, k, l, 0.025F, 0.025F, f5, f6);
        MobRenderer.renderSide(ivertexbuilder, matrix4f, f, f1, f2, i, j, k, l, 0.025F, 0.0F, f5, f6);
        matrixStackIn.pop();
    }

}
