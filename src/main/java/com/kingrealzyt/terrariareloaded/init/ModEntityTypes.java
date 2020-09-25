package com.kingrealzyt.terrariareloaded.init;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.client.renderer.entities.DemonEyeRenderer;
import com.kingrealzyt.terrariareloaded.entities.boss.DemonEyeEntity;
import com.kingrealzyt.terrariareloaded.entities.boss.EOCEntity;
import com.kingrealzyt.terrariareloaded.entities.boss.WOFEyeEntity;
import com.kingrealzyt.terrariareloaded.entities.boss.WOFMouthEntity;
import com.kingrealzyt.terrariareloaded.entities.npc.DemolitionistNPCEntity;
import com.kingrealzyt.terrariareloaded.entities.npc.DyeTraderNPCEntity;
import com.kingrealzyt.terrariareloaded.entities.npc.GuideNPCEntity;
import com.kingrealzyt.terrariareloaded.entities.npc.MerchantNPCEntity;
import com.kingrealzyt.terrariareloaded.entities.projectiles.*;
import com.kingrealzyt.terrariareloaded.entities.yoyo.YoyoEntity;
import net.minecraft.advancements.criterion.EnchantedItemTrigger;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, TerrariaReloaded.MOD_ID);
    // PROJECTILE ENTITIES
    public static final RegistryObject<EntityType<ThrowingKnifeEntity>> THROWING_KNIFE_ENTITY = ENTITY_TYPES
            .register("throwing_knife",
                    () -> EntityType.Builder
                            .<ThrowingKnifeEntity>create(ThrowingKnifeEntity::new, EntityClassification.MISC)
                            .size(1.0f, 1.0f)
                            .build(new ResourceLocation(TerrariaReloaded.MOD_ID + ":throwing_knife").toString()));

    public static final RegistryObject<EntityType<DynamiteEntity>> DYNAMITE_ENTITY = ENTITY_TYPES
            .register("dynamite",
                    () -> EntityType.Builder
                            .<DynamiteEntity>create(DynamiteEntity::new, EntityClassification.MISC)
                            .size(1.0f, 1.0f)
                            .build(new ResourceLocation(TerrariaReloaded.MOD_ID + ":dynamite").toString()));

    public static final RegistryObject<EntityType<BombEntity>> BOMB_ENTITY = ENTITY_TYPES
            .register("bomb",
                    () -> EntityType.Builder
                            .<BombEntity>create(BombEntity::new, EntityClassification.MISC)
                            .size(1.0f, 1.0f)
                            .build(new ResourceLocation(TerrariaReloaded.MOD_ID + ":bomb").toString()));


    public static final RegistryObject<EntityType<GrenadeEntity>> GRENADE_ENTITY = ENTITY_TYPES
            .register("grenade",
                    () -> EntityType.Builder
                            .<GrenadeEntity>create(GrenadeEntity::new, EntityClassification.MISC)
                            .size(0.7f, 0.7f)
                            .build(new ResourceLocation(TerrariaReloaded.MOD_ID + ":grenade").toString()));


    public static final RegistryObject<EntityType<YoyoEntity>> YOYO_ENTITY = ENTITY_TYPES
            .register("yoyo",
                    () -> EntityType.Builder.
                            <YoyoEntity>create(YoyoEntity::new, EntityClassification.MISC)
                            .size(0.3F, 0.3F)
                            .disableSerialization().disableSummoning().build(new ResourceLocation(TerrariaReloaded.MOD_ID + ":yoyo").toString()));

    public static final RegistryObject<EntityType<TerrarianYoyoProjectile>> TERRARIAN_PROJECTILE_ENTITY = ENTITY_TYPES
            .register("terrarian_projectile",
                    () -> EntityType.Builder.<TerrarianYoyoProjectile>create(TerrarianYoyoProjectile::new, EntityClassification.MISC)
            .size(0.3F, 0.3F).build(new ResourceLocation(TerrariaReloaded.MOD_ID + ":terrarian_projectile").toString()));

    //BOSS ENTITIES

    public static final RegistryObject<EntityType<WOFEyeEntity>> WALL_OF_FLESH_EYE = ENTITY_TYPES.register("wall_of_flesh_eye",
            () -> EntityType.Builder.<WOFEyeEntity>create(WOFEyeEntity::new, EntityClassification.MONSTER)
                    .size(1.7f, 1.7f)
                    .immuneToFire()
                    .build(new ResourceLocation(TerrariaReloaded.MOD_ID, "wall_of_flesh_eye").toString()));

    public static final RegistryObject<EntityType<WOFMouthEntity>> WALL_OF_FLESH_MOUTH = ENTITY_TYPES.register("wall_of_flesh_mouth",
            () -> EntityType.Builder.<WOFMouthEntity>create(WOFMouthEntity::new, EntityClassification.MONSTER)
                    .size(1.7f, 1.7f)
                    .immuneToFire()
                    .build(new ResourceLocation(TerrariaReloaded.MOD_ID, "wall_of_flesh_mouth").toString()));

    public static final RegistryObject<EntityType<EOCEntity>> EOC = ENTITY_TYPES.register("eye_of_cthulhu",
            () -> EntityType.Builder.<EOCEntity>create(EOCEntity::new, EntityClassification.MONSTER)
                    .size(2.0f, 2.0f)
                    .immuneToFire()
                    .build(new ResourceLocation(TerrariaReloaded.MOD_ID, "eye_of_cthulhu").toString()));

    public static final RegistryObject<EntityType<DemonEyeEntity>> DEMON_EYE = ENTITY_TYPES.register("demon_eye",
            () -> EntityType.Builder.<DemonEyeEntity>create(DemonEyeEntity::new, EntityClassification.MONSTER)
                    .size(0.5f, 0.4f)
                    .build(new ResourceLocation(TerrariaReloaded.MOD_ID, "demon_eye").toString()));

    // NPC ENTITIES

    public static final RegistryObject<EntityType<MerchantNPCEntity>> NPC_MERCHANT = ENTITY_TYPES.register("npc_merchant",
            () -> EntityType.Builder.<MerchantNPCEntity>create(MerchantNPCEntity::new, EntityClassification.CREATURE)
                    .size(0.6f, 1.6f)
                    .immuneToFire()
                    .build(new ResourceLocation(TerrariaReloaded.MOD_ID, "npc_merchant").toString()));

    public static final RegistryObject<EntityType<GuideNPCEntity>> NPC_GUIDE = ENTITY_TYPES.register("npc_guide",
            () -> EntityType.Builder.<GuideNPCEntity>create(GuideNPCEntity::new, EntityClassification.CREATURE)
                    .size(0.6f, 1.6f)
                    .immuneToFire()
                    .build(new ResourceLocation(TerrariaReloaded.MOD_ID, "npc_guide").toString()));

    public static final RegistryObject<EntityType<DyeTraderNPCEntity>> NPC_DYE_TRADER = ENTITY_TYPES.register("npc_dye_trader",
            () -> EntityType.Builder.<DyeTraderNPCEntity>create(DyeTraderNPCEntity::new, EntityClassification.CREATURE)
                    .size(0.6f, 1.6f)
                    .immuneToFire()
                    .build(new ResourceLocation(TerrariaReloaded.MOD_ID, "npc_dye_trader").toString()));

    public static final RegistryObject<EntityType<DemolitionistNPCEntity>> NPC_DEMOLITIONIST = ENTITY_TYPES.register("npc_demolitionist",
            () -> EntityType.Builder.<DemolitionistNPCEntity>create(DemolitionistNPCEntity::new, EntityClassification.CREATURE)
                    .size(0.6f, 1.6f)
                    .immuneToFire()
                    .build(new ResourceLocation(TerrariaReloaded.MOD_ID, "npc_demolitionist").toString()));

}
