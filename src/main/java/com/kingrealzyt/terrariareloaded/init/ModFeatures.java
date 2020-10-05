package com.kingrealzyt.terrariareloaded.init;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.world.feature.structures.SwordShrinePieces;
import com.kingrealzyt.terrariareloaded.world.feature.structures.SwordShrineStructure;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Locale;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = TerrariaReloaded.MOD_ID)
public class ModFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = new DeferredRegister<Feature<?>>(
            ForgeRegistries.FEATURES, TerrariaReloaded.MOD_ID
    );
    public static IStructurePieceType SWORD_SHRINE_PIECE = SwordShrinePieces.Piece::new;

    public static final RegistryObject<SwordShrineStructure> SWORD_SHRINE = FEATURES.register("sword_shrine", () -> new SwordShrineStructure (NoFeatureConfig::deserialize));

    @SubscribeEvent
    public static void registerStructurePieces(RegistryEvent.Register<Feature<?>> event) {
        Registry.register(Registry.STRUCTURE_PIECE, "SWORDSHRINE".toLowerCase(Locale.ROOT), SWORD_SHRINE_PIECE);

    }
}
