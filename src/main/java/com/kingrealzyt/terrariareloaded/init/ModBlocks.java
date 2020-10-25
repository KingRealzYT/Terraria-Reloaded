package com.kingrealzyt.terrariareloaded.init;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.blocks.BlinkrootCrop;
import com.kingrealzyt.terrariareloaded.blocks.ChlorophyteOre;
import com.kingrealzyt.terrariareloaded.blocks.CobaltOre;
import com.kingrealzyt.terrariareloaded.blocks.CopperOre;
import com.kingrealzyt.terrariareloaded.blocks.CrystalHeart;
import com.kingrealzyt.terrariareloaded.blocks.DaybloomCrop;
import com.kingrealzyt.terrariareloaded.blocks.DeathweedCrop;
import com.kingrealzyt.terrariareloaded.blocks.DemonAltar;
import com.kingrealzyt.terrariareloaded.blocks.DemoniteOre;
import com.kingrealzyt.terrariareloaded.blocks.EbonwoodSapling;
import com.kingrealzyt.terrariareloaded.blocks.FireblossomCrop;
import com.kingrealzyt.terrariareloaded.blocks.GemOre;
import com.kingrealzyt.terrariareloaded.blocks.GlowingMushroom;
import com.kingrealzyt.terrariareloaded.blocks.Hellforge;
import com.kingrealzyt.terrariareloaded.blocks.HellstoneOre;
import com.kingrealzyt.terrariareloaded.blocks.HiveBlock;
import com.kingrealzyt.terrariareloaded.blocks.MeteoriteOre;
import com.kingrealzyt.terrariareloaded.blocks.ModDirtBlock;
import com.kingrealzyt.terrariareloaded.blocks.ModFleshBlock;
import com.kingrealzyt.terrariareloaded.blocks.ModGlowBushBlock;
import com.kingrealzyt.terrariareloaded.blocks.ModGrassBlock;
import com.kingrealzyt.terrariareloaded.blocks.ModLeavesBlock;
import com.kingrealzyt.terrariareloaded.blocks.ModPlanksBlock;
import com.kingrealzyt.terrariareloaded.blocks.ModSandBlock;
import com.kingrealzyt.terrariareloaded.blocks.ModStoneBlock;
import com.kingrealzyt.terrariareloaded.blocks.MoonglowCrop;
import com.kingrealzyt.terrariareloaded.blocks.MushroomGrassBlock;
import com.kingrealzyt.terrariareloaded.blocks.MythrilOre;
import com.kingrealzyt.terrariareloaded.blocks.PiggyBank;
import com.kingrealzyt.terrariareloaded.blocks.PlatinumOre;
import com.kingrealzyt.terrariareloaded.blocks.ShadewoodSapling;
import com.kingrealzyt.terrariareloaded.blocks.ShiverthornCrop;
import com.kingrealzyt.terrariareloaded.blocks.SilverOre;
import com.kingrealzyt.terrariareloaded.blocks.SwordShrine;
import com.kingrealzyt.terrariareloaded.blocks.TitaniumOre;
import com.kingrealzyt.terrariareloaded.blocks.WaterleafCrop;
import com.kingrealzyt.terrariareloaded.world.feature.EbonwoodTree;
import com.kingrealzyt.terrariareloaded.world.feature.ShadewoodTree;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, TerrariaReloaded.MOD_ID);

    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Ore Blocks

    public static Block SHIMMERING_DIAMOND_ORE;
    public static Block SHIMMERING_EMERALD_ORE;
    public static Block RUBY_ORE;
    public static Block AMETHYST_ORE;
    public static Block TOPAZ_ORE;
    public static Block SAPPHIRE_ORE;
    public static Block AMBER_ORE;

    public static Block SILVER_ORE;
    public static Block COPPER_ORE;
    public static Block PLATINUM_ORE;
    public static Block METEORITE_ORE;
    public static Block DEMONITE_ORE;
    public static Block CRIMTANE_ORE;
    public static Block HELLSTONE_ORE;
    public static Block COBALT_ORE;
    public static Block PALLADIUM_ORE;
    public static Block MYTHRIL_ORE;
    public static Block ORICHALCUM_ORE;
    public static Block ADAMANTITE_ORE;
    public static Block TITANIUM_ORE;
    public static Block CHLOROPHYTE_ORE;
/* Note: Some ore blocks above use the same block class as they're identical other than their texture and drops, e.g Demonite + Crimtane,
 Cobalt + Palladium, etc. Up to yall if you wanna keep using that*/

    // Crops
    public static Block DEATHWEED_CROP;
    public static Block SHIVERTHORN_CROP;
    public static Block FIREBLOSSOM_CROP;
    public static Block BLINKROOT_CROP;
    public static Block MOONGLOW_CROP;
    public static Block WATERLEAF_CROP;
    public static Block DAYBLOOM_CROP;

    public static Block GLOWING_MUSHROOM;


    // Crafting Stations
    public static Block HELLFORGE;
    public static Block DEMON_ALTAR;

    // Special Blocks
    public static Block PIGGY_BANK;
    public static Block CRYSTAL_HEART;
    public static Block SWORD_SHRINE;

    //Bush Blocks
    public static Block LIFE_FRUIT_BUSH;
    public static Block JUNGLE_SPORES_BUSH;

    // Other Blocks
    public static Block HIVE_BLOCK;

    public static Block EBONWOOD_PLANKS;
    public static Block SHADEWOOD_PLANKS;
    public static Block EBONWOOD_LOG;
    public static Block SHADEWOOD_LOG;

    public static Block EBONWOOD_SAPLING;
    public static Block SHADEWOOD_SAPLING;

    public static Block EBONWOOD_LEAVES;
    public static Block SHADEWOOD_LEAVES;

    public static Block EBONSTONE;
    public static Block CRIMSTONE;
    public static Block PEARLSTONE;
    public static Block BLUE_GRANITE;
    public static Block MARBLE;

    public static Block MUDSTONE_BRICKS;
    public static Block COPPER_BRICKS;
    public static Block SILVER_BRICKS;
    public static Block GOLD_BRICKS;
    public static Block PLATINUM_BRICKS;
    public static Block OBSIDIAN_BRICKS;
    public static Block METEORITE_BRICKS;
    public static Block HELLSTONE_BRICKS;
    public static Block EBONSTONE_BRICKS;
    public static Block CRIMSTONE_BRICKS;
    public static Block PEARLSTONE_BRICKS;
    public static Block SMOOTH_BLUE_GRANITE;
    public static Block SMOOTH_MARBLE;

    public static Block EBONSAND;
    public static Block CRIMSAND;
    public static Block PEARLSAND;

    public static Block MUD;
    public static Block ASH;
    public static Block SLUSH;
    public static Block SILT;

    public static Block MUSHROOM_GRASS_BLOCK;
    public static Block CRIMSON_GRASS_BLOCK;
    public static Block CORRUPT_GRASS_BLOCK;
    public static Block JUNGLE_GRASS_BLOCK;
    public static Block BLOCK_OF_FLESH;
    
    public static Block HONEY;

    @SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(
				
			HONEY = new FlowingFluidBlock(ModFluids.HONEY_FLUID::get, Block.Properties.create(Material.WATER)
                    .doesNotBlockMovement().hardnessAndResistance(100.0f).noDrops()).setRegistryName("honey"),
				
			SHIMMERING_DIAMOND_ORE = new GemOre().setRegistryName("shimmering_diamond_ore"),
			SHIMMERING_EMERALD_ORE = new GemOre().setRegistryName("shimmering_emerald_ore"),
		    RUBY_ORE = new GemOre().setRegistryName("ruby_ore"),
		    AMETHYST_ORE = new GemOre().setRegistryName("amethyst_ore"),
		    TOPAZ_ORE = new GemOre().setRegistryName("topaz_ore"),
		    SAPPHIRE_ORE = new GemOre().setRegistryName("sapphire_ore"),
		    AMBER_ORE = new GemOre().setRegistryName("amber_ore"),

		    SILVER_ORE = new SilverOre().setRegistryName("silver_ore"),
		    COPPER_ORE = new CopperOre().setRegistryName("copper_ore"),
		    PLATINUM_ORE = new PlatinumOre().setRegistryName("platinum_ore"),
		    METEORITE_ORE = new MeteoriteOre().setRegistryName("meteorite_ore"),
		    DEMONITE_ORE = new DemoniteOre().setRegistryName("demonite_ore"),
		    CRIMTANE_ORE = new DemoniteOre().setRegistryName("crimtane_ore"),
		    HELLSTONE_ORE = new HellstoneOre().setRegistryName("hellstone_ore"),
		    COBALT_ORE = new CobaltOre().setRegistryName("cobalt_ore"),
		    PALLADIUM_ORE = new CobaltOre().setRegistryName("palladium_ore"),
		    MYTHRIL_ORE = new MythrilOre().setRegistryName("mythril_ore"),
		    ORICHALCUM_ORE = new MythrilOre().setRegistryName("orichalcum_ore"),
		    ADAMANTITE_ORE = new TitaniumOre().setRegistryName("adamantite_ore"),
		    TITANIUM_ORE = new TitaniumOre().setRegistryName("titanium_ore"),
		    CHLOROPHYTE_ORE = new ChlorophyteOre().setRegistryName("chlorophyte_ore"),
		/* Note: Some ore blocks above use the same block class as they're identical other than their texture and drops, e.g Demonite + Crimtane,
		 Cobalt + Palladium, etc. Up to yall if you wanna keep using that*/

		    // Crops
		    DEATHWEED_CROP = new DeathweedCrop(Block.Properties.from(Blocks.WHEAT)).setRegistryName("deathweed_crop"),
		    SHIVERTHORN_CROP = new ShiverthornCrop(Block.Properties.from(Blocks.WHEAT)).setRegistryName("shiverthorn_crop"),
		    FIREBLOSSOM_CROP = new FireblossomCrop(Block.Properties.from(Blocks.WHEAT)).setRegistryName("fireblossom_crop"),
		    BLINKROOT_CROP = new BlinkrootCrop(Block.Properties.from(Blocks.WHEAT)).setRegistryName("blinkroot_crop"),
		    MOONGLOW_CROP = new MoonglowCrop(Block.Properties.from(Blocks.WHEAT)).setRegistryName("moonglow_crop"),
		    WATERLEAF_CROP = new WaterleafCrop(Block.Properties.from(Blocks.WHEAT)).setRegistryName("waterleaf_crop"),
		    DAYBLOOM_CROP = new DaybloomCrop(Block.Properties.from(Blocks.WHEAT)).setRegistryName("daybloom_crop"),

		    GLOWING_MUSHROOM = new GlowingMushroom().setRegistryName("glowing_mushroom"),


		    // Crafting Stations
		    HELLFORGE = new Hellforge(Block.Properties.from(Blocks.FURNACE)).setRegistryName("hellforge"),

		    DEMON_ALTAR = new DemonAltar().setRegistryName("demon_altar"),

		    // Special Blocks
		    PIGGY_BANK = new PiggyBank().setRegistryName("piggy_bank"),
		    CRYSTAL_HEART = new CrystalHeart().setRegistryName("crystal_heart"),
		    SWORD_SHRINE = new SwordShrine().setRegistryName("sword_shrine"),

		    //Bush Blocks
		    LIFE_FRUIT_BUSH = new ModGlowBushBlock().setRegistryName("life_fruit_bush"),
		    JUNGLE_SPORES_BUSH = new ModGlowBushBlock().setRegistryName("jungle_spores_bush"),
		    
		    // Other Blocks
		    HIVE_BLOCK = new HiveBlock().setRegistryName("hive_block"),

		    EBONWOOD_PLANKS = new ModPlanksBlock().setRegistryName("ebonwood_planks"),
		    SHADEWOOD_PLANKS = new ModPlanksBlock().setRegistryName("shadewood_planks"),
		    EBONWOOD_LOG = new ModPlanksBlock().setRegistryName("ebonwood_log"),
		    SHADEWOOD_LOG = new ModPlanksBlock().setRegistryName("shadewood_log"),

		    EBONWOOD_SAPLING = new EbonwoodSapling(() -> new EbonwoodTree(), Block.Properties.from(Blocks.OAK_SAPLING)).setRegistryName("ebonwood_sapling"),
		    SHADEWOOD_SAPLING = new ShadewoodSapling(() -> new ShadewoodTree(), Block.Properties.from(Blocks.OAK_SAPLING)).setRegistryName("shadewood_sapling"),

		    EBONWOOD_LEAVES = new ModLeavesBlock().setRegistryName("ebonwood_leaves"),
		    SHADEWOOD_LEAVES = new ModLeavesBlock().setRegistryName("shadewood_leaves"),

		    EBONSTONE = new ModStoneBlock().setRegistryName("ebonstone"),
		    CRIMSTONE = new ModStoneBlock().setRegistryName("crimstone"),
		    PEARLSTONE = new ModStoneBlock().setRegistryName("pearlstone"),
		    BLUE_GRANITE = new ModStoneBlock().setRegistryName("blue_granite"),
            MARBLE = new ModStoneBlock().setRegistryName("marble"),


		    MUDSTONE_BRICKS = new ModStoneBlock().setRegistryName("mudstone_bricks"),
		    COPPER_BRICKS = new ModStoneBlock().setRegistryName("copper_bricks"),
		    SILVER_BRICKS = new ModStoneBlock().setRegistryName("silver_bricks"),
		    GOLD_BRICKS = new ModStoneBlock().setRegistryName("gold_bricks"),
		    PLATINUM_BRICKS = new ModStoneBlock().setRegistryName("platinum_bricks"),
		    OBSIDIAN_BRICKS = new ModStoneBlock().setRegistryName("obsidian_bricks"),
		    METEORITE_BRICKS =new ModStoneBlock().setRegistryName("meteorite_bricks"),
		    HELLSTONE_BRICKS = new ModStoneBlock().setRegistryName("hellstone_bricks"),
		    EBONSTONE_BRICKS = new ModStoneBlock().setRegistryName("ebonstone_bricks"),
		    CRIMSTONE_BRICKS = new ModStoneBlock().setRegistryName("crimstone_bricks"),
		    PEARLSTONE_BRICKS = new ModStoneBlock().setRegistryName("pearlstone_bricks"),
		    SMOOTH_BLUE_GRANITE = new ModStoneBlock().setRegistryName("smooth_blue_granite"),
		   	SMOOTH_MARBLE = new ModStoneBlock().setRegistryName("smooth_marble"),

		    EBONSAND = new ModSandBlock(0x523f5a).setRegistryName("ebonsand"),
		    CRIMSAND = new ModSandBlock(0xc34343).setRegistryName("crimsand"),
		    PEARLSAND = new ModSandBlock(0xb5acbe).setRegistryName("pearlsand"),

		    MUD = new ModDirtBlock().setRegistryName("mud"),
		    ASH = new ModDirtBlock().setRegistryName("ash"),
		    SLUSH = new ModSandBlock(0x99b2b9).setRegistryName("slush"),
		    SILT = new ModSandBlock(0x595353).setRegistryName("silt"),

		    MUSHROOM_GRASS_BLOCK = new MushroomGrassBlock().setRegistryName("mushroom_grass_block"),
		    CRIMSON_GRASS_BLOCK = new ModGrassBlock().setRegistryName("crimson_grass_block"),
		    CORRUPT_GRASS_BLOCK = new ModGrassBlock().setRegistryName("corrupt_grass_block"),
		    JUNGLE_GRASS_BLOCK = new ModGrassBlock().setRegistryName("jungle_grass_block"),
		    BLOCK_OF_FLESH = new ModFleshBlock().setRegistryName("block_of_flesh")
			
		);
				
    }
    
}
