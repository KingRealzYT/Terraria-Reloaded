package com.kingrealzyt.terrariareloaded.world.biomes;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.foliageplacer.AcaciaFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.placement.*;

public class CrimsonBiome extends Biome{

    private static final BlockState WATER = Blocks.WATER.getDefaultState();
    private static final BlockState DARK_OAK_LEAVES = Blocks.DARK_OAK_LEAVES.getDefaultState();
    private static final BlockState ACACIA_LOG = Blocks.ACACIA_LOG.getDefaultState();
    private static final BlockState DARK_OAK_LOG = Blocks.DARK_OAK_LOG.getDefaultState();
    private static final BlockState ACACIA_LEAVES = Blocks.ACACIA_LEAVES.getDefaultState();
    private static final BlockState DEAD_BUSH = Blocks.DEAD_BUSH.getDefaultState();
    private static final BlockState OAK_LOG = Blocks.OAK_LOG.getDefaultState();
    private static final BlockState OAK_LEAVES = Blocks.OAK_LEAVES.getDefaultState();
    public static final TreeFeatureConfig OAK_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(OAK_LOG), new SimpleBlockStateProvider(OAK_LEAVES), new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(2).foliageHeight(3).ignoreVines().setSapling((net.minecraftforge.common.IPlantable)Blocks.OAK_SAPLING).build();
    public static final TreeFeatureConfig ACACIA_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(ACACIA_LOG), new SimpleBlockStateProvider(ACACIA_LEAVES), new AcaciaFoliagePlacer(2, 0))).baseHeight(5).heightRandA(2).heightRandB(2).trunkHeight(0).ignoreVines().setSapling((net.minecraftforge.common.IPlantable)Blocks.ACACIA_SAPLING).build();
    public static final HugeTreeFeatureConfig DARK_OAK_TREE_CONFIG = (new HugeTreeFeatureConfig.Builder(new SimpleBlockStateProvider(DARK_OAK_LOG), new SimpleBlockStateProvider(DARK_OAK_LEAVES))).baseHeight(6).setSapling((net.minecraftforge.common.IPlantable)Blocks.DARK_OAK_SAPLING).build();
    public static final BlockClusterFeatureConfig DEAD_BUSH_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(DEAD_BUSH), new SimpleBlockPlacer())).tries(4).build();
    public CrimsonBiome(Builder biomeBuilder) {
        super(biomeBuilder);


        //All stuff found in DefaultBiomeFeatures Class
        //Spawning Entitys
        addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.BLAZE, 15, 1, 3));


        //Cave Gen
        addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.HELL_CAVE, new ProbabilityConfig(0.14285715F)));
        //Mineshaft
        addFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES, Feature.MINESHAFT.withConfiguration(new MineshaftConfig((double)0.004F, MineshaftStructure.Type.NORMAL)).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
        //Fossil
        addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.FOSSIL.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(256))));

        //Lakes
        addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Feature.LAKE.withConfiguration(new BlockStateFeatureConfig(WATER)).withPlacement(Placement.LAVA_LAKE.configure(new ChanceConfig(80))));
        //Monster Rooms
        addFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES, Feature.MONSTER_ROOM.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.DUNGEONS.configure(new ChanceConfig(8))));
        //Trees
        addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.ACACIA_TREE.withConfiguration(ACACIA_TREE_CONFIG).withChance(0.8F)), Feature.NORMAL_TREE.withConfiguration(OAK_TREE_CONFIG))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(2, 0.1F, 1))));
        //Dead Bushes
        addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DEAD_BUSH_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(20))));


        //Ores
        DefaultBiomeFeatures.addOres(this);











    }



}
