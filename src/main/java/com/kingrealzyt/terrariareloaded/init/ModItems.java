package com.kingrealzyt.terrariareloaded.init;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.blocks.BlockItemBase;
import com.kingrealzyt.terrariareloaded.entities.yoyo.YoyoType;
import com.kingrealzyt.terrariareloaded.items.*;
import com.kingrealzyt.terrariareloaded.items.misc.*;
import com.kingrealzyt.terrariareloaded.items.tools.others.PickaxeAxeItem;
import com.kingrealzyt.terrariareloaded.items.weapons.ranged.repeaters.*;
import com.kingrealzyt.terrariareloaded.items.weapons.melee.yoyo.YoyoItem;
import com.kingrealzyt.terrariareloaded.items.weapons.throwing.BombItem;
import com.kingrealzyt.terrariareloaded.items.weapons.throwing.DynamiteItem;
import com.kingrealzyt.terrariareloaded.items.weapons.throwing.GrenadeItem;
import com.kingrealzyt.terrariareloaded.items.weapons.throwing.ThrowingKnifeItem;
import com.kingrealzyt.terrariareloaded.util.enums.ModItemTier;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings("typo")
public class ModItems {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, TerrariaReloaded.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Items

    public static final RegistryObject<Item> MAGIC_MIRROR = ITEMS.register("magic_mirror", MagicMirror::new);
    public static final RegistryObject<Item> ICE_MIRROR = ITEMS.register("ice_mirror", MagicMirror::new);
    public static final RegistryObject<Item> GUIDE_VOODOO = ITEMS.register("guide_voodoo_doll", GuideVoodoo::new);
    public static final RegistryObject<Item> SUSPICIOUS_EYE = ITEMS.register("suspicious_looking_eye", SuspiciousEye::new);
    public static final RegistryObject<Item> BLOODY_SPINE = ITEMS.register("bloody_spine", BloodySpine::new);
    public static final RegistryObject<Item> ABEEMINATION = ITEMS.register("abeemination", Abeemination::new);
    public static final RegistryObject<Item> WORM_FOOD = ITEMS.register("worm_food", WormFood::new);
    public static final RegistryObject<Item> SLIME_CROWN = ITEMS.register("slime_crown", SlimeCrown::new);

    public static final RegistryObject<Item> BAND_REGENERATION = ITEMS.register("band_of_regeneration", ItemBand::new);
    //Crafting items hehe
    public static final RegistryObject<Item> LENS = ITEMS.register("lens", MiscItemBase::new);
    public static final RegistryObject<Item> STINGER = ITEMS.register("stinger", MiscItemBase::new);
    public static final RegistryObject<Item> CHAIN = ITEMS.register("chain", MiscItemBase::new);
    public static final RegistryObject<Item> JUNGLE_SPORES = ITEMS.register("jungle_spores", MiscItemBase::new);
    public static final RegistryObject<Item> BLACK_LENS = ITEMS.register("black_lens", MiscItemBase::new);
    public static final RegistryObject<Item> CRIMTANE_INGOT  = ITEMS.register("crimtane_ingot", MiscItemBase::new);
    public static final RegistryObject<Item> DEMONITE_INGOT = ITEMS.register("demonite_ingot", MiscItemBase::new);
    public static final RegistryObject<Item> COBALT_INGOT  = ITEMS.register("cobalt_ingot", MiscItemBase::new);
    public static final RegistryObject<Item> PALLADIUM_INGOT = ITEMS.register("palladium_ingot", MiscItemBase::new);
    public static final RegistryObject<Item> MYTHRIL_INGOT  = ITEMS.register("mythril_ingot", MiscItemBase::new);
    public static final RegistryObject<Item> ORICHALCUM_INGOT = ITEMS.register("orichalcum_ingot", MiscItemBase::new);
    public static final RegistryObject<Item> TITANIUM_INGOT  = ITEMS.register("titanium_ingot", MiscItemBase::new);
    public static final RegistryObject<Item> ADAMANTITE_INGOT = ITEMS.register("adamantite_ingot", MiscItemBase::new);
    public static final RegistryObject<Item> HELLSTONE_INGOT = ITEMS.register("hellstone_ingot", MiscItemBase::new);
    public static final RegistryObject<Item> CHLOROPHYTE_INGOT = ITEMS.register("chlorophyte_ingot", MiscItemBase::new);
    public static final RegistryObject<Item> SPECTRE_INGOT = ITEMS.register("spectre_ingot", MiscItemBase::new);
    public static final RegistryObject<Item> METEORITE_INGOT = ITEMS.register("meteorite_ingot", MiscItemBase::new);
    public static final RegistryObject<Item> SILVER_INGOT  = ITEMS.register("silver_ingot", MiscItemBase::new);
    public static final RegistryObject<Item> COPPER_INGOT = ITEMS.register("copper_ingot", MiscItemBase::new);

    public static final RegistryObject<Item> COPPER_COIN = ITEMS.register("copper_coin", MiscItemBase::new);
    public static final RegistryObject<Item> SILVER_COIN = ITEMS.register("silver_coin", MiscItemBase::new);
    public static final RegistryObject<Item> GOLD_COIN = ITEMS.register("gold_coin", MiscItemBase::new);
    public static final RegistryObject<Item> PLATINUM_COIN  = ITEMS.register("platinum_coin", MiscItemBase::new);

    // Tools
    public static final RegistryObject<SwordItem> COPPER_SHORTSWORD = ITEMS.register("copper_shortsword", () -> new SwordItem(ModItemTier.COPPER_SHORT, 1, 0.0F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<SwordItem> COPPER_BROADSWORD = ITEMS.register("copper_broadsword", () -> new SwordItem(ModItemTier.COPPER_BROAD, 2, -2.4F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<AxeItem> COPPER_AXE = ITEMS.register("copper_axe", () -> new AxeItem(ModItemTier.COPPER_SHORT, 0, 0.0F, new Item.Properties().group(TerrariaReloaded.TOOL).setNoRepair()));
    public static final RegistryObject<PickaxeItem> COPPER_PICKAXE = ITEMS.register("copper_pickaxe", () -> new PickaxeItem(ModItemTier.COPPER_SHORT, 0, 0.0F, new Item.Properties().group(TerrariaReloaded.TOOL).setNoRepair()));
    public static final RegistryObject<HallowedRepeaterItem> HALLOWED_REPEATER_ITEM = ITEMS.register("hallowed_repeater", () -> new HallowedRepeaterItem(new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<AdamantiteRepeaterItem> ADAMANTITE_REPEATER_ITEM = ITEMS.register("adamantite_repeater", () -> new AdamantiteRepeaterItem(new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<CobaltRepeaterItem> COBALT_REPEATER_ITEM = ITEMS.register("cobalt_repeater", () -> new CobaltRepeaterItem(new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<OrichalcumRepeaterItem> ORICHALCUM_REPEATER_ITEM = ITEMS.register("orichalcum_repeater", () -> new OrichalcumRepeaterItem(new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<MythrilRepeaterItem> MYTHRIL_REPEATER_ITEM = ITEMS.register("mythril_repeater", () -> new MythrilRepeaterItem(new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<PalladiumRepeaterItem> PALLADIUM_REPEATER_ITEM = ITEMS.register("palladium_repeater", () -> new PalladiumRepeaterItem(new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<TitaniumRepeaterItem> TITANIUM_REPEATER_ITEM = ITEMS.register("titanium_repeater", () -> new TitaniumRepeaterItem(new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<ChlorophyteRepeaterItem> CHLOROPHYTE_SHOTBOW_ITEM = ITEMS.register("chlorophyte_shotbow", () -> new ChlorophyteRepeaterItem(new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));

    public static final RegistryObject<PickaxeAxeItem> PICKSAW = ITEMS.register("picksaw", () -> new PickaxeAxeItem(ItemTier.DIAMOND, 0, 0.0F, new Item.Properties().group(TerrariaReloaded.TOOL).setNoRepair()));
    public static final RegistryObject<PickaxeAxeItem> PICKAXE_AXE = ITEMS.register("pickaxe_axe", () -> new PickaxeAxeItem(ItemTier.DIAMOND, 0, 0.0F, new Item.Properties().group(TerrariaReloaded.TOOL).setNoRepair()));


    // Block Items  
    public static final RegistryObject<Item> METEORITE_ORE_ITEM = ITEMS.register("meteorite_ore", () -> new BlockItemBase(ModBlocks.METEORITE_ORE.get()));
    public static final RegistryObject<Item> CRIMTANE_ORE_ITEM = ITEMS.register("crimtane_ore", () -> new BlockItemBase(ModBlocks.CRIMTANE_ORE.get()));
    public static final RegistryObject<Item> DEMONITE_ORE_ITEM = ITEMS.register("demonite_ore", () -> new BlockItemBase(ModBlocks.DEMONITE_ORE.get()));
    public static final RegistryObject<Item> HELLSTONE_ORE_ITEM = ITEMS.register("hellstone_ore", () -> new BlockItemBase(ModBlocks.HELLSTONE_ORE.get()));
    public static final RegistryObject<Item> COBALT_ORE_ITEM = ITEMS.register("cobalt_ore", () -> new BlockItemBase(ModBlocks.COBALT_ORE.get()));
    public static final RegistryObject<Item> PALLADIUM_ORE_ITEM = ITEMS.register("palladium_ore", () -> new BlockItemBase(ModBlocks.PALLADIUM_ORE.get()));
    public static final RegistryObject<Item> MYTHRIL_ORE_ITEM = ITEMS.register("mythril_ore", () -> new BlockItemBase(ModBlocks.MYTHRIL_ORE.get()));
    public static final RegistryObject<Item> ORICHALCUM_ORE_ITEM = ITEMS.register("orichalcum_ore", () -> new BlockItemBase(ModBlocks.ORICHALCUM_ORE.get()));
    public static final RegistryObject<Item> ADAMANTITE_ORE_ITEM = ITEMS.register("adamantite_ore", () -> new BlockItemBase(ModBlocks.ADAMANTITE_ORE.get()));
    public static final RegistryObject<Item> TITANIUM_ORE_ITEM = ITEMS.register("titanium_ore", () -> new BlockItemBase(ModBlocks.TITANIUM_ORE.get()));
    public static final RegistryObject<Item> CHLOROPHYTE_ORE_ITEM = ITEMS.register("chlorophyte_ore", () -> new BlockItemBase(ModBlocks.CHLOROPHYTE_ORE.get()));
    public static final RegistryObject<Item> SILVER_ORE_ITEM = ITEMS.register("silver_ore", () -> new BlockItemBase(ModBlocks.SILVER_ORE.get()));
    public static final RegistryObject<Item> COPPER_ORE_ITEM = ITEMS.register("copper_ore", () -> new BlockItemBase(ModBlocks.COPPER_ORE.get()));
    public static final RegistryObject<Item> HIVE_BLOCK_ITEM = ITEMS.register("hive_block", () -> new BlockItemBase(ModBlocks.HIVE_BLOCK.get()));
    public static final RegistryObject<Item> PIGGY_BANK_ITEM = ITEMS.register("piggy_bank", () -> new BlockItemBase(ModBlocks.PIGGY_BANK.get()));

    // Throwing weapons
    public static final RegistryObject<Item> THROWING_KNIFE_ITEM = ITEMS.register("throwing_knife_item", () -> new ThrowingKnifeItem(new Item.Properties().group(TerrariaReloaded.THROW)));
    public static final RegistryObject<Item> DYNAMITE_ITEM = ITEMS.register("dynamite_item", () -> new DynamiteItem(new Item.Properties().group(TerrariaReloaded.THROW)));
    public static final RegistryObject<Item> BOMB_ITEM = ITEMS.register("bomb_item", () -> new BombItem(new Item.Properties().group(TerrariaReloaded.THROW)));
    public static final RegistryObject<Item> GRENADE_ITEM = ITEMS.register("grenade_item", () -> new GrenadeItem(new Item.Properties().group(TerrariaReloaded.THROW)));

    //Yoyos

    public static final RegistryObject<Item> AMAROK_YOYO = registerYoyo("amarok", YoyoType.AMAROK);
    public static final RegistryObject<Item> AMAZON_YOYO = registerYoyo("amazon", YoyoType.AMAZON);
    public static final RegistryObject<Item> ARTERY_YOYO = registerYoyo("artery", YoyoType.ARTERY);
    public static final RegistryObject<Item> CASCADE_YOYO = registerYoyo("cascade", YoyoType.CASCADE);
    public static final RegistryObject<Item> CHICK_YOYO = registerYoyo("chick", YoyoType.CHICK);
    public static final RegistryObject<Item> CODE_1_YOYO = registerYoyo("code_1", YoyoType.CODE_1);
    public static final RegistryObject<Item> CODE_2_YOYO = registerYoyo("code_2", YoyoType.CODE_2);
    public static final RegistryObject<Item> FORMAT_C_YOYO = registerYoyo("format_c", YoyoType.FORMAT_C);
    public static final RegistryObject<Item> GRADIENT_YOYO = registerYoyo("gradient", YoyoType.GRADIENT);
    public static final RegistryObject<Item> HEL_FIRE_YOYO = registerYoyo("hel_fire", YoyoType.HEL_FIRE);
    public static final RegistryObject<Item> KRAKEN_YOYO = registerYoyo("kraken", YoyoType.KRAKEN);
    public static final RegistryObject<Item> MALAISE_YOYO = registerYoyo("malaise", YoyoType.MALAISE);
    public static final RegistryObject<Item> RALLY_YOYO = registerYoyo("rally", YoyoType.RALLY);
    public static final RegistryObject<Item> REDS_THROW_YOYO = registerYoyo("reds_throw", YoyoType.REDS_THROW);
    public static final RegistryObject<Item> TERRARIAN_YOYO = registerYoyo("terrarian", YoyoType.TERRARIAN);
    public static final RegistryObject<Item> THE_EYE_OF_CTHULHU_YOYO = registerYoyo("the_eye_of_cthulhu", YoyoType.THE_EYE_OF_CTHULHU);
    public static final RegistryObject<Item> VALKYRIE_YOYO = registerYoyo("valkyrie", YoyoType.VALKYRIE_YOYO);
    public static final RegistryObject<Item> VALOR_YOYO = registerYoyo("valor", YoyoType.VALOR);
    public static final RegistryObject<Item> WOODEN_YOYO = registerYoyo("wooden", YoyoType.WOODEN);
    public static final RegistryObject<Item> YELETS_YOYO = registerYoyo("yelets", YoyoType.YELETS);
    public static final RegistryObject<Item> TERRARIAN_YOYO_PROJECTILE = ITEMS.register("terrarian_yoyo_projectile", () -> new Item(new Item.Properties()));

    //Foods
    public static final RegistryObject<Item> GOLDFISH_SOUP = ITEMS.register("goldfish_soup", () -> new FoodItemBase(5, 1.0f));
    public static final RegistryObject<Item> BUNNY_STEW = ITEMS.register("bunny_stew", () -> new FoodItemBase(5, 1.0f));
    public static final RegistryObject<Item> FRUIT_JUICE = ITEMS.register("fruit_juice", () -> new FoodItemBase(3, 1.0f));
    public static final RegistryObject<Item> PRISMATIC_PUNCH = ITEMS.register("prismatic_punch", () -> new FoodItemBase(6, 1.2f));
    public static final RegistryObject<Item> SEAFOOD_DINNER = ITEMS.register("seafood_dinner", () -> new FoodItemBase(8, 3.0f));
    public static final RegistryObject<Item> SMOOTHIE_OF_DARKNESS = ITEMS.register("smoothie_of_darkness", () -> new FoodItemBase(5, 1.0f));
    public static final RegistryObject<Item> SASHIMI = ITEMS.register("sashimi", () -> new FoodItemBase(5, 1.0f));
    public static final RegistryObject<Item> ALE = ITEMS.register("ale", () -> new FoodItemBase(5, 1.0f));
    public static final RegistryObject<Item> APPLE_PIE = ITEMS.register("apple_pie", () -> new FoodItemBase(5, 1.0f));
    public static final RegistryObject<Item> BBQ_RIBS = ITEMS.register("bbq_ribs", () -> new FoodItemBase(5, 1.0f));
    public static final RegistryObject<Item> BURGER = ITEMS.register("burger", () -> new FoodItemBase(8, 1.0f));
    public static final RegistryObject<Item> CHICKEN_NUGGET = ITEMS.register("chicken_nugget", () -> new FoodItemBase(5, 1.0f));
    public static final RegistryObject<Item> CREAM_SODA = ITEMS.register("cream_soda", () -> new FoodItemBase(5, 1.0f));
    public static final RegistryObject<Item> FRIED_EGG = ITEMS.register("fried_egg", () -> new FoodItemBase(5, 1.0f));
    public static final RegistryObject<Item> PAD_THAI = ITEMS.register("pad_thai", () -> new FoodItemBase(5, 1.0f));
    public static final RegistryObject<Item> PIZZA = ITEMS.register("pizza", () -> new FoodItemBase(5, 1.0f));
    public static final RegistryObject<Item> MARSHMALLOW = ITEMS.register("marshmallow", () -> new FoodItemBase(5, 1.0f));
    public static final RegistryObject<Item> COOKED_MARSHMALLOW = ITEMS.register("cooked_marshmallow", () -> new FoodItemBase(5, 1.0f));
    public static final RegistryObject<Item> SAKE = ITEMS.register("sake", () -> new FoodItemBase(5, 1.0f));



    private static RegistryObject<Item> registerYoyo(String name, YoyoType type) {
        return ITEMS.register(name + "_yoyo", () -> new YoyoItem(type));
    }

}
