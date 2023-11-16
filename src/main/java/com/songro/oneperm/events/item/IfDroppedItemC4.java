package com.songro.oneperm.events.item;

import com.songro.oneperm.OnePerm;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

import java.util.logging.Logger;

public class IfDroppedItemC4 implements Listener {

    @EventHandler
    public void ifDroppedItem(PlayerDropItemEvent e, PlayerInteractEvent e2) {
        Player player = e.getPlayer();
        Location explosionLoc = e.getItemDrop().getLocation();
        Logger log = Bukkit.getLogger();
    }


    @EventHandler
    public void onPlayerPickUpEvent(PlayerPickupItemEvent e) {
        if(e.getItem().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_GREEN + "[ 원격폭탄장치 ]")) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlaceGrenade(BlockPlaceEvent e) {
        if(e.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_GREEN + "[ 원격폭탄장치 ]")) {
            e.setCancelled(true);
        }
    }

}
