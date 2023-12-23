package com.songro.oneperm.recipe.drug;

import com.songro.oneperm.util.maxStack;
import io.papermc.paper.entity.TeleportFlag;
import io.papermc.paper.threadedregions.scheduler.EntityScheduler;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.util.TriState;
import org.bukkit.*;
import org.bukkit.block.BlockFace;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Logger;

import static com.songro.oneperm.OnePerm.plugin;

public class weed {

    public ItemStack weedItem() {

        ItemStack weed = new ItemStack(Material.SUGAR, 1);
        ItemMeta weedMeta = weed.getItemMeta();

        weedMeta.setDisplayName(ChatColor.RED + "[ 대막초 ]");

        ArrayList<String> weedLore = new ArrayList<>();
        weedLore.add(ChatColor.GOLD + "정신건강에 좋진 않지만, 단기간에 회복을 할수 있다.");
        weedLore.add("");
        weedLore.add(ChatColor.GOLD + "[ (공중에 보면서) 우클릭 시: 회복 효과 (15초) +  " + ChatColor.GRAY + "???" + ChatColor.GOLD + " ]");
        weedLore.add(ChatColor.GOLD + "[ 등급: " + ChatColor.RED + "위험" + ChatColor.GOLD + " ]");

        weedMeta.setLore(weedLore);
        weedMeta.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
        weedMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        weedMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        weed.setItemMeta(weedMeta);

        return weed;
    }

    public void recipe() {
        {
            NamespacedKey key = new NamespacedKey(plugin, "mafiaweed");
            ShapedRecipe recipe = new ShapedRecipe(key, new weed().weedItem());
            recipe.shape("ASA", "SZS", "ASA");
            recipe.setIngredient('A', Material.AIR);
            recipe.setIngredient('Z', Material.JUNGLE_LEAVES);
            recipe.setIngredient('S', Material.OAK_LEAVES);

            Bukkit.addRecipe(recipe);
        }
    }

}
