package me.john000708.bees.objects;

import me.john000708.bees.BeeItemHandler;
import org.bukkit.inventory.ItemStack;

/**
 * Created by John on 23.05.2016.
 */
public class BeeRecipe {

    ItemStack princess;
    ItemStack drone;

    ItemStack[] output;

    public BeeRecipe(ItemStack princess, ItemStack drone, ItemStack[] output) {
        this.princess = princess;
        this.drone = drone;
        this.output = output;
    }

    public ItemStack getPrincess() {
        return this.princess;
    }

    public ItemStack getDrone() {
        return this.drone;
    }

    public ItemStack[] getOutput() {
        return this.output;
    }

    public double getBreedTime() {
        double averageProductivity = (BeeItemHandler.getStats(princess).get(1) + BeeItemHandler.getStats(drone).get(1)) / 2;

        return (1200 * 30) / averageProductivity;
    }
}
