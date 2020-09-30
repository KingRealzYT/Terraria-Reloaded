package com.kingrealzyt.terrariareloaded.events;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.init.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TerrariaReloaded.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {
// ADD FLAG TO PLAYER THAT HE HAS JOINED TO FIX
   @SubscribeEvent
    public static void CopperFirstJoin(PlayerEvent.PlayerLoggedInEvent event) {
        PlayerEntity player = event.getPlayer();
        CompoundNBT nbt = player.getPersistentData();
        boolean loggedInBefore = nbt.getBoolean("loggedInBefore");
        if (!loggedInBefore) {

            player.inventory.addItemStackToInventory(new ItemStack(ModItems.COPPER_SHORTSWORD.get().asItem(), 1));
            player.inventory.addItemStackToInventory(new ItemStack(ModItems.COPPER_AXE.get().asItem(), 1));
            player.inventory.addItemStackToInventory(new ItemStack(ModItems.COPPER_PICKAXE.get().asItem(), 1));
            nbt.putBoolean("loggedInBefore", true);
        }
    }
}

