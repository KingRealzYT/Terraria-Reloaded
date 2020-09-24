package com.kingrealzyt.terrariareloaded.world.capability.player;

import com.kingrealzyt.terrariareloaded.inventory.PiggyBankInventory;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class PlayerCoinCapabilitySerializable implements ICapabilitySerializable<ListNBT> {

    private IPlayerCoinCapability iPlayerCoinCapability;

    public PlayerCoinCapabilitySerializable() {
        this.iPlayerCoinCapability = new PlayerCoinCapabilityImpl();
        this.iPlayerCoinCapability.setPiggyBankInventory(new PiggyBankInventory());
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        return IPlayerCoinCapability.Capability.get().orEmpty(cap, LazyOptional.of(() -> iPlayerCoinCapability));
    }

    @Override
    public ListNBT serializeNBT() {
        System.out.print("CAPABILITY_SERIALIZE");
        return iPlayerCoinCapability.getPiggyBankInventory().write();
    }

    @Override
    public void deserializeNBT(ListNBT nbt) {
        PiggyBankInventory piggyBankInventory = new PiggyBankInventory();
        piggyBankInventory.read(nbt);
        if(iPlayerCoinCapability == null)
            iPlayerCoinCapability = new PlayerCoinCapabilityImpl();
        iPlayerCoinCapability.setPiggyBankInventory(piggyBankInventory);
        System.out.println("CAPABILITY_DESERIALIZE");
    }
}
