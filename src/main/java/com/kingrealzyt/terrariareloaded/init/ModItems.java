package com.kingrealzyt.terrariareloaded.init;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.items.GuideVoodoo;
import com.kingrealzyt.terrariareloaded.items.ItemBand;
import com.kingrealzyt.terrariareloaded.items.Lens;
import com.kingrealzyt.terrariareloaded.items.MagicMirror;
import com.kingrealzyt.terrariareloaded.items.tools.others.PickaxeAxeItem;
import com.kingrealzyt.terrariareloaded.items.weapons.ranged.repeaters.HallowedRepeaterItem;
import com.kingrealzyt.terrariareloaded.items.weapons.throwing.ThrowingKnifeItem;
import com.kingrealzyt.terrariareloaded.items.weapons.ranged.yoyo.*;
import com.kingrealzyt.terrariareloaded.util.enums.ModItemTier;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, TerrariaReloaded.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Items
    public static final RegistryObject<Item> MAGIC_MIRROR = ITEMS.register("magic_mirror", MagicMirror::new);
    public static final RegistryObject<Item> ICE_MIRROR = ITEMS.register("ice_mirror", MagicMirror::new);
    public static final RegistryObject<Item> GUIDE_VOODOO = ITEMS.register("guide_voodoo_doll", GuideVoodoo::new);
    public static final RegistryObject<Item> BAND_REGENERATION = ITEMS.register("band_of_regeneration", ItemBand::new);
    public static final RegistryObject<Item> LENS = ITEMS.register("lens", Lens::new);

    // Tools
    public static final RegistryObject<SwordItem> COPPER_SHORTSWORD = ITEMS.register("copper_shortsword", () -> new SwordItem(ModItemTier.COPPER_SHORT, 1, 0.0F, new Item.Properties().group(TerrariaReloaded.SWORDS).setNoRepair()));
    public static final RegistryObject<SwordItem> COPPER_BROADSWORD = ITEMS.register("copper_broadsword", () -> new SwordItem(ModItemTier.COPPER_BROAD, 2, -2.4F, new Item.Properties().group(TerrariaReloaded.SWORDS).setNoRepair()));
    public static final RegistryObject<AxeItem> COPPER_AXE = ITEMS.register("copper_axe", () -> new AxeItem(ModItemTier.COPPER_SHORT, 0, 0.0F, new Item.Properties().group(TerrariaReloaded.AXE).setNoRepair()));
    public static final RegistryObject<PickaxeItem> COPPER_PICKAXE = ITEMS.register("copper_pickaxe", () -> new PickaxeItem(ModItemTier.COPPER_SHORT, 0, 0.0F, new Item.Properties().group(TerrariaReloaded.PICKAXE).setNoRepair()));
    public static final RegistryObject<HallowedRepeaterItem> HALLOWED_REPEATER_ITEM = ITEMS.register("hallowed_repeater", () -> new HallowedRepeaterItem(new Item.Properties().group(TerrariaReloaded.RANGED).setNoRepair()));

    public static final RegistryObject<PickaxeAxeItem> PICKSAW = ITEMS.register("picksaw", () -> new PickaxeAxeItem(ItemTier.DIAMOND, 0, 0.0F, new Item.Properties().group(TerrariaReloaded.PICKAXE).setNoRepair()));
    public static final RegistryObject<PickaxeAxeItem> PICKAXE_AXE = ITEMS.register("pickaxe_axe", () -> new PickaxeAxeItem(ItemTier.DIAMOND, 0, 0.0F, new Item.Properties().group(TerrariaReloaded.PICKAXE).setNoRepair()));



    // Block Items


    // Throwing weapons
    public static final RegistryObject<Item> THROWING_KNIFE_ITEM = ITEMS.register("throwing_knife_item", () -> new ThrowingKnifeItem(new Item.Properties().group(TerrariaReloaded.THROW)));
    //Yoyos
    public static final RegistryObject<Item> AMAROK_YOYO = ITEMS.register("amarok_yoyo", AmarokYoyo::new);
    public static final RegistryObject<Item> AMAZON_YOYO = ITEMS.register("amazon_yoyo", AmazonYoyo::new);
    public static final RegistryObject<Item> ARTERY_YOYO = ITEMS.register("artery_yoyo", ArteryYoyo::new);
    public static final RegistryObject<Item> CASCADE_YOYO = ITEMS.register("cascade_yoyo", CascadeYoyo::new);
    public static final RegistryObject<Item> CHICK_YOYO = ITEMS.register("chick_yoyo", ChickYoyo::new);
    public static final RegistryObject<Item> CODE_1_YOYO = ITEMS.register("code_1_yoyo", Code1Yoyo::new);
    public static final RegistryObject<Item> CODE_2_YOYO = ITEMS.register("code_2_yoyo", Code2Yoyo::new);
    public static final RegistryObject<Item> FORMAT_C_YOYO = ITEMS.register("format_c_yoyo", FormatCYoyo::new);
    public static final RegistryObject<Item> GRADIENT_YOYO = ITEMS.register("gradient_yoyo", GradientYoyo::new);
    public static final RegistryObject<Item> HEL_FIRE_YOYO = ITEMS.register("hel_fire_yoyo", HelFireYoyo::new);
    public static final RegistryObject<Item> KRAKEN_YOYO = ITEMS.register("kraken_yoyo", KrakenYoyo::new);
    public static final RegistryObject<Item> MALAISE_YOYO = ITEMS.register("malaise_yoyo", MalaiseYoyo::new);
    public static final RegistryObject<Item> RALLY_YOYO = ITEMS.register("rally_yoyo", RallyYoyo::new);
    public static final RegistryObject<Item> REDS_THROW_YOYO = ITEMS.register("red_throw_yoyo", RedsThrowYoyo::new);
    public static final RegistryObject<Item> TERRARIAN_YOYO = ITEMS.register("terrarian_yoyo", TerrarianYoyo::new);
    public static final RegistryObject<Item> THE_EYE_OF_CTHULU_YOYO = ITEMS.register("the_eye_of_cthulu_yoyo", TheEyeOfCthuluYoyo::new);
    public static final RegistryObject<Item> VALKYRIE_YOYO = ITEMS.register("valkyrie_yoyo", ValkyrieYoyo::new);
    public static final RegistryObject<Item> VALOR_YOYO = ITEMS.register("valor_yoyo", ValorYoyo::new);
    public static final RegistryObject<Item> WOODEN_YOYO = ITEMS.register("wooden_yoyo", WoodenYoyo::new);
    public static final RegistryObject<Item> YELETS_YOYO = ITEMS.register("yelets_yoyo", YeletsYoyo::new);

}
