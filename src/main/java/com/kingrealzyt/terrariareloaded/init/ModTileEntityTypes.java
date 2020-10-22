package com.kingrealzyt.terrariareloaded.init;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.tileentities.HellforgeTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes {
    public static final DeferredRegister<TileEntityType<?>> TILEENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, TerrariaReloaded.MOD_ID);


    public static final RegistryObject<TileEntityType<HellforgeTileEntity>> HELLFORGE = TILEENTITY_TYPES
            .register("hellforge", ()-> TileEntityType.Builder.create(HellforgeTileEntity::new, ModBlocks.HELLFORGE.getBlock()).build(null));
}
