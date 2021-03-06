package com.kingrealzyt.terrariareloaded.init;

import com.google.common.collect.Lists;
import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.blocks.BlockItemBase;
import com.kingrealzyt.terrariareloaded.entities.yoyo.YoyoType;
import com.kingrealzyt.terrariareloaded.items.FoodItemBase;
import com.kingrealzyt.terrariareloaded.items.LifeCrystalItem;
import com.kingrealzyt.terrariareloaded.items.LifeFruitItem;
import com.kingrealzyt.terrariareloaded.items.MiscItemBase;
import com.kingrealzyt.terrariareloaded.items.misc.*;
import com.kingrealzyt.terrariareloaded.items.tools.others.PickaxeAxeItem;
import com.kingrealzyt.terrariareloaded.items.weapons.melee.projectileSwords.EnchantedSwordItem;
import com.kingrealzyt.terrariareloaded.items.weapons.melee.projectileSwords.IceBladeItem;
import com.kingrealzyt.terrariareloaded.items.weapons.melee.yoyo.YoyoItem;
import com.kingrealzyt.terrariareloaded.items.weapons.ranged.bows.ModBowItem;
import com.kingrealzyt.terrariareloaded.items.weapons.ranged.repeaters.*;
import com.kingrealzyt.terrariareloaded.items.weapons.throwing.*;
import com.kingrealzyt.terrariareloaded.util.enums.ModItemTier;
import net.minecraft.item.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

@SuppressWarnings("all")
public class ModItems {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, TerrariaReloaded.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Items
    public static final RegistryObject<BucketItem> HONEY_BUCKET = ITEMS.register("honey_bucket",
            () -> new BucketItem(() -> ModFluids.HONEY_FLUID.get(),
                    new Item.Properties().group(TerrariaReloaded.MISC).maxStackSize(1)));

    public static final RegistryObject<Item> MAGIC_MIRROR = ITEMS.register("magic_mirror", MagicMirror::new);
    public static final RegistryObject<Item> ICE_MIRROR = ITEMS.register("ice_mirror", MagicMirror::new);
    public static final RegistryObject<Item> GUIDE_VOODOO = ITEMS.register("guide_voodoo_doll", GuideVoodoo::new);
    public static final RegistryObject<Item> SUSPICIOUS_EYE = ITEMS.register("suspicious_looking_eye", SuspiciousEye::new);
    public static final RegistryObject<Item> BLOODY_SPINE = ITEMS.register("bloody_spine", BloodySpine::new);
    public static final RegistryObject<Item> ABEEMINATION = ITEMS.register("abeemination", Abeemination::new);
    public static final RegistryObject<Item> WORM_FOOD = ITEMS.register("worm_food", WormFood::new);
    public static final RegistryObject<Item> SLIME_CROWN = ITEMS.register("slime_crown", SlimeCrown::new);
    public static final RegistryObject<Item> LIFE_FRUIT = ITEMS.register("life_fruit", LifeFruitItem::new);

    public static final RegistryObject<Item> BAND_REGENERATION = ITEMS.register("band_of_regeneration", ItemBand::new);

    public static final RegistryObject<Item> BLINKROOT = ITEMS.register("blinkroot", MiscItemBase::new);
    public static final RegistryObject<Item> WATERLEAF = ITEMS.register("waterleaf", MiscItemBase::new);
    public static final RegistryObject<Item> SHIVERTHORN = ITEMS.register("shiverthorn", MiscItemBase::new);
    public static final RegistryObject<Item> MOONGLOW = ITEMS.register("moonglow", MiscItemBase::new);
    public static final RegistryObject<Item> DAYBLOOM = ITEMS.register("daybloom", MiscItemBase::new);
    public static final RegistryObject<Item> FIREBLOSSOM = ITEMS.register("fireblossom", MiscItemBase::new);
    public static final RegistryObject<Item> DEATHWEED = ITEMS.register("deathweed", MiscItemBase::new);

    public static final RegistryObject<Item> DEATHWEED_SEEDS = ITEMS.register("deathweed_seeds", () -> new BlockItem(ModBlocks.DEATHWEED_CROP, new Item.Properties().group(TerrariaReloaded.MISC)));
    public static final RegistryObject<Item> SHIVERTHORN_SEEDS = ITEMS.register("shiverthorn_seeds", () -> new BlockItem(ModBlocks.SHIVERTHORN_CROP, new Item.Properties().group(TerrariaReloaded.MISC)));
    public static final RegistryObject<Item> FIREBLOSSOM_SEEDS = ITEMS.register("fireblossom_seeds", () -> new BlockItem(ModBlocks.FIREBLOSSOM_CROP, new Item.Properties().group(TerrariaReloaded.MISC)));
    public static final RegistryObject<Item> MOONGLOW_SEEDS = ITEMS.register("moonglow_seeds", () -> new BlockItem(ModBlocks.MOONGLOW_CROP, new Item.Properties().group(TerrariaReloaded.MISC)));
    public static final RegistryObject<Item> WATERLEAF_SEEDS = ITEMS.register("waterleaf_seeds", () -> new BlockItem(ModBlocks.WATERLEAF_CROP, new Item.Properties().group(TerrariaReloaded.MISC)));
    public static final RegistryObject<Item> BLINKROOT_SEEDS = ITEMS.register("blinkroot_seeds", () -> new BlockItem(ModBlocks.BLINKROOT_CROP, new Item.Properties().group(TerrariaReloaded.MISC)));
    public static final RegistryObject<Item> DAYBLOOM_SEEDS = ITEMS.register("daybloom_seeds", () -> new BlockItem(ModBlocks.DAYBLOOM_CROP, new Item.Properties().group(TerrariaReloaded.MISC)));


    //Crafting Items
    public static final RegistryObject<Item> LENS = ITEMS.register("lens", MiscItemBase::new);
    public static final RegistryObject<Item> STINGER = ITEMS.register("stinger", MiscItemBase::new);
    public static final RegistryObject<Item> GOLDFISH = ITEMS.register("goldfish", MiscItemBase::new);
    public static final RegistryObject<Item> BUNNY = ITEMS.register("bunny", MiscItemBase::new);
    public static final RegistryObject<Item> CHAIN = ITEMS.register("chain", MiscItemBase::new);
    public static final RegistryObject<Item> JUNGLE_SPORES = ITEMS.register("jungle_spores", MiscItemBase::new);
    public static final RegistryObject<Item> BLACK_LENS = ITEMS.register("black_lens", MiscItemBase::new);
    public static final RegistryObject<Item> SILK = ITEMS.register("silk", MiscItemBase::new);
    public static final RegistryObject<Item> ECTOPLASM = ITEMS.register("ectoplasm", MiscItemBase::new);
    public static final RegistryObject<Item> SHADOW_SCALE = ITEMS.register("shadow_scale", MiscItemBase::new);
    public static final RegistryObject<Item> TISSUE_SAMPLE = ITEMS.register("tissue_sample", MiscItemBase::new);
    public static final RegistryObject<Item> HARPY_FEATHER = ITEMS.register("harpy_feather", MiscItemBase::new);
    public static final RegistryObject<Item> SHARK_FIN = ITEMS.register("shark_fin", MiscItemBase::new);
    public static final RegistryObject<Item> ANTLION_MANDIBLE = ITEMS.register("antlion_mandible", MiscItemBase::new);
    public static final RegistryObject<Item> CORAL_PIECE = ITEMS.register("coral_piece", MiscItemBase::new);
    public static final RegistryObject<Item> FALLEN_STAR = ITEMS.register("fallen_star", MiscItemBase::new);

    public static final RegistryObject<Item> CRIMTANE_INGOT = ITEMS.register("crimtane_ingot", MiscItemBase::new);
    public static final RegistryObject<Item> DEMONITE_INGOT = ITEMS.register("demonite_ingot", MiscItemBase::new);
    public static final RegistryObject<Item> COBALT_INGOT = ITEMS.register("cobalt_ingot", MiscItemBase::new);
    public static final RegistryObject<Item> PALLADIUM_INGOT = ITEMS.register("palladium_ingot", MiscItemBase::new);
    public static final RegistryObject<Item> MYTHRIL_INGOT = ITEMS.register("mythril_ingot", MiscItemBase::new);
    public static final RegistryObject<Item> ORICHALCUM_INGOT = ITEMS.register("orichalcum_ingot", MiscItemBase::new);
    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot", MiscItemBase::new);
    public static final RegistryObject<Item> ADAMANTITE_INGOT = ITEMS.register("adamantite_ingot", MiscItemBase::new);
    public static final RegistryObject<Item> HELLSTONE_INGOT = ITEMS.register("hellstone_ingot", MiscItemBase::new);
    public static final RegistryObject<Item> CHLOROPHYTE_INGOT = ITEMS.register("chlorophyte_ingot", MiscItemBase::new);
    public static final RegistryObject<Item> SPECTRE_INGOT = ITEMS.register("spectre_ingot", MiscItemBase::new);
    public static final RegistryObject<Item> METEORITE_INGOT = ITEMS.register("meteorite_ingot", MiscItemBase::new);
    public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot", MiscItemBase::new);
    public static final RegistryObject<Item> COPPER_INGOT = ITEMS.register("copper_ingot", MiscItemBase::new);
    public static final RegistryObject<Item> PLATINUM_INGOT = ITEMS.register("platinum_ingot", MiscItemBase::new);
    public static final RegistryObject<Item> HALLOWED_INGOT = ITEMS.register("hallowed_ingot", MiscItemBase::new);

    public static final RegistryObject<Item> AMETHYST = ITEMS.register("amethyst", MiscItemBase::new);
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", MiscItemBase::new);
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire", MiscItemBase::new);
    public static final RegistryObject<Item> AMBER = ITEMS.register("amber", MiscItemBase::new);
    public static final RegistryObject<Item> TOPAZ = ITEMS.register("topaz", MiscItemBase::new);
    public static final RegistryObject<Item> SHIMMERING_EMERALD = ITEMS.register("shimmering_emerald", MiscItemBase::new);
    public static final RegistryObject<Item> SHIMMERING_DIAMOND = ITEMS.register("shimmering_diamond", MiscItemBase::new);

    public static final RegistryObject<Item> LIFE_CRYSTAL = ITEMS.register("life_crystal", LifeCrystalItem::new);

    public static final RegistryObject<Item> COPPER_COIN = ITEMS.register("copper_coin", MiscItemBase::new);
    public static final RegistryObject<Item> SILVER_COIN = ITEMS.register("silver_coin", MiscItemBase::new);
    public static final RegistryObject<Item> GOLD_COIN = ITEMS.register("gold_coin", MiscItemBase::new);
    public static final RegistryObject<Item> PLATINUM_COIN = ITEMS.register("platinum_coin", MiscItemBase::new);

    // Tools
    public static final RegistryObject<SwordItem> COPPER_SHORTSWORD = ITEMS.register("copper_shortsword", () -> new SwordItem(ModItemTier.COPPER, 1, 0.0F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<SwordItem> COPPER_BROADSWORD = ITEMS.register("copper_broadsword", () -> new SwordItem(ModItemTier.SILVER, 2, -2.4F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<AxeItem> COPPER_AXE = ITEMS.register("copper_axe", () -> new AxeItem(ModItemTier.COPPER, 0, 0.0F, new Item.Properties().group(TerrariaReloaded.TOOL).setNoRepair()));
    public static final RegistryObject<PickaxeItem> COPPER_PICKAXE = ITEMS.register("copper_pickaxe", () -> new PickaxeItem(ModItemTier.COPPER, 0, 0.0F, new Item.Properties().group(TerrariaReloaded.TOOL).setNoRepair()));

    public static final RegistryObject<HallowedRepeaterItem> HALLOWED_REPEATER_ITEM = ITEMS.register("hallowed_repeater", () -> new HallowedRepeaterItem(new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<AdamantiteRepeaterItem> ADAMANTITE_REPEATER_ITEM = ITEMS.register("adamantite_repeater", () -> new AdamantiteRepeaterItem(new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<CobaltRepeaterItem> COBALT_REPEATER_ITEM = ITEMS.register("cobalt_repeater", () -> new CobaltRepeaterItem(new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<OrichalcumRepeaterItem> ORICHALCUM_REPEATER_ITEM = ITEMS.register("orichalcum_repeater", () -> new OrichalcumRepeaterItem(new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<MythrilRepeaterItem> MYTHRIL_REPEATER_ITEM = ITEMS.register("mythril_repeater", () -> new MythrilRepeaterItem(new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<PalladiumRepeaterItem> PALLADIUM_REPEATER_ITEM = ITEMS.register("palladium_repeater", () -> new PalladiumRepeaterItem(new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<TitaniumRepeaterItem> TITANIUM_REPEATER_ITEM = ITEMS.register("titanium_repeater", () -> new TitaniumRepeaterItem(new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<ChlorophyteRepeaterItem> CHLOROPHYTE_SHOTBOW_ITEM = ITEMS.register("chlorophyte_shotbow", () -> new ChlorophyteRepeaterItem(new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));

    public static final RegistryObject<PickaxeItem> SILVER_PICKAXE = ITEMS.register("silver_pickaxe", () -> new PickaxeItem(ModItemTier.SILVER, 0, 0.0F, new Item.Properties().group(TerrariaReloaded.TOOL).setNoRepair()));
    public static final RegistryObject<PickaxeItem> PLATINUM_PICKAXE = ITEMS.register("platinum_pickaxe", () -> new PickaxeItem(ModItemTier.PLATINUM, 0, 0.0F, new Item.Properties().group(TerrariaReloaded.TOOL).setNoRepair()));
    public static final RegistryObject<PickaxeItem> NIGHTMARE_PICKAXE = ITEMS.register("nightmare_pickaxe", () -> new PickaxeItem(ModItemTier.DEMONITE, 0, 0.0F, new Item.Properties().group(TerrariaReloaded.TOOL).setNoRepair()));
    public static final RegistryObject<PickaxeItem> DEATHBRINGER_PICKAXE = ITEMS.register("deathbringer_pickaxe", () -> new PickaxeItem(ModItemTier.CRIMTANE, 0, 0.0F, new Item.Properties().group(TerrariaReloaded.TOOL).setNoRepair()));
    public static final RegistryObject<PickaxeItem> MOLTEN_PICKAXE = ITEMS.register("molten_pickaxe", () -> new PickaxeItem(ModItemTier.HELLSTONE, 0, 0.0F, new Item.Properties().group(TerrariaReloaded.TOOL).setNoRepair()));
    public static final RegistryObject<PickaxeItem> REAVER_SHARK = ITEMS.register("reaver_shark", () -> new PickaxeItem(ModItemTier.DEMONITE, 0, 0.0F, new Item.Properties().group(TerrariaReloaded.TOOL).setNoRepair()));

    public static final RegistryObject<PickaxeAxeItem> PICKSAW = ITEMS.register("picksaw", () -> new PickaxeAxeItem(ModItemTier.PICKSAW, 0, 0.0F, new Item.Properties().group(TerrariaReloaded.TOOL).setNoRepair()));
    public static final RegistryObject<PickaxeAxeItem> PICKAXE_AXE = ITEMS.register("pickaxe_axe", () -> new PickaxeAxeItem(ModItemTier.HALLOWED, 0, 0.0F, new Item.Properties().group(TerrariaReloaded.TOOL).setNoRepair()));

    public static final RegistryObject<AxeItem> SILVER_AXE = ITEMS.register("silver_axe", () -> new AxeItem(ModItemTier.SILVER, 0, 0.0F, new Item.Properties().group(TerrariaReloaded.TOOL).setNoRepair()));
    public static final RegistryObject<AxeItem> PLATINUM_AXE = ITEMS.register("platinum_axe", () -> new AxeItem(ModItemTier.PLATINUM, 0, 0.0F, new Item.Properties().group(TerrariaReloaded.TOOL).setNoRepair()));

    //swords
    public static final RegistryObject<SwordItem> IRON_SHORTSWORD = ITEMS.register("iron_shortsword", () -> new SwordItem(ItemTier.IRON, 1, 0.0F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<SwordItem> CACTUS_SWORD = ITEMS.register("cactus_sword", () -> new SwordItem(ModItemTier.COPPER, 1, 0.0F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<SwordItem> SILVER_SHORTSWORD = ITEMS.register("silver_shortsword", () -> new SwordItem(ModItemTier.SILVER, 1, 0.0F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<SwordItem> EBONWOOD_SWORD = ITEMS.register("ebonwood_sword", () -> new SwordItem(ModItemTier.COPPER, 1, 0.0F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<SwordItem> SHADEWOOD_SWORD = ITEMS.register("shadewood_sword", () -> new SwordItem(ModItemTier.COPPER, 1, 0.0F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<SwordItem> GOLD_SHORTSWORD = ITEMS.register("gold_shortsword", () -> new SwordItem(ModItemTier.COPPER, 1, 0.0F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<SwordItem> SILVER_BROADSWORD = ITEMS.register("silver_broadsword", () -> new SwordItem(ModItemTier.SILVER, 1, 0.0F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<SwordItem> BLADED_GLOVE = ITEMS.register("bladed_glove", () -> new SwordItem(ModItemTier.COPPER, 1, 0.0F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<SwordItem> ZOMBIE_ARM = ITEMS.register("zombie_arm", () -> new SwordItem(ModItemTier.COPPER, 1, 0.0F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<SwordItem> MANDIBLE_BLADE = ITEMS.register("mandible_blade", () -> new SwordItem(ModItemTier.COPPER, 1, 0.0F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<SwordItem> STYLISH_SCISSORS = ITEMS.register("stylish_scissors", () -> new SwordItem(ModItemTier.COPPER, 1, 0.0F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<SwordItem> RULER = ITEMS.register("ruler", () -> new SwordItem(ModItemTier.COPPER, 1, 0.0F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<SwordItem> UMBRELLA = ITEMS.register("umbrella", () -> new SwordItem(ModItemTier.COPPER, 1, 0.0F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<SwordItem> BREATHING_REED = ITEMS.register("breathing_reed", () -> new SwordItem(ModItemTier.COPPER, 1, 0.0F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<SwordItem> GLADIUS = ITEMS.register("gladius", () -> new SwordItem(ModItemTier.COPPER, 1, 0.0F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<SwordItem> BONE_SWORD = ITEMS.register("bone_sword", () -> new SwordItem(ModItemTier.COPPER, 1, 0.0F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<SwordItem> CANDY_CANE_SWORD = ITEMS.register("candy_cane_sword", () -> new SwordItem(ModItemTier.COPPER, 1, 0.0F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<SwordItem> KATANA = ITEMS.register("katana", () -> new SwordItem(ModItemTier.COPPER, 1, 0.0F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<IceBladeItem> ICE_BLADE = ITEMS.register("ice_blade", () -> new IceBladeItem(ModItemTier.COPPER, 1, 0.0F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<SwordItem> LIGHTS_BANE = ITEMS.register("lights_bane", () -> new SwordItem(ModItemTier.COPPER, 1, 0.0F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<SwordItem> TRAGIC_UMBRELLA = ITEMS.register("tragic_umbrella", () -> new SwordItem(ModItemTier.COPPER, 1, 0.0F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<SwordItem> MURAMASA = ITEMS.register("muramasa", () -> new SwordItem(ModItemTier.COPPER, 1, 0.0F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<SwordItem> TERRAGRIM = ITEMS.register("terragrim", () -> new SwordItem(ModItemTier.COPPER, 1, 0.0F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<SwordItem> EXOTIC_SCIMITAR = ITEMS.register("exotic_scimitar", () -> new SwordItem(ModItemTier.COPPER, 1, 0.0F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<SwordItem> YELLOW_PHASEBLADE = ITEMS.register("yellow_phaseblade", () -> new SwordItem(ModItemTier.COPPER, 1, 0.0F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<SwordItem> RED_PHASEBLADE = ITEMS.register("red_phaseblade", () -> new SwordItem(ModItemTier.COPPER, 1, 0.0F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<SwordItem> WHITE_PHASEBLADE = ITEMS.register("white_phaseblade", () -> new SwordItem(ModItemTier.COPPER, 1, 0.0F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<SwordItem> PURPLE_PHASEBLADE = ITEMS.register("purple_phaseblade", () -> new SwordItem(ModItemTier.COPPER, 1, 0.0F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<SwordItem> GREEN_PHASEBLADE = ITEMS.register("green_phaseblade", () -> new SwordItem(ModItemTier.COPPER, 1, 0.0F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<SwordItem> BLUE_PHASEBLADE = ITEMS.register("blue_phaseblade", () -> new SwordItem(ModItemTier.COPPER, 1, 0.0F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<SwordItem> ORANGE_PHASEBLADE = ITEMS.register("orange_phaseblade", () -> new SwordItem(ModItemTier.COPPER, 1, 0.0F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<SwordItem> BLOOD_BUTCHERER = ITEMS.register("blood_butcherer", () -> new SwordItem(ModItemTier.COPPER, 1, 0.0F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<SwordItem> STARFURY = ITEMS.register("starfury", () -> new SwordItem(ModItemTier.COPPER, 1, 0.0F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<EnchantedSwordItem> ENCHANTED_SWORD = ITEMS.register("enchanted_sword", () -> new EnchantedSwordItem(ModItemTier.COPPER, 1, 0.0F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<SwordItem> PURPLE_CLUBBERFISH = ITEMS.register("purple_clubberfish", () -> new SwordItem(ModItemTier.COPPER, 1, 0.0F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<SwordItem> BEE_KEEPER = ITEMS.register("bee_keeper", () -> new SwordItem(ModItemTier.COPPER, 1, 0.0F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<SwordItem> FALCON_BLADE = ITEMS.register("falcon_blade", () -> new SwordItem(ModItemTier.COPPER, 1, 0.0F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<SwordItem> BLADE_OF_GRASS = ITEMS.register("blade_of_grass", () -> new SwordItem(ModItemTier.COPPER, 1, 0.0F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<SwordItem> FIERY_GREATSWORD = ITEMS.register("fiery_greatsword", () -> new SwordItem(ModItemTier.COPPER, 1, 0.0F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    public static final RegistryObject<SwordItem> NIGHTS_EDGE = ITEMS.register("nights_edge", () -> new SwordItem(ModItemTier.COPPER, 1, 0.0F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));
    //public static final RegistryObject<SwordItem> LUMINITE_SWORD = ITEMS.register("luminite_sword", () -> new SwordItem(ModItemTier.LUMINITE, 0, 0.0F, new Item.Properties().group(TerrariaReloaded.WEAPONS).setNoRepair()));


    // Block Items

    public static final RegistryObject<Item> HELLFORGE_ITEM = ITEMS.register("hellforge", () -> new BlockItemBase(ModBlocks.HELLFORGE));

    public static final RegistryObject<Item> HIVE_BLOCK_ITEM = ITEMS.register("hive_block", () -> new BlockItemBase(ModBlocks.HIVE_BLOCK));
    public static final RegistryObject<Item> PIGGY_BANK_ITEM = ITEMS.register("piggy_bank", () -> new BlockItemBase(ModBlocks.PIGGY_BANK));
    public static final RegistryObject<Item> CRYSTAL_HEART_ITEM = ITEMS.register("crystal_heart", () -> new BlockItemBase(ModBlocks.CRYSTAL_HEART));
    public static final RegistryObject<Item> SWORD_SHRINE_ITEM = ITEMS.register("sword_shrine", () -> new BlockItemBase(ModBlocks.SWORD_SHRINE));
    public static final RegistryObject<Item> DEMON_ALTAR_ITEM = ITEMS.register("demon_altar", () -> new BlockItemBase(ModBlocks.DEMON_ALTAR));

    public static final RegistryObject<Item> LIFE_FRUIT_BUSH_BLOCK = ITEMS.register("life_fruit_bush", () -> new BlockItemBase(ModBlocks.LIFE_FRUIT_BUSH));
    public static final RegistryObject<Item> JUNGLE_SPORES_BUSH_BLOCK = ITEMS.register("jungle_spores_bush", () -> new BlockItemBase(ModBlocks.JUNGLE_SPORES_BUSH));

    public static final RegistryObject<Item> METEORITE_ORE_ITEM = ITEMS.register("meteorite_ore", () -> new BlockItemBase(ModBlocks.METEORITE_ORE));
    public static final RegistryObject<Item> CRIMTANE_ORE_ITEM = ITEMS.register("crimtane_ore", () -> new BlockItemBase(ModBlocks.CRIMTANE_ORE));
    public static final RegistryObject<Item> DEMONITE_ORE_ITEM = ITEMS.register("demonite_ore", () -> new BlockItemBase(ModBlocks.DEMONITE_ORE));
    public static final RegistryObject<Item> HELLSTONE_ORE_ITEM = ITEMS.register("hellstone_ore", () -> new BlockItemBase(ModBlocks.HELLSTONE_ORE));
    public static final RegistryObject<Item> COBALT_ORE_ITEM = ITEMS.register("cobalt_ore", () -> new BlockItemBase(ModBlocks.COBALT_ORE));
    public static final RegistryObject<Item> PALLADIUM_ORE_ITEM = ITEMS.register("palladium_ore", () -> new BlockItemBase(ModBlocks.PALLADIUM_ORE));
    public static final RegistryObject<Item> MYTHRIL_ORE_ITEM = ITEMS.register("mythril_ore", () -> new BlockItemBase(ModBlocks.MYTHRIL_ORE));
    public static final RegistryObject<Item> ORICHALCUM_ORE_ITEM = ITEMS.register("orichalcum_ore", () -> new BlockItemBase(ModBlocks.ORICHALCUM_ORE));
    public static final RegistryObject<Item> ADAMANTITE_ORE_ITEM = ITEMS.register("adamantite_ore", () -> new BlockItemBase(ModBlocks.ADAMANTITE_ORE));
    public static final RegistryObject<Item> TITANIUM_ORE_ITEM = ITEMS.register("titanium_ore", () -> new BlockItemBase(ModBlocks.TITANIUM_ORE));
    public static final RegistryObject<Item> CHLOROPHYTE_ORE_ITEM = ITEMS.register("chlorophyte_ore", () -> new BlockItemBase(ModBlocks.CHLOROPHYTE_ORE));
    public static final RegistryObject<Item> SILVER_ORE_ITEM = ITEMS.register("silver_ore", () -> new BlockItemBase(ModBlocks.SILVER_ORE));
    public static final RegistryObject<Item> COPPER_ORE_ITEM = ITEMS.register("copper_ore", () -> new BlockItemBase(ModBlocks.COPPER_ORE));
    public static final RegistryObject<Item> PLATINUM_ORE_ITEM = ITEMS.register("platinum_ore", () -> new BlockItemBase(ModBlocks.PLATINUM_ORE));

    public static final RegistryObject<Item> SHIMMERING_DIAMOND_ORE_ITEM = ITEMS.register("shimmering_diamond_ore", () -> new BlockItemBase(ModBlocks.SHIMMERING_DIAMOND_ORE));
    public static final RegistryObject<Item> SHIMMERING_EMERALD_ORE_ITEM = ITEMS.register("shimmering_emerald_ore", () -> new BlockItemBase(ModBlocks.SHIMMERING_EMERALD_ORE));
    public static final RegistryObject<Item> RUBY_ORE_ITEM = ITEMS.register("ruby_ore", () -> new BlockItemBase(ModBlocks.RUBY_ORE));
    public static final RegistryObject<Item> AMETHYST_ORE_ITEM = ITEMS.register("amethyst_ore", () -> new BlockItemBase(ModBlocks.AMETHYST_ORE));
    public static final RegistryObject<Item> TOPAZ_ORE_ITEM = ITEMS.register("topaz_ore", () -> new BlockItemBase(ModBlocks.TOPAZ_ORE));
    public static final RegistryObject<Item> SAPPHIRE_ORE_ITEM = ITEMS.register("sapphire_ore", () -> new BlockItemBase(ModBlocks.SAPPHIRE_ORE));
    public static final RegistryObject<Item> AMBER_ORE_ITEM = ITEMS.register("amber_ore", () -> new BlockItemBase(ModBlocks.AMBER_ORE));

    public static final RegistryObject<Item> EBONSTONE_ITEM = ITEMS.register("ebonstone", () -> new BlockItemBase(ModBlocks.EBONSTONE));
    public static final RegistryObject<Item> CRIMSTONE_ITEM = ITEMS.register("crimstone", () -> new BlockItemBase(ModBlocks.CRIMSTONE));
    public static final RegistryObject<Item> PEARLSTONE_ITEM = ITEMS.register("pearlstone", () -> new BlockItemBase(ModBlocks.PEARLSTONE));
    public static final RegistryObject<Item> BLUE_GRANITE_ITEM = ITEMS.register("blue_granite", () -> new BlockItemBase(ModBlocks.BLUE_GRANITE));
    public static final RegistryObject<Item> MARBLE_ITEM = ITEMS.register("marble", () -> new BlockItemBase(ModBlocks.MARBLE));
    public static final RegistryObject<Item> EBONSAND_ITEM = ITEMS.register("ebonsand", () -> new BlockItemBase(ModBlocks.EBONSAND));
    public static final RegistryObject<Item> CRIMSAND_ITEM = ITEMS.register("crimsand", () -> new BlockItemBase(ModBlocks.CRIMSAND));
    public static final RegistryObject<Item> PEARLSAND_ITEM = ITEMS.register("pearlsand", () -> new BlockItemBase(ModBlocks.PEARLSAND));
    public static final RegistryObject<Item> EBONSTONE_BRICKS_ITEM = ITEMS.register("ebonstone_bricks", () -> new BlockItemBase(ModBlocks.EBONSTONE_BRICKS));

    public static final RegistryObject<Item> METEORITE_BRICKS_ITEM = ITEMS.register("meteorite_bricks", () -> new BlockItemBase(ModBlocks.METEORITE_BRICKS));
    public static final RegistryObject<Item> OBSIDIAN_BRICKS_ITEM = ITEMS.register("obsidian_bricks", () -> new BlockItemBase(ModBlocks.OBSIDIAN_BRICKS));
    public static final RegistryObject<Item> PLATINUM_BRICKS_ITEM = ITEMS.register("platinum_bricks", () -> new BlockItemBase(ModBlocks.PLATINUM_BRICKS));
    public static final RegistryObject<Item> SILVER_BRICKS_ITEM = ITEMS.register("silver_bricks", () -> new BlockItemBase(ModBlocks.SILVER_BRICKS));
    public static final RegistryObject<Item> GOLD_BRICKS_ITEM = ITEMS.register("gold_bricks", () -> new BlockItemBase(ModBlocks.GOLD_BRICKS));
    public static final RegistryObject<Item> COPPER_BRICKS_ITEM = ITEMS.register("copper_bricks", () -> new BlockItemBase(ModBlocks.COPPER_BRICKS));
    public static final RegistryObject<Item> MUDSTONE_BRICKS_ITEM = ITEMS.register("mudstone_bricks", () -> new BlockItemBase(ModBlocks.MUDSTONE_BRICKS));
    public static final RegistryObject<Item> HELLSTONE_BRICKS_ITEM = ITEMS.register("hellstone_bricks", () -> new BlockItemBase(ModBlocks.HELLSTONE_BRICKS));
    public static final RegistryObject<Item> CRIMSTONE_BRICKS_ITEM = ITEMS.register("crimstone_bricks", () -> new BlockItemBase(ModBlocks.CRIMSTONE_BRICKS));
    public static final RegistryObject<Item> PEARLSTONE_BRICKS_ITEM = ITEMS.register("pearlstone_bricks", () -> new BlockItemBase(ModBlocks.PEARLSTONE_BRICKS));
    public static final RegistryObject<Item> SMOOTH_BLUE_GRANITE_ITEM = ITEMS.register("smooth_blue_granite", () -> new BlockItemBase(ModBlocks.SMOOTH_BLUE_GRANITE));
    public static final RegistryObject<Item> SMOOTH_MARBLE_ITEM = ITEMS.register("smooth_marble", () -> new BlockItemBase(ModBlocks.SMOOTH_MARBLE));
    public static final RegistryObject<Item> MUD_ITEM = ITEMS.register("mud", () -> new BlockItemBase(ModBlocks.MUD));
    public static final RegistryObject<Item> SILT_ITEM = ITEMS.register("silt", () -> new BlockItemBase(ModBlocks.SILT));
    public static final RegistryObject<Item> SLUSH_ITEM = ITEMS.register("slush", () -> new BlockItemBase(ModBlocks.SLUSH));
    public static final RegistryObject<Item> ASH_ITEM = ITEMS.register("ash", () -> new BlockItemBase(ModBlocks.ASH));
    public static final RegistryObject<Item> BLOCK_OF_FLESH_ITEM = ITEMS.register("block_of_flesh", () -> new BlockItemBase(ModBlocks.BLOCK_OF_FLESH));

    public static final RegistryObject<Item> CORRUPT_GRASS_BLOCK_ITEM = ITEMS.register("corrupt_grass_block", () -> new BlockItemBase(ModBlocks.CORRUPT_GRASS_BLOCK));
    public static final RegistryObject<Item> CRIMSON_GRASS_BLOCK_ITEM = ITEMS.register("crimson_grass_block", () -> new BlockItemBase(ModBlocks.CRIMSON_GRASS_BLOCK));
    public static final RegistryObject<Item> JUNGLE_GRASS_BLOCK_ITEM = ITEMS.register("jungle_grass_block", () -> new BlockItemBase(ModBlocks.JUNGLE_GRASS_BLOCK));
    public static final RegistryObject<Item> MUSHROOM_GRASS_BLOCK_ITEM = ITEMS.register("mushroom_grass_block", () -> new BlockItemBase(ModBlocks.MUSHROOM_GRASS_BLOCK));

    public static final RegistryObject<Item> EBONWOOD_LOG_ITEM = ITEMS.register("ebonwood_log", () -> new BlockItemBase(ModBlocks.EBONWOOD_LOG));
    public static final RegistryObject<Item> SHADEWOOD_LOG_ITEM = ITEMS.register("shadewood_log", () -> new BlockItemBase(ModBlocks.SHADEWOOD_LOG));
    public static final RegistryObject<Item> EBONWOOD_PLANKS_ITEM = ITEMS.register("ebonwood_planks", () -> new BlockItemBase(ModBlocks.EBONWOOD_PLANKS));
    public static final RegistryObject<Item> SHADEWOOD_PLANKS_ITEM = ITEMS.register("shadewood_planks", () -> new BlockItemBase(ModBlocks.SHADEWOOD_PLANKS));
    public static final RegistryObject<Item> EBONWOOD_LEAVES_ITEM = ITEMS.register("ebonwood_leaves", () -> new BlockItemBase(ModBlocks.EBONWOOD_LEAVES));
    public static final RegistryObject<Item> SHADEWOOD_LEAVES_ITEM = ITEMS.register("shadewood_leaves", () -> new BlockItemBase(ModBlocks.SHADEWOOD_LEAVES));
    public static final RegistryObject<Item> EBONWOOD_SAPLING_ITEM = ITEMS.register("ebonwood_sapling", () -> new BlockItemBase(ModBlocks.EBONWOOD_SAPLING));
    public static final RegistryObject<Item> SHADEWOOD_SAPLING_ITEM = ITEMS.register("shadewood_sapling", () -> new BlockItemBase(ModBlocks.SHADEWOOD_SAPLING));

    public static final RegistryObject<Item> GLOWING_MUSHROOM_ITEM = ITEMS.register("glowing_mushroom", () -> new BlockItemBase(ModBlocks.GLOWING_MUSHROOM));

    // Throwing weapons
    public static final RegistryObject<Item> THROWING_KNIFE_ITEM = ITEMS.register("throwing_knife_item", () -> new ThrowingKnifeItem(new Item.Properties().group(TerrariaReloaded.THROW)));
    public static final RegistryObject<Item> POISONED_THROWING_KNIFE_ITEM = ITEMS.register("poisoned_knife_item", () -> new PoisonedKnifeItem(new Item.Properties().group(TerrariaReloaded.THROW)));

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

    //Bows
    public static final RegistryObject<ModBowItem> PLATINUM_BOW = ITEMS.register("platinum_bow", () -> new ModBowItem(new Item.Properties().group(TerrariaReloaded.WEAPONS), 10.0f, 72000, 1.0f, 1.0f, false, false));

    //Foods
    public static final RegistryObject<Item> GOLDFISH_SOUP = registerBaseFoodItem("goldfish_soup", 5, 1.0F, "'Simple, yet refreshing.'");
    public static final RegistryObject<Item> BUNNY_STEW = registerBaseFoodItem("bunny_stew", 5, 1.0F, "'This one's luck has run out.'");
    public static final RegistryObject<Item> FRUIT_JUICE = registerBaseFoodItem("fruit_juice", 3, 1.0F, "'With 5% real fruit juice!'");
    public static final RegistryObject<Item> PRISMATIC_PUNCH = registerBaseFoodItem("prismatic_punch", 6, 1.2F, "'Feel the rainbow, taste the crystal!'");
    public static final RegistryObject<Item> SEAFOOD_DINNER = registerBaseFoodItem("seafood_dinner", 8, 3.0F, "'I sea food, I eat it.'");
    public static final RegistryObject<Item> SMOOTHIE_OF_DARKNESS = registerBaseFoodItem("smoothie_of_darkness", 5, 1.0F, "'Come to the dark side, we have smoothies'");
    public static final RegistryObject<Item> SASHIMI = registerBaseFoodItem("sashimi", 5, 1.0F, "'It's raw! It's exotic!'");
    public static final RegistryObject<Item> ALE = registerBaseFoodItem("ale", 5, 1.0F, "'Down the hatch!'");
    public static final RegistryObject<Item> APPLE_PIE = registerBaseFoodItem("apple_pie", 5, 1.0F, "'Nothing is as Terrarian as apple pie.'");
    public static final RegistryObject<Item> BBQ_RIBS = registerBaseFoodItem("bbq_ribs", 5, 1.0F, "'Grilled to perfection!'");
    public static final RegistryObject<Item> BURGER = registerBaseFoodItem("burger", 8, 1.0F, "'...but wait! It was 99 cents.'");
    public static final RegistryObject<Item> CHICKEN_NUGGET = registerBaseFoodItem("chicken_nugget", 5, 1.0F, "'Caution: may contain harpy.'");
    public static final RegistryObject<Item> CREAM_SODA = registerBaseFoodItem("cream_soda", 5, 1.0F, "'It's so fizzy!'");
    public static final RegistryObject<Item> FRIED_EGG = registerBaseFoodItem("fried_egg", 5, 1.0F, "Sunny side up!'");
    public static final RegistryObject<Item> PAD_THAI = registerBaseFoodItem("pad_thai", 5, 1.0F, "'Spicy level 5!'");
    public static final RegistryObject<Item> PIZZA = registerBaseFoodItem("pizza", 5, 1.0F, "I'm not paying for those.'");
    public static final RegistryObject<Item> MARSHMALLOW = registerBaseFoodItem("marshmallow", 2, 1.0F, "'How many can you fit in your mouth?'");
    public static final RegistryObject<Item> COOKED_MARSHMALLOW = registerBaseFoodItem("cooked_marshmallow", 2, 1.0F, "'How can I have some more of nothing?'");
    public static final RegistryObject<Item> SAKE = registerBaseFoodItem("sake", 4, 1.0F, "'Drink too much of this, and you become karate master.'");

    //Projectiles
    public static final RegistryObject<Item> TERRARIAN_YOYO_PROJECTILE = ITEMS.register("terrarian_yoyo_projectile", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ENCHANTED_SWORD_PROJECTILE = ITEMS.register("enchanted_sword_projectile", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ICEBOLT_PROJECTILE = ITEMS.register("icebolt_projectile", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAYCAST_PROJECTILE = ITEMS.register("raycast_projectile", () -> new Item(new Item.Properties()));






    /**
     * Use this for default description
     * The color will be gray you can change the color, or you can use the other method for different colors
     *
     * @param name        the registry name of the item
     * @param hunger      the hunger value
     * @param saturation  the saturation value
     * @param description the description
     * @return the registered item object
     */
    private static RegistryObject<Item> registerBaseFoodItem(String name, int hunger, float saturation, String... description) {
        List<ITextComponent> list = Lists.newArrayList();
        for (String desc : description)
            list.add(new StringTextComponent(desc).applyTextStyle(TextFormatting.GRAY));
        return ITEMS.register(name, () -> new FoodItemBase(hunger, saturation, () -> list));
    }

    /**
     * Use this if you want to use custom colors for the description, ore more colors in one description
     *
     * @param name        the registry name of the item
     * @param hunger      the hunger value
     * @param saturation  the saturation value
     * @param description the description list as {@link ITextComponent} use {@link StringTextComponent} and the method {@link StringTextComponent#applyTextStyle(TextFormatting)} for custom colors.
     *                    The {@link TextFormatting} parameter is the color, so you can use TextFormatting.GRAY or something like this
     * @return the registered item object
     */
    private static RegistryObject<Item> registerBaseFoodItem(String name, int hunger, float saturation, List<ITextComponent> description) {
        return ITEMS.register(name, () -> new FoodItemBase(hunger, saturation, () -> description));
    }

    private static RegistryObject<Item> registerYoyo(String name, YoyoType type) {
        return ITEMS.register(name + "_yoyo", () -> new YoyoItem(type));
    }

}
