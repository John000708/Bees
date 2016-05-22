package me.john000708.bees;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BeeItemHandler {
	
	public static ItemStack saveStats(ItemStack item, int fertility, int lifespan, int productivity) {
		if (item == null) return null;
		ItemStack stack = item.clone();
		ItemMeta meta = stack.getItemMeta();
		List<String> lore = new ArrayList<String>();
		if (meta.hasLore() && meta.getLore().size() > 0) {
			lore = meta.getLore();
			lore.set(0, "§b§e§e §a" + encode(fertility) + "§b" + encode(lifespan) + "§c" + encode(productivity));
		}
		else {
			lore.add("§b§e§e §a" + encode(fertility) + "§b" + encode(lifespan) + "§c" + encode(productivity));
		}
		meta.setLore(lore);
		stack.setItemMeta(meta);
		return stack;
	}

	public static List<Integer> getStats(ItemStack item) {
		if (item == null || !item.hasItemMeta() || !item.getItemMeta().hasLore() || item.getItemMeta().getLore().isEmpty()) return new ArrayList<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		String data = item.getItemMeta().getLore().get(0).replace("§b§e§e ", "");

		list.add(Integer.parseInt(data.replace("§a", "").split("§b")[0].replaceAll("§", "")));
		list.add(Integer.parseInt(data.split("§b")[1].split("§c")[0].replaceAll("§", "")));
		list.add(Integer.parseInt(data.split("§c")[1].replaceAll("§", "")));

		return list;
	}

	private static String encode(int n) {
		StringBuilder builder = new StringBuilder("");
		String s = String.valueOf(n);
		for (int i = 0; i < s.length(); i++) {
			builder.append("§" + s.charAt(i));
		}
		return builder.toString();
	}

}
