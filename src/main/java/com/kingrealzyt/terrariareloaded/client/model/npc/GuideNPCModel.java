package com.kingrealzyt.terrariareloaded.client.model.npc;

import com.kingrealzyt.terrariareloaded.entities.npc.GuideNPCEntity;
import com.kingrealzyt.terrariareloaded.entities.npc.MerchantNPCEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class GuideNPCModel<T extends GuideNPCEntity> extends EntityModel<T> {

    private final ModelRenderer armLeft;
    private final ModelRenderer head;
    private final ModelRenderer bone;
    private final ModelRenderer bone3;
    private final ModelRenderer legLeft;
    private final ModelRenderer legRight;
    private final ModelRenderer armRight;
    private final ModelRenderer body;
    private final ModelRenderer bone2;

    public GuideNPCModel() {
        textureWidth = 72;
        textureHeight = 72;

        armLeft = new ModelRenderer(this);
        armLeft.setRotationPoint(4.0F, 1.5F, 0.0F);
        armLeft.setTextureOffset(48, 56).addBox(0.0F, -1.5F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
        armLeft.setTextureOffset(14, 0).addBox(-0.5F, 4.75F, -2.5F, 5.0F, 2.0F, 5.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 0.0F, 0.0F);
        head.setTextureOffset(0, 24).addBox(-4.0F, -7.75F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

        bone = new ModelRenderer(this);
        bone.setRotationPoint(0.0F, -7.25F, -4.0625F);
        head.addChild(bone);
        setRotationAngle(bone, -0.0436F, 0.0F, 0.0F);
        bone.setTextureOffset(48, 45).addBox(-4.0F, -0.5F, 0.0F, 8.0F, 5.0F, 0.0F, 0.0F, false);

        bone3 = new ModelRenderer(this);
        bone3.setRotationPoint(0.0F, -7.25F, 3.9375F);
        head.addChild(bone3);
        setRotationAngle(bone3, 0.0436F, 0.0F, 0.0F);
        bone3.setTextureOffset(56, 45).addBox(-4.0F, -0.5F, 0.0F, 8.0F, 5.0F, 0.0F, 0.0F, false);

        legLeft = new ModelRenderer(this);
        legLeft.setRotationPoint(2.0F, 12.25F, 0.0F);
        legLeft.setTextureOffset(0, 56).addBox(-2.0F, -0.25F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        legRight = new ModelRenderer(this);
        legRight.setRotationPoint(-2.0F, 12.25F, 0.0F);
        legRight.setTextureOffset(16, 56).addBox(-2.0F, -0.25F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        armRight = new ModelRenderer(this);
        armRight.setRotationPoint(-4.0F, 1.5F, 0.0F);
        armRight.setTextureOffset(14, 0).addBox(-4.5F, 4.75F, -2.5F, 5.0F, 2.0F, 5.0F, 0.0F, false);
        armRight.setTextureOffset(48, 56).addBox(-4.0F, -1.5F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 3.75F, 2.25F);
        body.setTextureOffset(0, 40).addBox(-4.0F, -3.75F, -4.25F, 8.0F, 12.0F, 4.0F, 0.0F, false);
        body.setTextureOffset(14, 9).addBox(-3.0F, -3.75F, -4.5F, 6.0F, 3.0F, 0.0F, 0.0F, false);

        bone2 = new ModelRenderer(this);
        bone2.setRotationPoint(0.5F, 1.5F, -4.3125F);
        body.addChild(bone2);
        setRotationAngle(bone2, 0.0F, 0.0F, 0.5236F);
        bone2.setTextureOffset(3, 0).addBox(-1.125F, -6.2165F, 4.125F, 5.0F, 15.0F, 0.0F, 0.0F, false);
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
