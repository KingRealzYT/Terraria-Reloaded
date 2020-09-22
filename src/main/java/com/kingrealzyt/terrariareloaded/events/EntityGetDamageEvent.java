package com.kingrealzyt.terrariareloaded.events;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.entities.yoyo.YoyoEntity;
import com.kingrealzyt.terrariareloaded.items.weapons.ranged.yoyo.YoyoItem;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TerrariaReloaded.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EntityGetDamageEvent {

    @SubscribeEvent
    public static void onEntityDamage(LivingAttackEvent event) {
        if (event.getSource() == TerrariaReloaded.YOYO) {
            LivingEntity entity = event.getEntityLiving();
            if(entity.isAlive()) {
                YoyoItem.spawnTerrarianProjectile(entity);
            }
        }
    }

    @SubscribeEvent
    public static void onEntityFall(LivingFallEvent event) {
        if(event.getEntityLiving() instanceof YoyoEntity) {
            event.setDistance(0);
        }
    }

}
