package com.kingrealzyt.terrariareloaded.entities.boss.ai.eoc;

import com.kingrealzyt.terrariareloaded.entities.boss.EOCEntity;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class EOCMovementHelperController extends MovementController {

    private final EOCEntity eoc;
    private int courseChangeCooldown;

    public EOCMovementHelperController(EOCEntity eoc) {
        super(eoc);
        this.eoc = eoc;
    }

    public void tick() {
        if (this.action == MovementController.Action.MOVE_TO) {
            if (this.courseChangeCooldown-- <= 0) {
                this.courseChangeCooldown += this.eoc.getRNG().nextInt(5) + 2;
                Vec3d vec3d = new Vec3d(this.posX - this.eoc.getPosX(), this.posY - this.eoc.getPosY(), this.posZ - this.eoc.getPosZ());
                double d0 = vec3d.length();
                vec3d = vec3d.normalize();
                if (this.collide(vec3d, MathHelper.ceil(d0))) {
                    this.eoc.setMotion(this.eoc.getMotion().add(vec3d.scale(0.1D)));
                } else {
                    this.action = MovementController.Action.WAIT;
                }
            }

        }
    }

    private boolean collide(Vec3d vec3d, int iteration) {
        AxisAlignedBB axisalignedbb = this.eoc.getBoundingBox();

        for (int i = 1; i < iteration; ++i) {
            axisalignedbb = axisalignedbb.offset(vec3d);
            if (!this.eoc.world.hasNoCollisions(this.eoc, axisalignedbb)) {
                return false;
            }
        }

        return true;
    }
}
