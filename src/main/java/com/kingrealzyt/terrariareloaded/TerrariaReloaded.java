package com.kingrealzyt.terrariareloaded;

import com.kingrealzyt.terrariareloaded.init.DimensionInit;
import com.kingrealzyt.terrariareloaded.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

@Mod("terrariareloaded")
public class TerrariaReloaded
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "terrariareloaded";

    public TerrariaReloaded() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);

        ModItems.init();
        DimensionInit.MOD_DIMENSIONS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {

    }

    private void doClientStuff(final FMLClientSetupEvent event)
    {

    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event)
    {

    }

    public static final ItemGroup SWORDS = new ItemGroup("Swords") {

        @Override
        public ItemStack createIcon() {
            return  new ItemStack(ModItems.COPPER_SHORTSWORD.get());
        }
    };

    public static final ItemGroup AXE = new ItemGroup("Axe") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.COPPER_AXE.get());
        }
    };

    public static final ItemGroup PICKAXE = new ItemGroup("Pickaxe") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.COPPER_PICKAXE.get());
        }
    };
}
