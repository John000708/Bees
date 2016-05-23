package me.john000708.bees;

import me.john000708.bees.lists.Honeycombs;
import me.john000708.bees.machines.Apiary;
import me.john000708.bees.objects.Bee;
import me.john000708.bees.objects.Species;
import me.john000708.bees.objects.Type;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by John on 20.05.2016.
 */
public class Bees extends JavaPlugin {
    public static Category bees;
    public static Category utils;

    public void onEnable() {
        bees = new Category(new CustomItem(Items.BEE_ITEM, "&eBee-Keeping - &6Drones & Princesses", "", "&a> Click to open"));
        utils = new Category(new CustomItem(Items.APIARY, "&eBee-Keeping - &6Utilities", "", "&a> Click to open"));

        new Bee(bees, "&aCommon Princess", "COMMON_PRINCESS", Species.COMMON, Type.PRINCESS, 1, 1, Honeycombs.COMMON_COMB).register();
        new Bee(bees, "&aCommon Drone", "COMMON_DRONE", Species.COMMON, Type.DRONE, 1, 1, Honeycombs.COMMON_COMB).register();

        new Bee(bees, "&aForest Princess", "FOREST_PRINCESS", Species.FOREST, Type.PRINCESS, 1, 1, Honeycombs.FOREST_COMB).register();
        new Bee(bees, "&aForest Drone", "FOREST_DRONE", Species.FOREST, Type.DRONE, 1, 1, Honeycombs.FOREST_COMB).register();

        new Bee(bees, "&aMeadows Princess", "MEADOWS_PRINCESS", Species.MEADOWS, Type.PRINCESS, 1, 1, Honeycombs.MEADOWS_COMB).register();
        new Bee(bees, "&aMeadows Drone", "MEADOWS_DRONE", Species.MEADOWS, Type.DRONE, 1, 1, Honeycombs.MEADOWS_COMB).register();

        new Bee(bees, "&aModest Princess", "MODEST_PRINCESS", Species.MODEST, Type.PRINCESS, 1, 1, Honeycombs.MODEST_COMB).register();
        new Bee(bees, "&aModest Drone", "MODEST_DRONE", Species.MODEST, Type.DRONE, 1, 1, Honeycombs.MODEST_COMB).register();

        new Bee(bees, "&aNoble Princess", "NOBLE_PRINCESS", Species.NOBLE, Type.PRINCESS, 1, 1, Honeycombs.NOBLE_COMB).register();
        new Bee(bees, "&aNoble Drone", "NOBLE_DRONE", Species.NOBLE, Type.DRONE, 1, 1, Honeycombs.NOBLE_COMB);

        new Bee(bees, "&aWater Princess", "WATER_PRINCESS", Species.WATER, Type.PRINCESS, 1, 1, Honeycombs.WATER_COMB).register();
        new Bee(bees, "&aWater Drone", "WATER_DRONE", Species.WATER, Type.DRONE, 1, 1, Honeycombs.WATER_COMB).register();

        new Bee(bees, "&aSinister Princess", "SINISTER_PRINCESS", Species.SINISTER, Type.PRINCESS, 1, 1, Honeycombs.SINISTER_COMB).register();
        new Bee(bees, "&aSinister Drone", "SINISTER_DRONE", Species.SINISTER, Type.DRONE, 1, 1, Honeycombs.SINISTER_COMB).register();

        new Bee(bees, "&aRural Princess", "RURAL_PRINCESS", Species.RURAL, Type.PRINCESS, 1, 1, Honeycombs.RURAL_COMB).register();
        new Bee(bees, "&aRural Drone", "RURAL_DRONE", Species.RURAL, Type.DRONE, 1, 1, Honeycombs.RURAL_COMB).register();

        new Apiary(utils, new CustomItem(Items.APIARY, "&6Apiary"), "APIARY", RecipeType.NULL, new ItemStack[]{null, null, null, null, null, null, null, null, null}) {

        }.register();
    }

    public void onDisable() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("getStats")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;

                if (player.getInventory().getItem(player.getInventory().getHeldItemSlot()) != null) {
                    ItemStack heldItem = player.getInventory().getItem(player.getInventory().getHeldItemSlot());
                    if (SlimefunItem.getByItem(BeeItemHandler.stripStats(heldItem)) != null) {
                        SlimefunItem item = SlimefunItem.getByItem(BeeItemHandler.stripStats(heldItem));

                        if (item instanceof Bee) {
                            Bee bee = (Bee)item;

                            player.sendMessage("Species: " + bee.getSpecies().name());
                            player.sendMessage("Product: " + bee.getProduct().getItemMeta().getDisplayName());
                            player.sendMessage("Fertility: " + BeeItemHandler.getStats(heldItem).get(0));
                            player.sendMessage("Lifespan: " + BeeItemHandler.getStats(heldItem).get(1));
                            player.sendMessage("Productivity: " + BeeItemHandler.getStats(heldItem).get(2));
                        }
                    }
                }
            }
        }
        return true;
    }
}
