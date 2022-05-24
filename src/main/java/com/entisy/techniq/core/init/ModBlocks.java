package com.entisy.techniq.core.init;

import com.entisy.techniq.Techniq;
import com.entisy.techniq.common.block.alloySmelter.AlloySmelterBlock;
import com.entisy.techniq.common.block.battery.BatteryBlock;
//import com.entisy.techniq.common.block.blockBreaker.BlockBreakerBlock;
import com.entisy.techniq.common.block.cable.CableBlock;
//import com.entisy.techniq.common.block.displayCase.DisplayCaseBlock;
import com.entisy.techniq.common.block.electricalFurnace.ElectricalFurnaceBlock;
import com.entisy.techniq.common.block.fluidCable.FluidCableBlock;
import com.entisy.techniq.common.block.furnaceGenerator.FurnaceGeneratorBlock;
import com.entisy.techniq.common.block.itemCable.ItemCableBlock;
import com.entisy.techniq.common.block.metalPress.MetalPressBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            Techniq.MOD_ID);

    /**
     * METAL
     */
    public static final RegistryObject<Block> COPPER_BLOCK = BLOCKS.register("copper_block",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> STEEL_BLOCK = BLOCKS.register("steel_block",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.IRON_BLOCK)));

    /**
     * ORE
     */
    public static final RegistryObject<Block> COPPER_ORE = BLOCKS.register("copper_ore",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.IRON_ORE)));
    public static final RegistryObject<Block> NETHER_COPPER_ORE = BLOCKS.register("nether_copper_ore",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.IRON_ORE)));
    public static final RegistryObject<Block> END_COPPER_ORE = BLOCKS.register("end_copper_ore",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.IRON_ORE)));
    public static final RegistryObject<Block> NETHER_IRON_ORE = BLOCKS.register("nether_iron_ore",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.IRON_ORE)));
    public static final RegistryObject<Block> END_IRON_ORE = BLOCKS.register("end_iron_ore",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.IRON_ORE)));
    public static final RegistryObject<Block> NETHER_GOLD_ORE = BLOCKS.register("nether_gold_ore",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.GOLD_ORE)));
    public static final RegistryObject<Block> END_GOLD_ORE = BLOCKS.register("end_gold_ore",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.GOLD_ORE)));
    public static final RegistryObject<Block> NETHER_LAPIS_ORE = BLOCKS.register("nether_lapis_ore",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.LAPIS_ORE)));
    public static final RegistryObject<Block> END_LAPIS_ORE = BLOCKS.register("end_lapis_ore",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.LAPIS_ORE)));
    public static final RegistryObject<Block> NETHER_REDSTONE_ORE = BLOCKS.register("nether_redstone_ore",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.LAPIS_ORE)));
    public static final RegistryObject<Block> END_REDSTONE_ORE = BLOCKS.register("end_redstone_ore",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.LAPIS_ORE)));
    public static final RegistryObject<Block> NETHER_COAL_ORE = BLOCKS.register("nether_coal_ore",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.COAL_ORE)));
    public static final RegistryObject<Block> END_COAL_ORE = BLOCKS.register("end_coal_ore",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.COAL_ORE)));
    public static final RegistryObject<Block> NETHER_DIAMOND_ORE = BLOCKS.register("nether_diamond_ore",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.DIAMOND_ORE)));
    public static final RegistryObject<Block> END_DIAMOND_ORE = BLOCKS.register("end_diamond_ore",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.DIAMOND_ORE)));
    public static final RegistryObject<Block> NETHER_EMERALD_ORE = BLOCKS.register("nether_emerald_ore",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.EMERALD_ORE)));
    public static final RegistryObject<Block> END_EMERALD_ORE = BLOCKS.register("end_emerald_ore",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.EMERALD_ORE)));
    public static final RegistryObject<Block> QUARTZ_ORE = BLOCKS.register("quartz_ore",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.IRON_ORE)));
    public static final RegistryObject<Block> END_QUARTZ_ORE = BLOCKS.register("end_quartz_ore",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.IRON_ORE)));

    /*
     * MACHINE
     */
//    public static final RegistryObject<Block> BLOCK_BREAKER = BLOCKS.register("block_breaker",
//            () -> new BlockBreakerBlock());
//    public static final RegistryObject<Block> DISPLAY_CASE = BLOCKS.register("display_case",
//            () -> new DisplayCaseBlock());
    public static final RegistryObject<Block> METAL_PRESS = BLOCKS.register("metal_press",
            () -> new MetalPressBlock());
    public static final RegistryObject<Block> ELECTRICAL_FURNACE = BLOCKS.register("electrical_furnace",
            () -> new ElectricalFurnaceBlock());
    public static final RegistryObject<Block> ALLOY_SMELTER = BLOCKS.register("alloy_smelter",
            () -> new AlloySmelterBlock());
    public static final RegistryObject<Block> BATTERY = BLOCKS.register("battery",
            () -> new BatteryBlock());
    public static final RegistryObject<Block> FURNACE_GENERATOR = BLOCKS.register("furnace_generator",
            () -> new FurnaceGeneratorBlock());

    /*
     * CABLES
     */
    public static final RegistryObject<Block> CABLE = BLOCKS.register("cable",
            () -> new CableBlock(AbstractBlock.Properties.of(Material.DECORATION).strength(1, 5)));
    public static final RegistryObject<Block> ITEM_CABLE = BLOCKS.register("item_cable",
            () -> new ItemCableBlock(AbstractBlock.Properties.of(Material.DECORATION).strength(1, 5)));
    public static final RegistryObject<Block> FLUID_CABLE = BLOCKS.register("fluid_cable",
            () -> new FluidCableBlock(AbstractBlock.Properties.of(Material.DECORATION).strength(1, 5)));
}