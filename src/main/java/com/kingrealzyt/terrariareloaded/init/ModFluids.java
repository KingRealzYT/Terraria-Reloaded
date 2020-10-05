package com.kingrealzyt.terrariareloaded.init;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import net.minecraft.block.Block;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Rarity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings("all")
public class ModFluids {

    public static void init() {
        FLUIDS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final ResourceLocation HONEY_STILL_RL = new ResourceLocation(TerrariaReloaded.MOD_ID, "blocks/honey_still");
    public static final ResourceLocation HONEY_FLOWING_RL = new ResourceLocation(TerrariaReloaded.MOD_ID,
            "blocks/honey_flow");
    public static final ResourceLocation HONEY_OVERLAY_RL = new ResourceLocation(TerrariaReloaded.MOD_ID,
            "blocks/honey_overlay");

    public static final DeferredRegister<Fluid> FLUIDS = new DeferredRegister<Fluid>(ForgeRegistries.FLUIDS,
            TerrariaReloaded.MOD_ID);

    public static final RegistryObject<FlowingFluid> HONEY_FLUID = FLUIDS.register("honey_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.HONEY_PROPERTIES));

    public static final RegistryObject<FlowingFluid> HONEY_FLOWING = FLUIDS.register("honey_flowing",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.HONEY_PROPERTIES));

    public static final ForgeFlowingFluid.Properties HONEY_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> HONEY_FLUID.get(), () -> HONEY_FLOWING.get(),
            FluidAttributes.builder(HONEY_STILL_RL, HONEY_FLOWING_RL).density(10).luminosity(12).rarity(Rarity.RARE)
                    .sound(SoundEvents.ITEM_BUCKET_EMPTY_LAVA).overlay(HONEY_OVERLAY_RL))
            .block(() -> ModFluids.HONEY_BLOCK.get()).bucket(() -> ModItems.HONEY_BUCKET.get());

    public static final RegistryObject<FlowingFluidBlock> HONEY_BLOCK = ModBlocks.BLOCKS.register("honey",
            () -> new FlowingFluidBlock(() -> ModFluids.HONEY_FLUID.get(), Block.Properties.create(Material.WATER)
                    .doesNotBlockMovement().hardnessAndResistance(100.0f).noDrops()));

}
