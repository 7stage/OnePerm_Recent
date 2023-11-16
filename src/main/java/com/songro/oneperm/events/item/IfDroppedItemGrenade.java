package com.songro.oneperm.events.item;

import com.songro.oneperm.OnePerm;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class IfDroppedItemGrenade implements Listener {

    @EventHandler
    public void ifDroppedItem(PlayerDropItemEvent e) {
        Player player = e.getPlayer();
        Location explosionLoc = e.getItemDrop().getLocation();

        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(OnePerm.plugin, () -> {
            if(e.getItemDrop().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_GREEN + "[ 수류탄 ]")) {
                player.getWorld().createExplosion(explosionLoc, 10, false); // v = explosionRadius, b = isitsafe
                e.getItemDrop().remove();
            }
        }, 60);
    }

    @EventHandler
    public void onPlayerPickUpEvent(PlayerPickupItemEvent e) {
        if(e.getItem().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_GREEN + "[ 수류탄 ]")) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlaceGrenade(BlockPlaceEvent e) {
        if(e.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_GREEN + "[ 수류탄 ]")) {
            e.setCancelled(true);
        }
    }

}
