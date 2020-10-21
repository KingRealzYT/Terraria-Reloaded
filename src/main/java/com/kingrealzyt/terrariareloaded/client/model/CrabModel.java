package com.kingrealzyt.terrariareloaded.client.model;

import com.kingrealzyt.terrariareloaded.entities.enemy.CrabEntity;
import com.kingrealzyt.terrariareloaded.entities.enemy.DemonEyeEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class CrabModel<T extends CrabEntity> extends EntityModel<T> {

    private final ModelRenderer body;
    private final ModelRenderer bone2;
    private final ModelRenderer bone3;
    private final ModelRenderer arm;
    private final ModelRenderer arm2;
    private final ModelRenderer legBackLeft;
    private final ModelRenderer legFrontLeft;
    private final ModelRenderer legBackRight;
    private final ModelRenderer legMidRight;
    private final ModelRenderer legFrontRight;
    private final ModelRenderer legMidLeft;

    public CrabModel() {
        textureWidth = 48;
        textureHeight = 48;

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 21.0F, 0.0F);
        setRotationAngle(body, 0.1047F, 0.0F, 0.0F);


        bone2 = new ModelRenderer(this);
        bone2.setRotationPoint(0.0F, 0.275F, 0.25F);
        body.addChild(bone2);
        bone2.setTextureOffset(0, 39).addBox(-4.5F, -0.525F, -4.0F, 9.0F, 1.0F, 8.0F, 0.0F, false);
        bone2.setTextureOffset(0, 32).addBox(-4.0F, -1.275F, -2.75F, 8.0F, 1.0F, 6.0F, 0.0F, false);
        bone2.setTextureOffset(0, 24).addBox(-4.0F, -0.025F, -3.5F, 8.0F, 1.0F, 7.0F, 0.0F, false);

        bone3 = new ModelRenderer(this);
        bone3.setRotationPoint(3.0F, 2.725F, -1.0F);
        bone2.addChild(bone3);
        bone3.setTextureOffset(28, 0).addBox(-2.0F, -4.5F, -3.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        bone3.setTextureOffset(28, 0).addBox(-5.0F, -4.5F, -3.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        arm = new ModelRenderer(this);
        arm.setRotationPoint(4.25F, 0.0242F, -4.0799F);
        bone2.addChild(arm);
        setRotationAngle(arm, -0.3927F, -0.5236F, 0.0F);
        arm.setTextureOffset(0, 18).addBox(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
        arm.setTextureOffset(0, 12).addBox(-2.1154F, -0.5809F, -4.2076F, 2.0F, 1.0F, 3.0F, 0.0F, false);

        arm2 = new ModelRenderer(this);
        arm2.setRotationPoint(-4.25F, 0.0242F, -4.0799F);
        bone2.addChild(arm2);
        setRotationAngle(arm2, -0.3927F, 0.5236F, 0.0F);
        arm2.setTextureOffset(0, 18).addBox(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 3.0F, 0.0F, true);
        arm2.setTextureOffset(0, 12).addBox(0.1154F, -0.5809F, -4.2076F, 2.0F, 1.0F, 3.0F, 0.0F, true);

        legBackLeft = new ModelRenderer(this);
        legBackLeft.setRotationPoint(4.25F, 21.2F, 3.25F);
        setRotationAngle(legBackLeft, 0.3491F, 0.0F, -0.7854F);
        legBackLeft.setTextureOffset(0, 0).addBox(-0.3586F, -0.1329F, -0.4516F, 1.0F, 4.0F, 1.0F, 0.0F, false);

        legFrontLeft = new ModelRenderer(this);
        legFrontLeft.setRotationPoint(4.25F, 21.2F, -1.5F);
        setRotationAngle(legFrontLeft, -0.2618F, 0.0F, -0.7854F);
        legFrontLeft.setTextureOffset(0, 0).addBox(-0.3586F, -0.1366F, -0.5366F, 1.0F, 4.0F, 1.0F, 0.0F, false);

        legBackRight = new ModelRenderer(this);
        legBackRight.setRotationPoint(-4.25F, 21.2F, 3.25F);
        setRotationAngle(legBackRight, 0.3491F, 0.0F, 0.7854F);
        legBackRight.setTextureOffset(0, 0).addBox(-0.6414F, -0.1329F, -0.4516F, 1.0F, 4.0F, 1.0F, 0.0F, false);

        legMidRight = new ModelRenderer(this);
        legMidRight.setRotationPoint(-4.25F, 21.2F, 1.0F);
        setRotationAngle(legMidRight, 0.0F, 0.0F, 0.7854F);
        legMidRight.setTextureOffset(0, 5).addBox(-0.6414F, -0.1414F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

        legFrontRight = new ModelRenderer(this);
        legFrontRight.setRotationPoint(-4.25F, 21.2F, -1.5F);
        setRotationAngle(legFrontRight, -0.2618F, 0.0F, 0.7854F);
        legFrontRight.setTextureOffset(0, 0).addBox(-0.6414F, -0.1366F, -0.5366F, 1.0F, 4.0F, 1.0F, 0.0F, false);

        legMidLeft = new ModelRenderer(this);
        legMidLeft.setRotationPoint(4.25F, 21.2F, 1.0F);
        setRotationAngle(legMidLeft, 0.0F, 0.0F, -0.7854F);
        legMidLeft.setTextureOffset(0, 5).addBox(-0.3586F, -0.1414F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        // this.body.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.legBackRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.legBackLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.legFrontLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.legFrontRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.legMidLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + ((float)Math.PI)/2) * 1.4F * limbSwingAmount;
        this.legMidRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + ((float)Math.PI)/2) * 1.4F * limbSwingAmount;
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        legBackLeft.render(matrixStack, buffer, packedLight, packedOverlay);
        legFrontLeft.render(matrixStack, buffer, packedLight, packedOverlay);
        legBackRight.render(matrixStack, buffer, packedLight, packedOverlay);
        legMidRight.render(matrixStack, buffer, packedLight, packedOverlay);
        legFrontRight.render(matrixStack, buffer, packedLight, packedOverlay);
        legMidLeft.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

}
