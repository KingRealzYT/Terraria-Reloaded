package com.kingrealzyt.terrariareloaded.container;

import com.kingrealzyt.terrariareloaded.init.ModContainers;
import com.kingrealzyt.terrariareloaded.inventory.PiggyBankInventory;
import com.kingrealzyt.terrariareloaded.inventory.PiggyBankSlot;
import com.kingrealzyt.terrariareloaded.world.capability.CapabilityAccessor;
import com.kingrealzyt.terrariareloaded.world.capability.player.IPlayerCoinCapability;
import com.kingrealzyt.terrariareloaded.world.capability.player.PlayerCoinCapabilityImpl;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class PiggyBankContainer extends Container {

    private final int numRows = 3;
    private final PiggyBankInventory piggyBankInventory;

    public PiggyBankContainer(int id, PlayerInventory playerInventory, PacketBuffer data) {
        this(id, playerInventory, CapabilityAccessor.getPlayerCoinCapability(playerInventory.player).getPiggyBankInventory());
    }

    public PiggyBankContainer(int id, PlayerInventory playerInventory, PiggyBankInventory piggyBankInventory) {
        super(ModContainers.PIGGY_BANK.get(), id);
        int i = (this.numRows - 4) * 18;
        this.piggyBankInventory = piggyBankInventory;

        for (int j = 0; j < this.numRows; ++j) {
            for (int k = 0; k < 9; ++k) {
                this.addSlot(new PiggyBankSlot(piggyBankInventory, k + j * 9, 8 + k * 18, 18 + j * 18));
            }
        }

        for (int l = 0; l < 3; ++l) {
            for (int j1 = 0; j1 < 9; ++j1) {
                this.addSlot(new Slot(playerInventory, j1 + l * 9 + 9, 8 + j1 * 18, 103 + l * 18 + i));
            }
        }

        for (int i1 = 0; i1 < 9; ++i1) {
            this.addSlot(new Slot(playerInventory, i1, 8 + i1 * 18, 161 + i));
        }
    }

    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (index < this.numRows * 9) {
                if (!this.mergeItemStack(itemstack1, this.numRows * 9, this.inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemstack1, 0, this.numRows * 9, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }

    public void onContainerClosed(PlayerEntity playerIn) {
        super.onContainerClosed(playerIn);
        this.piggyBankInventory.closeInventory(playerIn);
    }

    @OnlyIn(Dist.CLIENT)
    public int getNumRows() {
        return numRows;
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return this.piggyBankInventory.isUsableByPlayer(playerIn);
    }
}
