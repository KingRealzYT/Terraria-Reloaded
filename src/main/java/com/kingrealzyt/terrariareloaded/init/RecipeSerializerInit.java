package com.kingrealzyt.terrariareloaded.init;



import com.kingrealzyt.terrariareloaded.TerrariaReloaded;
import com.kingrealzyt.terrariareloaded.recipes.HellForgeRecipe;
import com.kingrealzyt.terrariareloaded.recipes.HellForgeRecipeSerializer;
import com.kingrealzyt.terrariareloaded.recipes.IHellForgeRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RecipeSerializerInit {

    public static final IRecipeSerializer<HellForgeRecipe> HELLFORGE_RECIPE_SERIALIZER = new HellForgeRecipeSerializer();
    public static final IRecipeType<IHellForgeRecipe> HELLFORGE_TYPE = registerType(IHellForgeRecipe.RECIPE_TYPE_ID);

    public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS = new DeferredRegister<>(
            ForgeRegistries.RECIPE_SERIALIZERS, TerrariaReloaded.MOD_ID);

    public static final RegistryObject<IRecipeSerializer<?>> HELLFORGE_SERIALIZER = RECIPE_SERIALIZERS.register("hellforge",
            () -> HELLFORGE_RECIPE_SERIALIZER);

    private static class RecipeType<T extends IRecipe<?>> implements IRecipeType<T> {
        @Override
        public String toString() {
            return Registry.RECIPE_TYPE.getKey(this).toString();
        }
    }

    private static <T extends IRecipeType> T registerType(ResourceLocation recipeTypeId) {
        return (T) Registry.register(Registry.RECIPE_TYPE, recipeTypeId, new RecipeType<>());
    }
}
