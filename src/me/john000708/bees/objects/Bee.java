package me.john000708.bees.objects;

import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import org.bukkit.inventory.ItemStack;

/**
 * Created by John on 20.05.2016.
 */
public class Bee extends SlimefunItem {

    private String species;
    private Gender gender;
    private int lifespan;
    private int speed;

    public Bee(Category category, ItemStack itemStack, String name, String species, Gender gender, int lifespan, int speed) {
        super(category, itemStack, name, RecipeType.NULL, new ItemStack[]{null, null, null, null, null, null, null, null, null});

        this.species = species;
        this.gender = gender;
        this.lifespan = lifespan;
        this.speed = speed;
    }

    public String getSpecies() {
        return this.species;
    }

    public Gender getGender() {
        return this.gender;
    }

    public int getLifespan() {
        return this.lifespan;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpecies(String name) {
        this.species = name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setLifespan(int lifespan) {
        this.lifespan = lifespan;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

}
