package com.kingrealzyt.terrariareloaded.init;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.blocks.*;
import com.kingrealzyt.terrariareloaded.world.feature.EbonwoodTree;
import com.kingrealzyt.terrariareloaded.world.feature.ShadewoodTree;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
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

    public static final RegistryObject<Block> SHIMMERING_DIAMOND_ORE = BLOCKS.register("shimmering_diamond_ore", GemOre::new);
    public static final RegistryObject<Block> SHIMMERING_EMERALD_ORE = BLOCKS.register("shimmering_emerald_ore", GemOre::new);
    public static final RegistryObject<Block> RUBY_ORE = BLOCKS.register("ruby_ore", GemOre::new);
    public static final RegistryObject<Block> AMETHYST_ORE = BLOCKS.register("amethyst_ore", GemOre::new);
    public static final RegistryObject<Block> TOPAZ_ORE = BLOCKS.register("topaz_ore", GemOre::new);
    public static final RegistryObject<Block> SAPPHIRE_ORE = BLOCKS.register("sapphire_ore", GemOre::new);
    public static final RegistryObject<Block> AMBER_ORE = BLOCKS.register("amber_ore", GemOre::new);

    public static final RegistryObject<Block> SILVER_ORE = BLOCKS.register("silver_ore", SilverOre::new);
    public static final RegistryObject<Block> COPPER_ORE = BLOCKS.register("copper_ore", CopperOre::new);
    public static final RegistryObject<Block> PLATINUM_ORE = BLOCKS.register("platinum_ore", PlatinumOre::new);
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

    // Crafting Stations
    public static final RegistryObject<Block> HELLFORGE = BLOCKS.register("hellforge",
            () -> new Hellforge(Block.Properties.from(Blocks.FURNACE)));

    // Special Blocks
    public static final RegistryObject<Block> PIGGY_BANK = BLOCKS.register("piggy_bank", PiggyBank::new);
    public static final RegistryObject<Block> CRYSTAL_HEART = BLOCKS.register("crystal_heart", CrystalHeart::new);
    public static final RegistryObject<Block> SWORD_SHRINE = BLOCKS.register("sword_shrine", SwordShrine::new);

    //Bush Blocks
    public static final RegistryObject<Block> LIFE_FRUIT_BUSH = BLOCKS.register("life_fruit_bush", ModGlowBushBlock::new);
    public static final RegistryObject<Block> JUNGLE_SPORES_BUSH = BLOCKS.register("jungle_spores_bush", ModGlowBushBlock::new);

    // Other Blocks
    public static final RegistryObject<Block> HIVE_BLOCK = BLOCKS.register("hive_block", HiveBlock::new);

    public static final RegistryObject<Block> EBONWOOD_PLANKS = BLOCKS.register("ebonwood_planks", ModPlanksBlock::new);
    public static final RegistryObject<Block> SHADEWOOD_PLANKS = BLOCKS.register("shadewood_planks", ModPlanksBlock::new);
    public static final RegistryObject<Block> EBONWOOD_LOG = BLOCKS.register("ebonwood_log", ModLogBlock::new);
    public static final RegistryObject<Block> SHADEWOOD_LOG = BLOCKS.register("shadewood_log", ModLogBlock::new);

    public static final RegistryObject<Block> EBONWOOD_SAPLING = BLOCKS.register("ebonwood_sapling",
            () -> new EbonwoodSapling(() -> new EbonwoodTree(), Block.Properties.from(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> SHADEWOOD_SAPLING = BLOCKS.register("shadewood_sapling",
            () -> new ShadewoodSapling(() -> new ShadewoodTree(), Block.Properties.from(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> EBONWOOD_LEAVES = BLOCKS.register("ebonwood_leaves", ModLeavesBlock::new);
    public static final RegistryObject<Block> SHADEWOOD_LEAVES = BLOCKS.register("shadewood_leaves", ModLeavesBlock::new);

    public static final RegistryObject<Block> EBONSTONE = BLOCKS.register("ebonstone", ModStoneBlock::new);
    public static final RegistryObject<Block> CRIMSTONE = BLOCKS.register("crimstone", ModStoneBlock::new);
    public static final RegistryObject<Block> PEARLSTONE = BLOCKS.register("pearlstone", ModStoneBlock::new);
    public static final RegistryObject<Block> BLUE_GRANITE = BLOCKS.register("blue_granite", ModStoneBlock::new);
    public static final RegistryObject<Block> MARBLE = BLOCKS.register("marble", ModStoneBlock::new);


    public static final RegistryObject<Block> MUDSTONE_BRICKS = BLOCKS.register("mudstone_bricks", ModStoneBlock::new);
    public static final RegistryObject<Block> COPPER_BRICKS = BLOCKS.register("copper_bricks", ModStoneBlock::new);
    public static final RegistryObject<Block> SILVER_BRICKS = BLOCKS.register("silver_bricks", ModStoneBlock::new);
    public static final RegistryObject<Block> GOLD_BRICKS = BLOCKS.register("gold_bricks", ModStoneBlock::new);
    public static final RegistryObject<Block> PLATINUM_BRICKS = BLOCKS.register("platinum_bricks", ModStoneBlock::new);
    public static final RegistryObject<Block> OBSIDIAN_BRICKS = BLOCKS.register("obsidian_bricks", ModStoneBlock::new);
    public static final RegistryObject<Block> METEORITE_BRICKS = BLOCKS.register("meteorite_bricks", ModGlowStoneBlock::new);
    public static final RegistryObject<Block> HELLSTONE_BRICKS = BLOCKS.register("hellstone_bricks", ModGlowStoneBlock::new);
    public static final RegistryObject<Block> EBONSTONE_BRICKS = BLOCKS.register("ebonstone_bricks", ModStoneBlock::new);
    public static final RegistryObject<Block> CRIMSTONE_BRICKS = BLOCKS.register("crimstone_bricks", ModStoneBlock::new);
    public static final RegistryObject<Block> PEARLSTONE_BRICKS = BLOCKS.register("pearlstone_bricks", ModStoneBlock::new);
    public static final RegistryObject<Block> SMOOTH_BLUE_GRANITE = BLOCKS.register("smooth_blue_granite", ModStoneBlock::new);
    public static final RegistryObject<Block> SMOOTH_MARBLE = BLOCKS.register("smooth_marble", ModStoneBlock::new);

    public static final RegistryObject<Block> EBONSAND = BLOCKS.register("ebonsand", () -> new ModSandBlock(0x523f5a));
    public static final RegistryObject<Block> CRIMSAND = BLOCKS.register("crimsand", () -> new ModSandBlock(0xc34343));
    public static final RegistryObject<Block> PEARLSAND = BLOCKS.register("pearlsand", () -> new ModSandBlock(0xb5acbe));

    public static final RegistryObject<Block> MUD = BLOCKS.register("mud", ModDirtBlock::new);
    public static final RegistryObject<Block> ASH = BLOCKS.register("ash", ModDirtBlock::new);
    public static final RegistryObject<Block> SLUSH = BLOCKS.register("slush", () -> new ModSandBlock(0x99b2b9));
    public static final RegistryObject<Block> SILT = BLOCKS.register("silt", () -> new ModSandBlock(0x595353));

    public static final RegistryObject<Block> MUSHROOM_GRASS_BLOCK = BLOCKS.register("mushroom_grass_block", MushroomGrassBlock::new);
    public static final RegistryObject<Block> CRIMSON_GRASS_BLOCK = BLOCKS.register("crimson_grass_block", ModGrassBlock::new);
    public static final RegistryObject<Block> CORRUPT_GRASS_BLOCK = BLOCKS.register("corrupt_grass_block", ModGrassBlock::new);
    public static final RegistryObject<Block> JUNGLE_GRASS_BLOCK = BLOCKS.register("jungle_grass_block", ModGrassBlock::new);
    public static final RegistryObject<Block> BLOCK_OF_FLESH = BLOCKS.register("block_of_flesh", ModFleshBlock::new);

}
