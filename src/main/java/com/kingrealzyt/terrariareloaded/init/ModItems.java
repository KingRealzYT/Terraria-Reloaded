package com.kingrealzyt.terrariareloaded.init;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.items.GuideVoodoo;
import com.kingrealzyt.terrariareloaded.items.ItemBand;
import com.kingrealzyt.terrariareloaded.items.Lens;
import com.kingrealzyt.terrariareloaded.items.MagicMirror;
import com.kingrealzyt.terrariareloaded.items.tools.others.PickaxeAxeItem;
import com.kingrealzyt.terrariareloaded.items.weapons.ranged.repeaters.*;
import com.kingrealzyt.terrariareloaded.items.weapons.throwing.PoisonedKnifeItem;
import com.kingrealzyt.terrariareloaded.items.weapons.throwing.ThrowingKnifeItem;
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
    public static final RegistryObject<AdmantiteRepeaterItem> ADMANTITE_REPEATER_ITEM = ITEMS.register("admantite_repeater", () -> new AdmantiteRepeaterItem(new Item.Properties().group(TerrariaReloaded.RANGED).setNoRepair()));
    public static final RegistryObject<CobaltRepeaterItem> COBALT_REPEATER_ITEM = ITEMS.register("cobalt_repeater", () -> new CobaltRepeaterItem(new Item.Properties().group(TerrariaReloaded.RANGED).setNoRepair()));
    public static final RegistryObject<OrichalcumRepeaterItem> ORICHALCUM_REPEATER_ITEM = ITEMS.register("orichalcum_repeater", () -> new OrichalcumRepeaterItem(new Item.Properties().group(TerrariaReloaded.RANGED).setNoRepair()));
    public static final RegistryObject<MythrilRepeaterItem> MYTHRIL_REPEATER_ITEM = ITEMS.register("mythril_repeater", () -> new MythrilRepeaterItem(new Item.Properties().group(TerrariaReloaded.RANGED).setNoRepair()));
    public static final RegistryObject<PalladiumRepeaterItem> PALLADIUM_REPEATER_ITEM = ITEMS.register("palladium_repeater", () -> new PalladiumRepeaterItem(new Item.Properties().group(TerrariaReloaded.RANGED).setNoRepair()));
    public static final RegistryObject<TitaniumRepeaterItem> TITANIUM_REPEATER_ITEM = ITEMS.register("titanium_repeater", () -> new TitaniumRepeaterItem(new Item.Properties().group(TerrariaReloaded.RANGED).setNoRepair()));


    public static final RegistryObject<PickaxeAxeItem> PICKSAW = ITEMS.register("picksaw", () -> new PickaxeAxeItem(ItemTier.DIAMOND, 0, 0.0F, new Item.Properties().group(TerrariaReloaded.PICKAXE).setNoRepair()));
    public static final RegistryObject<PickaxeAxeItem> PICKAXE_AXE = ITEMS.register("pickaxe_axe", () -> new PickaxeAxeItem(ItemTier.DIAMOND, 0, 0.0F, new Item.Properties().group(TerrariaReloaded.PICKAXE).setNoRepair()));



    // Block Items


    // Throwing weapons
    public static final RegistryObject<Item> THROWING_KNIFE_ITEM = ITEMS.register("throwing_knife_item", () -> new ThrowingKnifeItem(new Item.Properties().group(TerrariaReloaded.THROW)));
    public static final RegistryObject<Item> POISONED_KNIFE_ITEM = ITEMS.register("poisoned_knife_item", () -> new PoisonedKnifeItem(new Item.Properties().group(TerrariaReloaded.THROW)));

}
