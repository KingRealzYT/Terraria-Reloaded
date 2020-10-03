package com.kingrealzyt.terrariareloaded.client.model;

import com.kingrealzyt.terrariareloaded.entities.boss.EOCEntity;
import com.kingrealzyt.terrariareloaded.entities.boss.WOFEyeEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class EOCModel<T extends EOCEntity> extends EntityModel<T> {
    private final ModelRenderer total;
    private final ModelRenderer head;
    private final ModelRenderer bone4;
    private final ModelRenderer bone2;
    private final ModelRenderer bone3;
    private final ModelRenderer bone;
    private final ModelRenderer arm1a;
    private final ModelRenderer arm1b;
    private final ModelRenderer arm1c;
    private final ModelRenderer arm1a2;
    private final ModelRenderer arm1b2;
    private final ModelRenderer arm1c2;
    private final ModelRenderer arm2a;
    private final ModelRenderer arm2b;
    private final ModelRenderer arm2c;
    private final ModelRenderer arm3a;
    private final ModelRenderer arm3b;
    private final ModelRenderer arm3c;
    private final ModelRenderer arm4a;
    private final ModelRenderer arm4b;
    private final ModelRenderer arm4c;
    private final ModelRenderer arm5a;
    private final ModelRenderer arm5b;
    private final ModelRenderer arm5c;
    private final ModelRenderer arm6a;
    private final ModelRenderer arm5b2;
    private final ModelRenderer arm5c2;
    private final ModelRenderer arm7a;
    private final ModelRenderer arm5b3;
    private final ModelRenderer arm5c3;

    public EOCModel() {
        textureWidth = 364;
        textureHeight = 364;

        total = new ModelRenderer(this);
        total.setRotationPoint(0.0F, 18.0F, 0.0F);


        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 0.0F, 0.0F);
        total.addChild(head);
        head.setTextureOffset(0, 137).addBox(-15.0F, -37.0F, -26.25F, 30.0F, 27.0F, 4.0F, 0.0F, false);
        head.setTextureOffset(0, 0).addBox(-19.0F, -42.0F, -23.0F, 39.0F, 38.0F, 46.0F, 0.0F, false);
        head.setTextureOffset(104, 251).addBox(-19.0F, -45.5F, 18.0F, 39.0F, 45.0F, 6.0F, 0.0F, false);
        head.setTextureOffset(90, 98).addBox(-12.0F, -34.0F, -28.25F, 24.0F, 21.0F, 4.0F, 0.0F, false);
        head.setTextureOffset(0, 173).addBox(-9.0F, -31.25F, -29.35F, 18.0F, 15.0F, 2.0F, 0.0F, false);
        head.setTextureOffset(42, 172).addBox(-7.0F, -33.25F, -29.25F, 14.0F, 19.0F, 2.0F, 0.0F, false);
        head.setTextureOffset(91, 128).addBox(-9.0F, -36.0F, -28.25F, 18.0F, 25.0F, 4.0F, 0.0F, false);

        bone4 = new ModelRenderer(this);
        bone4.setRotationPoint(0.5F, -23.0F, 21.0F);
        head.addChild(bone4);
        setRotationAngle(bone4, 0.0F, 0.0F, -1.5708F);
        bone4.setTextureOffset(0, 267).addBox(-19.5F, -22.0F, -1.75F, 39.0F, 44.0F, 6.0F, 0.0F, false);

        bone2 = new ModelRenderer(this);
        bone2.setRotationPoint(0.5F, -23.0F, 0.0F);
        head.addChild(bone2);
        setRotationAngle(bone2, 0.0F, 1.5708F, 0.0F);
        bone2.setTextureOffset(94, 131).addBox(-19.5F, -19.0F, -23.0F, 39.0F, 38.0F, 46.0F, 0.0F, false);

        bone3 = new ModelRenderer(this);
        bone3.setRotationPoint(0.5F, -23.0F, 0.0F);
        head.addChild(bone3);
        setRotationAngle(bone3, -1.5708F, 1.5708F, 0.0F);
        bone3.setTextureOffset(144, 44).addBox(-19.5F, -19.0F, -23.0F, 39.0F, 38.0F, 46.0F, 0.0F, false);

        bone = new ModelRenderer(this);
        bone.setRotationPoint(0.0F, -23.5F, -26.85F);
        head.addChild(bone);
        setRotationAngle(bone, 0.0F, 0.0F, 1.5708F);
        bone.setTextureOffset(0, 137).addBox(-15.0F, -13.5F, 0.5F, 30.0F, 27.0F, 4.0F, 0.0F, false);

        arm1a = new ModelRenderer(this);
        arm1a.setRotationPoint(19.0F, -22.5F, 24.5F);
        total.addChild(arm1a);


        arm1b = new ModelRenderer(this);
        arm1b.setRotationPoint(0.25F, -0.5F, 0.0F);
        arm1a.addChild(arm1b);
        setRotationAngle(arm1b, 0.0F, 0.48F, 0.0F);
        arm1b.setTextureOffset(218, 129).addBox(-1.6032F, -2.0F, -0.8817F, 3.0F, 4.0F, 12.0F, 0.0F, false);

        arm1c = new ModelRenderer(this);
        arm1c.setRotationPoint(0.0186F, 0.5F, 10.6722F);
        arm1b.addChild(arm1c);
        setRotationAngle(arm1c, 0.0F, -0.7418F, 0.0F);
        arm1c.setTextureOffset(247, 135).addBox(-1.9963F, -2.0F, -0.6382F, 3.0F, 3.0F, 15.0F, 0.0F, false);

        arm1a2 = new ModelRenderer(this);
        arm1a2.setRotationPoint(-17.0F, -22.5F, 24.5F);
        total.addChild(arm1a2);


        arm1b2 = new ModelRenderer(this);
        arm1b2.setRotationPoint(0.25F, -0.5F, 0.0F);
        arm1a2.addChild(arm1b2);
        setRotationAngle(arm1b2, 0.0F, 0.48F, -2.4435F);
        arm1b2.setTextureOffset(218, 129).addBox(-1.6032F, -2.0F, -0.8817F, 3.0F, 4.0F, 12.0F, 0.0F, false);

        arm1c2 = new ModelRenderer(this);
        arm1c2.setRotationPoint(0.0186F, 0.5F, 10.6722F);
        arm1b2.addChild(arm1c2);
        setRotationAngle(arm1c2, 0.0F, -0.4363F, 0.0F);
        arm1c2.setTextureOffset(247, 135).addBox(-1.9963F, -2.0F, -0.6382F, 3.0F, 3.0F, 15.0F, 0.0F, false);

        arm2a = new ModelRenderer(this);
        arm2a.setRotationPoint(16.75F, -39.0F, 24.5F);
        total.addChild(arm2a);


        arm2b = new ModelRenderer(this);
        arm2b.setRotationPoint(0.25F, -0.5F, 0.0F);
        arm2a.addChild(arm2b);
        setRotationAngle(arm2b, 0.0F, 0.48F, -0.6109F);
        arm2b.setTextureOffset(218, 129).addBox(-1.6032F, -2.0F, -0.8817F, 3.0F, 4.0F, 12.0F, 0.0F, false);

        arm2c = new ModelRenderer(this);
        arm2c.setRotationPoint(0.0186F, 0.5F, 10.6722F);
        arm2b.addChild(arm2c);
        setRotationAngle(arm2c, 0.0F, -0.48F, 0.0F);
        arm2c.setTextureOffset(247, 135).addBox(-1.9963F, -2.0F, -0.6382F, 3.0F, 3.0F, 15.0F, 0.0F, false);

        arm3a = new ModelRenderer(this);
        arm3a.setRotationPoint(-16.75F, -39.0F, 24.5F);
        total.addChild(arm3a);


        arm3b = new ModelRenderer(this);
        arm3b.setRotationPoint(0.25F, -0.5F, 0.0F);
        arm3a.addChild(arm3b);
        setRotationAngle(arm3b, 0.0F, 0.1309F, 1.4399F);
        arm3b.setTextureOffset(218, 129).addBox(-1.6032F, -2.0F, -0.8817F, 3.0F, 4.0F, 12.0F, 0.0F, false);

        arm3c = new ModelRenderer(this);
        arm3c.setRotationPoint(0.6685F, -0.0736F, 11.1708F);
        arm3b.addChild(arm3c);
        setRotationAngle(arm3c, 0.0F, -0.48F, -0.8727F);
        arm3c.setTextureOffset(247, 135).addBox(-1.9963F, -2.0F, -0.6382F, 3.0F, 3.0F, 15.0F, 0.0F, false);

        arm4a = new ModelRenderer(this);
        arm4a.setRotationPoint(-16.75F, -10.0F, 24.5F);
        total.addChild(arm4a);


        arm4b = new ModelRenderer(this);
        arm4b.setRotationPoint(0.25F, -0.5F, 0.0F);
        arm4a.addChild(arm4b);
        setRotationAngle(arm4b, 0.0F, 0.1309F, 1.1781F);
        arm4b.setTextureOffset(218, 129).addBox(-1.6032F, -2.0F, -0.8817F, 3.0F, 4.0F, 12.0F, 0.0F, false);

        arm4c = new ModelRenderer(this);
        arm4c.setRotationPoint(-0.6178F, 0.6896F, 11.0569F);
        arm4b.addChild(arm4c);
        setRotationAngle(arm4c, 0.0F, 0.3491F, 1.1781F);
        arm4c.setTextureOffset(247, 135).addBox(-1.9963F, -2.0F, -0.6382F, 3.0F, 3.0F, 15.0F, 0.0F, false);

        arm5a = new ModelRenderer(this);
        arm5a.setRotationPoint(14.25F, -10.0F, 24.5F);
        total.addChild(arm5a);


        arm5b = new ModelRenderer(this);
        arm5b.setRotationPoint(0.25F, -0.5F, 0.0F);
        arm5a.addChild(arm5b);
        setRotationAngle(arm5b, 0.0F, 0.6545F, 0.0F);
        arm5b.setTextureOffset(218, 129).addBox(-1.6032F, -2.0F, -0.8817F, 3.0F, 4.0F, 12.0F, 0.0F, false);

        arm5c = new ModelRenderer(this);
        arm5c.setRotationPoint(-0.413F, 1.1642F, 10.8441F);
        arm5b.addChild(arm5c);
        setRotationAngle(arm5c, 0.0F, 0.1309F, 1.1781F);
        arm5c.setTextureOffset(247, 135).addBox(-1.9963F, -2.0F, -0.6382F, 3.0F, 3.0F, 15.0F, 0.0F, false);

        arm6a = new ModelRenderer(this);
        arm6a.setRotationPoint(-0.5F, -5.25F, 24.5F);
        total.addChild(arm6a);


        arm5b2 = new ModelRenderer(this);
        arm5b2.setRotationPoint(0.25F, -0.5F, 0.0F);
        arm6a.addChild(arm5b2);
        setRotationAngle(arm5b2, 0.0345F, 0.263F, 1.4991F);
        arm5b2.setTextureOffset(218, 129).addBox(-1.6032F, -2.0F, -0.8817F, 3.0F, 4.0F, 12.0F, 0.0F, false);

        arm5c2 = new ModelRenderer(this);
        arm5c2.setRotationPoint(0.682F, 0.6398F, 10.5468F);
        arm5b2.addChild(arm5c2);
        setRotationAngle(arm5c2, 0.0F, 0.4363F, 0.0873F);
        arm5c2.setTextureOffset(247, 135).addBox(-1.9963F, -2.0F, -0.6382F, 3.0F, 3.0F, 15.0F, 0.0F, false);

        arm7a = new ModelRenderer(this);
        arm7a.setRotationPoint(-0.5F, -40.25F, 24.5F);
        total.addChild(arm7a);


        arm5b3 = new ModelRenderer(this);
        arm5b3.setRotationPoint(0.25F, -0.5F, 0.0F);
        arm7a.addChild(arm5b3);
        setRotationAngle(arm5b3, 0.4343F, -0.2025F, 0.6007F);
        arm5b3.setTextureOffset(218, 129).addBox(-1.6032F, -2.0F, -0.8817F, 3.0F, 4.0F, 12.0F, 0.0F, false);

        arm5c3 = new ModelRenderer(this);
        arm5c3.setRotationPoint(0.682F, 0.6398F, 10.5468F);
        arm5b3.addChild(arm5c3);
        setRotationAngle(arm5c3, 0.0F, 0.1309F, 0.0873F);
        arm5c3.setTextureOffset(247, 135).addBox(-1.9963F, -2.0F, -0.6382F, 3.0F, 3.0F, 15.0F, 0.0F, false);
    }


    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.total.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.total.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);

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

    @Override
    public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
        this.arm1a.rotateAngleX = MathHelper.cos(limbSwing * 0.5F) * 1F * limbSwingAmount * 0.2F;
        this.arm1b.rotateAngleX = MathHelper.cos(limbSwing * 0.5F) * 1F * limbSwingAmount * 0.2F;
        this.arm1c.rotateAngleX = MathHelper.cos(limbSwing * 0.5F) * 1F * limbSwingAmount * 0.2F;
        this.arm1a2.rotateAngleX = MathHelper.cos(limbSwing * 0.5F) * 1F * limbSwingAmount * 0.2F;
        this.arm1b2.rotateAngleX = MathHelper.cos(limbSwing * 0.5F) * 1F * limbSwingAmount * 0.2F;
        this.arm1c2.rotateAngleX = MathHelper.cos(limbSwing * 0.5F) * 1F * limbSwingAmount * 0.2F;
        this.arm2a.rotateAngleX = MathHelper.cos(limbSwing * 0.5F) * 1F * limbSwingAmount * 0.2F;
        this.arm2b.rotateAngleX = MathHelper.cos(limbSwing * 0.5F) * 1F * limbSwingAmount * 0.2F;
        this.arm2c.rotateAngleX = MathHelper.cos(limbSwing * 0.5F) * 1F * limbSwingAmount * 0.2F;
        this.arm3a.rotateAngleX = MathHelper.cos(limbSwing * 0.5F) * 1F * limbSwingAmount * 0.2F;
        this.arm3b.rotateAngleX = MathHelper.cos(limbSwing * 0.5F) * 1F * limbSwingAmount * 0.2F;
        this.arm3c.rotateAngleX = MathHelper.cos(limbSwing * 0.5F) * 1F * limbSwingAmount * 0.2F;
        this.arm4a.rotateAngleX = MathHelper.cos(limbSwing * 0.5F) * 1F * limbSwingAmount * 0.2F;
        this.arm4b.rotateAngleX = MathHelper.cos(limbSwing * 0.5F) * 1F * limbSwingAmount * 0.2F;
        this.arm4c.rotateAngleX = MathHelper.cos(limbSwing * 0.5F) * 1F * limbSwingAmount * 0.2F;
        this.arm5a.rotateAngleX = MathHelper.cos(limbSwing * 0.5F) * 1F * limbSwingAmount * 0.2F;
        this.arm5b.rotateAngleX = MathHelper.cos(limbSwing * 0.5F) * 1F * limbSwingAmount * 0.2F;
        this.arm5c.rotateAngleX = MathHelper.cos(limbSwing * 0.5F) * 1F * limbSwingAmount * 0.2F;
        this.arm6a.rotateAngleX = MathHelper.cos(limbSwing * 0.5F) * 1F * limbSwingAmount * 0.2F;
        this.arm5b2.rotateAngleX = MathHelper.cos(limbSwing * 0.5F) * 1F * limbSwingAmount * 0.2F;
        this.arm5c2.rotateAngleX = MathHelper.cos(limbSwing * 0.5F) * 1F * limbSwingAmount * 0.2F;
        this.arm7a.rotateAngleX = MathHelper.cos(limbSwing * 0.5F) * 1F * limbSwingAmount * 0.2F;
        this.arm5b3.rotateAngleX = MathHelper.cos(limbSwing * 0.5F) * 1F * limbSwingAmount * 0.2F;
        this.arm5c3.rotateAngleX = MathHelper.cos(limbSwing * 0.52F) * 1F * limbSwingAmount * 0.2F;
        //this.leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
        //this.leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount * 0.5F;

        //this.leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
        //this.leg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount * 0.5F;

    }



}
