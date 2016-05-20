package me.john000708.bees;

import org.bukkit.inventory.ItemStack;

import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.CSCoreLibPlugin.general.World.CustomSkull;

/**
 * Created by John on 20.05.2016.
 */
public class Items {
	
    public static ItemStack BEE_ITEM;
    public static ItemStack APIARY;

    static {
        try {
        	BEE_ITEM = CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTQ3MzIyZjgzMWUzYzE2OGNmYmQzZTI4ZmU5MjUxNDRiMjYxZTc5ZWIzOWM3NzEzNDlmYWM1NWE4MTI2NDczIn19fQ==");
        	APIARY = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTI5NmMwMzUyYzFmMjllNjg1OTg2YWNkZTg3NTk0MmNiNTU0YzVhYzEzOTc1MzhhNTI2NzUyYWRlOTU5NjU0In19fQ=="), "§6Apiary");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
