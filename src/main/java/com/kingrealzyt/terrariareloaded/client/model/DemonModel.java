package com.kingrealzyt.terrariareloaded.client.model;

import com.kingrealzyt.terrariareloaded.entities.enemy.DemonEntity;
import com.kingrealzyt.terrariareloaded.entities.enemy.DemonEyeEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class DemonModel<T extends DemonEntity> extends EntityModel<T> {


    private final ModelRenderer total;
    private final ModelRenderer leftLeg;
    private final ModelRenderer leftLeg2;
    private final ModelRenderer leftLeg3;
    private final ModelRenderer leftArm;
    private final ModelRenderer leftArm2;
    private final ModelRenderer leftArm3;
    private final ModelRenderer rightArm;
    private final ModelRenderer rightArm2;
    private final ModelRenderer rightArm3;
    private final ModelRenderer rightLeg;
    private final ModelRenderer rightLeg2;
    private final ModelRenderer rightLeg3;
    private final ModelRenderer body;
    private final ModelRenderer bone;
    private final ModelRenderer head;
    private final ModelRenderer bone2;
    private final ModelRenderer bone3;
    private final ModelRenderer mouth;
    private final ModelRenderer bone9;
    private final ModelRenderer bone11;
    private final ModelRenderer horny1;
    private final ModelRenderer bone5;
    private final ModelRenderer bone6;
    private final ModelRenderer horny2;
    private final ModelRenderer bone4;
    private final ModelRenderer bone7;
    private final ModelRenderer leftWing;
    private final ModelRenderer bone8;
    private final ModelRenderer rightWing;
    private final ModelRenderer bone10;

    public DemonModel() {
        textureWidth = 72;
        textureHeight = 72;

        total = new ModelRenderer(this);
        total.setRotationPoint(0.0F, 8.0F, -1.5F);


        leftLeg = new ModelRenderer(this);
        leftLeg.setRotationPoint(1.75F, 3.5F, -0.25F);
        total.addChild(leftLeg);


        leftLeg2 = new ModelRenderer(this);
        leftLeg2.setRotationPoint(0.5F, 1.0F, 1.5F);
        leftLeg.addChild(leftLeg2);
        setRotationAngle(leftLeg2, -0.3033F, -0.3829F, -0.2355F);
        leftLeg2.setTextureOffset(0, 45).addBox(-1.295F, -1.152F, -1.063F, 2.0F, 7.0F, 2.0F, 0.0F, false);

        leftLeg3 = new ModelRenderer(this);
        leftLeg3.setRotationPoint(-0.3732F, 5.9728F, -0.0249F);
        leftLeg2.addChild(leftLeg3);
        setRotationAngle(leftLeg3, 0.9163F, 0.0F, 0.0F);
        leftLeg3.setTextureOffset(0, 37).addBox(-0.8918F, -0.673F, -0.7147F, 2.0F, 6.0F, 2.0F, 0.0F, false);
        leftLeg3.setTextureOffset(0, 33).addBox(-0.8641F, 4.5944F, -3.3124F, 2.0F, 1.0F, 3.0F, 0.0F, false);
        leftLeg3.setTextureOffset(0, 26).addBox(-1.0539F, 4.4685F, -4.8201F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        leftLeg3.setTextureOffset(0, 26).addBox(0.4466F, 4.3633F, -5.1554F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        leftArm = new ModelRenderer(this);
        leftArm.setRotationPoint(4.25F, -5.5F, -2.25F);
        total.addChild(leftArm);


        leftArm2 = new ModelRenderer(this);
        leftArm2.setRotationPoint(0.5F, 0.5F, 0.0F);
        leftArm.addChild(leftArm2);
        setRotationAngle(leftArm2, -0.3033F, -0.3829F, -0.4537F);
        leftArm2.setTextureOffset(64, 63).addBox(-1.295F, -1.152F, -1.063F, 2.0F, 7.0F, 2.0F, 0.0F, false);

        leftArm3 = new ModelRenderer(this);
        leftArm3.setRotationPoint(-0.3732F, 5.9728F, -0.0249F);
        leftArm2.addChild(leftArm3);
        setRotationAngle(leftArm3, -0.48F, 0.0F, 1.1781F);
        leftArm3.setTextureOffset(64, 55).addBox(-0.9003F, -0.5709F, -0.7863F, 2.0F, 6.0F, 2.0F, 0.0F, false);

        rightArm = new ModelRenderer(this);
        rightArm.setRotationPoint(-4.25F, -5.5F, -2.25F);
        total.addChild(rightArm);


        rightArm2 = new ModelRenderer(this);
        rightArm2.setRotationPoint(-0.5F, 0.5F, 0.0F);
        rightArm.addChild(rightArm2);
        setRotationAngle(rightArm2, -0.3033F, 0.3829F, 0.5409F);
        rightArm2.setTextureOffset(64, 63).addBox(-0.705F, -1.152F, -1.063F, 2.0F, 7.0F, 2.0F, 0.0F, true);

        rightArm3 = new ModelRenderer(this);
        rightArm3.setRotationPoint(0.3732F, 5.9728F, -0.0249F);
        rightArm2.addChild(rightArm3);
        setRotationAngle(rightArm3, -0.8727F, 0.0F, -1.0908F);
        rightArm3.setTextureOffset(64, 55).addBox(-1.0997F, -0.5709F, -0.7863F, 2.0F, 6.0F, 2.0F, 0.0F, true);

        rightLeg = new ModelRenderer(this);
        rightLeg.setRotationPoint(-1.75F, 3.5F, -0.25F);
        total.addChild(rightLeg);


        rightLeg2 = new ModelRenderer(this);
        rightLeg2.setRotationPoint(-0.25F, 0.75F, 1.75F);
        rightLeg.addChild(rightLeg2);
        setRotationAngle(rightLeg2, -0.6477F, 0.3111F, 0.1374F);
        rightLeg2.setTextureOffset(8, 45).addBox(-0.9844F, -0.6932F, -1.3396F, 2.0F, 7.0F, 2.0F, 0.0F, true);

        rightLeg3 = new ModelRenderer(this);
        rightLeg3.setRotationPoint(0.0939F, 5.6816F, -0.3015F);
        rightLeg2.addChild(rightLeg3);
        setRotationAngle(rightLeg3, 1.309F, 0.0F, 0.0F);
        rightLeg3.setTextureOffset(8, 37).addBox(-1.1082F, -0.2164F, -1.3097F, 2.0F, 6.0F, 2.0F, 0.0F, true);
        rightLeg3.setTextureOffset(10, 33).addBox(-1.1359F, 5.051F, -3.9074F, 2.0F, 1.0F, 3.0F, 0.0F, true);
        rightLeg3.setTextureOffset(0, 26).addBox(0.0861F, 4.7731F, -5.3835F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        rightLeg3.setTextureOffset(0, 26).addBox(-1.4144F, 4.8783F, -5.0481F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, -1.0F, -0.25F);
        total.addChild(body);


        bone = new ModelRenderer(this);
        bone.setRotationPoint(0.5F, 0.5F, 0.5F);
        body.addChild(bone);
        setRotationAngle(bone, 0.2618F, 0.0F, 0.0F);
        bone.setTextureOffset(0, 63).addBox(-4.5F, -0.5F, -1.5F, 8.0F, 6.0F, 3.0F, 0.0F, false);
        bone.setTextureOffset(0, 54).addBox(-5.5F, -5.4985F, -2.1375F, 10.0F, 5.0F, 4.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, -6.5F, -2.25F);
        total.addChild(head);


        bone2 = new ModelRenderer(this);
        bone2.setRotationPoint(0.0F, 0.0F, -0.25F);
        head.addChild(bone2);
        setRotationAngle(bone2, 0.576F, 0.0F, 0.0F);
        bone2.setTextureOffset(0, 0).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);

        bone3 = new ModelRenderer(this);
        bone3.setRotationPoint(0.0F, -0.25F, -2.25F);
        head.addChild(bone3);
        setRotationAngle(bone3, 0.2618F, 0.0F, 0.0F);
        bone3.setTextureOffset(0, 6).addBox(-2.5F, -3.5F, -2.5F, 5.0F, 4.0F, 5.0F, 0.0F, false);
        bone3.setTextureOffset(0, 16).addBox(-1.0F, -2.4659F, -2.9912F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        bone3.setTextureOffset(0, 20).addBox(-0.5F, -2.5348F, -3.2897F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        bone3.setTextureOffset(9, 0).addBox(-2.0F, -3.2912F, -3.7213F, 4.0F, 1.0F, 2.0F, 0.0F, false);

        mouth = new ModelRenderer(this);
        mouth.setRotationPoint(-0.5F, 0.7237F, 1.775F);
        bone3.addChild(mouth);
        setRotationAngle(mouth, 0.1745F, 0.0F, 0.0F);
        mouth.setTextureOffset(6, 17).addBox(-2.0F, -0.5344F, -4.16F, 5.0F, 1.0F, 5.0F, 0.0F, false);

        bone9 = new ModelRenderer(this);
        bone9.setRotationPoint(-1.5F, -1.2682F, -3.9993F);
        mouth.addChild(bone9);
        setRotationAngle(bone9, 0.4363F, 0.0F, -0.2618F);
        bone9.setTextureOffset(16, 4).addBox(-0.8115F, -0.6038F, -0.6872F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        bone11 = new ModelRenderer(this);
        bone11.setRotationPoint(2.5F, -1.2682F, -3.9993F);
        mouth.addChild(bone11);
        setRotationAngle(bone11, 0.4363F, 0.0F, 0.2618F);
        bone11.setTextureOffset(16, 4).addBox(-0.1885F, -0.6038F, -0.6872F, 1.0F, 2.0F, 1.0F, 0.0F, true);

        horny1 = new ModelRenderer(this);
        horny1.setRotationPoint(2.75F, -3.0253F, -0.0429F);
        bone3.addChild(horny1);
        setRotationAngle(horny1, 0.3186F, -0.1451F, 0.413F);
        horny1.setTextureOffset(64, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

        bone5 = new ModelRenderer(this);
        bone5.setRotationPoint(-0.8164F, -1.7509F, 0.5176F);
        horny1.addChild(bone5);
        setRotationAngle(bone5, 0.0F, 0.0F, 0.4363F);
        bone5.setTextureOffset(64, 4).addBox(-0.4946F, -0.5759F, -1.4356F, 2.0F, 2.0F, 2.0F, 0.0F, false);

        bone6 = new ModelRenderer(this);
        bone6.setRotationPoint(-2.6862F, -2.2112F, 0.8412F);
        horny1.addChild(bone6);
        setRotationAngle(bone6, 0.0F, 0.0F, -0.0873F);
        bone6.setTextureOffset(64, 8).addBox(-0.4893F, -0.6559F, -1.6771F, 2.0F, 2.0F, 2.0F, 0.0F, false);

        horny2 = new ModelRenderer(this);
        horny2.setRotationPoint(-2.75F, -3.0253F, -0.0429F);
        bone3.addChild(horny2);
        setRotationAngle(horny2, 0.3186F, 0.1451F, -0.413F);
        horny2.setTextureOffset(64, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, true);

        bone4 = new ModelRenderer(this);
        bone4.setRotationPoint(0.8164F, -1.7509F, 0.5176F);
        horny2.addChild(bone4);
        setRotationAngle(bone4, 0.0F, 0.0F, -0.4363F);
        bone4.setTextureOffset(64, 4).addBox(-1.5054F, -0.5759F, -1.4356F, 2.0F, 2.0F, 2.0F, 0.0F, true);

        bone7 = new ModelRenderer(this);
        bone7.setRotationPoint(2.6862F, -2.2112F, 0.8412F);
        horny2.addChild(bone7);
        setRotationAngle(bone7, 0.0F, 0.0F, 0.0873F);
        bone7.setTextureOffset(64, 8).addBox(-1.5107F, -0.6559F, -1.6771F, 2.0F, 2.0F, 2.0F, 0.0F, true);

        leftWing = new ModelRenderer(this);
        leftWing.setRotationPoint(1.75F, 0.5F, 1.5F);
        total.addChild(leftWing);


        bone8 = new ModelRenderer(this);
        bone8.setRotationPoint(-3.0F, -1.5F, 8.75F);
        leftWing.addChild(bone8);
        setRotationAngle(bone8, 0.2618F, 0.3927F, 0.0F);
        bone8.setTextureOffset(42, 11).addBox(5.7046F, -13.5155F, -6.9948F, 1.0F, 25.0F, 14.0F, 0.0F, false);

        rightWing = new ModelRenderer(this);
        rightWing.setRotationPoint(-1.75F, 0.5F, 1.5F);
        total.addChild(rightWing);


        bone10 = new ModelRenderer(this);
        bone10.setRotationPoint(3.0F, -1.5F, 8.75F);
        rightWing.addChild(bone10);
        setRotationAngle(bone10, 0.2618F, -0.3927F, 0.0F);
        bone10.setTextureOffset(42, 11).addBox(-6.7046F, -13.5155F, -6.9948F, 1.0F, 25.0F, 14.0F, 0.0F, true);
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
