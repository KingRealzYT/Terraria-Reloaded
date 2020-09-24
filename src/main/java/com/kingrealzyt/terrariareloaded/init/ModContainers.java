package com.kingrealzyt.terrariareloaded.init;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.container.PiggyBankContainer;
import com.kingrealzyt.terrariareloaded.container.ShopNPCContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainers {

    public static final DeferredRegister<ContainerType<?>> CONTAINERS = new DeferredRegister<>(ForgeRegistries.CONTAINERS, TerrariaReloaded.MOD_ID);

    public static final RegistryObject<ContainerType<PiggyBankContainer>> PIGGY_BANK = CONTAINERS.register("piggy_bank",
            () -> IForgeContainerType.create(PiggyBankContainer::new));

    public static final RegistryObject<ContainerType<ShopNPCContainer>> SHOP_NPC = CONTAINERS.register("shop_npc",
            () -> IForgeContainerType.create(ShopNPCContainer::new));

}
