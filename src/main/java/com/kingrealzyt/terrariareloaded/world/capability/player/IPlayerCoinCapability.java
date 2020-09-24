package com.kingrealzyt.terrariareloaded.world.capability.player;

import com.kingrealzyt.terrariareloaded.inventory.PiggyBankInventory;
import net.minecraftforge.common.capabilities.CapabilityInject;

public interface IPlayerCoinCapability {

    void setPiggyBankInventory(PiggyBankInventory piggyBankInventory);

    PiggyBankInventory getPiggyBankInventory();

    class Capability {

        @CapabilityInject(IPlayerCoinCapability.class)
        public static net.minecraftforge.common.capabilities.Capability<IPlayerCoinCapability> PLAYER_COIN_CAP;

        public static net.minecraftforge.common.capabilities.Capability<IPlayerCoinCapability> get() {
            return PLAYER_COIN_CAP;
        }

    }

}
