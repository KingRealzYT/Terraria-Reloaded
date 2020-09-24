package com.kingrealzyt.terrariareloaded;

import com.kingrealzyt.terrariareloaded.init.*;
import com.kingrealzyt.terrariareloaded.world.capability.PlayerCoinInventory;
import com.kingrealzyt.terrariareloaded.world.capability.PlayerCoinInventoryStorage;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("terrariareloaded")
public class TerrariaReloaded {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "terrariareloaded";

    public TerrariaReloaded() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);

        SoundInit.SOUNDS.register(modEventBus);
        ModItems.init();
        //ModFluids.init();
        ModBlocks.init();
        ModContainers.CONTAINERS.register(modEventBus);
        ModEntityTypes.ENTITY_TYPES.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {

        //Register the capability
        CapabilityManager.INSTANCE.register(PlayerCoinInventory.class, new PlayerCoinInventoryStorage(), PlayerCoinInventory::new);

    }

    private void doClientStuff(final FMLClientSetupEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {

    }

    public static ResourceLocation rlTexture(String path) {
        return new ResourceLocation(MOD_ID, "textures/" + path);
    }

    public static final DamageSource YOYO = new DamageSource(MOD_ID + ".yoyo");

    // Tabs

    public static final ItemGroup BLOCKS = new ItemGroup("Blocks") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.COBALT_ORE.get());
        }
    };


    public static final ItemGroup WEAPONS = new ItemGroup("Weapons") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.CHLOROPHYTE_SHOTBOW_ITEM.get());
        }
    };

    public static final ItemGroup THROW = new ItemGroup("Throwable") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.THROWING_KNIFE_ITEM.get());
        }
    };

    public static final ItemGroup FOOD = new ItemGroup("Foods") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.BURGER.get());
        }
    };

    public static final ItemGroup TOOL = new ItemGroup("Tools") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.PICKAXE_AXE.get());
        }
    };

    public static final ItemGroup BOSS = new ItemGroup("BossSpawns") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.GUIDE_VOODOO.get());
        }
    };

    public static final ItemGroup MISC = new ItemGroup("Miscellaneous") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.CRIMTANE_INGOT.get());
        }
    };


}
