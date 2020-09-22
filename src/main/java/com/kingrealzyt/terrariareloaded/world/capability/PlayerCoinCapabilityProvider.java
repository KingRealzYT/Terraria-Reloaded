package com.kingrealzyt.terrariareloaded.world.capability;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;

/**
 * Use this class, to get the coin amount or the {@link PlayerCoinStorage} class himself
 *
 * {@link PlayerCoinCapabilityProvider#getCoinAmount(PlayerEntity, PlayerCoinStorage.Coin)} get the coin amount
 */
public class PlayerCoinCapabilityProvider implements ICapabilityProvider {

    private final LazyOptional<PlayerCoinStorage> coinStorage;

    public PlayerCoinCapabilityProvider() {
        this.coinStorage = LazyOptional.of(PlayerCoinStorage::new);
    }

    public static LazyOptional<PlayerCoinStorage> getClientCapability() {
        assert Minecraft.getInstance().player != null;
        return Optional.of(Minecraft.getInstance().player).map(p -> p.getCapability(PlayerCoinStorage.Capability.get())).orElse(null);
    }

    public static LazyOptional<PlayerCoinStorage> getPlayerCapability(PlayerEntity player) {
        return player.getCapability(PlayerCoinStorage.Capability.get());
    }

    /**
     * Use this to get the coin amount
     *
     * @param player the player entity
     * @param coin the coin type
     * @return the amount or -1 if it is not present
     * @throws IllegalStateException if the coin type is null or invalid
     */
    public static int getCoinAmount(PlayerEntity player, PlayerCoinStorage.Coin coin) {
        return player.getCapability(PlayerCoinStorage.Capability.get()).map(s -> s.getAmount(coin)).orElse(-1);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return PlayerCoinStorage.Capability.get().orEmpty(cap, this.coinStorage);
    }


}
