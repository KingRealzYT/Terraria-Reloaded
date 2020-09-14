package com.kingrealzyt.terrariareloaded.init;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.world.dimension.TheUnderworld;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DimensionInit {

    public static final DeferredRegister<ModDimension> MOD_DIMENSIONS = new  DeferredRegister<>(ForgeRegistries.MOD_DIMENSIONS, TerrariaReloaded.MOD_ID);

    public static final RegistryObject<ModDimension> UNDERWORLD = MOD_DIMENSIONS.register("underworld", () -> new TheUnderworld());

}
