package com.kingrealzyt.terrariareloaded.events;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.world.capability.PlayerCoinCapabilityProvider;
import com.kingrealzyt.terrariareloaded.world.capability.PlayerCoinStorage;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/*
        THIS IS ONLY FOR TEST OR DEBUG THINGS
 */

@Mod.EventBusSubscriber(modid = TerrariaReloaded.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class DEBUGEVENT {

    @SubscribeEvent
    public static void onJoin(EntityJoinWorldEvent event) {
        if(event.getEntity() instanceof PlayerEntity) {
            PlayerEntity playerEntity = (PlayerEntity) event.getEntity();
            PlayerCoinStorage coinStorage = PlayerCoinCapabilityProvider.getPlayerCapability(playerEntity).orElse(null);
            coinStorage.setBronze(120);
            coinStorage.setGold(2);
        }
    }

}
