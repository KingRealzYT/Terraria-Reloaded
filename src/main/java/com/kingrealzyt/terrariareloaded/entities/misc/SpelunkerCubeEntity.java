package com.kingrealzyt.terrariareloaded.entities.misc;


import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;

public class SpelunkerCubeEntity extends MobEntity {

    public SpelunkerCubeEntity(EntityType<? extends MobEntity> p_i50218_1_, World p_i50218_2_) {
        super(p_i50218_1_, p_i50218_2_);
        setNoGravity(true);
        this.noClip = true;
    }


    @Override
    public boolean canBeAttackedWithItem() {
        return false;
    }

    @Override
    public boolean canBeCollidedWith() {
        return false;
    }


}
