package com.kingrealzyt.terrariareloaded.init;

import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.recipes.HellforgeRecipe;
import com.kingrealzyt.terrariareloaded.recipes.HellforgeRecipeSerializer;
import com.kingrealzyt.terrariareloaded.recipes.IHellforgeRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class RecipeSerializerInit {

    public static final IRecipeSerializer<HellforgeRecipe> HELLFORGE_RECIPE_SERIALIZER = new HellforgeRecipeSerializer();
    public static final IRecipeType<IHellforgeRecipe> HELLFORGE_TYPE = registerType(IHellforgeRecipe.RECIPE_TYPE_ID);

    public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS = new DeferredRegister<>(
            ForgeRegistries.RECIPE_SERIALIZERS, TerrariaReloaded.MOD_ID
    );
    public static final RegistryObject<IRecipeSerializer<?>> HELLFORGE_SERIALIZER = RECIPE_SERIALIZERS.register("hellforge", () -> HELLFORGE_RECIPE_SERIALIZER);

    private static IRecipeType<IHellforgeRecipe> registerType(ResourceLocation recipeTypeId) {
        return Registry.register(Registry.RECIPE_TYPE, recipeTypeId, new RecipeType<>());
    }

    private static class RecipeType<T extends IRecipe<?>> implements IRecipeType<T> {
        @Override
        public String toString() {
            return Registry.RECIPE_TYPE.getKey(this).toString();
        }
    }
}
