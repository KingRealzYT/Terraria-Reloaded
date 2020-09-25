package com.kingrealzyt.terrariareloaded.events;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.entities.boss.EOCEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextComponent;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.NetherDimension;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = TerrariaReloaded.MOD_ID, bus = Bus.FORGE/*, value = Dist.DEDICATED_SERVER*/)
public class FleshEvent {
    @SubscribeEvent
    public static void FleshEvent(LivingDeathEvent event)
    {
        World world = event.getEntity().getEntityWorld();
        if(event.getEntity() instanceof SheepEntity)
        {
            if(world.dimension instanceof NetherDimension)
                TerrariaReloaded.LOGGER.info("The wall of fettuccine has been summoned!");
        }else if(event.getEntity() instanceof EOCEntity) //todo make this wall of flesh
        {
            //todo Starts hard mode

        }
    }
}
