package com.entisy.techniq.data;

import com.entisy.techniq.Techniq;
import com.entisy.techniq.data.client.ModBlockStateProvider;
import com.entisy.techniq.data.client.ModItemModelProvider;

import com.entisy.techniq.data.client.ModLanguageProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = Techniq.MOD_ID, bus = Bus.MOD)
public class DataGenerators {
	
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator gen = event.getGenerator();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

		gen.addProvider(new ModBlockStateProvider(gen, existingFileHelper));
		gen.addProvider(new ModItemModelProvider(gen, existingFileHelper));
		
		ModBlockTagsProvider blockTags = new ModBlockTagsProvider(gen, existingFileHelper);
		gen.addProvider(new ModFluidTagsProvider(gen, existingFileHelper));
		gen.addProvider(blockTags);
		gen.addProvider(new ModItemTagsProvider(gen, blockTags, existingFileHelper));
		
		gen.addProvider(new ModLootTableProvider(gen));
		gen.addProvider(new ModRecipeProvider(gen));
		gen.addProvider(new ModLanguageProvider(gen));
	}
}
