package com.entisy.techniq.common.block.solarPanel;

import com.entisy.techniq.common.block.MachineTileEntity;
import com.entisy.techniq.core.capabilities.energy.EnergyStorageImpl;
import com.entisy.techniq.core.capabilities.energy.IEnergyHandler;
import com.entisy.techniq.core.init.ModTileEntityTypes;
import com.entisy.techniq.core.util.EnergyUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DaylightDetectorBlock;
import net.minecraft.item.Items;
import net.minecraft.tileentity.ITickableTileEntity;

public class SolarPanelTileEntity extends MachineTileEntity implements ITickableTileEntity, IEnergyHandler {

    public SolarPanelTileEntity() {
        super(0, 0, 15, ModTileEntityTypes.SOLAR_PANEL_TILE_ENTITY.get());
    }

    @Override
    public void tick() {
        if (level != null && !level.isClientSide()) {
            if (maxEnergyExtract > 0) {
                EnergyUtils.trySendToNeighbors(level, worldPosition, this, maxEnergyExtract);
            }

            if (level.isDay()) {
                if (currentEnergy + 1 <= maxEnergy) {
                    energy.ifPresent(iEnergyStorage -> {
                        energyStorage.setEnergyDirectly(energyStorage.getEnergyStored() + 1);
                    });
                }
            }
        }
    }

    @Override
    public EnergyStorageImpl getEnergyImpl() {
        return energyStorage;
    }
}