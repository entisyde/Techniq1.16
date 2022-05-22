package com.entisy.techniq.common.block.furnaceGenerator;

import com.entisy.techniq.common.block.MachineBlock;
import com.entisy.techniq.core.init.ModTileEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class FurnaceGeneratorBlock extends MachineBlock
{

    public FurnaceGeneratorBlock() {
        registerDefaultState(stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(LIT, false));
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntityTypes.FURNACE_GENERATOR_TILE_ENTITY.get().create();
    }

    @Override
    public void setPlacedBy(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack item) {
        super.setPlacedBy(world, pos, state, placer, item);
        if (!item.getDisplayName().getString().isEmpty()) {
            TileEntity tileEntity = world.getBlockEntity(pos);
            if (tileEntity instanceof FurnaceGeneratorTileEntity) {
                ((FurnaceGeneratorTileEntity) tileEntity).setCustomName(item.getDisplayName());
            }
        }
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand,
                                BlockRayTraceResult rayTrace) {
        if (world != null && !world.isClientSide()) {
            TileEntity tileEntity = world.getBlockEntity(pos);
            if (tileEntity instanceof FurnaceGeneratorTileEntity) {
                NetworkHooks.openGui((ServerPlayerEntity) player, (INamedContainerProvider) tileEntity, pos);
                return ActionResultType.SUCCESS;
            }
        }
        return ActionResultType.SUCCESS;
    }

    @Override
    public void onRemove(BlockState state, World world, BlockPos pos, BlockState newState, boolean isMoving) {
        TileEntity tileEntity = world.getBlockEntity(pos);
        if (tileEntity instanceof FurnaceGeneratorTileEntity && state.getBlock() != newState.getBlock()) {
            FurnaceGeneratorTileEntity furnace = (FurnaceGeneratorTileEntity) tileEntity;
            furnace.getInventory().toNonNullList().forEach(item -> {
                ItemEntity itemEntity = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), item);
                world.addFreshEntity(itemEntity);
            });
        }
        if (state.hasTileEntity() && state.getBlock() != newState.getBlock()) {
            world.removeBlockEntity(pos);
        }
    }
}
