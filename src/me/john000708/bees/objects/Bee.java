package me.john000708.bees.objects;

import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import org.bukkit.inventory.ItemStack;

import me.john000708.bees.Items;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;

/**
 * Created by John on 20.05.2016.
 */
public class Bee extends SlimefunItem {

    private Species species;
    private Type type;
    private int lifespan;
    private int speed;
    private ItemStack product;

    public Bee(Category category, String name, String id, Species species, Type type, int lifespan, int speed, ItemStack product) {
        super(category, new CustomItem(Items.BEE_ITEM, name), id, RecipeType.NULL, new ItemStack[] {null, null, null, null, null, null, null, null, null});

        this.species = species;
        this.type = type;
        this.lifespan = lifespan;
        this.speed = speed;
        this.product = product;
    }

    public Species getSpecies() {
        return this.species;
    }

    public Type getType() {
        return this.type;
    }

    public ItemStack getProduct(){
        return this.product;
    }

    public void setProduct(ItemStack item){
        this.product = item;
    }

    public int getLifespan() {
        return this.lifespan;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setLifespan(int lifespan) {
        this.lifespan = lifespan;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

}
