package com.kingrealzyt.terrariareloaded.items.weapons.melee.yoyo;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.entities.projectiles.TerrarianYoyoProjectile;
import com.kingrealzyt.terrariareloaded.entities.yoyo.YoyoEntity;
import com.kingrealzyt.terrariareloaded.entities.yoyo.YoyoType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class YoyoItem extends Item implements IYoyo {

    private final YoyoType type;

    public YoyoItem(YoyoType type) {
        super(new Item.Properties().group(TerrariaReloaded.WEAPONS).maxStackSize(1).setNoRepair());
        this.type = type;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (!worldIn.isRemote) {
            YoyoEntity yoyoEntity = YoyoEntity.CASTERS.get(playerIn.getUniqueID());
            if (yoyoEntity == null) {
                yoyoEntity = new YoyoEntity(worldIn, playerIn, handIn, this.getYoyoType());
                worldIn.addEntity(yoyoEntity);
            } else {
                yoyoEntity.setRetracting(!yoyoEntity.isRetracting());
            }
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    public ItemStack getDefaultInstance() {
        ItemStack instance = super.getDefaultInstance();
        CompoundNBT tag = new CompoundNBT();
        tag.putInt("YoyoTypeID", type.ordinal());
        instance.setTag(tag);
        return instance;
    }

    @Override
    public int getDuration(ItemStack yoyoStack) {
        YoyoType type = getYoyoTypeByStack(yoyoStack);
        if (type == null)
            return -1;
        return type.getDuration();
    }

    @Override
    public YoyoType getYoyoType() {
        return this.type;
    }

    @Override
    public double getLength(ItemStack yoyoStack) {
        YoyoType type = getYoyoTypeByStack(yoyoStack);
        if (type == null)
            return -1;
        return type.getLength();
    }

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
        YoyoType type = getYoyoTypeByStack(yoyoStack);
        if (type == null)
            return;
        if (targetEntity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) targetEntity;
            if (livingEntity.getUniqueID().equals(playerEntity.getUniqueID()))
                return;
            livingEntity.attackEntityFrom(TerrariaReloaded.YOYO, type.getDamage());
            livingEntity.knockBack(livingEntity, type.getKnockback(), playerEntity.getPosX() - livingEntity.getPosX(), playerEntity.getPosZ() - livingEntity.getPosZ());
            if (type == YoyoType.TERRARIAN) {
                spawnTerrarianProjectile(livingEntity);
            }
        }
    }

    public static void spawnTerrarianProjectile(LivingEntity hurtEntity) {
        World world = hurtEntity.world;
        TerrarianYoyoProjectile projectile = new TerrarianYoyoProjectile(world, hurtEntity);
        Vec3d motion = getRandomMotion(world.rand);
        projectile.shoot(motion.x, motion.y, motion.z, 0.3F, 0.1F);
        world.addEntity(projectile);
    }

    private static Vec3d getRandomMotion(Random random) {
        double x = random.nextDouble();
        double y = random.nextDouble();
        double z = random.nextDouble();
        return new Vec3d(random.nextBoolean() ? x : -x, y, random.nextBoolean() ? z : -z);
    }

    private Vec3d reverse(Vec3d vec3d) {
        return new Vec3d(-vec3d.x, -vec3d.y, -vec3d.z);
    }

    @Override
    public <T extends LivingEntity> void damageItem(ItemStack yoyoStack, Hand hand, int amount, T entity) {

    }

    @Override
    public void blockInteraction(ItemStack yoyoStack, PlayerEntity playerEntity, World world, BlockPos pos, BlockState blockState, Block block, YoyoEntity yoyoEntity) {

    }

    @Override
    public void onUpdate(ItemStack yoyoStack, YoyoEntity yoyoEntity) {

    }

    //Can be null of the stack has no tag, or the tag does not contain the "YoyoTypeID" tag
    //If the stack is a yoyo item but has no tag, it will add the tag.
    @Nullable
    public static YoyoType getYoyoTypeByStack(ItemStack stack) {
        CompoundNBT tag = stack.getTag();
        if (tag == null && stack.getItem() instanceof IYoyo) {
            tag = new CompoundNBT();
            String name = stack.getItem().getRegistryName().getPath();
            YoyoType type = YoyoType.getByName(name);
            tag.putInt("YoyoTypeID", type.ordinal());
            stack.setTag(tag);
            return type;
        }
        if (tag == null || !tag.contains("YoyoTypeID"))
            return null;
        return YoyoType.VALUES[tag.getInt("YoyoTypeID")];
    }

}
