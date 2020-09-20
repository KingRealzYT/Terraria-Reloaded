package com.kingrealzyt.terrariareloaded.items.weapons.ranged.yoyo;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.entities.yoyo.YoyoEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class AbstractYoyoItem extends Item implements IYoyo {

    public AbstractYoyoItem() {
        super(new Item.Properties().group(TerrariaReloaded.RANGED).maxStackSize(1).setNoRepair());
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (!worldIn.isRemote) {
            YoyoEntity yoyoEntity = YoyoEntity.CASTERS.get(playerIn.getUniqueID());
            if (yoyoEntity == null) {
                yoyoEntity = new YoyoEntity(worldIn, playerIn, handIn, this.getYoyoType());
                worldIn.addEntity(yoyoEntity);
                playerIn.addExhaustion(0.05F);
            } else {
                yoyoEntity.setRetracting(!yoyoEntity.isRetracting());
            }
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    public abstract float getDamage();

    public abstract float getKnockback();

    @Override
    public double getWeight(ItemStack yoyoStack) {
        return 1.0;
    }

    @Override
    public int getAttackInterval(ItemStack yoyoStack) {
        return 25;
    }

    @Override
    public void entityInteraction(ItemStack yoyoStack, PlayerEntity playerEntity, Hand hand, YoyoEntity yoyoEntity, Entity targetEntity) {
        if(targetEntity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) targetEntity;
            livingEntity.attackEntityFrom(DamageSource.GENERIC, this.getDamage());
            livingEntity.knockBack(livingEntity, getKnockback(), livingEntity.getPosX() - playerEntity.getPosX(), livingEntity.getPosZ() - playerEntity.getPosZ());
        }
    }

    //Override if you want to do something
    @Override
    public <T extends LivingEntity> void damageItem(ItemStack yoyoStack, Hand hand, int amount, T entity) {

    }

    //Override if you want to do something
    @Override
    public void blockInteraction(ItemStack yoyoStack, PlayerEntity playerEntity, World world, BlockPos pos, BlockState blockState, Block block, YoyoEntity yoyoEntity) {

    }

    //Override if you want to do something
    @Override
    public void onUpdate(ItemStack yoyoStack, YoyoEntity yoyoEntity) {

    }
}
