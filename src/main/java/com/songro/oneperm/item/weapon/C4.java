package com.songro.oneperm.item.weapon;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class C4 {

    public static void giveItem(Player p) {
        ItemStack grenadeItem = new ItemStack(Material.GREEN_CANDLE);
        ItemMeta grenateMeta = grenadeItem.getItemMeta();

        grenateMeta.setDisplayName(ChatColor.DARK_GREEN + "[ 원격폭탄장치 ]");
        ArrayList<String> grenadeLore = new ArrayList<>();
        grenadeLore.add(ChatColor.GOLD + "원격으로 터트릴수 있는 폭탄");
        grenadeLore.add("");
        grenadeLore.add(ChatColor.GOLD + "타이머: " + ChatColor.RED + "X (존재하지 않음)");
        grenadeLore.add(ChatColor.GOLD + "사용방법: 현재 상 작동불가");
        grenadeLore.add(ChatColor.GOLD + "폭파 반경: 5B");
        grenateMeta.setLore(grenadeLore);

        grenadeItem.setItemMeta(grenateMeta);

        p.getInventory().addItem(grenadeItem);

    }

    public ItemStack returnC4() {
        ItemStack c4Item = new ItemStack(Material.GREEN_CANDLE);
        ItemMeta c4Meta = c4Item.getItemMeta();

        c4Meta.setDisplayName(ChatColor.DARK_GREEN + "[ 원격폭탄장치 ]");
        ArrayList<String> grenadeLore = new ArrayList<>();
        grenadeLore.add(ChatColor.GOLD + "원격으로 터트릴수 있는 폭탄");
        grenadeLore.add("");
        grenadeLore.add(ChatColor.GOLD + "타이머: " + ChatColor.RED + "X (존재하지 않음)");
        grenadeLore.add(ChatColor.GOLD + "사용방법: 현재 상 작동불가");
        grenadeLore.add(ChatColor.GOLD + "폭파 반경: 5B");
        c4Meta.setLore(grenadeLore);

        c4Item.setItemMeta(c4Meta);

        return c4Item;
    }

}
