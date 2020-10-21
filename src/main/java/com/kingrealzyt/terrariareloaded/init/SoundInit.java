package com.kingrealzyt.terrariareloaded.init;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundInit {

    public static final DeferredRegister<SoundEvent> SOUNDS = new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS, TerrariaReloaded.MOD_ID);

    public static final RegistryObject<SoundEvent> ITEMTHROW = SOUNDS.register("item_throw", () -> new SoundEvent(new ResourceLocation(TerrariaReloaded.MOD_ID, "item_throw")));
    public static final RegistryObject<SoundEvent> MAGICMIRRORUSE = SOUNDS.register("item_magicmirror_use", () -> new SoundEvent(new ResourceLocation(TerrariaReloaded.MOD_ID, "item_magicmirror_use")));
    public static final RegistryObject<SoundEvent> GUNSHOOT = SOUNDS.register("item_gun_shoot", () -> new SoundEvent(new ResourceLocation(TerrariaReloaded.MOD_ID, "item_gun_shoot")));
    public static final RegistryObject<SoundEvent> REPEATERSHOOT = SOUNDS.register("item_repeater_shoot", () -> new SoundEvent(new ResourceLocation(TerrariaReloaded.MOD_ID, "item_repeater_shoot")));
    public static final RegistryObject<SoundEvent> ENTITYDEATH = SOUNDS.register("entity_death", () -> new SoundEvent(new ResourceLocation(TerrariaReloaded.MOD_ID, "entity_death")));
    public static final RegistryObject<SoundEvent> ENTITYBOSSROAR = SOUNDS.register("entity_boss_roar", () -> new SoundEvent(new ResourceLocation(TerrariaReloaded.MOD_ID, "entity_boss_roar")));
    public static final RegistryObject<SoundEvent> BOSS1 = SOUNDS.register("boss_1", () -> new SoundEvent(new ResourceLocation(TerrariaReloaded.MOD_ID, "boss_1")));

    public static final RegistryObject<SoundEvent> DEMON_HURT = SOUNDS.register("demon_hurt", () -> new SoundEvent(new ResourceLocation(TerrariaReloaded.MOD_ID, "demon_hurt")));
    public static final RegistryObject<SoundEvent> DEMON_AMBIENT = SOUNDS.register("demon_ambient", () -> new SoundEvent(new ResourceLocation(TerrariaReloaded.MOD_ID, "demon_ambient")));
    public static final RegistryObject<SoundEvent> DEMON_KILLED = SOUNDS.register("demon_killed", () -> new SoundEvent(new ResourceLocation(TerrariaReloaded.MOD_ID, "demon_killed")));

}
