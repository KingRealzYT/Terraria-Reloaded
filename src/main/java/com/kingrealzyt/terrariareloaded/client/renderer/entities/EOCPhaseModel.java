package com.kingrealzyt.terrariareloaded.client.renderer.entities;

import com.kingrealzyt.terrariareloaded.client.model.EOC2Model;
import com.kingrealzyt.terrariareloaded.client.model.EOCModel;
import com.kingrealzyt.terrariareloaded.entities.boss.EOCEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.EntityModel;

public class EOCPhaseModel extends EntityModel<EOCEntity> {
	
	EntityRendererManager render;
	
	EOCModel phase1 = new EOCModel();
	
	EOC2Model phase2 = new EOC2Model();
	
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		if (EOCEntity.phase == 1) {
			this.phase1.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	    }
	    if (EOCEntity.phase == 2) {
			this.phase2.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	    }
	 }

	@Override
	public void setRotationAngles(EOCEntity arg0, float arg1, float arg2, float arg3, float arg4, float arg5) {
		
	}
}