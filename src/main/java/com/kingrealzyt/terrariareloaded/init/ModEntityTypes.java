package com.kingrealzyt.terrariareloaded.init;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.entities.projectiles.ThrowingKnifeEntity;
import com.kingrealzyt.terrariareloaded.entities.yoyo.YoyoEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, TerrariaReloaded.MOD_ID);

    public static final RegistryObject<EntityType<ThrowingKnifeEntity>> THROWING_KNIFE_ENTITY = ENTITY_TYPES
            .register("throwing_knife",
                    () -> EntityType.Builder
                            .<ThrowingKnifeEntity>create(ThrowingKnifeEntity::new, EntityClassification.MISC)
                            .size(1.0f, 1.0f)
                            .build(new ResourceLocation(TerrariaReloaded.MOD_ID + ":throwing_knife").toString()));

    public static final RegistryObject<EntityType<YoyoEntity>> YOYO_ENTITY = ENTITY_TYPES
            .register("yoyo",
                    () -> EntityType.Builder.
                            <YoyoEntity>create(YoyoEntity::new, EntityClassification.MISC)
                            .size(0.3F, 0.3F)
                            .disableSerialization().disableSummoning().build(new ResourceLocation(TerrariaReloaded.MOD_ID + ":yoyo").toString()));

}
