package com.kingrealzyt.terrariareloaded.world.capability;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.world.capability.player.PlayerCoinCapabilitySerializable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TerrariaReloaded.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AttachCapabilityEvent {

    @SubscribeEvent
    public static void attachToPlayer(AttachCapabilitiesEvent<Entity> event) {
        //event.addCapability(new ResourceLocation(TerrariaReloaded.MOD_ID, "player_coin_inventory"), new PlayerCoinInventoryCapabilityProvider());
        if(event.getObject() instanceof PlayerEntity) {
            event.addCapability(new ResourceLocation("player_coin_inventory_pb"), new PlayerCoinCapabilitySerializable());
        }
    }

}
