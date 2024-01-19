package com.songro.oneperm.util;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class CreateItem {

    /*
    Creates an item with custom title and lore
     */
    public ItemStack createItem(Material material, int amount, String displayName, String mainDesc, String startRole, int payDay, boolean canChangeRole) {

        ItemStack roleItem = new ItemStack(material, amount);
        ItemMeta roleMeta = roleItem.getItemMeta();

        roleMeta.setDisplayName(displayName);
        ArrayList<String> itemLore = new ArrayList<>();
        itemLore.add(ChatColor.WHITE + mainDesc);
        itemLore.add("");
        itemLore.add(ChatColor.GOLD + "시작 역할: " + startRole);
        if (payDay > 0) {
            itemLore.add(ChatColor.GOLD + "월급: " + ChatColor.GREEN + payDay + ChatColor.GOLD + " 부터 시작");
        } else {
            itemLore.add(ChatColor.GOLD + "월급: " + ChatColor.RED + "X");
        }
        if(canChangeRole) {
            return roleItem;
        } else {
            itemLore.add("");
            itemLore.add(ChatColor.YELLOW + "경고: 이 역할을 선택하면 다시는 역할을 변경할 수 없습니다.");
        }
        roleMeta.setLore(itemLore);
        roleItem.setItemMeta(roleMeta);

        return roleItem;
    }
}
