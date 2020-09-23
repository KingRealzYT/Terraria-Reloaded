package com.kingrealzyt.terrariareloaded.world.capability;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;

import java.util.Optional;

public class PlayerCoinInventoryCapabilityProvider implements ICapabilityProvider {

    private final LazyOptional<PlayerCoinInventory> playerCoinInventory;

    public PlayerCoinInventoryCapabilityProvider() {
        this.playerCoinInventory = LazyOptional.of(PlayerCoinInventory::new);
    }

    public static LazyOptional<PlayerCoinInventory> getClientCapability() {
        assert Minecraft.getInstance().player != null;
        return Optional.of(Minecraft.getInstance().player).map(p -> p.getCapability(PlayerCoinInventory.Capability.get())).orElse(null);
    }

    public static LazyOptional<PlayerCoinInventory> getPlayerCapability(PlayerEntity player) {
        return player.getCapability(PlayerCoinInventory.Capability.get());
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        return PlayerCoinInventory.Capability.get().orEmpty(cap, this.playerCoinInventory);
    }
}
