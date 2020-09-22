package com.kingrealzyt.terrariareloaded.client.model;

import com.kingrealzyt.terrariareloaded.entities.boss.WOFMouthEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class WOFMouthModel<T extends WOFMouthEntity> extends EntityModel<T> {

    private final ModelRenderer bone;
    private final ModelRenderer topJaw;
    private final ModelRenderer JAW;
    private final ModelRenderer bone17;
    private final ModelRenderer bone3;
    private final ModelRenderer bone14;
    private final ModelRenderer bone13;
    private final ModelRenderer bone12;
    private final ModelRenderer bone11;
    private final ModelRenderer bone10;
    private final ModelRenderer bone15;
    private final ModelRenderer bottomJaw;
    private final ModelRenderer JAW2;
    private final ModelRenderer bone5;
    private final ModelRenderer bone7;
    private final ModelRenderer bone8;
    private final ModelRenderer bone9;
    private final ModelRenderer bone16;
    private final ModelRenderer bone6;
    private final ModelRenderer bone2;

    public WOFMouthModel() {
        textureWidth = 128;
        textureHeight = 128;

        bone = new ModelRenderer(this);
        bone.setRotationPoint(0.0F, 24.0F, -4.0F);
        bone.setTextureOffset(48, 0).addBox(-14.0F, -41.0F, 2.0F, 26.0F, 39.0F, 14.0F, 0.0F, false);
        bone.setTextureOffset(64, 55).addBox(-11.5F, -8.25F, -3.25F, 22.0F, 5.0F, 8.0F, 0.0F, false);
        bone.setTextureOffset(64, 55).addBox(-11.5F, -40.25F, -3.0F, 22.0F, 5.0F, 8.0F, 0.0F, false);
        bone.setTextureOffset(62, 81).addBox(-15.0F, -42.75F, 15.25F, 28.0F, 42.0F, 5.0F, 0.0F, false);

        topJaw = new ModelRenderer(this);
        topJaw.setRotationPoint(-0.5F, -36.0F, 1.25F);
        bone.addChild(topJaw);
        setRotationAngle(topJaw, 0.3054F, 0.0F, 0.0F);
        topJaw.setTextureOffset(63, 0).addBox(-9.0F, -2.2229F, -8.4466F, 18.0F, 5.0F, 12.0F, 0.0F, false);

        JAW = new ModelRenderer(this);
        JAW.setRotationPoint(6.5F, 3.3612F, -6.1517F);
        topJaw.addChild(JAW);
        setRotationAngle(JAW, -0.1309F, 0.0F, 0.0F);


        bone17 = new ModelRenderer(this);
        bone17.setRotationPoint(-5.0F, 0.0F, -0.75F);
        JAW.addChild(bone17);
        setRotationAngle(bone17, 1.1345F, 0.0F, 0.0F);
        bone17.setTextureOffset(0, 100).addBox(-1.25F, -1.0F, -8.5F, 2.0F, 2.0F, 9.0F, 0.0F, false);

        bone3 = new ModelRenderer(this);
        bone3.setRotationPoint(-8.5F, -2.25F, -0.75F);
        JAW.addChild(bone3);
        setRotationAngle(bone3, 1.1345F, 0.0F, 0.0F);
        bone3.setTextureOffset(0, 100).addBox(-1.25F, -1.0F, -8.5F, 2.0F, 2.0F, 9.0F, 0.0F, false);

        bone14 = new ModelRenderer(this);
        bone14.setRotationPoint(0.0F, -0.75F, 1.25F);
        JAW.addChild(bone14);
        setRotationAngle(bone14, 1.3963F, 0.0F, 0.0F);
        bone14.setTextureOffset(0, 100).addBox(-1.25F, -0.4785F, -7.1388F, 2.0F, 2.0F, 9.0F, 0.0F, false);

        bone13 = new ModelRenderer(this);
        bone13.setRotationPoint(0.0F, -3.25F, 4.25F);
        JAW.addChild(bone13);
        setRotationAngle(bone13, 1.4835F, 0.0F, 0.0F);
        bone13.setTextureOffset(0, 117).addBox(-0.5F, -1.0F, -8.5F, 2.0F, 2.0F, 9.0F, 0.0F, false);

        bone12 = new ModelRenderer(this);
        bone12.setRotationPoint(-13.5F, -0.25F, 4.25F);
        JAW.addChild(bone12);
        setRotationAngle(bone12, 1.4399F, 0.0F, 0.0F);
        bone12.setTextureOffset(0, 117).addBox(-1.0F, -1.3263F, -6.0214F, 2.0F, 2.0F, 9.0F, 0.0F, false);

        bone11 = new ModelRenderer(this);
        bone11.setRotationPoint(-13.0F, -2.25F, 2.25F);
        JAW.addChild(bone11);
        setRotationAngle(bone11, 1.3963F, 0.0F, 0.0F);
        bone11.setTextureOffset(0, 100).addBox(-1.0F, -1.0F, -8.5F, 2.0F, 2.0F, 9.0F, 0.0F, false);

        bone10 = new ModelRenderer(this);
        bone10.setRotationPoint(-13.25F, -1.0F, 0.0F);
        JAW.addChild(bone10);
        setRotationAngle(bone10, 1.1345F, 0.0F, 0.0F);
        bone10.setTextureOffset(0, 117).addBox(-1.0F, -1.0F, -8.5F, 2.0F, 2.0F, 9.0F, 0.0F, false);

        bone15 = new ModelRenderer(this);
        bone15.setRotationPoint(13.25F, 1.0F, 0.0F);
        bone10.addChild(bone15);
        setRotationAngle(bone15, -0.2182F, 0.0F, 0.0F);
        bone15.setTextureOffset(0, 117).addBox(-1.0F, -1.1958F, -7.0128F, 2.0F, 2.0F, 9.0F, 0.0F, false);

        bottomJaw = new ModelRenderer(this);
        bottomJaw.setRotationPoint(-0.5F, -9.5F, 1.5F);
        bone.addChild(bottomJaw);
        setRotationAngle(bottomJaw, -0.3054F, 0.0F, 0.0F);
        bottomJaw.setTextureOffset(63, 0).addBox(-9.0F, -3.1788F, -8.8354F, 18.0F, 5.0F, 12.0F, 0.0F, false);

        JAW2 = new ModelRenderer(this);
        JAW2.setRotationPoint(0.0F, 0.0F, 0.0F);
        bottomJaw.addChild(JAW2);
        setRotationAngle(JAW2, 0.2356F, 0.0F, 0.0F);


        bone5 = new ModelRenderer(this);
        bone5.setRotationPoint(-6.75F, -4.25F, -6.0F);
        JAW2.addChild(bone5);
        setRotationAngle(bone5, -0.9599F, 0.0F, 0.0F);
        bone5.setTextureOffset(0, 117).addBox(-1.0F, -1.0F, -8.5F, 2.0F, 2.0F, 9.0F, 0.0F, false);

        bone7 = new ModelRenderer(this);
        bone7.setRotationPoint(-6.5F, -4.0F, -3.75F);
        JAW2.addChild(bone7);
        setRotationAngle(bone7, -1.3963F, 0.0F, 0.0F);
        bone7.setTextureOffset(0, 100).addBox(-1.0F, -1.0F, -8.5F, 2.0F, 2.0F, 9.0F, 0.0F, false);

        bone8 = new ModelRenderer(this);
        bone8.setRotationPoint(6.5F, -3.0F, -1.75F);
        JAW2.addChild(bone8);
        setRotationAngle(bone8, -1.5708F, 0.0F, 0.0F);
        bone8.setTextureOffset(0, 117).addBox(-0.5F, -1.0F, -8.5F, 2.0F, 2.0F, 9.0F, 0.0F, false);

        bone9 = new ModelRenderer(this);
        bone9.setRotationPoint(-7.0F, -3.0F, -1.75F);
        JAW2.addChild(bone9);
        setRotationAngle(bone9, -1.5708F, 0.0F, 0.0F);
        bone9.setTextureOffset(0, 117).addBox(-1.0F, -1.0F, -8.5F, 2.0F, 2.0F, 9.0F, 0.0F, false);

        bone16 = new ModelRenderer(this);
        bone16.setRotationPoint(-2.5F, -4.25F, -6.75F);
        JAW2.addChild(bone16);
        setRotationAngle(bone16, -1.1345F, 0.0F, 0.0F);
        bone16.setTextureOffset(0, 100).addBox(-1.25F, -1.0F, -8.5F, 2.0F, 2.0F, 9.0F, 0.0F, false);
        bone16.setTextureOffset(0, 100).addBox(3.5F, -0.9834F, -6.3641F, 2.0F, 2.0F, 9.0F, 0.0F, false);

        bone6 = new ModelRenderer(this);
        bone6.setRotationPoint(6.5F, -4.0F, -3.75F);
        JAW2.addChild(bone6);
        setRotationAngle(bone6, -1.3963F, 0.0F, 0.0F);
        bone6.setTextureOffset(0, 100).addBox(-1.25F, -1.0F, -8.5F, 2.0F, 2.0F, 9.0F, 0.0F, false);

        bone2 = new ModelRenderer(this);
        bone2.setRotationPoint(6.5F, -4.25F, -6.0F);
        JAW2.addChild(bone2);
        setRotationAngle(bone2, -1.1345F, 0.0F, 0.0F);
        bone2.setTextureOffset(0, 117).addBox(-1.0F, -1.0F, -8.5F, 2.0F, 2.0F, 9.0F, 0.0F, false);
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
