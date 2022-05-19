package com.entisy.techniq.common.tileentity;

import com.entisy.techniq.core.init.TileEntityTypesInit;

import net.minecraft.block.Blocks;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class BlockBreakerTileEntity extends TileEntity implements ITickableTileEntity {

	public BlockBreakerTileEntity(TileEntityType<?> type) {
		super(type);
	}
	
	public BlockBreakerTileEntity()
	{
		this(TileEntityTypesInit.BLOCK_BREAKER_TILE_ENTITY_TYPE.get());
	}

	@Override
	public void tick() {
		this.level.setBlock(this.getBlockPos().below(), Blocks.AIR.defaultBlockState(), 0);
	}
}
