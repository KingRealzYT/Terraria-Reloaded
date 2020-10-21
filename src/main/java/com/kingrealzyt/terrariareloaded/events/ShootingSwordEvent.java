package com.kingrealzyt.terrariareloaded.events;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.entities.projectiles.ThrowingKnifeEntity;
import com.kingrealzyt.terrariareloaded.init.ModBlocks;
import com.kingrealzyt.terrariareloaded.init.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TerrariaReloaded.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ShootingSwordEvent {
    @SubscribeEvent
    public static void LeftClickEvent(PlayerInteractEvent.LeftClickEmpty event) {
        PlayerEntity playerIn = event.getPlayer();
        ItemStack itemStackIn = playerIn.getHeldItemMainhand();
        World worldIn = event.getWorld();
        if (!worldIn.isRemote){
            if(itemStackIn.getItem() == ModItems.ENCHANTED_SWORD.get()) {
                ArrowEntity arrow = new ArrowEntity(worldIn, playerIn);
                arrow.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.25F, 0.0F);
                worldIn.addEntity(arrow);
                
            }
            else if(itemStackIn.getItem() == ModItems.ICE_BLADE.get()){
                ThrowingKnifeEntity throwingKnife = new ThrowingKnifeEntity(worldIn, playerIn);
                throwingKnife.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.25F, 0.0F);
                worldIn.addEntity(throwingKnife);
            }
        }
    }
}

