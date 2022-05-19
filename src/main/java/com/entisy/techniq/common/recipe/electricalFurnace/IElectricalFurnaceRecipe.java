package com.entisy.techniq.common.recipe.electricalFurnace;

import javax.annotation.Nonnull;

import com.entisy.techniq.Techniq;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public interface IElectricalFurnaceRecipe extends IRecipe<RecipeWrapper> {
	
	ResourceLocation RECIPE_TYPE_ID = new ResourceLocation(Techniq.MOD_ID, "electrical_furnace");
	
	@Nonnull
	@Override
	default IRecipeType<?> getType() {
		return Registry.RECIPE_TYPE.get(RECIPE_TYPE_ID);
	}
	
	@Override
	default boolean canCraftInDimensions(int width, int height) {
		return false;
	}
	
	Ingredient getInput();
}
