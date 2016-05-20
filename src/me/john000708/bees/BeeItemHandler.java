package me.john000708.bees;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BeeItemHandler {
	
	// John, rename these args to your stats
	public static ItemStack saveStats(ItemStack item, int arg0, int arg1, int arg2) {
		if (item == null) return null;
		ItemStack stack = item.clone();
		ItemMeta meta = stack.getItemMeta();
		List<String> lore = new ArrayList<String>();
		lore.add("§b§e§e §a" + encode(arg0) + "§b" + encode(arg1) + "§c" + encode(arg2));
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
