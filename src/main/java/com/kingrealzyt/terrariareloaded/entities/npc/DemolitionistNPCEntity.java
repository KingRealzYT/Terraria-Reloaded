package com.kingrealzyt.terrariareloaded.entities.npc;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.world.World;

public class DemolitionistNPCEntity extends ShopNPCEntity {

    public DemolitionistNPCEntity(EntityType<? extends AbstractVillagerEntity> type, World worldIn) {
        super(type, worldIn, ShopType.DEMOLITIONIST);
    }
}
