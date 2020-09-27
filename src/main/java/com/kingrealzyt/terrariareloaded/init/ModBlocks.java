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

    // Ore Blocks

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
/* Note: Some ore blocks above use the same block class as they're identical other than their texture and drops, e.g Demonite + Crimtane,
 Cobalt + Palladium, etc. Up to yall if you wanna keep using that*/

    // Special Blocks

    public static final RegistryObject<Block> PIGGY_BANK = BLOCKS.register("piggy_bank", PiggyBank::new);

    //Bush Blocks
    public static final RegistryObject<Block> LIFE_FRUIT_BUSH = BLOCKS.register("life_fruit_bush", ModGlowBushBlock::new);

    // Other Blocks
    public static final RegistryObject<Block> HIVE_BLOCK = BLOCKS.register("hive_block", HiveBlock::new);

    public static final RegistryObject<Block> EBONSTONE = BLOCKS.register("ebonstone", ModStoneBlock::new);
    public static final RegistryObject<Block> CRIMSTONE = BLOCKS.register("crimstone", ModStoneBlock::new);
    public static final RegistryObject<Block> PEARLSTONE = BLOCKS.register("pearlstone", ModStoneBlock::new);
    public static final RegistryObject<Block> BLUE_GRANITE = BLOCKS.register("blue_granite", ModStoneBlock::new);
    public static final RegistryObject<Block> MARBLE = BLOCKS.register("marble", ModStoneBlock::new);

    public static final RegistryObject<Block> EBONSTONE_BRICKS = BLOCKS.register("ebonstone_bricks", ModStoneBlock::new);
    public static final RegistryObject<Block> CRIMSTONE_BRICKS = BLOCKS.register("crimstone_bricks", ModStoneBlock::new);
    public static final RegistryObject<Block> PEARLSTONE_BRICKS = BLOCKS.register("pearlstone_bricks", ModStoneBlock::new);
    public static final RegistryObject<Block> SMOOTH_BLUE_GRANITE = BLOCKS.register("smooth_blue_granite", ModStoneBlock::new);
    public static final RegistryObject<Block> SMOOTH_MARBLE = BLOCKS.register("smooth_marble", ModStoneBlock::new);

    public static final RegistryObject<Block> EBONSAND = BLOCKS.register("ebonsand", () -> new ModSandBlock(0x523f5a));
    public static final RegistryObject<Block> CRIMSAND = BLOCKS.register("crimsand", () -> new ModSandBlock(0xc34343));
    public static final RegistryObject<Block> PEARLSAND = BLOCKS.register("pearlsand", () -> new ModSandBlock(0xb5acbe));

}
