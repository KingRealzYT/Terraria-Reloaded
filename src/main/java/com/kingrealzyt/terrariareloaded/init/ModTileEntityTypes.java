package com.kingrealzyt.terrariareloaded.init;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.blocks.Hellforge;
import com.kingrealzyt.terrariareloaded.entities.boss.DemonEyeEntity;
import com.kingrealzyt.terrariareloaded.entities.boss.EOCEntity;
import com.kingrealzyt.terrariareloaded.entities.boss.WOFEyeEntity;
import com.kingrealzyt.terrariareloaded.entities.boss.WOFMouthEntity;
import com.kingrealzyt.terrariareloaded.entities.enemy.ModSlimeEntity;
import com.kingrealzyt.terrariareloaded.entities.npc.*;
import com.kingrealzyt.terrariareloaded.entities.projectiles.*;
import com.kingrealzyt.terrariareloaded.entities.yoyo.YoyoEntity;
import com.kingrealzyt.terrariareloaded.tileentities.HellforgeTileEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes {
    public static final DeferredRegister<TileEntityType<?>> TILEENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, TerrariaReloaded.MOD_ID);


    public static final RegistryObject<TileEntityType<HellforgeTileEntity>> HELLFORGE = TILEENTITY_TYPES
            .register("hellforge", ()-> TileEntityType.Builder.create(HellforgeTileEntity::new, ModBlocks.HELLFORGE.get()).build(null));
}
