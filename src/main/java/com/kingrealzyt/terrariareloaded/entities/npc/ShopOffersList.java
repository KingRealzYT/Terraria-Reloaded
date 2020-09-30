package com.kingrealzyt.terrariareloaded.entities.npc;

import com.kingrealzyt.terrariareloaded.init.ModItems;
import net.minecraft.item.*;

import java.util.Arrays;

/**
 * This class is a storage for all {@link MerchantOffers} objects for the shop npcs
 */
public class ShopOffersList {

    public static final MerchantOffers MERCHANT = create(
            silver(1, Items.ARROW, 20),
            silver(2, Items.TORCH, 4),
            silver(3, ModItems.MARSHMALLOW.get(), 1),
            silver(3, Items.FURNACE, 1),
            silver(4, ModItems.COPPER_AXE.get(), 1),
            silver(5, ModItems.COPPER_PICKAXE.get(), 1),
            silver(20, ModItems.SILVER_INGOT.get(), 4),
            silver(50, Items.ANVIL, 1),
            gold(2, ModItems.PIGGY_BANK_ITEM.get(), 1)

    );

    public static final MerchantOffers GUIDE = create(
            silver(1, Items.ARROW, 20),
            silver(1, Items.TORCH, 2)
    );

    public static final MerchantOffers DYE_TRADER = create(
            silver(1, Items.BLACK_DYE, 2),
            silver(1, Items.WHITE_DYE, 2),
            silver(1, Items.RED_DYE, 2),
            silver(1, Items.ORANGE_DYE, 1),
            silver(1, Items.YELLOW_DYE, 2),
            silver(1, Items.GREEN_DYE, 2),
            silver(1, Items.BLUE_DYE, 1),
            silver(1, Items.PURPLE_DYE, 1),
            silver(1, Items.PINK_DYE, 2),
            silver(1, Items.BROWN_DYE, 2)
    );

    public static final MerchantOffers DEMOLITIONIST = create(
            copper(60, Items.FLINT_AND_STEEL, 1),
            silver(1, Items.GUNPOWDER, 1),
            silver(3, ModItems.BOMB_ITEM.get(), 1),
            silver(6, ModItems.GRENADE_ITEM.get(), 10),
            silver(6, Items.TNT, 1),
            silver(20, ModItems.DYNAMITE_ITEM.get(), 1)
    );

    public static final MerchantOffers DRYAD = create(
            copper(40, Items.GRASS_BLOCK, 2),
            silver(2, Items.MELON_SEEDS, 1),
            silver(2, Items.PUMPKIN_SEEDS, 1),
            silver(2, Items.MYCELIUM, 2),
            silver(1, Items.FLOWER_POT, 3),
            silver(20, Items.SUNFLOWER, 3),
            silver(1, ModItems.CORRUPT_GRASS_BLOCK_ITEM.get(), 1),
            silver(1, ModItems.CRIMSON_GRASS_BLOCK_ITEM.get(), 1)

    );
    //ADDFORNPC

    public static final MerchantOffers ARMS_DEALER = create(
            silver(1, Items.GUNPOWDER, 1),
            silver(4, Items.SPECTRAL_ARROW, 1)

    );

    public static final MerchantOffers TINKERER = create(
            silver(50, Items.ANVIL, 1),
            silver(10, ModItems.RULER.get(), 1),
            silver(16, Items.IRON_INGOT, 4)
    );

    /**
     * Use this method to create merchant offers
     *
     * @param offer the offers
     * @return the MerchantOffers list
     */
    private static MerchantOffers create(MerchantOffer... offer) {
        MerchantOffers offers = new MerchantOffers();
        offers.addAll(Arrays.asList(offer));
        return offers;
    }

    /**
     * This method represent a copper trade
     *
     * @param amount the amount of copper that you need
     * @param output the output item
     * @param outputAmount the amount of the output item
     * @return the final merchant offer
     */
    private static MerchantOffer copper(int amount, Item output, int outputAmount) {
        return new MerchantOffer(new ItemStack(ModItems.COPPER_COIN.get(), amount), new ItemStack(output, outputAmount), 100000, 3, 0);
    }

    /**
     * Same method as above, only with the output amount 1
     */
    private static MerchantOffer copper(int amount, Item output) {
        return copper(amount, output, 1);
    }

    /**
     * This method represent a silver trade
     *
     * @param amount the amount of silver that you need
     * @param output the output item
     * @param outputAmount the amount of the output item
     * @return the final merchant offer
     */
    private static MerchantOffer silver(int amount, Item output, int outputAmount) {
        return new MerchantOffer(new ItemStack(ModItems.SILVER_COIN.get(), amount), new ItemStack(output, outputAmount), 100000, 3, 0);
    }

    /**
     * Same method as above, only with the output amount 1
     */
    private static MerchantOffer silver(int amount, Item output) {
        return silver(amount, output, 1);
    }

    /**
     * This method represent a gold trade
     *
     * @param amount the amount of gold that you need
     * @param output the output item
     * @param outputAmount the amount of the output item
     * @return the final merchant offer
     */
    private static MerchantOffer gold(int amount, Item output, int outputAmount) {
        return new MerchantOffer(new ItemStack(ModItems.GOLD_COIN.get(), amount), new ItemStack(output, outputAmount), 100000, 3, 0);
    }

    /**
     * Same method as above, only with the output amount 1
     */
    private static MerchantOffer gold(int amount, Item output) {
        return gold(amount, output, 1);
    }

    /**
     * This method represent a platinum trade
     *
     * @param amount the amount of platinum that you need
     * @param output the output item
     * @param outputAmount the amount of the output item
     * @return the final merchant offer
     */
    private static MerchantOffer platinum(int amount, Item output, int outputAmount) {
        return new MerchantOffer(new ItemStack(ModItems.PLATINUM_COIN.get(), amount), new ItemStack(output, outputAmount), 100000, 3, 0);
    }

    /**
     * Same method as above, only with the output amount 1
     */
    private static MerchantOffer platinum(int amount, Item output) {
        return platinum(amount, output, 1);
    }

}
