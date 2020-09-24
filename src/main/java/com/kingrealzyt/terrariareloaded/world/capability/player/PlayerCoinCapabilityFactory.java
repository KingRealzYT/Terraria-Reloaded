package com.kingrealzyt.terrariareloaded.world.capability.player;

import java.util.concurrent.Callable;

public class PlayerCoinCapabilityFactory implements Callable<IPlayerCoinCapability> {

    @Override
    public IPlayerCoinCapability call() throws Exception {
        return new PlayerCoinCapabilityImpl();
    }
}
