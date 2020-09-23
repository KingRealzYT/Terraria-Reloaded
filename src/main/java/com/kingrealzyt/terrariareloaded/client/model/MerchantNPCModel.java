package com.kingrealzyt.terrariareloaded.client.model;

import com.kingrealzyt.terrariareloaded.entities.boss.WOFEyeEntity;
import com.kingrealzyt.terrariareloaded.entities.npc.MerchantNPCEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class MerchantNPCModel<T extends MerchantNPCEntity> extends EntityModel<T> {
    private final ModelRenderer armLeft;
    private final ModelRenderer head;
    private final ModelRenderer feather;
    private final ModelRenderer legLeft;
    private final ModelRenderer bone2;
    private final ModelRenderer bone3;
    private final ModelRenderer legRight;
    private final ModelRenderer bone;
    private final ModelRenderer armRight;
    private final ModelRenderer body;
    private final ModelRenderer cape;

    public MerchantNPCModel() {
        textureWidth = 72;
        textureHeight = 72;

        armLeft = new ModelRenderer(this);
        armLeft.setRotationPoint(4.0F, 1.5F, 0.0F);
        armLeft.setTextureOffset(48, 56).addBox(0.0F, -1.5F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 0.0F, 0.0F);
        head.setTextureOffset(0, 24).addBox(-4.0F, -7.75F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
        head.setTextureOffset(0, 0).addBox(-2.5F, -1.5863F, -4.1901F, 5.0F, 1.0F, 0.0F, 0.0F, false);
        head.setTextureOffset(0, 0).addBox(-3.75F, -4.5863F, -4.1901F, 3.0F, 1.0F, 0.0F, 0.0F, false);
        head.setTextureOffset(2, 1).addBox(0.75F, -4.5863F, -4.1901F, 3.0F, 1.0F, 0.0F, 0.0F, false);
        head.setTextureOffset(0, 2).addBox(-3.5F, -0.3363F, -4.0026F, 7.0F, 7.0F, 0.0F, 0.0F, false);
        head.setTextureOffset(0, 2).addBox(-3.75F, -2.8363F, 4.0599F, 7.0F, 7.0F, 0.0F, 0.0F, false);
        head.setTextureOffset(36, 0).addBox(-4.0F, -6.0F, -6.0F, 8.0F, 1.0F, 2.0F, 0.0F, false);
        head.setTextureOffset(35, 3).addBox(-3.5F, -6.25F, 4.0F, 7.0F, 5.0F, 1.0F, 0.0F, false);

        feather = new ModelRenderer(this);
        feather.setRotationPoint(3.25F, -7.25F, 0.0F);
        head.addChild(feather);
        setRotationAngle(feather, 0.0F, 0.9599F, 0.3054F);
        feather.setTextureOffset(0, 10).addBox(-0.8754F, -2.0463F, 0.6803F, 0.0F, 3.0F, 2.0F, 0.0F, false);

        legLeft = new ModelRenderer(this);
        legLeft.setRotationPoint(2.0F, 12.25F, 0.0F);
        legLeft.setTextureOffset(0, 56).addBox(-2.0F, -0.25F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        bone2 = new ModelRenderer(this);
        bone2.setRotationPoint(0.0F, -0.4375F, -2.0F);
        legLeft.addChild(bone2);
        setRotationAngle(bone2, -0.0873F, 0.0F, -0.0524F);
        bone2.setTextureOffset(0, 21).addBox(-2.0F, -0.25F, 0.0F, 4.0F, 9.0F, 0.0F, 0.0F, true);

        bone3 = new ModelRenderer(this);
        bone3.setRotationPoint(2.0F, -1.0F, 0.0F);
        legLeft.addChild(bone3);
        setRotationAngle(bone3, 0.0F, 0.0F, -0.0524F);
        bone3.setTextureOffset(24, 19).addBox(0.0F, 0.0F, -2.0F, 0.0F, 9.0F, 4.0F, 0.0F, false);

        legRight = new ModelRenderer(this);
        legRight.setRotationPoint(-2.0F, 12.25F, 0.0F);
        legRight.setTextureOffset(16, 56).addBox(-2.0F, -0.25F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        bone = new ModelRenderer(this);
        bone.setRotationPoint(0.0F, -0.4375F, -2.0F);
        legRight.addChild(bone);
        setRotationAngle(bone, -0.0873F, 0.0F, 0.0873F);
        bone.setTextureOffset(0, 21).addBox(-2.0F, -0.25F, 0.0F, 4.0F, 9.0F, 0.0F, 0.0F, false);

        armRight = new ModelRenderer(this);
        armRight.setRotationPoint(-4.0F, 1.5F, 0.0F);
        armRight.setTextureOffset(48, 56).addBox(-4.0F, -1.5F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 3.75F, 2.25F);
        body.setTextureOffset(0, 40).addBox(-4.0F, -3.75F, -4.25F, 8.0F, 12.0F, 4.0F, 0.0F, false);

        cape = new ModelRenderer(this);
        cape.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addChild(cape);
        setRotationAngle(cape, 0.1222F, 0.0F, 0.0F);
        cape.setTextureOffset(15, 0).addBox(-4.5F, -1.1455F, -1.3627F, 9.0F, 18.0F, 1.0F, 0.0F, false);
    }
    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.legLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.legRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.armLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.armRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        armLeft.render(matrixStack, buffer, packedLight, packedOverlay);
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        legLeft.render(matrixStack, buffer, packedLight, packedOverlay);
        legRight.render(matrixStack, buffer, packedLight, packedOverlay);
        armRight.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

}
