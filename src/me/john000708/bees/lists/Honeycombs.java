package me.john000708.bees.lists;

import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.CSCoreLibPlugin.general.World.CustomSkull;
import org.bukkit.inventory.ItemStack;

/**
 * Created by John on 22.05.2016.
 */
public class Honeycombs {
    public static ItemStack BASE_COMB;

    public static ItemStack COMMON_COMB;
    public static ItemStack FOREST_COMB;
    public static ItemStack MODEST_COMB;
    public static ItemStack MEADOWS_COMB;
    public static ItemStack NOBLE_COMB;
    public static ItemStack WATER_COMB;
    public static ItemStack SINISTER_COMB;
    public static ItemStack RURAL_COMB;

    static {
        try {
            BASE_COMB = CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDE1NDkxMzJkYmM4NzVkNjM5ZDY3ZDkzY2M3MTNlOTQxYmIxNmM5NjRkMGE2MmU4YzY3OTRiZDNkZTZmZjgifX19");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        COMMON_COMB = new CustomItem(BASE_COMB, "&aCommon Comb");
        FOREST_COMB = new CustomItem(BASE_COMB, "&aForest Comb");
        MODEST_COMB = new CustomItem(BASE_COMB, "&aModest Comb");
        MEADOWS_COMB = new CustomItem(BASE_COMB, "&aMeadows Comb");
        NOBLE_COMB = new CustomItem(BASE_COMB, "&aNoble Comb");
        WATER_COMB = new CustomItem(BASE_COMB, "&aWater Comb");
        SINISTER_COMB = new CustomItem(BASE_COMB, "&aSinister Comb");
        RURAL_COMB = new CustomItem(BASE_COMB, "&aRural Comb");
    }
}
