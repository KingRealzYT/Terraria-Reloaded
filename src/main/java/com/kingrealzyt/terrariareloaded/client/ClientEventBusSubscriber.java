package com.kingrealzyt.terrariareloaded.client;

import com.kingrealzyt.terrariareloaded.client.renderer.entities.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.init.ModEntityTypes;

@Mod.EventBusSubscriber(modid = TerrariaReloaded.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event){
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.THROWING_KNIFE_ENTITY.get(), RenderThrowingKnife::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.DYNAMITE_ENTITY.get(), RenderDynamite::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.GRENADE_ENTITY.get(), RenderGrenade::new);

        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.TERRARIAN_PROJECTILE_ENTITY.get(), TerrarianYoyoProjectileRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.YOYO_ENTITY.get(), YoyoEntityRenderer::new);

        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.WALL_OF_FLESH_EYE.get(), WOFEyeRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.WALL_OF_FLESH_MOUTH.get(), WOFMouthRenderer::new);
    }
}
