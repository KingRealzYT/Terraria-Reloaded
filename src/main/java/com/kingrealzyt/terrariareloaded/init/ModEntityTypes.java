package com.kingrealzyt.terrariareloaded.init;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.entities.boss.EOCEntity;
import com.kingrealzyt.terrariareloaded.entities.boss.WOFEyeEntity;
import com.kingrealzyt.terrariareloaded.entities.boss.WOFMouthEntity;
import com.kingrealzyt.terrariareloaded.entities.enemy.CrabEntity;
import com.kingrealzyt.terrariareloaded.entities.enemy.DemonEntity;
import com.kingrealzyt.terrariareloaded.entities.enemy.DemonEyeEntity;
import com.kingrealzyt.terrariareloaded.entities.enemy.ModSlimeEntity;
import com.kingrealzyt.terrariareloaded.entities.npc.ArmsDealerNPCEntity;
import com.kingrealzyt.terrariareloaded.entities.npc.DemolitionistNPCEntity;
import com.kingrealzyt.terrariareloaded.entities.npc.DryadNPCEntity;
import com.kingrealzyt.terrariareloaded.entities.npc.DyeTraderNPCEntity;
import com.kingrealzyt.terrariareloaded.entities.npc.GuideNPCEntity;
import com.kingrealzyt.terrariareloaded.entities.npc.MerchantNPCEntity;
import com.kingrealzyt.terrariareloaded.entities.npc.TinkererNPCEntity;
import com.kingrealzyt.terrariareloaded.entities.passive.GoldenRatEntity;
import com.kingrealzyt.terrariareloaded.entities.projectiles.*;
import com.kingrealzyt.terrariareloaded.entities.yoyo.YoyoEntity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityType.Builder;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class ModEntityTypes {
	
	
	public static EntityType<EOCEntity> EOC;

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, TerrariaReloaded.MOD_ID);
    // PROJECTILE ENTITIES
    public static final RegistryObject<EntityType<RaycastProjectile>> RAYCAST_PROJECTILE = ENTITY_TYPES
            .register("raycast_projectile",
                    () -> EntityType.Builder
                            .<RaycastProjectile>create(RaycastProjectile::new, EntityClassification.MISC)
                            .size(1.0f, 1.0f)
                            .build(new ResourceLocation(TerrariaReloaded.MOD_ID + ":raycast_projectile").toString()));

    public static final RegistryObject<EntityType<ThrowingKnifeEntity>> THROWING_KNIFE_ENTITY = ENTITY_TYPES
            .register("throwing_knife",
                    () -> EntityType.Builder
                            .<ThrowingKnifeEntity>create(ThrowingKnifeEntity::new, EntityClassification.MISC)
                            .size(1.0f, 1.0f)
                            .build(new ResourceLocation(TerrariaReloaded.MOD_ID + ":throwing_knife").toString()));

    public static final RegistryObject<EntityType<PoisonedKnifeEntity>> POISONED_KNIFE_ENTITY = ENTITY_TYPES
            .register("poisoned_knife",
                    () -> EntityType.Builder
                            .<PoisonedKnifeEntity>create(PoisonedKnifeEntity::new, EntityClassification.MISC)
                            .size(1.0f, 1.0f)
                            .build(new ResourceLocation(TerrariaReloaded.MOD_ID + ":poisoned_knife").toString()));


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

    public static final RegistryObject<EntityType<EnchantedSwordProjectileEntity>> ENCHANTED_SWORD_PROJECTILE_ENTITY = ENTITY_TYPES
            .register("enchanted_sword_projectile",
                    () -> EntityType.Builder
                            .<EnchantedSwordProjectileEntity>create(EnchantedSwordProjectileEntity::new, EntityClassification.MISC)
                            .size(1.0f, 1.0f)
                            .build(new ResourceLocation(TerrariaReloaded.MOD_ID + ":enchanted_sword_projectile").toString()));

    public static final RegistryObject<EntityType<IceboltProjectileEntity>> ICEBOLT_PROJECTILE_ENTITY = ENTITY_TYPES
            .register("icebolt_projectile",
                    () -> EntityType.Builder
                            .<IceboltProjectileEntity>create(IceboltProjectileEntity::new, EntityClassification.MISC)
                            .size(1.0f, 1.0f)
                            .build(new ResourceLocation(TerrariaReloaded.MOD_ID + ":iceblade_projectile").toString()));

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

    //PASSIVE ENTITIES
    public static final RegistryObject<EntityType<GoldenRatEntity>> GOLDEN_RAT = ENTITY_TYPES.register("golden_rat",
            () -> EntityType.Builder.<GoldenRatEntity>create(GoldenRatEntity::new, EntityClassification.CREATURE)
                    .size(0.5f, 0.4f)
                    .build(new ResourceLocation(TerrariaReloaded.MOD_ID, "golden_rat").toString()));


    //HOSTILE ENTITIES
    public static final RegistryObject<EntityType<CrabEntity>> CRAB = ENTITY_TYPES.register("crab",
            () -> EntityType.Builder.<CrabEntity>create(CrabEntity::new, EntityClassification.MONSTER)
                    .size(0.5f, 0.4f)
                    .build(new ResourceLocation(TerrariaReloaded.MOD_ID, "crab").toString()));


    public static final RegistryObject<EntityType<DemonEyeEntity>> DEMON_EYE = ENTITY_TYPES.register("demon_eye",
            () -> EntityType.Builder.<DemonEyeEntity>create(DemonEyeEntity::new, EntityClassification.MONSTER)
                    .size(0.5f, 0.4f)
                    .build(new ResourceLocation(TerrariaReloaded.MOD_ID, "demon_eye").toString()));

    public static final RegistryObject<EntityType<DemonEntity>> DEMON = ENTITY_TYPES.register("demon",
            () -> EntityType.Builder.<DemonEntity>create(DemonEntity::new, EntityClassification.MONSTER)
                    .size(0.6f, 1.4f)
                    .build(new ResourceLocation(TerrariaReloaded.MOD_ID, "demon").toString()));

    public static final RegistryObject<EntityType<ModSlimeEntity>> BLUE_SLIME = ENTITY_TYPES.register("blue_slime",
            () -> EntityType.Builder.<ModSlimeEntity>create(ModSlimeEntity::new, EntityClassification.MONSTER)
                    .size(2.0f, 2.0f)
                    .build(new ResourceLocation(TerrariaReloaded.MOD_ID, "blue_slime").toString()));

    // NPC ENTITIES
    //ADDFORNPC

    public static final RegistryObject<EntityType<MerchantNPCEntity>> NPC_MERCHANT = ENTITY_TYPES.register("npc_merchant",
            () -> EntityType.Builder.<MerchantNPCEntity>create(MerchantNPCEntity::new, EntityClassification.CREATURE)
                    .size(0.6f, 1.75f)
                    .immuneToFire()
                    .build(new ResourceLocation(TerrariaReloaded.MOD_ID, "npc_merchant").toString()));

    public static final RegistryObject<EntityType<GuideNPCEntity>> NPC_GUIDE = ENTITY_TYPES.register("npc_guide",
            () -> EntityType.Builder.<GuideNPCEntity>create(GuideNPCEntity::new, EntityClassification.CREATURE)
                    .size(0.6f, 1.75f)
                    .immuneToFire()
                    .build(new ResourceLocation(TerrariaReloaded.MOD_ID, "npc_guide").toString()));

    public static final RegistryObject<EntityType<DyeTraderNPCEntity>> NPC_DYE_TRADER = ENTITY_TYPES.register("npc_dye_trader",
            () -> EntityType.Builder.<DyeTraderNPCEntity>create(DyeTraderNPCEntity::new, EntityClassification.CREATURE)
                    .size(0.6f, 1.75f)
                    .immuneToFire()
                    .build(new ResourceLocation(TerrariaReloaded.MOD_ID, "npc_dye_trader").toString()));

    public static final RegistryObject<EntityType<DemolitionistNPCEntity>> NPC_DEMOLITIONIST = ENTITY_TYPES.register("npc_demolitionist",
            () -> EntityType.Builder.<DemolitionistNPCEntity>create(DemolitionistNPCEntity::new, EntityClassification.CREATURE)
                    .size(0.6f, 1.6f)
                    .immuneToFire()
                    .build(new ResourceLocation(TerrariaReloaded.MOD_ID, "npc_demolitionist").toString()));

    public static final RegistryObject<EntityType<DryadNPCEntity>> NPC_DRYAD = ENTITY_TYPES.register("npc_dryad",
            () -> EntityType.Builder.<DryadNPCEntity>create(DryadNPCEntity::new, EntityClassification.CREATURE)
                    .size(0.6f, 1.75f)
                    .immuneToFire()
                    .build(new ResourceLocation(TerrariaReloaded.MOD_ID, "npc_dryad").toString()));

    public static final RegistryObject<EntityType<ArmsDealerNPCEntity>> NPC_ARMS_DEALER = ENTITY_TYPES.register("npc_arms_dealer",
            () -> EntityType.Builder.<ArmsDealerNPCEntity>create(ArmsDealerNPCEntity::new, EntityClassification.CREATURE)
                    .size(0.6f, 1.75f)
                    .immuneToFire()
                    .build(new ResourceLocation(TerrariaReloaded.MOD_ID, "npc_arms_dealer").toString()));

    public static final RegistryObject<EntityType<TinkererNPCEntity>> NPC_TINKERER = ENTITY_TYPES.register("npc_tinkerer",
            () -> EntityType.Builder.<TinkererNPCEntity>create(TinkererNPCEntity::new, EntityClassification.CREATURE)
                    .size(0.6f, 1.75f)
                    .immuneToFire()
                    .build(new ResourceLocation(TerrariaReloaded.MOD_ID, "npc_tinkerer").toString()));
    

    @SubscribeEvent
    public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
    	ModEntityTypes.EOC = register("terrariareloaded:eye_of_cthulhu", Builder.<EOCEntity>create(EOCEntity::new, EntityClassification.MISC).immuneToFire().setCustomClientFactory((spawnEntity, world) -> {
    	  	return new EOCEntity(world);
    	}));
    }
    
    private static <T extends Entity> EntityType<T> register(String id, EntityType.Builder<T> builder) {
	      return Registry.register(Registry.ENTITY_TYPE, id, builder.build(id));
    }

}
