package com.kingrealzyt.terrariareloaded.init;

public class ModFluids {/*
    //This is where i do the fluids
    // For some reason Terraria has like a million enemies and a billion items and a trillion blocks but only THREE FLUIDS
    //and two of them are water and lava so i just need to add honey lmao

    // IMPORTANT: Currently this fluid doesnt work correctly so I disabled it. It doesn't act like water (can't swim) and it doesnt
    have transparent textures for some reason, plus the textures are fucky wucky anyway. Might fix eventually, can't right now
    //- goldrat1

    public static void init() {
        FLUIDS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final ResourceLocation HONEY_STILL_RL = new ResourceLocation(TerrariaReloaded.MOD_ID, "blocks/honey_still");
    public static final ResourceLocation HONEY_FLOWING_RL = new ResourceLocation(TerrariaReloaded.MOD_ID, "blocks/honey_flow");
    public static final ResourceLocation HONEY_OVERLAY_RL = new ResourceLocation(TerrariaReloaded.MOD_ID, "blocks/honey_overlay");

    public static final DeferredRegister<Fluid> FLUIDS = new DeferredRegister<>(ForgeRegistries.FLUIDS, TerrariaReloaded.MOD_ID);

    public static final RegistryObject<FlowingFluid> HONEY_FLUID = FLUIDS.register("honey_fluid", () -> new ForgeFlowingFluid.Source(ModFluids.HONEY_PROPERTIES));
    public static final RegistryObject<FlowingFluid> HONEY_FLOWING = FLUIDS.register("honey_flow", () -> new ForgeFlowingFluid.Flowing(ModFluids.HONEY_PROPERTIES));
    public static final RegistryObject<FlowingFluidBlock> HONEY_FLUID_BLOCK = ModBlocks.BLOCKS.register("honey", () -> new FlowingFluidBlock(() -> ModFluids.HONEY_FLUID.get(),
            Block.Properties.create(Material.WATER)
    .doesNotBlockMovement()
    .speedFactor(0.8f)
    .hardnessAndResistance(100f)
    .noDrops()
    .jumpFactor(1.5f)));


    public static final ForgeFlowingFluid.Properties HONEY_PROPERTIES = new ForgeFlowingFluid.Properties(() -> HONEY_FLUID.get(), () -> HONEY_FLOWING.get(),
            FluidAttributes.builder(HONEY_STILL_RL, HONEY_STILL_RL)
            .color(0xf79909)
            .density(10)
            .luminosity(10)
            .rarity(Rarity.UNCOMMON)
            .sound(SoundEvents.BLOCK_HONEY_BLOCK_SLIDE)
            .overlay(HONEY_OVERLAY_RL)
            .viscosity(3)
    ).block(() -> ModFluids.HONEY_FLUID_BLOCK.get());
*/
}
