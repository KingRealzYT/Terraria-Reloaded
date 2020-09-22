package com.kingrealzyt.terrariareloaded.items.weapons.ranged.yoyo;

import com.kingrealzyt.terrariareloaded.entities.yoyo.YoyoEntity;
import com.kingrealzyt.terrariareloaded.entities.yoyo.YoyoType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public interface IYoyo {

    enum RenderOrientation {

        VERTICAL,
        HORIZONTAL

    }

    /**
     * @return the yoyo type
     */
    YoyoType getYoyoType();

    /**
     * @param yoyoStack the yoyo item
     * @return the weight from the yoyo (Default = 1.0)
     */
    double getWeight(ItemStack yoyoStack);

    /**
     * @param yoyoStack the yoyo item
     * @return the length from the yoyo (Default = 1.0)
     */
    double getLength(ItemStack yoyoStack);

    /**
     * @param yoyoStack the yoyo item
     * @return the length in ticks after the yo-yo comes back
     */
    int getDuration(ItemStack yoyoStack);

    /**
     * @param yoyoStack the yoyo item
     * @return the interval when the yoyo can be thrown again in ticks
     */
    int getAttackInterval(ItemStack yoyoStack);

    /**
     * Call this if you want to damage the item
     *
     * @param yoyoStack the yoyo item
     * @param hand the holding hand
     * @param amount amount of damage
     * @param entity the target hitting entity
     * @param <T> a {@link LivingEntity}
     */
    <T extends LivingEntity> void damageItem(ItemStack yoyoStack, Hand hand, int amount, T entity);

    /**
     * This is been called when the yoyo hit a entity
     *
     * @param yoyoStack the yoyo item
     * @param playerEntity the thrower
     * @param hand the holding hand
     * @param yoyoEntity the yoyo entity self
     * @param targetEntity the target entity, who get hit
     */
    void entityInteraction(ItemStack yoyoStack, PlayerEntity playerEntity, Hand hand, YoyoEntity yoyoEntity, Entity targetEntity);

    /**
     * This is been called when the yoyo hit a block
     *
     * @param yoyoStack the yoyo item
     * @param playerEntity the thrower
     * @param world the world
     * @param pos the pos from the block
     * @param blockState the block state
     * @param block the block self
     * @param yoyoEntity the yoyo entity self
     */
    void blockInteraction(ItemStack yoyoStack, PlayerEntity playerEntity, World world, BlockPos pos, BlockState blockState, Block block, YoyoEntity yoyoEntity);

    /**
     * This is been called in the {@link Entity#tick()} method
     *
     * @param yoyoStack the yoyo item
     * @param yoyoEntity the yoyo entity
     */
    void onUpdate(ItemStack yoyoStack, YoyoEntity yoyoEntity);

    /**
     * If the yoyo is in water you can set a modifier
     *
     * @param yoyoStack the yoyo item
     * @return the modifier (Default = 0.3F)
     */
    default float getWaterMovementModifier(ItemStack yoyoStack) {
        return 0.3F;
    }

    /**
     * @param yoyoStack the yoyo item
     * @return VERTICAL for vertical render orientation or HORIZONTAL for horizontal render orientation from the yoyo item
     */
    @OnlyIn(Dist.CLIENT)
    default RenderOrientation getRenderOrientation(ItemStack yoyoStack) {
        return RenderOrientation.VERTICAL;
    }
}
