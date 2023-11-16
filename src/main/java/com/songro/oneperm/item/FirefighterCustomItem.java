package com.songro.oneperm.item;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class FirefighterCustomItem {
    public static void giveFireItem(Player p) {
        ItemStack fireTopItem = new ItemStack(Material.LEATHER_HELMET);
        ItemStack fireBottomItem = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemStack firePantsItem = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemStack fireShoesItem = new ItemStack(Material.DIAMOND_BOOTS);

        ItemMeta fireTopmeta = fireTopItem.getItemMeta();
        ItemMeta fireBottonMeta = fireBottomItem.getItemMeta();
        ItemMeta firePantsMeta = firePantsItem.getItemMeta();
        ItemMeta fireShoesMeta = fireShoesItem.getItemMeta();

        fireTopmeta.setDisplayName(ChatColor.RED + "[ 소방관 모자 ]");
        ArrayList<String> fireTopLore = new ArrayList<>();
        fireTopLore.add(ChatColor.GOLD + "소방관 기본 보급품이다.");
        fireTopLore.add("");
        fireTopLore.add(ChatColor.GOLD + "+ 부서지지 않음");
        fireTopLore.add(ChatColor.GOLD + "+ 불에 있을시 데미지 감소");
        fireTopmeta.setLore(fireTopLore);
        fireTopmeta.setUnbreakable(true);
        fireTopmeta.addEnchant(Enchantment.PROTECTION_FIRE, 1, true);
        fireTopmeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        fireTopmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        fireBottonMeta.setDisplayName(ChatColor.RED + "[ 소방관 옷 ]");
        ArrayList<String> fireBottomLore = new ArrayList<>();
        fireBottomLore.add(ChatColor.GOLD + "소방관 기본 보급품이다.");
        fireBottomLore.add("");
        fireBottomLore.add(ChatColor.GOLD + "+ 부서지지 않음");
        fireBottomLore.add(ChatColor.GOLD + "+ 불에 있을시 데미지 감소");
        fireBottonMeta.setLore(fireBottomLore);
        fireBottonMeta.setUnbreakable(true);
        fireBottonMeta.addEnchant(Enchantment.PROTECTION_FIRE, 1, true);
        fireBottonMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        fireBottonMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        firePantsMeta.setDisplayName(ChatColor.RED + "[ 소방관 바지 ]");
        ArrayList<String> firePantsLore = new ArrayList<>();
        firePantsLore.add(ChatColor.GOLD + "소방관 기본 보급품이다.");
        firePantsLore.add("");
        firePantsLore.add(ChatColor.GOLD + "+ 부서지지 않음");
        firePantsLore.add(ChatColor.GOLD + "+ 불에 있을시 데미지 감소");
        firePantsMeta.setLore(firePantsLore);
        firePantsMeta.setUnbreakable(true);
        firePantsMeta.addEnchant(Enchantment.PROTECTION_FIRE, 1, true);
        firePantsMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        firePantsMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        fireShoesMeta.setDisplayName(ChatColor.RED + "[ 소방관 신발 ]");
        ArrayList<String> fireShoesLore = new ArrayList<>();
        fireShoesLore.add(ChatColor.GOLD + "소방관 기본 보급품이다.");
        fireShoesLore.add("");
        fireShoesLore.add(ChatColor.GOLD + "+ 부서지지 않음");
        fireShoesLore.add(ChatColor.GOLD + "+ 불에 있을시 데미지 감소");
        fireShoesMeta.setLore(fireShoesLore);
        fireShoesMeta.setUnbreakable(true);
        fireShoesMeta.addEnchant(Enchantment.PROTECTION_FIRE, 1, true);
        fireShoesMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        fireShoesMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        fireTopItem.setItemMeta(fireTopmeta);
        fireBottomItem.setItemMeta(fireBottonMeta);
        firePantsItem.setItemMeta(firePantsMeta);
        fireShoesItem.setItemMeta(fireShoesMeta);

        p.getInventory().addItem(fireTopItem);
        p.getInventory().addItem(fireBottomItem);
        p.getInventory().addItem(firePantsItem);
        p.getInventory().addItem(fireShoesItem);
    }

}
