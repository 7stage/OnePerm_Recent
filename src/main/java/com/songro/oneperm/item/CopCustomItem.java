package com.songro.oneperm.item;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class CopCustomItem {
    public static void giveCopItem(Player p) {
        ItemStack copTopItem = new ItemStack(Material.DIAMOND_HELMET);
        ItemStack copBottomItem = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemStack copPantsItem = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemStack copShoesItem = new ItemStack(Material.DIAMOND_BOOTS);
        ItemStack copStick = new ItemStack(Material.STICK);

        ItemMeta copTopMeta = copTopItem.getItemMeta();
        ItemMeta copBottomMeta = copBottomItem.getItemMeta();
        ItemMeta copPantsMeta = copPantsItem.getItemMeta();
        ItemMeta copShoesMeta = copShoesItem.getItemMeta();
        ItemMeta copStickMeta = copStick.getItemMeta();

        copTopMeta.setDisplayName(ChatColor.BLUE + "[ 경찰 모자 ]");
        ArrayList<String> copTopLore = new ArrayList<>();
        copTopLore.add(ChatColor.GOLD + "경찰 기본 보급품이다.");
        copTopLore.add("");
        copTopLore.add(ChatColor.GOLD + "+ 부서지지 않음");
        copTopMeta.setLore(copTopLore);
        copTopMeta.setUnbreakable(true);
        copTopMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        copBottomMeta.setDisplayName(ChatColor.BLUE + "[ 경찰 갑옷 ]");
        ArrayList<String> copBottomLore = new ArrayList<>();
        copBottomLore.add(ChatColor.GOLD + "경찰 기본 보급품이다.");
        copBottomLore.add("");
        copBottomLore.add(ChatColor.GOLD + "+ 부서지지 않음");
        copBottomMeta.setLore(copBottomLore);
        copBottomMeta.setUnbreakable(true);
        copBottomMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        copPantsMeta.setDisplayName(ChatColor.BLUE + "[ 경찰 바지 ]");
        ArrayList<String> copPantsLore = new ArrayList<>();
        copPantsLore.add(ChatColor.GOLD + "경찰 기본 보급품이다.");
        copPantsLore.add("");
        copPantsLore.add(ChatColor.GOLD + "+ 부서지지 않음");
        copPantsMeta.setLore(copPantsLore);
        copPantsMeta.setUnbreakable(true);
        copPantsMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        copShoesMeta.setDisplayName(ChatColor.BLUE + "[ 경찰 신발 ]");
        ArrayList<String> copShoesLore = new ArrayList<>();
        copShoesLore.add(ChatColor.GOLD + "경찰 기본 보급품이다.");
        copShoesLore.add("");
        copShoesLore.add(ChatColor.GOLD + "+ 부서지지 않음");
        copShoesMeta.setLore(copShoesLore);
        copShoesMeta.setUnbreakable(true);
        copShoesMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        copStickMeta.setDisplayName("[ 제압봉 ]");
        ArrayList<String> copStickLore = new ArrayList<>();
        copStickLore.add(ChatColor.GOLD + "경찰 기본 보급품이다.");
        copStickLore.add("");
        copStickLore.add(ChatColor.GOLD + "+ 부서지지 않음");
        copStickMeta.setLore(copStickLore);
        copStickMeta.addEnchant(Enchantment.KNOCKBACK, 1, true);
        copStickMeta.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
        copStickMeta.setUnbreakable(true);
        copStickMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        copStickMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        copStickMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);


        copTopItem.setItemMeta(copTopMeta);
        copBottomItem.setItemMeta(copBottomMeta);
        copPantsItem.setItemMeta(copPantsMeta);
        copShoesItem.setItemMeta(copShoesMeta);
        copStick.setItemMeta(copStickMeta);

        p.getInventory().addItem(copTopItem);
        p.getInventory().addItem(copBottomItem);
        p.getInventory().addItem(copPantsItem);
        p.getInventory().addItem(copShoesItem);
        p.getInventory().addItem(copStick);
    }

    /*
    Return Item for GUI
     */
    public ItemStack returnCopTopItem() {
        ItemStack copTopItem = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta copTopMeta = copTopItem.getItemMeta();

        copTopMeta.setDisplayName(ChatColor.BLUE + "[ 경찰 모자 ]");
        ArrayList<String> copTopLore = new ArrayList<>();
        copTopLore.add(ChatColor.GOLD + "경찰 기본 보급품이다.");
        copTopLore.add("");
        copTopLore.add(ChatColor.GOLD + "+ 부서지지 않음");
        copTopMeta.setLore(copTopLore);
        copTopMeta.setUnbreakable(true);
        copTopMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        copTopItem.setItemMeta(copTopMeta);

        return copTopItem;
    }
    public ItemStack returnCopBottomItem() {
        ItemStack copBottomItem = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta copBottomMeta = copBottomItem.getItemMeta();

        copBottomMeta.setDisplayName(ChatColor.BLUE + "[ 경찰 갑옷 ]");
        ArrayList<String> copBottomLore = new ArrayList<>();
        copBottomLore.add(ChatColor.GOLD + "경찰 기본 보급품이다.");
        copBottomLore.add("");
        copBottomLore.add(ChatColor.GOLD + "+ 부서지지 않음");
        copBottomMeta.setLore(copBottomLore);
        copBottomMeta.setUnbreakable(true);
        copBottomMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        copBottomItem.setItemMeta(copBottomMeta);

        return copBottomItem;
    }
    public ItemStack retrunCopPantsItem() {
        ItemStack copPantsItem = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta copPantsMeta = copPantsItem.getItemMeta();

        copPantsMeta.setDisplayName(ChatColor.BLUE + "[ 경찰 바지 ]");
        ArrayList<String> copPantsLore = new ArrayList<>();
        copPantsLore.add(ChatColor.GOLD + "경찰 기본 보급품이다.");
        copPantsLore.add("");
        copPantsLore.add(ChatColor.GOLD + "+ 부서지지 않음");
        copPantsMeta.setLore(copPantsLore);
        copPantsMeta.setUnbreakable(true);
        copPantsMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        copPantsItem.setItemMeta(copPantsMeta);

        return copPantsItem;
    }
    public ItemStack returnCopShoesItem() {
        ItemStack copShoesItem = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta copShoesMeta = copShoesItem.getItemMeta();

        copShoesMeta.setDisplayName(ChatColor.BLUE + "[ 경찰 신발 ]");
        ArrayList<String> copShoesLore = new ArrayList<>();
        copShoesLore.add(ChatColor.GOLD + "경찰 기본 보급품이다.");
        copShoesLore.add("");
        copShoesLore.add(ChatColor.GOLD + "+ 부서지지 않음");
        copShoesMeta.setLore(copShoesLore);
        copShoesMeta.setUnbreakable(true);
        copShoesMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        copShoesItem.setItemMeta(copShoesMeta);

        return copShoesItem;
    }
    public ItemStack returnCopStickItem() {
        ItemStack copStickItem = new ItemStack(Material.STICK);
        ItemMeta copStickMeta = copStickItem.getItemMeta();

        copStickMeta.setDisplayName("[ 제압봉 ]");
        ArrayList<String> copStickLore = new ArrayList<>();
        copStickLore.add(ChatColor.GOLD + "경찰 기본 보급품이다.");
        copStickLore.add("");
        copStickLore.add(ChatColor.GOLD + "+ 부서지지 않음");
        copStickMeta.setLore(copStickLore);
        copStickMeta.addEnchant(Enchantment.KNOCKBACK, 1, true);
        copStickMeta.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
        copStickMeta.setUnbreakable(true);
        copStickMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        copStickMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        copStickMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        copStickItem.setItemMeta(copStickMeta);

        return copStickItem;
    }

}
