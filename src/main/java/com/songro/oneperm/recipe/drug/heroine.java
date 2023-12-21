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

import static com.songro.oneperm.OnePerm.plugin;

public class heroine {

    public ItemStack heroineitem() {

        ItemStack herobine = new ItemStack(Material.SUGAR, 1);
        ItemMeta herobineMeta = herobine.getItemMeta();

        herobineMeta.setDisplayName(ChatColor.RED + "[ 히로빈 ]");

        ArrayList<String> herobineLore = new ArrayList<>();
        herobineLore.add(ChatColor.GOLD + "정신건강에 좋진 않지만, 각성제이기도 하다.");
        herobineLore.add("");
        herobineLore.add(ChatColor.GOLD + "[ 우클릭 시: 회복 효과 (15초) +  " + ChatColor.GRAY + "???" + ChatColor.GOLD + " ]");
        herobineLore.add(ChatColor.GOLD + "[ 등급: " + ChatColor.RED + "위험" + ChatColor.GOLD + " ]");

        herobineMeta.setLore(herobineLore);
        herobineMeta.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
        herobineMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        herobineMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        herobine.setItemMeta(herobineMeta);

        return herobine;
    }

    public void recipe() {
        {
            NamespacedKey key = new NamespacedKey(plugin, "mafiaherobine");
            ShapedRecipe recipe = new ShapedRecipe(key, new heroine().heroineitem());
            recipe.shape("ASA", "SZS", "ASA");
            recipe.setIngredient('A', Material.AIR);
            recipe.setIngredient('Z', Material.SUGAR);
            recipe.setIngredient('S', Material.OAK_LEAVES);

            Bukkit.addRecipe(recipe);
        }
    }

}
