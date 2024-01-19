package com.songro.oneperm.recipe.drug;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.logging.Logger;

import static com.songro.oneperm.OnePerm.plugin;

public class cocaine {

    public ItemStack cocaineitem() {

        ItemStack cocaine = new ItemStack(Material.SUGAR, 1);
        ItemMeta cocaineMeta = cocaine.getItemMeta();

        cocaineMeta.setDisplayName(ChatColor.RED + "[ 코케인 ]");

        ArrayList<String> cocaineLore = new ArrayList<>();
        cocaineLore.add(ChatColor.GOLD + "정신건강에 좋진 않지만, 각성제이기도 하다.");
        cocaineLore.add("");
        cocaineLore.add(ChatColor.GOLD + "[ (공중에 보면서) 우클릭 시: 회복 효과 (15초) +  " + ChatColor.GRAY + "???" + ChatColor.GOLD + " ]");
        cocaineLore.add(ChatColor.GOLD + "[ 등급: " + ChatColor.RED + "위험" + ChatColor.GOLD + " ]");

        cocaineMeta.setLore(cocaineLore);
        cocaineMeta.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
        cocaineMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        cocaineMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        cocaine.setItemMeta(cocaineMeta);

        return cocaine;
    }

    public void recipe() {
        {
            NamespacedKey key = new NamespacedKey(plugin, "maifacocaine");
            ShapedRecipe recipe = new ShapedRecipe(key, new cocaine().cocaineitem());
            recipe.shape("ASA", "SZS", "ASA");
            recipe.setIngredient('A', Material.AIR);
            recipe.setIngredient('Z', Material.SUGAR);
            recipe.setIngredient('S', Material.OAK_LEAVES);

            Bukkit.addRecipe(recipe);
        }
    }

}
