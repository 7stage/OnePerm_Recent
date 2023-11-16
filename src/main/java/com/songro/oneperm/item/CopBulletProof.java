package com.songro.oneperm.item;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class CopBulletProof {
    public static void giveItem(Player p) {

        ItemStack bulletProof = new ItemStack(Material.NETHERITE_CHESTPLATE);
        ItemMeta bulletMeta = bulletProof.getItemMeta();

        bulletMeta.setUnbreakable(true);
        bulletMeta.setDisplayName(ChatColor.DARK_BLUE + "[ 경찰용 방탄복 ]");
        bulletMeta.setUnbreakable(true);
        ArrayList<String> bulletProofLore = new ArrayList<>();
        bulletProofLore.add(ChatColor.GOLD + "경찰용 방탄복이다.");
        bulletProofLore.add("");
        bulletProofLore.add(ChatColor.GOLD + "+ 총알 데미지 감소");
        bulletProofLore.add(ChatColor.GOLD + "+ 폭파 데미지 감소");
        bulletMeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 5, true);
        bulletMeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 5, true);
        bulletMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        bulletMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        bulletMeta.setLore(bulletProofLore);

        bulletProof.setItemMeta(bulletMeta);

        p.getInventory().addItem(bulletProof);
    }

    public ItemStack returnItem() {
        ItemStack bulletProof = new ItemStack(Material.NETHERITE_CHESTPLATE);
        ItemMeta bulletMeta = bulletProof.getItemMeta();

        bulletMeta.setUnbreakable(true);
        bulletMeta.setDisplayName(ChatColor.DARK_BLUE + "[ 경찰용 방탄복 ]");
        bulletMeta.setUnbreakable(true);
        ArrayList<String> bulletProofLore = new ArrayList<>();
        bulletProofLore.add(ChatColor.GOLD + "경찰용 방탄복이다.");
        bulletProofLore.add("");
        bulletProofLore.add(ChatColor.GOLD + "+ 총알 데미지 감소");
        bulletProofLore.add(ChatColor.GOLD + "+ 폭파 데미지 감소");
        bulletMeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 5, true);
        bulletMeta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 5, true);
        bulletMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        bulletMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        bulletMeta.setLore(bulletProofLore);

        bulletProof.setItemMeta(bulletMeta);

        return bulletProof;
    }

}
