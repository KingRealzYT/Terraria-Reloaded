package com.kingrealzyt.terrariareloaded;

import com.kingrealzyt.terrariareloaded.init.*;
import com.kingrealzyt.terrariareloaded.inventory.PiggyBankInventory;
import com.kingrealzyt.terrariareloaded.world.capability.PlayerCoinInventory;
import com.kingrealzyt.terrariareloaded.world.capability.PlayerCoinStorage;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;

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
        ModBlocks.init();
        ModContainers.CONTAINERS.register(modEventBus);
        ModEntityTypes.ENTITY_TYPES.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {

        //Register the capability
        CapabilityManager.INSTANCE.register(PlayerCoinStorage.class, new Capability.IStorage<PlayerCoinStorage>() {
            @Nullable
            @Override
            public INBT writeNBT(Capability<PlayerCoinStorage> capability, PlayerCoinStorage instance, Direction side) {
                CompoundNBT nbt = new CompoundNBT();
                PlayerCoinStorage pcs = capability.getDefaultInstance();
                if(pcs == null)
                    return null;
                nbt.putInt("copper", pcs.getAmount(PlayerCoinStorage.Coin.BRONZE));
                nbt.putInt("silver", pcs.getAmount(PlayerCoinStorage.Coin.SILVER));
                nbt.putInt("gold", pcs.getAmount(PlayerCoinStorage.Coin.GOLD));
                nbt.putInt("platinum", pcs.getAmount(PlayerCoinStorage.Coin.PLATINUM));
                return nbt;
            }

            @Override
            public void readNBT(Capability<PlayerCoinStorage> capability, PlayerCoinStorage instance, Direction side, INBT nbt) {
                if(!(nbt instanceof CompoundNBT))
                    return;

                CompoundNBT tag = (CompoundNBT) nbt;
                PlayerCoinStorage pcs = capability.getDefaultInstance();
                if(pcs == null)
                    pcs = new PlayerCoinStorage();

                pcs.setBronze(tag.getInt("silver"));
                pcs.setSilver(tag.getInt("copper"));
                pcs.setGold(tag.getInt("gold"));
                pcs.setPlatinum(tag.getInt("platinum"));

            }
        }, PlayerCoinStorage::new);

        CapabilityManager.INSTANCE.register(PlayerCoinInventory.class, new Capability.IStorage<PlayerCoinInventory>() {
            @Override
            public INBT writeNBT(Capability<PlayerCoinInventory> capability, PlayerCoinInventory instance, Direction side) {
                PlayerCoinInventory pci = capability.getDefaultInstance();
                if(pci == null)
                    return null;
                CompoundNBT nbt = new CompoundNBT();
                nbt.put("inventory", pci.getPiggyBankInventory().write());
                return nbt;
            }

            @Override
            public void readNBT(Capability<PlayerCoinInventory> capability, PlayerCoinInventory instance, Direction side, INBT nbt) {
                if(!(nbt instanceof CompoundNBT))
                    return;

                CompoundNBT tag = (CompoundNBT) nbt;
                PlayerCoinInventory pci = capability.getDefaultInstance();
                if(pci == null)
                    pci = new PlayerCoinInventory();
                PiggyBankInventory inventory = new PiggyBankInventory();
                INBT inbt = tag.get("inventory");
                if(!(inbt instanceof ListNBT))
                    return;
                inventory.read((ListNBT) inbt);
                pci.setPiggyBankInventory(inventory);
            }
        }, PlayerCoinInventory::new);

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

    public static final ItemGroup SWORDS = new ItemGroup("Swords") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.COPPER_SHORTSWORD.get());
        }
    };

    public static final ItemGroup RANGED = new ItemGroup("Ranged") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.HALLOWED_REPEATER_ITEM.get());
        }
    };

    public static final ItemGroup THROW = new ItemGroup("Throwable") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.THROWING_KNIFE_ITEM.get());
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
