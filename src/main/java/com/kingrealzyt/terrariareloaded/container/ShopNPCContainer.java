package com.kingrealzyt.terrariareloaded.container;

import net.minecraft.entity.merchant.IMerchant;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.MerchantContainer;
import net.minecraft.network.PacketBuffer;

public class ShopNPCContainer extends MerchantContainer {

    /*public ShopNPCContainer(int id, PlayerInventory playerInventory, PacketBuffer data) {
        this(id, playerInventory, (IMerchant) playerInventory.player.world.getEntityByID(data.readInt()));
    }*/

    public ShopNPCContainer(int id, PlayerInventory playerInventory, PacketBuffer data) {
        this(id, playerInventory, (IMerchant) playerInventory.player.world.getEntityByID(data.readInt()));
    }

    public ShopNPCContainer(int id, PlayerInventory playerInventoryIn, IMerchant merchantIn) {
        super(id, playerInventoryIn, merchantIn);
    }
}
