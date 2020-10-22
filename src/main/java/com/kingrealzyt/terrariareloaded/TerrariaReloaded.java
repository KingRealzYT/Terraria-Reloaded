package com.kingrealzyt.terrariareloaded;

import java.lang.reflect.Field;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.kingrealzyt.terrariareloaded.client.TMusicTicker;
import com.kingrealzyt.terrariareloaded.init.ModBiomes;
import com.kingrealzyt.terrariareloaded.init.ModBlocks;
import com.kingrealzyt.terrariareloaded.init.ModContainers;
import com.kingrealzyt.terrariareloaded.init.ModEntityTypes;
import com.kingrealzyt.terrariareloaded.init.ModFeatures;
import com.kingrealzyt.terrariareloaded.init.ModFluids;
import com.kingrealzyt.terrariareloaded.init.ModItems;
import com.kingrealzyt.terrariareloaded.init.ModTileEntityTypes;
import com.kingrealzyt.terrariareloaded.init.RecipeSerializerInit;
import com.kingrealzyt.terrariareloaded.init.SoundInit;
import com.kingrealzyt.terrariareloaded.util.HealthLimitRemover;
import com.kingrealzyt.terrariareloaded.util.ReflectionUtil;
import com.kingrealzyt.terrariareloaded.world.capability.player.IPlayerCoinCapability;
import com.kingrealzyt.terrariareloaded.world.capability.player.PlayerCoinCapabilityFactory;
import com.kingrealzyt.terrariareloaded.world.capability.player.PlayerCoinCapabilityStorage;
import com.kingrealzyt.terrariareloaded.world.gen.ModStructureGen;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("terrariareloaded")
@Mod.EventBusSubscriber(modid = TerrariaReloaded.MOD_ID, bus = Bus.MOD)
public class TerrariaReloaded {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "terrariareloaded";
        
    public TerrariaReloaded() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);

        SoundInit.SOUNDS.register(modEventBus);
        ModItems.init();
        ModFluids.init();
        ModContainers.CONTAINERS.register(modEventBus);
        ModEntityTypes.ENTITY_TYPES.register(modEventBus);
        ModFeatures.FEATURES.register(modEventBus);
        ModTileEntityTypes.TILEENTITY_TYPES.register(modEventBus);
        RecipeSerializerInit.RECIPE_SERIALIZERS.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {

        DeferredWorkQueue.runLater(ModStructureGen::generateStructures);
        //Register the capability
        CapabilityManager.INSTANCE.register(IPlayerCoinCapability.class, new PlayerCoinCapabilityStorage(), new PlayerCoinCapabilityFactory());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {

    	ReflectionUtil.getFieldByValue(SharedMonsterAttributes.class, null, SharedMonsterAttributes.MAX_HEALTH);
        for (Field field : SharedMonsterAttributes.class.getDeclaredFields()) {
          if (field.getType().isAssignableFrom(IAttribute.class)) {
            field.setAccessible(true);
            try {
              if (field.get((Object)null) == SharedMonsterAttributes.MAX_HEALTH) {
                ReflectionUtil.setStaticFinalField(field, HealthLimitRemover.MAX_HEALTH);
              } 
            } catch (IllegalAccessException err) {}
          }	
        }
        
        try {
			Field musicTicker = ObfuscationReflectionHelper.findField(Minecraft.class, "field_147126_aw");
			musicTicker.setAccessible(true);
			musicTicker.set(Minecraft.getInstance(), new TMusicTicker(Minecraft.getInstance()));
		} catch (Exception e1) {
			e1.printStackTrace();
		}

    }

    @SubscribeEvent
    public static void OnRegisterBiomes(final RegistryEvent.Register<Biome> event)
    {
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {

    }

    public static ResourceLocation rlTexture(String path) {
        return new ResourceLocation(MOD_ID, "textures/" + path);
    }

    public static final DamageSource YOYO = new DamageSource(MOD_ID + ".yoyo");

    // Item Groups

    public static final ItemGroup BLOCKS = new ItemGroup("Blocks") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.COBALT_ORE);
        }
    };


    public static final ItemGroup WEAPONS = new ItemGroup("Weapons") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.CHLOROPHYTE_SHOTBOW_ITEM.get());
        }
    };

    public static final ItemGroup EQUIPMENT = new ItemGroup("Equipment") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.BAND_REGENERATION.get());
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
