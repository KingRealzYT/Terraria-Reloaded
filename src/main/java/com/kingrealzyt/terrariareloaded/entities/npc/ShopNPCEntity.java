package com.kingrealzyt.terrariareloaded.entities.npc;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.container.ShopNPCContainer;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.MerchantOffer;
import net.minecraft.item.MerchantOffers;
import net.minecraft.network.play.server.SMerchantOffersPacket;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.OptionalInt;

public abstract class ShopNPCEntity extends AbstractVillagerEntity {

    private final ShopType shopType;

    public ShopNPCEntity(EntityType<? extends AbstractVillagerEntity> type, World worldIn) {
        super(type, worldIn);
        this.shopType = ShopType.MERCHANT; //Default if the npc is spawned via command
        this.offers = ShopType.MERCHANT.getOffers();
    }

    public ShopNPCEntity(EntityType<? extends AbstractVillagerEntity> type, World world, ShopType shopType) {
        super(type, world);
        this.shopType = shopType;
        this.offers = shopType.getOffers();
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(2, new PanicGoal(this, 1.1f));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomWalkingGoal(this, 1.0f));
        this.goalSelector.addGoal(2, new LookAtGoal(this, PlayerEntity.class, 7.0f));
        this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
    }


    @Override
    public boolean processInteract(PlayerEntity player, Hand hand) {
        if (this.offers == null)
            this.populateTradeData();
        if (!this.world.isRemote && !this.offers.isEmpty()) {
            this.displayGui(player);
            return true;
        }
        return super.processInteract(player, hand);
    }

    @Override
    public boolean func_213705_dZ() {
        return false;
    }

    public void displayGui(PlayerEntity player) {
        this.setCustomer(player);
        //this.openMerchantContainer(player, this.getDisplayName(), 0);
        SimpleNamedContainerProvider sncp = new SimpleNamedContainerProvider((id, inventory, playerE) -> new ShopNPCContainer(id, inventory, this), this.getDisplayName());
        OptionalInt optionalInt = player.openContainer(sncp);
        if (optionalInt.isPresent()) {
            MerchantOffers merchantOffers = this.getOffers();
            if (!merchantOffers.isEmpty()) {
                if (!world.isRemote) {
                    ServerPlayerEntity spe = (ServerPlayerEntity) player;
                    spe.connection.sendPacket(new SMerchantOffersPacket(optionalInt.getAsInt(), merchantOffers, 0, 0, this.func_213705_dZ(), this.func_223340_ej()));
                }
            }
        }
        /*
        OptionalInt optionalint = player.openContainer(new SimpleNamedContainerProvider((p_213701_1_, p_213701_2_, p_213701_3_) -> {
         return new MerchantContainer(p_213701_1_, p_213701_2_, this);
      }, p_213707_2_));
      if (optionalint.isPresent()) {
         MerchantOffers merchantoffers = this.getOffers();
         if (!merchantoffers.isEmpty()) {
            player.openMerchantContainer(optionalint.getAsInt(), merchantoffers, level, this.getXp(), this.func_213705_dZ(), this.func_223340_ej());
         }
      }
         */
    }


    @Override
    public boolean func_223340_ej() {
        return true;
    }


    @Override
    public ITextComponent getDisplayName() {
        return new StringTextComponent(shopType.getNpcName());
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(70.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
        this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.3D);
    }

    @Override
    protected void onVillagerTrade(MerchantOffer offer) {
        TerrariaReloaded.LOGGER.debug("ShopNPC traded. Yeah");
    }

    @Override
    protected void populateTradeData() {
        this.offers = shopType.getOffers();
    }

    @Override
    public AgeableEntity createChild(AgeableEntity ageable) {
        return null;
    }

    public ShopType getShopType() {
        return shopType;
    }
}
