package com.kingrealzyt.terrariareloaded.world.gen;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = TerrariaReloaded.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModOreGen {

    @SubscribeEvent
    public static void generateOres(FMLLoadCompleteEvent event) {
        for (Biome biome : ForgeRegistries.BIOMES) {
            genOre(biome, 3, 19, 30, 41, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.SILVER_ORE.getDefaultState(), 5);
            genOre(biome, 6, 19, 5, 80, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.COPPER_ORE.getDefaultState(), 7);
            genOre(biome, 2, 3, 20, 40, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.PLATINUM_ORE.getDefaultState(), 5);

            genOre(biome, 2, 3, 5, 40, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.SHIMMERING_DIAMOND_ORE.getDefaultState(), 3);
            genOre(biome, 2, 3, 5, 40, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.SHIMMERING_EMERALD_ORE.getDefaultState(), 3);

            genOre(biome, 3, 10, 10, 80, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.AMETHYST_ORE.getDefaultState(), 5);
            genOre(biome, 3, 10, 10, 80, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.RUBY_ORE.getDefaultState(), 2);
            genOre(biome, 3, 10, 10, 80, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.SAPPHIRE_ORE.getDefaultState(), 3);
            genOre(biome, 3, 10, 10, 80, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.TOPAZ_ORE.getDefaultState(), 2);

            genOre(biome, 2, 15, 10, 70, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.AMBER_ORE.getDefaultState(), 5);

            if (biome.getCategory() == Biome.Category.JUNGLE) {
                genOre(biome, 6, 5, 25, 41, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.CHLOROPHYTE_ORE.getDefaultState(), 4);

            }
        }
    }


    private static void genOre(Biome biome, int count, int bottomOffset, int topOffset, int max, OreFeatureConfig.FillerBlockType filler, BlockState defaultBlockstate, int size) {
        CountRangeConfig range = new CountRangeConfig(count, bottomOffset, topOffset, max);
        OreFeatureConfig feature = new OreFeatureConfig(filler, defaultBlockstate, size);
        ConfiguredPlacement config = Placement.COUNT_RANGE.configure(range);
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(feature).withPlacement(config));
    }
}
