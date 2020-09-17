package com.kingrealzyt.terrariareloaded.init;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundInit {

    public static final DeferredRegister<SoundEvent> SOUNDS = new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS, TerrariaReloaded.MOD_ID);

    public static final RegistryObject<SoundEvent> MAGICMIRRORUSE = SOUNDS.register("item_magicmirror_use", () -> new SoundEvent(new ResourceLocation(TerrariaReloaded.MOD_ID, "item_magicmirror_use")));
}
