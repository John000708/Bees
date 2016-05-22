package me.john000708.bees.machines;

import me.mrCookieSlime.CSCoreLibPlugin.CSCoreLib;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ClickAction;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.CSCoreLibPlugin.general.Particles.MC_1_8.ParticleEffect;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

/**
 * Created by John on 20.05.2016.
 */
public abstract class Apiary extends SlimefunItem {

    private int[] inputBorder = {0, 1, 10, 19, 27, 28};
    private int[] beeSlotBorder = {2, 3, 4, 6, 7, 8, 11, 13, 14, 15, 17, 20, 21, 22, 24, 25, 26, 29, 31, 32, 33, 35, 38, 39, 40, 42, 43, 44, 47, 53};

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

    protected void tick(Block b) {
        BlockMenu menu = BlockStorage.getInventory(b);

        for (int i : getInputSlots()) {

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
