package me.john000708.bees;

import me.john000708.bees.machines.Apiary;
import me.john000708.bees.objects.Bee;
import me.john000708.bees.objects.Species;
import me.john000708.bees.objects.Type;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by John on 20.05.2016.
 */
public class Bees extends JavaPlugin {

    public void onEnable() {
        Category utils = new Category(new CustomItem(Items.APIARY, "&eBee-Keeping - &6Utilities", "", "&a> Click to open"));
        Category bees = new Category(new CustomItem(Items.BEE_ITEM, "&eBee-Keeping - &6Drones & Princesses", "", "&a> Click to open"));
        Category queens = new Category(new CustomItem(Items.BEE_ITEM, "&eBee-Keeping - &6Queens", "", "&a> Click to open"));

        new Bee(bees, "&aCommon Drone", "COMMON_DRONE", Species.COMMON, Type.DRONE, 1, 1).register();
        new Bee(bees, "&aCommon Princess", "COMMON_PRINCESS", Species.COMMON, Type.PRINCESS, 1, 1).register();
        new Bee(queens, "&aCommon Queen", "COMMON_QUEEN", Species.COMMON, Type.QUEEN, 1, 1).register();
        new Apiary(utils, new CustomItem(Items.APIARY, "&6Apiary"), "APIARY", RecipeType.NULL, new ItemStack[]{null, null, null, null, null, null, null, null, null}) {

        }.register();
    }

    public void onDisable() {

    }
}
