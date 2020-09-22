package com.kingrealzyt.terrariareloaded.client.model;

import com.kingrealzyt.terrariareloaded.entities.boss.WOFEyeEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class WOFEyeModel<T extends WOFEyeEntity> extends EntityModel<T> {

    private final ModelRenderer bone;
    private final ModelRenderer bone2;

    public WOFEyeModel() {
        textureWidth = 128;
        textureHeight = 128;

        bone = new ModelRenderer(this);
        bone.setRotationPoint(0.0F, 24.0F, -4.0F);
        bone.setTextureOffset(0, 18).addBox(-8.0F, -34.0F, -8.0F, 15.0F, 24.0F, 8.0F, 0.0F, false);
        bone.setTextureOffset(0, 53).addBox(-11.0F, -37.0F, -5.0F, 21.0F, 31.0F, 7.0F, 0.0F, false);
        bone.setTextureOffset(48, 0).addBox(-14.0F, -41.0F, 2.0F, 26.0F, 39.0F, 14.0F, 0.0F, false);
        bone.setTextureOffset(64, 55).addBox(-11.5F, -8.25F, -3.25F, 22.0F, 5.0F, 8.0F, 0.0F, false);
        bone.setTextureOffset(64, 55).addBox(-11.5F, -40.25F, -3.0F, 22.0F, 5.0F, 8.0F, 0.0F, false);
        bone.setTextureOffset(62, 81).addBox(-15.0F, -42.75F, 15.25F, 28.0F, 42.0F, 5.0F, 0.0F, false);

        bone2 = new ModelRenderer(this);
        bone2.setRotationPoint(0.0F, -21.0F, -10.0F);
        bone.addChild(bone2);
        bone2.setTextureOffset(25, 0).addBox(-4.0F, -9.0F, 0.0F, 7.0F, 15.0F, 3.0F, 0.0F, false);
        bone2.setTextureOffset(0, 0).addBox(-5.0F, -8.0F, 0.0F, 9.0F, 13.0F, 3.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.bone.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.bone.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);

    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        bone.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }



}
