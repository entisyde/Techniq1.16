package com.entisy.techniq.common.item.energy;

import net.minecraft.item.ItemStack;
import net.minecraftforge.energy.EnergyStorage;

public class ItemEnergyStorageImpl extends EnergyStorage {

    private final ItemStack stack;

    public ItemEnergyStorageImpl(ItemStack stack, int capacity, int maxReceive, int maxExtract) {
        super(capacity, maxReceive, maxExtract);
        this.stack = stack;
    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        if (!canReceive()) {
            return 0;
        }
        int energyStored = getEnergyStored();
        int energyReceived = Math.min(capacity - energyStored, Math.min(this.maxReceive, maxReceive));
        if (!simulate) {
            setEnergyStored(energyStored + energyReceived);
        }
        return energyReceived;
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        if (!canExtract()) {
            return 0;
        }
        int energyStored = getEnergyStored();
        int energyExtracted = Math.min(energyStored, Math.min(this.maxExtract, maxExtract));
        if (!simulate) {
            setEnergyStored(energyStored - energyExtracted);
        }
        return energyExtracted;
    }

    @Override
    public int getEnergyStored() {
        return stack.getOrCreateTag().getInt("Energy");
    }

    private void setEnergyStored(int amount) {
        stack.getOrCreateTag().putInt("Energy", amount);
    }
}
