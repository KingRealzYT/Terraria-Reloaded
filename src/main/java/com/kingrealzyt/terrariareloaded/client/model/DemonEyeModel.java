package com.kingrealzyt.terrariareloaded.client.model;

import com.kingrealzyt.terrariareloaded.entities.boss.DemonEyeEntity;
import com.kingrealzyt.terrariareloaded.entities.boss.WOFEyeEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class DemonEyeModel<T extends DemonEyeEntity> extends EntityModel<T> {

    private final ModelRenderer total;
    private final ModelRenderer arm1;
    private final ModelRenderer bone;
    private final ModelRenderer arm2;
    private final ModelRenderer bone2;
    private final ModelRenderer arm3;
    private final ModelRenderer bone3;
    private final ModelRenderer arm4;
    private final ModelRenderer bone4;
    private final ModelRenderer arm5;
    private final ModelRenderer bone5;

    public DemonEyeModel() {
        textureWidth = 32;
        textureHeight = 32;

        total = new ModelRenderer(this);
        total.setRotationPoint(0.0F, 20.25F, -1.9063F);
        total.setTextureOffset(0, 21).addBox(-3.0F, -2.75F, -3.0938F, 6.0F, 6.0F, 5.0F, 0.0F, false);
        total.setTextureOffset(0, 0).addBox(-2.0F, -1.25F, -4.3438F, 4.0F, 3.0F, 1.0F, 0.0F, false);
        total.setTextureOffset(0, 4).addBox(-1.5F, -1.75F, -4.4063F, 3.0F, 4.0F, 1.0F, 0.0F, false);
        total.setTextureOffset(20, 20).addBox(-2.5F, -2.25F, -3.8438F, 5.0F, 5.0F, 1.0F, 0.0F, false);
        total.setTextureOffset(0, 15).addBox(-2.5F, -2.25F, 1.6563F, 5.0F, 5.0F, 1.0F, 0.0F, false);

        arm1 = new ModelRenderer(this);
        arm1.setRotationPoint(0.5F, 3.0F, 1.9063F);
        total.addChild(arm1);


        bone = new ModelRenderer(this);
        bone.setRotationPoint(0.0F, 0.0F, 0.25F);
        arm1.addChild(bone);
        setRotationAngle(bone, -0.3491F, 0.0F, 0.0F);
        bone.setTextureOffset(22, 0).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 4.0F, 0.0F, false);

        arm2 = new ModelRenderer(this);
        arm2.setRotationPoint(-1.0F, -2.0F, 1.9063F);
        total.addChild(arm2);


        bone2 = new ModelRenderer(this);
        bone2.setRotationPoint(0.0F, 0.0F, 0.25F);
        arm2.addChild(bone2);
        setRotationAngle(bone2, 0.3491F, 0.0F, 0.0F);
        bone2.setTextureOffset(22, 0).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 4.0F, 0.0F, false);

        arm3 = new ModelRenderer(this);
        arm3.setRotationPoint(-2.0F, 0.75F, 1.9063F);
        total.addChild(arm3);


        bone3 = new ModelRenderer(this);
        bone3.setRotationPoint(0.0F, 0.0F, 0.25F);
        arm3.addChild(bone3);
        setRotationAngle(bone3, 0.3491F, 0.0F, -1.4399F);
        bone3.setTextureOffset(22, 0).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 4.0F, 0.0F, false);

        arm4 = new ModelRenderer(this);
        arm4.setRotationPoint(2.25F, 0.75F, 1.9063F);
        total.addChild(arm4);
        setRotationAngle(arm4, 0.0F, -0.0436F, -2.4871F);


        bone4 = new ModelRenderer(this);
        bone4.setRotationPoint(0.0F, 0.0F, 0.25F);
        arm4.addChild(bone4);
        setRotationAngle(bone4, 0.3491F, -0.6981F, -1.4399F);
        bone4.setTextureOffset(22, 0).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 4.0F, 0.0F, false);

        arm5 = new ModelRenderer(this);
        arm5.setRotationPoint(0.25F, 0.25F, 1.9063F);
        total.addChild(arm5);
        setRotationAngle(arm5, 0.48F, 0.3927F, -2.9671F);


        bone5 = new ModelRenderer(this);
        bone5.setRotationPoint(0.0F, 0.0F, 0.25F);
        arm5.addChild(bone5);
        setRotationAngle(bone5, 0.3491F, -0.6981F, -1.4399F);
        bone5.setTextureOffset(22, 0).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 4.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.total.rotateAngleX = headPitch * ((float)Math.PI / 360F);
        this.total.rotateAngleY = netHeadYaw * ((float)Math.PI / 360F);

    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        total.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

}
