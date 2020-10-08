package com.kingrealzyt.terrariareloaded.client.model;

import com.kingrealzyt.terrariareloaded.entities.enemy.DemonEyeEntity;
import com.kingrealzyt.terrariareloaded.entities.passive.GoldenRatEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class GoldenRatModel<T extends GoldenRatEntity> extends EntityModel<T> {

    private final ModelRenderer head;
    private final ModelRenderer bone2;
    private final ModelRenderer bone3;
    private final ModelRenderer bone4;
    private final ModelRenderer bone5;
    private final ModelRenderer body;
    private final ModelRenderer tail;
    private final ModelRenderer tail2;
    private final ModelRenderer bone6;
    private final ModelRenderer legLeft;
    private final ModelRenderer legRight;
    private final ModelRenderer armLeft;
    private final ModelRenderer armRight;

    public GoldenRatModel() {
        textureWidth = 32;
        textureHeight = 32;

        head = new ModelRenderer(this);
        head.setRotationPoint(0.3125F, 20.8125F, -1.0625F);
        head.setTextureOffset(0, 18).addBox(-1.8125F, -1.3125F, -3.9375F, 3.0F, 3.0F, 3.0F, 0.0F, false);
        head.setTextureOffset(0, 0).addBox(0.4375F, -1.0625F, -3.6875F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(18, 0).addBox(-1.3125F, -0.8125F, -5.9375F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        head.setTextureOffset(18, 6).addBox(-0.8125F, -0.3125F, -6.9375F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(0, 0).addBox(-2.0625F, -1.0625F, -3.6875F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        bone2 = new ModelRenderer(this);
        bone2.setRotationPoint(1.25F, -1.75F, -0.5F);
        head.addChild(bone2);
        setRotationAngle(bone2, 0.0F, -0.4363F, -0.4363F);
        bone2.setTextureOffset(28, 0).addBox(-1.4226F, -1.0F, -0.9063F, 2.0F, 2.0F, 0.0F, 0.0F, false);

        bone3 = new ModelRenderer(this);
        bone3.setRotationPoint(-1.875F, -1.75F, -0.5F);
        head.addChild(bone3);
        setRotationAngle(bone3, 0.0F, 0.4363F, 0.4363F);
        bone3.setTextureOffset(28, 0).addBox(-0.5774F, -1.0F, -0.9063F, 2.0F, 2.0F, 0.0F, 0.0F, true);

        bone4 = new ModelRenderer(this);
        bone4.setRotationPoint(-1.625F, 0.0F, -4.5F);
        head.addChild(bone4);
        setRotationAngle(bone4, 0.3054F, 0.1745F, 0.0F);
        bone4.setTextureOffset(0, 11).addBox(-0.3264F, -0.7961F, -0.9392F, 1.0F, 1.0F, 0.0F, 0.0F, false);

        bone5 = new ModelRenderer(this);
        bone5.setRotationPoint(1.0F, 0.0F, -4.5F);
        head.addChild(bone5);
        setRotationAngle(bone5, 0.3054F, -0.1745F, 0.0F);
        bone5.setTextureOffset(0, 11).addBox(-0.6736F, -0.7961F, -0.9392F, 1.0F, 1.0F, 0.0F, 0.0F, true);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 20.625F, 3.0F);


        tail = new ModelRenderer(this);
        tail.setRotationPoint(0.0F, -1.25F, 3.0F);
        body.addChild(tail);
        setRotationAngle(tail, 0.48F, 0.0F, 0.0F);
        tail.setTextureOffset(16, 22).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);

        tail2 = new ModelRenderer(this);
        tail2.setRotationPoint(0.0F, 0.1261F, 4.3029F);
        tail.addChild(tail2);
        setRotationAngle(tail2, 0.48F, 0.0F, 0.0F);
        tail2.setTextureOffset(7, 19).addBox(-0.5F, -1.4419F, -1.7699F, 1.0F, 1.0F, 5.0F, 0.0F, false);

        bone6 = new ModelRenderer(this);
        bone6.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addChild(bone6);
        setRotationAngle(bone6, 0.0873F, 0.0F, 0.0F);
        bone6.setTextureOffset(0, 0).addBox(-2.5F, -2.2122F, -0.9962F, 5.0F, 4.0F, 4.0F, 0.0F, false);
        bone6.setTextureOffset(0, 10).addBox(-2.0F, -1.9622F, -4.9962F, 4.0F, 4.0F, 4.0F, 0.0F, false);

        legLeft = new ModelRenderer(this);
        legLeft.setRotationPoint(2.125F, 21.5F, 6.125F);
        legLeft.setTextureOffset(22, 4).addBox(-0.875F, -1.5F, -2.375F, 2.0F, 3.0F, 3.0F, 0.0F, false);
        legLeft.setTextureOffset(13, 8).addBox(-0.125F, 1.5F, -4.125F, 1.0F, 1.0F, 3.0F, 0.0F, false);

        legRight = new ModelRenderer(this);
        legRight.setRotationPoint(-2.125F, 21.5F, 6.125F);
        legRight.setTextureOffset(22, 4).addBox(-1.125F, -1.5F, -2.375F, 2.0F, 3.0F, 3.0F, 0.0F, true);
        legRight.setTextureOffset(13, 8).addBox(-0.875F, 1.5F, -4.125F, 1.0F, 1.0F, 3.0F, 0.0F, true);

        armLeft = new ModelRenderer(this);
        armLeft.setRotationPoint(1.7188F, 22.5F, 0.0F);
        armLeft.setTextureOffset(21, 10).addBox(-0.2188F, -1.0F, -2.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        armLeft.setTextureOffset(13, 8).addBox(-0.2813F, 0.5F, -3.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);

        armRight = new ModelRenderer(this);
        armRight.setRotationPoint(-1.7188F, 22.5F, 0.0F);
        armRight.setTextureOffset(21, 10).addBox(-0.7813F, -1.0F, -2.0F, 1.0F, 2.0F, 2.0F, 0.0F, true);
        armRight.setTextureOffset(13, 8).addBox(-0.7188F, 0.5F, -3.5F, 1.0F, 1.0F, 3.0F, 0.0F, true);
    }


    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.legRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.legLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.armRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.armLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.tail.rotateAngleZ = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        legLeft.render(matrixStack, buffer, packedLight, packedOverlay);
        legRight.render(matrixStack, buffer, packedLight, packedOverlay);
        armLeft.render(matrixStack, buffer, packedLight, packedOverlay);
        armRight.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

}
