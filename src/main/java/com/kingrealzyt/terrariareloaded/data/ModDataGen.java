package com.kingrealzyt.terrariareloaded.data;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModDataGen {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        TerrariaReloaded.LOGGER.info("Starting common data gen");
        generator.addProvider(new LootTableDataGenerator(generator));
    }

}
