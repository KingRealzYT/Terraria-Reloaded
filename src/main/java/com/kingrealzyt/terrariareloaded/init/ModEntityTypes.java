package com.kingrealzyt.terrariareloaded.init;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, TerrariaReloaded.MOD_ID);

    //public static final RegistryObject<EntityType<TerrariaSlime>> GREEN_SLIME = ENTITY_TYPES.register("green_slime", () -> EntityType.Builder.<TerrariaSlime>create(TerrariaSlime::new, EntityClassification.CREATURE).size(0.4f, 0.4f).build(new ResourceLocation(TerrariaReloaded.MOD_ID, "green_slime").toString()));
}
