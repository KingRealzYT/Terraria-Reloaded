package com.kingrealzyt.terrariareloaded.entities.npc;

import com.kingrealzyt.terrariareloaded.shop.IBuyCallback;
import com.kingrealzyt.terrariareloaded.shop.Offer;
import com.kingrealzyt.terrariareloaded.shop.OfferList;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.HandSide;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ShopNPC extends LivingEntity implements IShopNPC {

    public ShopNPC(EntityType<? extends LivingEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    public ActionResultType applyPlayerInteraction(PlayerEntity player, Vec3d vec, Hand hand) {
        if (!world.isRemote) {

        }
        return super.applyPlayerInteraction(player, vec, hand);
    }

    @Override
    public Iterable<ItemStack> getArmorInventoryList() {
        return NonNullList.withSize(4, ItemStack.EMPTY);
    }

    @Override
    public ItemStack getItemStackFromSlot(EquipmentSlotType slotIn) {
        //Not needed for a shop entity
        return null;
    }

    @Override
    public void setItemStackToSlot(EquipmentSlotType slotIn, ItemStack stack) {
        //Not needed for a shop entity
    }

    @Override
    public HandSide getPrimaryHand() {
        return HandSide.RIGHT;
    }

    @Override
    public OfferList getOfferList() {
        return OfferList.TEST;
    }

    @Override
    public IBuyCallback buy(Offer offer, ShopNPC entity) {
        return null;
    }
}
