package com.kingrealzyt.terrariareloaded.entities.npc;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.world.BossInfo;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;

public class GuideNPCEntity extends ShopNPCEntity {

    public GuideNPCEntity(EntityType<? extends AbstractVillagerEntity> type, World worldIn) {
        super(type, worldIn, ShopType.GUIDE);
    }

    //Keep this stuff here just so we can easily see what the bosses need for the boss bar
    //private final ServerBossInfo bossInfo = (ServerBossInfo)(new ServerBossInfo(this.getDisplayName(), BossInfo.Color.PURPLE, BossInfo.Overlay.PROGRESS)).setDarkenSky(true);
//    @Override
//    public void livingTick() {
//        this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
//        super.livingTick();
//    }
//
//    public void addTrackingPlayer(ServerPlayerEntity player) {
//        super.addTrackingPlayer(player);
//        this.bossInfo.addPlayer(player);
//    }
//
//    public void removeTrackingPlayer(ServerPlayerEntity player) {
//        super.removeTrackingPlayer(player);
//        this.bossInfo.removePlayer(player);
//    }
//
//    public boolean isNonBoss() {
//        return false;
//    }
}
