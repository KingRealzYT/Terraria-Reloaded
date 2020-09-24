package com.kingrealzyt.terrariareloaded.world.capability.player;

import com.kingrealzyt.terrariareloaded.inventory.PiggyBankInventory;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

public class PlayerCoinCapabilityStorage implements Capability.IStorage<IPlayerCoinCapability>{

    @Override
    public INBT writeNBT(Capability<IPlayerCoinCapability> capability, IPlayerCoinCapability instance, Direction side) {
        IPlayerCoinCapability playerCoinCapability = capability.getDefaultInstance();
        if(playerCoinCapability == null)
            throw new NullPointerException("Capability is null");
        return playerCoinCapability.getPiggyBankInventory().write();
    }

    @Override
    public void readNBT(Capability<IPlayerCoinCapability> capability, IPlayerCoinCapability instance, Direction side, INBT nbt) {
        IPlayerCoinCapability playerCoinCapability = capability.getDefaultInstance();
        if(playerCoinCapability == null)
            throw new NullPointerException("Capability is null");
        PiggyBankInventory piggyBankInventory = new PiggyBankInventory();
        piggyBankInventory.read((ListNBT) nbt);
        playerCoinCapability.setPiggyBankInventory(piggyBankInventory);
    }
}
