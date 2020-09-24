package com.kingrealzyt.terrariareloaded.entities.npc;

import com.kingrealzyt.terrariareloaded.init.ModItems;
import net.minecraft.item.*;

import java.util.Arrays;

/**
 * This class is a storage for all {@link MerchantOffers} objects for the shop npcs
 */
public class ShopOffersList {

    public static final MerchantOffers MERCHANT = create(
            gold(2, ModItems.PIGGY_BANK_ITEM.get(), 1),
            silver(5, ModItems.SILVER_INGOT.get(), 4)
    );

    public static final MerchantOffers GUIDE = create(
            copper(100, Items.ARROW, 1),
            silver(1, Items.TORCH, 16)
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
            copper(20, Items.GUNPOWDER, 2),
            copper(80, Items.FLINT_AND_STEEL, 1),
            silver(4, ModItems.GRENADE_ITEM.get(), 8),
            silver(1, ModItems.BOMB_ITEM.get(), 1),
            silver(2, Items.TNT, 1),
            silver(4, ModItems.DYNAMITE_ITEM.get(), 1)
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
