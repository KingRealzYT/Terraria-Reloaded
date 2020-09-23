package com.kingrealzyt.terrariareloaded.world.capability;

import com.kingrealzyt.terrariareloaded.inventory.PiggyBankInventory;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

public class PlayerCoinInventoryStorage implements Capability.IStorage<PlayerCoinInventory> {

    @Override
    public INBT writeNBT(Capability<PlayerCoinInventory> capability, PlayerCoinInventory instance, Direction side) {
        System.out.println("CAPABILITY_WRITE: " + instance);
        return instance.getPiggyBankInventory().write();
    }

    @Override
    public void readNBT(Capability<PlayerCoinInventory> capability, PlayerCoinInventory instance, Direction side, INBT nbt) {
        System.out.println("CAPABILITY_READ: " + instance);
        PiggyBankInventory inventory = new PiggyBankInventory();
        inventory.read((ListNBT) nbt);
        instance.setPiggyBankInventory(inventory);
    }
}
