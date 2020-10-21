package com.kingrealzyt.terrariareloaded.client.model;

import com.kingrealzyt.terrariareloaded.entities.boss.EOCEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class EOC2Model extends EntityModel<EOCEntity> {

    private final ModelRenderer total;
    private final ModelRenderer head;
    private final ModelRenderer bone4;
    private final ModelRenderer bone2;
    private final ModelRenderer bone3;
    private final ModelRenderer mouthTop;
    private final ModelRenderer maw3;
    private final ModelRenderer bone16;
    private final ModelRenderer bone;
    private final ModelRenderer bone17;
    private final ModelRenderer bone18;
    private final ModelRenderer bone19;
    private final ModelRenderer bone20;
    private final ModelRenderer bone33;
    private final ModelRenderer bone34;
    private final ModelRenderer bone21;
    private final ModelRenderer bone22;
    private final ModelRenderer bone27;
    private final ModelRenderer bone28;
    private final ModelRenderer bone23;
    private final ModelRenderer bone24;
    private final ModelRenderer bone25;
    private final ModelRenderer bone26;
    private final ModelRenderer mouthBottom;
    private final ModelRenderer maw2;
    private final ModelRenderer bone5;
    private final ModelRenderer bone6;
    private final ModelRenderer bone7;
    private final ModelRenderer bone14;
    private final ModelRenderer bone15;
    private final ModelRenderer bone31;
    private final ModelRenderer bone32;
    private final ModelRenderer bone8;
    private final ModelRenderer bone9;
    private final ModelRenderer bone29;
    private final ModelRenderer bone30;
    private final ModelRenderer bone10;
    private final ModelRenderer bone11;
    private final ModelRenderer bone12;
    private final ModelRenderer bone13;
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

    public EOC2Model() {
        textureWidth = 364;
        textureHeight = 364;

        total = new ModelRenderer(this);
        total.setRotationPoint(0.0F, -5.0F, 0.0F);


        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, -1.0F, 0.0F);
        total.addChild(head);
        head.setTextureOffset(104, 251).addBox(-19.0F, -21.5F, 18.0F, 39.0F, 45.0F, 6.0F, 0.0F, false);

        bone4 = new ModelRenderer(this);
        bone4.setRotationPoint(0.5F, 1.0F, 21.0F);
        head.addChild(bone4);
        setRotationAngle(bone4, 0.0F, 0.0F, -1.5708F);
        bone4.setTextureOffset(0, 267).addBox(-19.5F, -22.0F, -1.75F, 39.0F, 44.0F, 6.0F, 0.0F, false);

        bone2 = new ModelRenderer(this);
        bone2.setRotationPoint(0.5F, 1.0F, 0.0F);
        head.addChild(bone2);
        setRotationAngle(bone2, 0.0F, 1.5708F, 0.0F);
        bone2.setTextureOffset(105, 131).addBox(-19.5F, -19.0F, -23.0F, 28.0F, 38.0F, 46.0F, 0.0F, false);

        bone3 = new ModelRenderer(this);
        bone3.setRotationPoint(0.5F, 1.0F, 0.0F);
        head.addChild(bone3);
        setRotationAngle(bone3, -1.5708F, 1.5708F, 0.0F);
        bone3.setTextureOffset(144, 44).addBox(-19.25F, -19.0F, -23.0F, 27.0F, 38.0F, 46.0F, 0.0F, false);

        mouthTop = new ModelRenderer(this);
        mouthTop.setRotationPoint(0.0F, -16.75F, -9.0F);
        head.addChild(mouthTop);


        maw3 = new ModelRenderer(this);
        maw3.setRotationPoint(0.75F, -1.0F, 1.0F);
        mouthTop.addChild(maw3);
        setRotationAngle(maw3, 0.1745F, 0.0F, 0.0F);
        maw3.setTextureOffset(267, 173).addBox(16.25F, 0.5411F, -15.3356F, 6.0F, 6.0F, 17.0F, 0.0F, false);
        maw3.setTextureOffset(249, 201).addBox(-23.75F, 0.5411F, -15.3356F, 6.0F, 6.0F, 17.0F, 0.0F, true);

        bone16 = new ModelRenderer(this);
        bone16.setRotationPoint(-0.25F, 1.8468F, -15.5592F);
        maw3.addChild(bone16);
        setRotationAngle(bone16, 3.0107F, 3.1416F, 0.0F);
        bone16.setTextureOffset(210, 257).addBox(-18.5F, -4.0F, -6.0F, 37.0F, 8.0F, 12.0F, 0.0F, false);

        bone = new ModelRenderer(this);
        bone.setRotationPoint(-0.25F, 0.1247F, -5.8805F);
        maw3.addChild(bone);
        setRotationAngle(bone, 3.1416F, 3.1416F, 0.0F);
        bone.setTextureOffset(213, 227).addBox(-20.5F, -5.0F, -8.5F, 41.0F, 10.0F, 17.0F, 0.0F, false);

        bone17 = new ModelRenderer(this);
        bone17.setRotationPoint(-8.25F, 5.7302F, -19.011F);
        maw3.addChild(bone17);
        setRotationAngle(bone17, -0.1309F, 0.0F, 0.0F);
        bone17.setTextureOffset(0, 0).addBox(-1.0F, 0.0F, 0.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);

        bone18 = new ModelRenderer(this);
        bone18.setRotationPoint(0.0F, 4.6985F, -1.7101F);
        bone17.addChild(bone18);
        setRotationAngle(bone18, 0.1745F, 0.0F, 0.0F);
        bone18.setTextureOffset(0, 10).addBox(-0.5F, 0.134F, 2.2321F, 2.0F, 5.0F, 2.0F, 0.0F, false);

        bone19 = new ModelRenderer(this);
        bone19.setRotationPoint(-0.75F, 5.8896F, -19.5468F);
        maw3.addChild(bone19);
        setRotationAngle(bone19, 0.3927F, 0.0F, 0.0F);
        bone19.setTextureOffset(0, 0).addBox(-1.0F, 0.0F, 0.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);

        bone20 = new ModelRenderer(this);
        bone20.setRotationPoint(0.0F, 4.6985F, -1.7101F);
        bone19.addChild(bone20);
        setRotationAngle(bone20, 0.1745F, 0.0F, 0.0F);
        bone20.setTextureOffset(0, 10).addBox(-0.5F, 0.134F, 2.2321F, 2.0F, 5.0F, 2.0F, 0.0F, false);

        bone33 = new ModelRenderer(this);
        bone33.setRotationPoint(8.25F, 3.6738F, -19.1561F);
        maw3.addChild(bone33);
        setRotationAngle(bone33, 0.3927F, -0.3927F, 0.0F);
        bone33.setTextureOffset(0, 0).addBox(-1.0F, 0.0F, 0.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);

        bone34 = new ModelRenderer(this);
        bone34.setRotationPoint(0.0F, 4.6985F, -1.7101F);
        bone33.addChild(bone34);
        setRotationAngle(bone34, 0.1745F, 0.0F, 0.0F);
        bone34.setTextureOffset(0, 10).addBox(-0.5F, 0.134F, 2.2321F, 2.0F, 5.0F, 2.0F, 0.0F, false);

        bone21 = new ModelRenderer(this);
        bone21.setRotationPoint(-18.5F, 5.9324F, -14.9849F);
        maw3.addChild(bone21);
        setRotationAngle(bone21, 0.1745F, 0.5236F, 0.0F);
        bone21.setTextureOffset(0, 0).addBox(-1.0F, 0.0F, 0.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);

        bone22 = new ModelRenderer(this);
        bone22.setRotationPoint(0.0F, 4.6985F, -1.7101F);
        bone21.addChild(bone22);
        setRotationAngle(bone22, 0.1745F, 0.0F, 0.0F);
        bone22.setTextureOffset(0, 10).addBox(-0.5F, 0.134F, 2.2321F, 2.0F, 5.0F, 2.0F, 0.0F, false);

        bone27 = new ModelRenderer(this);
        bone27.setRotationPoint(16.25F, 5.9324F, -14.9849F);
        maw3.addChild(bone27);
        setRotationAngle(bone27, 0.1745F, -0.5236F, 0.0F);
        bone27.setTextureOffset(0, 0).addBox(-2.0F, 0.0F, 0.0F, 3.0F, 5.0F, 3.0F, 0.0F, true);

        bone28 = new ModelRenderer(this);
        bone28.setRotationPoint(0.0F, 4.6985F, -1.7101F);
        bone27.addChild(bone28);
        setRotationAngle(bone28, 0.1745F, 0.0F, 0.0F);
        bone28.setTextureOffset(0, 10).addBox(-1.5F, 0.134F, 2.2321F, 2.0F, 5.0F, 2.0F, 0.0F, true);

        bone23 = new ModelRenderer(this);
        bone23.setRotationPoint(21.75F, 6.1631F, -7.9176F);
        maw3.addChild(bone23);
        setRotationAngle(bone23, -2.9671F, -1.4835F, 2.81F);
        bone23.setTextureOffset(0, 0).addBox(-1.0F, 0.0F, 0.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);

        bone24 = new ModelRenderer(this);
        bone24.setRotationPoint(0.0F, 4.6985F, -1.7101F);
        bone23.addChild(bone24);
        setRotationAngle(bone24, 0.1745F, 0.0F, 0.0F);
        bone24.setTextureOffset(0, 10).addBox(-0.5F, 0.134F, 2.2321F, 2.0F, 5.0F, 2.0F, 0.0F, false);

        bone25 = new ModelRenderer(this);
        bone25.setRotationPoint(-23.25F, 6.5104F, -5.948F);
        maw3.addChild(bone25);
        setRotationAngle(bone25, -2.9671F, 1.4835F, 3.1241F);
        bone25.setTextureOffset(0, 0).addBox(-2.0F, 0.0F, 0.0F, 3.0F, 5.0F, 3.0F, 0.0F, true);

        bone26 = new ModelRenderer(this);
        bone26.setRotationPoint(0.0F, 4.6985F, -1.7101F);
        bone25.addChild(bone26);
        setRotationAngle(bone26, 0.1745F, 0.0F, 0.0F);
        bone26.setTextureOffset(0, 10).addBox(-1.5F, 0.134F, 2.2321F, 2.0F, 5.0F, 2.0F, 0.0F, true);

        mouthBottom = new ModelRenderer(this);
        mouthBottom.setRotationPoint(0.0F, 16.0F, -7.0F);
        head.addChild(mouthBottom);


        maw2 = new ModelRenderer(this);
        maw2.setRotationPoint(0.75F, 2.0F, 1.0F);
        mouthBottom.addChild(maw2);
        setRotationAngle(maw2, -0.1745F, 0.0F, 0.0F);
        maw2.setTextureOffset(213, 227).addBox(-20.75F, -3.7926F, -16.1765F, 41.0F, 10.0F, 17.0F, 0.0F, false);
        maw2.setTextureOffset(267, 173).addBox(16.25F, -6.1938F, -17.3052F, 6.0F, 6.0F, 17.0F, 0.0F, false);
        maw2.setTextureOffset(249, 201).addBox(-23.75F, -6.1938F, -17.3052F, 6.0F, 6.0F, 17.0F, 0.0F, true);

        bone5 = new ModelRenderer(this);
        bone5.setRotationPoint(0.0F, 0.9709F, -11.5275F);
        maw2.addChild(bone5);
        setRotationAngle(bone5, -0.3054F, 0.0F, 0.0F);
        bone5.setTextureOffset(210, 257).addBox(-18.75F, -4.747F, -11.6974F, 37.0F, 8.0F, 12.0F, 0.0F, false);

        bone6 = new ModelRenderer(this);
        bone6.setRotationPoint(-13.25F, -5.3829F, -20.9806F);
        maw2.addChild(bone6);
        setRotationAngle(bone6, 0.1309F, 0.0F, 0.0F);
        bone6.setTextureOffset(0, 0).addBox(-1.0F, -5.0F, 0.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);

        bone7 = new ModelRenderer(this);
        bone7.setRotationPoint(0.0F, -4.6985F, -1.7101F);
        bone6.addChild(bone7);
        setRotationAngle(bone7, -0.1745F, 0.0F, 0.0F);
        bone7.setTextureOffset(0, 10).addBox(-0.5F, -5.134F, 2.2321F, 2.0F, 5.0F, 2.0F, 0.0F, false);

        bone14 = new ModelRenderer(this);
        bone14.setRotationPoint(0.75F, -4.5575F, -21.3427F);
        maw2.addChild(bone14);
        setRotationAngle(bone14, -0.3927F, 0.0F, 0.0F);
        bone14.setTextureOffset(0, 0).addBox(-1.0F, -5.0F, 0.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);

        bone15 = new ModelRenderer(this);
        bone15.setRotationPoint(0.0F, -4.6985F, -1.7101F);
        bone14.addChild(bone15);
        setRotationAngle(bone15, -0.1745F, 0.0F, 0.0F);
        bone15.setTextureOffset(0, 10).addBox(-0.5F, -5.134F, 2.2321F, 2.0F, 5.0F, 2.0F, 0.0F, false);

        bone31 = new ModelRenderer(this);
        bone31.setRotationPoint(-4.25F, -2.5879F, -20.9954F);
        maw2.addChild(bone31);
        setRotationAngle(bone31, -0.3927F, -0.3927F, 0.0F);
        bone31.setTextureOffset(0, 0).addBox(-1.0F, -5.0F, 0.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);

        bone32 = new ModelRenderer(this);
        bone32.setRotationPoint(0.0F, -4.6985F, -1.7101F);
        bone31.addChild(bone32);
        setRotationAngle(bone32, -0.1745F, 0.0F, 0.0F);
        bone32.setTextureOffset(0, 10).addBox(-0.5F, -5.134F, 2.2321F, 2.0F, 5.0F, 2.0F, 0.0F, false);

        bone8 = new ModelRenderer(this);
        bone8.setRotationPoint(11.75F, -6.6139F, -21.1976F);
        maw2.addChild(bone8);
        setRotationAngle(bone8, -0.1745F, 0.0F, 0.0F);
        bone8.setTextureOffset(0, 0).addBox(-1.0F, -5.0F, 0.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);

        bone9 = new ModelRenderer(this);
        bone9.setRotationPoint(0.0F, -4.6985F, -1.7101F);
        bone8.addChild(bone9);
        setRotationAngle(bone9, -0.1745F, 0.0F, 0.0F);
        bone9.setTextureOffset(0, 10).addBox(-0.5F, -5.134F, 2.2321F, 2.0F, 5.0F, 2.0F, 0.0F, false);

        bone29 = new ModelRenderer(this);
        bone29.setRotationPoint(-19.0F, -2.8769F, -16.477F);
        maw2.addChild(bone29);
        setRotationAngle(bone29, -0.1745F, 0.829F, 0.0F);
        bone29.setTextureOffset(0, 0).addBox(-1.0F, -5.0F, 0.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);

        bone30 = new ModelRenderer(this);
        bone30.setRotationPoint(0.0F, -4.6985F, -1.7101F);
        bone29.addChild(bone30);
        setRotationAngle(bone30, -0.1745F, 0.0F, 0.0F);
        bone30.setTextureOffset(0, 10).addBox(-0.5F, -5.134F, 2.2321F, 2.0F, 5.0F, 2.0F, 0.0F, false);

        bone10 = new ModelRenderer(this);
        bone10.setRotationPoint(21.75F, -5.8159F, -9.8872F);
        maw2.addChild(bone10);
        setRotationAngle(bone10, 2.9671F, -1.4835F, 2.9932F);
        bone10.setTextureOffset(0, 0).addBox(-1.0F, -5.0F, 0.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);

        bone11 = new ModelRenderer(this);
        bone11.setRotationPoint(0.0F, -4.6985F, -1.7101F);
        bone10.addChild(bone11);
        setRotationAngle(bone11, -0.1745F, 0.0F, 0.0F);
        bone11.setTextureOffset(0, 10).addBox(-0.5F, -5.134F, 2.2321F, 2.0F, 5.0F, 2.0F, 0.0F, false);

        bone12 = new ModelRenderer(this);
        bone12.setRotationPoint(-23.25F, -5.8159F, -9.8872F);
        maw2.addChild(bone12);
        setRotationAngle(bone12, 2.9671F, 1.4835F, 2.9409F);
        bone12.setTextureOffset(0, 0).addBox(-2.0F, -5.0F, 0.0F, 3.0F, 5.0F, 3.0F, 0.0F, true);

        bone13 = new ModelRenderer(this);
        bone13.setRotationPoint(0.0F, -4.6985F, -1.7101F);
        bone12.addChild(bone13);
        setRotationAngle(bone13, -0.1745F, 0.0F, 0.0F);
        bone13.setTextureOffset(0, 10).addBox(-1.5F, -5.134F, 2.2321F, 2.0F, 5.0F, 2.0F, 0.0F, true);

        arm1a = new ModelRenderer(this);
        arm1a.setRotationPoint(19.0F, 0.5F, 24.5F);
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
        arm1a2.setRotationPoint(-17.0F, 0.5F, 24.5F);
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
        arm2a.setRotationPoint(16.75F, -16.0F, 24.5F);
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
        arm3a.setRotationPoint(-16.75F, -16.0F, 24.5F);
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
        arm4a.setRotationPoint(-16.75F, 13.0F, 24.5F);
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
        arm5a.setRotationPoint(14.25F, 13.0F, 24.5F);
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
        arm6a.setRotationPoint(-0.5F, 17.75F, 24.5F);
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
        arm7a.setRotationPoint(-0.5F, -17.25F, 24.5F);
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
    public void setRotationAngles(EOCEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
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
    public void setLivingAnimations(EOCEntity entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
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
