package me.john000708.bees;

import me.john000708.bees.objects.Bee;
import me.john000708.bees.objects.Gender;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.Slimefun.Objects.Category;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by John on 20.05.2016.
 */
public class Bees extends JavaPlugin {
    public static Category beeCat;

    public void onEnable() {
        beeCat = new Category(new CustomItem(Items.STANDARD_BEE.clone(), "&aBees"));
        new Bee(beeCat, new CustomItem(Items.STANDARD_BEE.clone()), "&6Sligtly Modified Bee", "COMMON", Gender.FEMALE, 2, 1).register();
    }

    public void onDisable() {

    }
}
