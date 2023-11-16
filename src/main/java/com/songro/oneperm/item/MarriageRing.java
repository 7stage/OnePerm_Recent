package com.songro.oneperm.item;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class MarriageRing {

    public static void giveItem(Player p) {
        ItemStack ring = new ItemStack(Material.HEART_OF_THE_SEA);
        ItemMeta ringMeta = ring.getItemMeta();

        ringMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ringMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "[ 결혼 반지 ]");
        ArrayList<String> ringLore = new ArrayList<>();
        ringLore.add(ChatColor.GOLD  + "다이아몬드로 만들어진 반지이다.");
        ringLore.add("");
        ringLore.add(ChatColor.GOLD + "사용방법: 신청할 플레이어를 보고 우클릭하세요.");
        ringMeta.setLore(ringLore);
        ringMeta.addEnchant(Enchantment.LUCK, 1, true);
        ringMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        ring.setItemMeta(ringMeta);

        p.getInventory().addItem(ring);
    }

}
