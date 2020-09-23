package com.kingrealzyt.terrariareloaded.init;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.blocks.*;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, TerrariaReloaded.MOD_ID);

    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Blocks
    public static final RegistryObject<Block> PIGGY_BANK = BLOCKS.register("piggy_bank", PiggyBank::new);

    public static final RegistryObject<Block> SILVER_ORE = BLOCKS.register("silver_ore", SilverOre::new);
    public static final RegistryObject<Block> COPPER_ORE = BLOCKS.register("copper_ore", CopperOre::new);
    public static final RegistryObject<Block> METEORITE_ORE = BLOCKS.register("meteorite_ore", MeteoriteOre::new);
    public static final RegistryObject<Block> DEMONITE_ORE = BLOCKS.register("demonite_ore", DemoniteOre::new);
    public static final RegistryObject<Block> CRIMTANE_ORE = BLOCKS.register("crimtane_ore", DemoniteOre::new);
    public static final RegistryObject<Block> HELLSTONE_ORE = BLOCKS.register("hellstone_ore", HellstoneOre::new);
    public static final RegistryObject<Block> COBALT_ORE = BLOCKS.register("cobalt_ore", CobaltOre::new);
    public static final RegistryObject<Block> PALLADIUM_ORE = BLOCKS.register("palladium_ore", CobaltOre::new);
    public static final RegistryObject<Block> MYTHRIL_ORE = BLOCKS.register("mythril_ore", MythrilOre::new);
    public static final RegistryObject<Block> ORICHALCUM_ORE = BLOCKS.register("orichalcum_ore", MythrilOre::new);
    public static final RegistryObject<Block> ADAMANTITE_ORE = BLOCKS.register("adamantite_ore", TitaniumOre::new);
    public static final RegistryObject<Block> TITANIUM_ORE = BLOCKS.register("titanium_ore", TitaniumOre::new);
    public static final RegistryObject<Block> CHLOROPHYTE_ORE = BLOCKS.register("chlorophyte_ore", ChlorophyteOre::new);
/* Note: Some blocks above use the same block class as they're identical other than their texture and drops, e.g Demonite + Crimtane,
 Cobalt + Palladium, etc. Up to yall if you wanna keep using that*/

}
