package com.kingrealzyt.terrariareloaded.world.capability.player;

import com.kingrealzyt.terrariareloaded.inventory.PiggyBankInventory;

public class PlayerCoinCapabilityImpl implements IPlayerCoinCapability{

    private PiggyBankInventory piggyBankInventory = new PiggyBankInventory();

    @Override
    public void setPiggyBankInventory(PiggyBankInventory piggyBankInventory) {
        this.piggyBankInventory = piggyBankInventory;
    }

    @Override
    public PiggyBankInventory getPiggyBankInventory() {
        return piggyBankInventory;
    }
}
