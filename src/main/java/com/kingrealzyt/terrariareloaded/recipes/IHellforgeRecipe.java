package com.kingrealzyt.terrariareloaded.recipes;

import javax.annotation.Nonnull;

import com.kingrealzyt.terrariareloaded.jei.TerrairaReloadedJEI;
import com.kingrealzyt.terrariareloaded.TerrariaReloaded;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public interface IHellForgeRecipe extends IRecipe<RecipeWrapper> {

	ResourceLocation RECIPE_TYPE_ID = new ResourceLocation(TerrariaReloaded.MOD_ID, "hellforge");
	
	@Nonnull
	@Override
	default IRecipeType<?> getType() {
		return Registry.RECIPE_TYPE.getValue(RECIPE_TYPE_ID).get();
	}
	
	@Override
	default boolean canFit(int width, int height) {
		return false;
	}
	
	Ingredient getInput();
}
