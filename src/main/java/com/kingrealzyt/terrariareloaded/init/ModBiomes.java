package com.kingrealzyt.terrariareloaded.init;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.world.biomes.CrimsonBiome;
import net.minecraft.block.Block;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomes {

    public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, TerrariaReloaded.MOD_ID);

    public static final RegistryObject<Biome> CRIMSON = BIOMES.register("crimson", () -> new CrimsonBiome(new Biome.Builder().scale(1f).temperature(0.2f).waterColor(10694464).waterFogColor(16748683).surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(ModBlocks.CRIMSON_GRASS_BLOCK.get().getDefaultState(), ModBlocks.CRIMSTONE.get().getDefaultState(), ModBlocks.CRIMSAND.get().getDefaultState())).category(Biome.Category.PLAINS).downfall(0.0001f).depth(0.125f).parent(null).precipitation(Biome.RainType.RAIN)));


    public static void registerBiomes()
    {
        registerBiome(CRIMSON.get(), Type.PLAINS, Type.DRY, Type.HOT, Type.DEAD, Type.OVERWORLD, Type.SPOOKY);
    }
    private static void registerBiome(Biome biome, Type... types)
    {
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }
}
