package me.john000708.bees;

import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.CSCoreLibPlugin.general.World.CustomSkull;
import org.bukkit.inventory.ItemStack;

/**
 * Created by John on 20.05.2016.
 */
public class Items {
    public static ItemStack STANDARD_BEE;

    static {
        try {
            STANDARD_BEE = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTQ3MzIyZjgzMWUzYzE2OGNmYmQzZTI4ZmU5MjUxNDRiMjYxZTc5ZWIzOWM3NzEzNDlmYWM1NWE4MTI2NDczIn19fQ==\"}]}}}"), "&6Standard Bee");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
