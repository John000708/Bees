package me.john000708.bees.machines;

import me.john000708.bees.BeeItemHandler;
import me.john000708.bees.objects.Bee;
import me.john000708.bees.objects.BeeRecipe;
import me.john000708.bees.objects.Type;
import me.mrCookieSlime.CSCoreLibPlugin.CSCoreLib;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ClickAction;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

import java.util.ArrayList;

/**
 * Created by John on 20.05.2016.
 */
public abstract class Apiary extends SlimefunItem {

    private int[] inputBorder = {0, 1, 10, 19, 27, 28};
    private int[] beeSlotBorder = {2, 3, 4, 6, 7, 8, 11, 13, 14, 15, 17, 20, 21, 22, 24, 25, 26, 29, 31, 32, 33, 35, 38, 39, 40, 42, 43, 44, 47, 53};

    private static ArrayList<BeeRecipe> recipes = new ArrayList<>();

    public Apiary(Category category, ItemStack itemStack, String name, RecipeType recipeType, ItemStack[] recipe) {
        super(category, itemStack, name, recipeType, recipe);

        new BlockMenuPreset(name, "&6Apiary") {

            public void init() {
                constructMenu(this);
            }

            @Override
            public void newInstance(final BlockMenu menu, final Block block) {

            }

            public int[] getSlotsAccessedByItemTransport(ItemTransportFlow flow) {
                if (flow.equals(ItemTransportFlow.INSERT)) return getInputSlots();
                else return getBeeSlots();
            }

            public boolean canOpen(Block block, Player p) {
                return p.hasPermission("slimefun.inventory.bypass") || CSCoreLib.getLib().getProtectionManager().canAccessChest(p.getUniqueId(), block);
            }
        };


    }

    public int[] getBeeSlots() {
        return new int[]{5, 12, 16, 23, 30, 34, 41};
    }

    public int[] getInputSlots() {
        return new int[]{9, 18};
    }

    public static void addBreed(BeeRecipe recipe) {
        recipes.add(recipe);
    }

    public void register(boolean slimefun) {
        addItemHandler(new BlockTicker() {
            @Override
            public boolean isSynchronized() {
                return false;
            }

            @Override
            public void uniqueTick() {

            }

            @Override
            public void tick(Block block, SlimefunItem slimefunItem, Config config) {
                Apiary.this.tick(block);
            }
        });
        super.register(slimefun);
    }

    protected void tick(Block b) {
        BlockMenu menu = BlockStorage.getInventory(b);

        ItemStack princess;
        ItemStack drone;

        for (int i : getInputSlots()) {
            if (menu.getItemInSlot(i) != null) {
                SlimefunItem slimefunItem = SlimefunItem.getByItem(BeeItemHandler.stripStats(menu.getItemInSlot(i)));

                if (slimefunItem == null) return;

                if (slimefunItem instanceof Bee) {
                    Bee bee = (Bee) slimefunItem;

                    if (BeeItemHandler.getStats(bee.getItem()).size() == 0) {
                        menu.replaceExistingItem(i, BeeItemHandler.saveStats(bee.getItem(), 1, 1, 1));
                    }
                    princess = bee.getType() == Type.PRINCESS ? menu.getItemInSlot(i) : null;
                    drone = bee.getType() == Type.DRONE ? menu.getItemInSlot(i) : null;
                }


            }
        }
    }

    @SuppressWarnings("deprecation")
    private void constructMenu(BlockMenuPreset preset) {
        for (int i : inputBorder) {
            preset.addItem(i, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte) 9), " "), new ChestMenu.MenuClickHandler() {
                @Override
                public boolean onClick(Player player, int i, ItemStack itemStack, ClickAction clickAction) {
                    return false;
                }
            });
        }

        for (int i : beeSlotBorder) {
            preset.addItem(i, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte) 15), " "), new ChestMenu.MenuClickHandler() {
                @Override
                public boolean onClick(Player player, int i, ItemStack itemStack, ClickAction clickAction) {
                    return false;
                }
            });
        }
    }
}
