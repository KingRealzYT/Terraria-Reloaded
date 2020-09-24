package com.kingrealzyt.terrariareloaded.client.model.npc;

import com.kingrealzyt.terrariareloaded.entities.npc.DemolitionistNPCEntity;
import com.kingrealzyt.terrariareloaded.entities.npc.DyeTraderNPCEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class DemolitionistNPCModel<T extends DemolitionistNPCEntity> extends EntityModel<T> {

    private final ModelRenderer armLeft;
    private final ModelRenderer head;
    private final ModelRenderer bone4;
    private final ModelRenderer legLeft;
    private final ModelRenderer bone2;
    private final ModelRenderer bone3;
    private final ModelRenderer legRight;
    private final ModelRenderer bone;
    private final ModelRenderer armRight;
    private final ModelRenderer body;

    public DemolitionistNPCModel() {
        textureWidth = 72;
        textureHeight = 72;

        armLeft = new ModelRenderer(this);
        armLeft.setRotationPoint(4.0F, 1.5F, 0.0F);
        armLeft.setTextureOffset(48, 56).addBox(0.0F, -1.5F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 0.0F, 0.0F);
        head.setTextureOffset(0, 24).addBox(-4.0F, -7.75F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
        head.setTextureOffset(12, 9).addBox(-2.5F, -1.5863F, -4.1901F, 5.0F, 1.0F, 0.0F, 0.0F, false);
        head.setTextureOffset(0, 13).addBox(-3.75F, -4.5863F, -4.1901F, 3.0F, 1.0F, 0.0F, 0.0F, false);
        head.setTextureOffset(0, 15).addBox(0.75F, -4.5863F, -4.1901F, 3.0F, 1.0F, 0.0F, 0.0F, false);
        head.setTextureOffset(0, 0).addBox(-4.0F, -1.8363F, -4.0026F, 8.0F, 9.0F, 0.0F, 0.0F, false);
        head.setTextureOffset(36, 0).addBox(-4.0F, -6.0F, -6.0F, 8.0F, 1.0F, 2.0F, 0.0F, false);
        head.setTextureOffset(36, 11).addBox(-3.5F, -8.75F, -2.25F, 7.0F, 1.0F, 5.0F, 0.0F, false);

        bone4 = new ModelRenderer(this);
        bone4.setRotationPoint(0.0F, -7.0F, -3.75F);
        head.addChild(bone4);
        setRotationAngle(bone4, -0.3927F, 0.0F, 0.0F);
        bone4.setTextureOffset(35, 21).addBox(-2.0F, -1.4522F, -0.6155F, 4.0F, 3.0F, 1.0F, 0.0F, false);

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
        armRight.setTextureOffset(48, 56).addBox(-4.0F, -1.5F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 3.75F, 2.25F);
        body.setTextureOffset(0, 40).addBox(-4.0F, -3.75F, -4.25F, 8.0F, 12.0F, 4.0F, 0.0F, false);
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
