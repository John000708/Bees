package me.john000708.bees;

import org.bukkit.plugin.java.JavaPlugin;

import me.john000708.bees.objects.Bee;
import me.john000708.bees.objects.Species;
import me.john000708.bees.objects.Type;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.Slimefun.Objects.Category;

/**
 * Created by John on 20.05.2016.
 */
public class Bees extends JavaPlugin {

    public void onEnable() {
        Category utils = new Category(new CustomItem(Items.APIARY, "§eBee-Keeping - §6Utilities", "", "§a> Click to open"));
        Category bees = new Category(new CustomItem(Items.BEE_ITEM, "§eBee-Keeping - §6Drones & Princesses", "", "§a> Click to open"));
        Category queens = new Category(new CustomItem(Items.BEE_ITEM, "§eBee-Keeping - §6Queens", "", "§a> Click to open"));
        
        new Bee(bees, "&aCommon Drone", Species.COMMON, Type.DRONE, 2, 1).register();
        new Bee(bees, "&aCommon Princess", Species.COMMON, Type.PRINCESS, 2, 1).register();
        new Bee(queens, "&aCommon Queen", Species.COMMON, Type.QUEEN, 2, 1).register();
    }

    public void onDisable() {

    }
}
