package com.kingrealzyt.terrariareloaded.client;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.client.gui.HellforgeScreen;
import com.kingrealzyt.terrariareloaded.client.gui.PiggyBankScreen;
import com.kingrealzyt.terrariareloaded.client.gui.ShopNPCScreen;
import com.kingrealzyt.terrariareloaded.client.model.npc.*;
import com.kingrealzyt.terrariareloaded.client.renderer.entities.*;
import com.kingrealzyt.terrariareloaded.client.renderer.entities.npc.ShopNPCRenderer;
import com.kingrealzyt.terrariareloaded.entities.npc.ArmsDealerNPCEntity;
import com.kingrealzyt.terrariareloaded.entities.npc.ShopNPCEntity;
import com.kingrealzyt.terrariareloaded.init.ModBlocks;
import com.kingrealzyt.terrariareloaded.init.ModContainers;
import com.kingrealzyt.terrariareloaded.init.ModEntityTypes;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = TerrariaReloaded.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.THROWING_KNIFE_ENTITY.get(), RenderThrowingKnife::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.POISONED_KNIFE_ENTITY.get(), RenderPoisonedKnife::new);

        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.DYNAMITE_ENTITY.get(), RenderDynamite::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.GRENADE_ENTITY.get(), RenderGrenade::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BOMB_ENTITY.get(), RenderBomb::new);

        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.TERRARIAN_PROJECTILE_ENTITY.get(), TerrarianYoyoProjectileRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.YOYO_ENTITY.get(), YoyoEntityRenderer::new);

        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.WALL_OF_FLESH_EYE.get(), WOFEyeRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.WALL_OF_FLESH_MOUTH.get(), WOFMouthRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.DEMON_EYE.get(), DemonEyeRenderer::new);

        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.EOC.get(), EOCRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BLUE_SLIME.get(), ModSlimeRenderer::new);

        ScreenManager.registerFactory(ModContainers.PIGGY_BANK.get(), PiggyBankScreen::new);
        ScreenManager.registerFactory(ModContainers.SHOP_NPC.get(), ShopNPCScreen::new);
        ScreenManager.registerFactory(ModContainers.HELLFORGE.get(), HellforgeScreen::new);

//ADDFORNPC
        registerNpcRenderer(ModEntityTypes.NPC_MERCHANT.get(), new MerchantNPCModel<>());
        registerNpcRenderer(ModEntityTypes.NPC_GUIDE.get(), new GuideNPCModel<>());
        registerNpcRenderer(ModEntityTypes.NPC_DYE_TRADER.get(), new DyeTraderNPCModel<>());
        registerNpcRenderer(ModEntityTypes.NPC_DEMOLITIONIST.get(), new DemolitionistNPCModel<>());
        registerNpcRenderer(ModEntityTypes.NPC_DRYAD.get(), new DryadNPCModel<>());
        registerNpcRenderer(ModEntityTypes.NPC_ARMS_DEALER.get(), new ArmsTraderNPCModel<>());
        registerNpcRenderer(ModEntityTypes.NPC_TINKERER.get(), new TinkererNPCModel<>());
    }


    private static <T extends ShopNPCEntity, M extends EntityModel<T>> void registerNpcRenderer(EntityType<T> entity, M model) {
        RenderingRegistry.registerEntityRenderingHandler(entity, (manager) -> new ShopNPCRenderer<>(manager, model));
    }

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(ModBlocks.LIFE_FRUIT_BUSH.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.JUNGLE_SPORES_BUSH.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.EBONWOOD_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SHADEWOOD_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.EBONWOOD_LEAVES.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(ModBlocks.SHADEWOOD_LEAVES.get(), RenderType.getCutoutMipped());

    }
}
