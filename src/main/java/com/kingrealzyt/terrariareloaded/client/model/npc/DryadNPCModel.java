package com.kingrealzyt.terrariareloaded.client.model.npc;

import com.kingrealzyt.terrariareloaded.entities.npc.DryadNPCEntity;
import com.kingrealzyt.terrariareloaded.entities.npc.GuideNPCEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class DryadNPCModel<T extends DryadNPCEntity> extends EntityModel<T> {


    private final ModelRenderer armLeft;
    private final ModelRenderer head;
    private final ModelRenderer bone4;
    private final ModelRenderer bone7;
    private final ModelRenderer bone5;
    private final ModelRenderer bone6;
    private final ModelRenderer legLeft;
    private final ModelRenderer bone2;
    private final ModelRenderer bone3;
    private final ModelRenderer legRight;
    private final ModelRenderer bone;
    private final ModelRenderer armRight;
    private final ModelRenderer body;

    public DryadNPCModel() {
        textureWidth = 72;
        textureHeight = 72;

        armLeft = new ModelRenderer(this);
        armLeft.setRotationPoint(4.0F, 1.5F, 0.0F);
        armLeft.setTextureOffset(32, 56).addBox(0.0F, -1.5F, -2.0F, 3.0F, 12.0F, 4.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 0.0F, 0.0F);
        head.setTextureOffset(0, 24).addBox(-4.0F, -7.75F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
        head.setTextureOffset(0, 0).addBox(-3.0F, -0.5F, 3.0F, 6.0F, 12.0F, 0.0F, 0.0F, false);
        head.setTextureOffset(42, 43).addBox(-3.5F, -8.0F, -3.5F, 7.0F, 0.0F, 7.0F, 0.0F, false);

        bone4 = new ModelRenderer(this);
        bone4.setRotationPoint(0.0F, -7.75F, -2.25F);
        head.addChild(bone4);
        setRotationAngle(bone4, -0.0873F, 0.0F, 0.0F);
        bone4.setTextureOffset(50, 31).addBox(-4.0F, 0.1481F, -1.7716F, 8.0F, 8.0F, 0.0F, 0.0F, false);

        bone7 = new ModelRenderer(this);
        bone7.setRotationPoint(0.0F, -7.75F, 2.25F);
        head.addChild(bone7);
        setRotationAngle(bone7, 0.0873F, 0.0F, 0.0F);
        bone7.setTextureOffset(30, 10).addBox(-3.0F, 0.1481F, 1.7716F, 6.0F, 8.0F, 0.0F, 0.0F, false);

        bone5 = new ModelRenderer(this);
        bone5.setRotationPoint(-2.25F, -7.75F, 0.75F);
        head.addChild(bone5);
        setRotationAngle(bone5, -0.0873F, 1.5708F, 0.0F);
        bone5.setTextureOffset(41, 17).addBox(-3.25F, 0.1481F, -1.7716F, 8.0F, 7.0F, 0.0F, 0.0F, false);

        bone6 = new ModelRenderer(this);
        bone6.setRotationPoint(2.25F, -7.75F, 0.75F);
        head.addChild(bone6);
        setRotationAngle(bone6, -0.0873F, -1.5708F, 0.0F);
        bone6.setTextureOffset(41, 17).addBox(-4.75F, 0.1481F, -1.7716F, 8.0F, 7.0F, 0.0F, 0.0F, true);

        legLeft = new ModelRenderer(this);
        legLeft.setRotationPoint(2.0F, 12.25F, 0.0F);
        legLeft.setTextureOffset(0, 56).addBox(-2.0F, -0.25F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        bone2 = new ModelRenderer(this);
        bone2.setRotationPoint(0.0F, -0.4375F, -2.0F);
        legLeft.addChild(bone2);
        setRotationAngle(bone2, -0.0873F, 0.0F, -0.0524F);
        bone2.setTextureOffset(0, 25).addBox(-2.0F, -0.25F, 0.0F, 4.0F, 5.0F, 0.0F, 0.0F, true);

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
        bone.setTextureOffset(0, 25).addBox(-2.0F, -0.25F, 0.0F, 4.0F, 5.0F, 0.0F, 0.0F, false);

        armRight = new ModelRenderer(this);
        armRight.setRotationPoint(-4.0F, 1.5F, 0.0F);
        armRight.setTextureOffset(46, 56).addBox(-3.0F, -1.5F, -2.0F, 3.0F, 12.0F, 4.0F, 0.0F, true);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 3.75F, 2.25F);
        body.setTextureOffset(0, 40).addBox(-4.0F, -3.75F, -4.25F, 8.0F, 12.0F, 4.0F, 0.0F, false);
        body.setTextureOffset(14, 2).addBox(-4.0F, -1.75F, -4.75F, 8.0F, 5.0F, 2.0F, 0.0F, false);
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
