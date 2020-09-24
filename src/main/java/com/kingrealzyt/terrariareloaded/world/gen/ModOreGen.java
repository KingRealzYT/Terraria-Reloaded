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
            genOre(biome, 9, 19, 30, 41, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.SILVER_ORE.get().getDefaultState(), 9);
            genOre(biome, 13, 19, 5, 80, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.COPPER_ORE.get().getDefaultState(), 11);
            if (biome.getCategory() == Biome.Category.JUNGLE) {
                genOre(biome, 6, 5, 25, 41, OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.CHLOROPHYTE_ORE.get().getDefaultState(), 4);

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
