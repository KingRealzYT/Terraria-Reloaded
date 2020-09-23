package com.kingrealzyt.terrariareloaded.world.capability;

import com.kingrealzyt.terrariareloaded.inventory.PiggyBankInventory;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.util.LazyOptional;

public class PlayerCoinInventory {

    private PiggyBankInventory piggyBankInventory;

    public PlayerCoinInventory() {
        this.piggyBankInventory = new PiggyBankInventory();
    }

    public void setPiggyBankInventory(PiggyBankInventory piggyBankInventory) {
        this.piggyBankInventory = piggyBankInventory;
    }

    public PiggyBankInventory getPiggyBankInventory() {
        return piggyBankInventory;
    }


    public static class Capability {

        @CapabilityInject(PlayerCoinInventory.class)
        public static net.minecraftforge.common.capabilities.Capability<PlayerCoinInventory> PLAYER_COIN_INVENTORY_CAP;

        public static LazyOptional<PlayerCoinInventory> getWorldPressure(final World world) {
            return world.getCapability(PLAYER_COIN_INVENTORY_CAP, null);
        }

        public static net.minecraftforge.common.capabilities.Capability<PlayerCoinInventory> get() {
            return PLAYER_COIN_INVENTORY_CAP;
        }

    }
}
