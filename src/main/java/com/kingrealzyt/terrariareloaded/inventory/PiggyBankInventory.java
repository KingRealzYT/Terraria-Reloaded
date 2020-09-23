package com.kingrealzyt.terrariareloaded.inventory;

import com.kingrealzyt.terrariareloaded.init.ModItems;
import com.kingrealzyt.terrariareloaded.world.capability.PlayerCoinStorage;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EnderChestInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.EnderChestTileEntity;

public class PiggyBankInventory extends EnderChestInventory {

    public PiggyBankInventory() {
    }

    public void fillInventoryCoins(PlayerCoinStorage coinStorage) {
        int slot = 0;
        this.applyCoins(slot, coinStorage, PlayerCoinStorage.Coin.BRONZE);
        this.applyCoins(slot, coinStorage, PlayerCoinStorage.Coin.SILVER);
        this.applyCoins(slot, coinStorage, PlayerCoinStorage.Coin.GOLD);
        this.applyCoins(slot, coinStorage, PlayerCoinStorage.Coin.PLATINUM);
    }

    private void applyCoins(int slot, PlayerCoinStorage storage, PlayerCoinStorage.Coin coin) {
        int amount = storage.getAmount(coin);
        Item coinItem;
        switch (coin) {
            case BRONZE:
                coinItem = ModItems.COPPER_COIN.get();
                break;
            case SILVER:
                coinItem = ModItems.SILVER_COIN.get();
                break;
            case GOLD:
                coinItem = ModItems.GOLD_COIN.get();
                break;
            case PLATINUM:
                coinItem = ModItems.PLATINUM_COIN.get();
                break;
            default:
                throw new IllegalStateException("Coin type not found");
        }

        if (amount > 0) {
            int i = amount % 100;
            if (i == 0) {
                for (int j = 0; j < amount / 100; j++) {
                    this.setInventorySlotContents(slot++, new ItemStack(coinItem, 100));
                }
            } else {
                if (amount < 100) {
                    this.setInventorySlotContents(++slot, new ItemStack(coinItem, amount));
                } else {
                    int j = amount - i;
                    amount -= i;
                    for (int k = 0; k < amount / 100; k++) {
                        this.setInventorySlotContents(slot++, new ItemStack(coinItem, 100));
                    }
                    this.setInventorySlotContents(++slot, new ItemStack(coinItem, j));
                }
            }
        }
    }

    @Override
    public boolean isUsableByPlayer(PlayerEntity player) {
        return true;
    }

    @Override
    public void setChestTileEntity(EnderChestTileEntity chestTileEntity) {
        //Not needed
    }
}
