package com.kingrealzyt.terrariareloaded.world.capability;

import com.kingrealzyt.terrariareloaded.world.capability.player.IPlayerCoinCapability;
import com.kingrealzyt.terrariareloaded.world.capability.player.PlayerCoinCapabilityImpl;
import net.minecraft.entity.player.PlayerEntity;

public class CapabilityAccessor {

    /**
     * Use this method to get the IPlayerCoinCapability which stored the piggy bank inventory
     *
     * @param playerEntity the player entity
     * @return the {@link IPlayerCoinCapability} instance OR a new instance from {@link IPlayerCoinCapability} if the player has no capability
     */
    public static IPlayerCoinCapability getPlayerCoinCapability(PlayerEntity playerEntity) {
        return playerEntity.getCapability(IPlayerCoinCapability.Capability.PLAYER_COIN_CAP).orElse(new PlayerCoinCapabilityImpl());
    }

}
