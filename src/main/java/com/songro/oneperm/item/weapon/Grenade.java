package com.songro.oneperm.item.weapon;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Grenade {

    public static void giveItem(Player p) {
        ItemStack grenadeItem = new ItemStack(Material.GREEN_CANDLE);
        ItemMeta grenateMeta = grenadeItem.getItemMeta();

        grenateMeta.setDisplayName(ChatColor.DARK_GREEN + "[ 수류탄 ]");
        ArrayList<String> grenadeLore = new ArrayList<>();
        grenadeLore.add(ChatColor.GOLD + "일반적인 수류탄");
        grenadeLore.add("");
        grenadeLore.add(ChatColor.GOLD + "타이머: 3초");
        grenadeLore.add(ChatColor.GOLD + "사용 방법: 던지고 3초동안 기다리면 터집니다.");
        grenadeLore.add(ChatColor.GOLD + "폭파 반경: 3B");
        grenateMeta.setLore(grenadeLore);

        grenadeItem.setItemMeta(grenateMeta);

        p.getInventory().addItem(grenadeItem);

    }

    public ItemStack returnGrenade() {
        ItemStack grenadeItem = new ItemStack(Material.GREEN_CANDLE);
        ItemMeta grenateMeta = grenadeItem.getItemMeta();

        grenateMeta.setDisplayName(ChatColor.DARK_GREEN + "[ 수류탄 ]");
        ArrayList<String> grenadeLore = new ArrayList<>();
        grenadeLore.add(ChatColor.GOLD + "일반적인 수류탄");
        grenadeLore.add("");
        grenadeLore.add(ChatColor.GOLD + "타이머: 3초");
        grenadeLore.add(ChatColor.GOLD + "사용 방법: 던지고 3초동안 기다리면 터집니다.");
        grenadeLore.add(ChatColor.GOLD + "폭파 반경: 3B");
        grenateMeta.setLore(grenadeLore);

        grenadeItem.setItemMeta(grenateMeta);

        return grenadeItem;
    }

}
