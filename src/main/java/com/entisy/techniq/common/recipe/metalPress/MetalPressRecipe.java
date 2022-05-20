package com.entisy.techniq.common.recipe.metalPress;

import com.entisy.techniq.core.init.RecipeSerializerInit;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public class MetalPressRecipe implements IMetalPressRecipe {
	
	private final ResourceLocation id;
	private final Ingredient input;
	private final ItemStack output;
	private int requiredEnergy = 200;
	
	public MetalPressRecipe(ResourceLocation id, Ingredient input, ItemStack output, int requiredEnergy) {
		this.id = id;
		this.input = input;
		this.output = output;
		this.requiredEnergy = requiredEnergy;
	}

	public int getRequiredEnergy() {
		return requiredEnergy;
	}

	public int getCount(ItemStack item) {
		return input.getItems()[0].getCount() | 1;
	}
	@Override
	public ItemStack assemble(RecipeWrapper wrapper) {
		return output;
	}

	@Override
	public ItemStack getResultItem() {
		return output;
	}

	@Override
	public ResourceLocation getId() {
		return id;
	}

	@Override
	public IRecipeSerializer<?> getSerializer() {
		return RecipeSerializerInit.METAL_PRESS_SERIALIZER.get();
	}

	@Override
	public Ingredient getInput() {
		return input;
	}
	
	@Override
	public NonNullList<Ingredient> getIngredients() {
		return NonNullList.of(null, input);
	}

	@Override
	public boolean matches(RecipeWrapper wrapper, World world) {
		return input.test(wrapper.getItem(0));
	}
}
