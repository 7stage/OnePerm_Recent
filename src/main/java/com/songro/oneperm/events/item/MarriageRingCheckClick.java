package com.songro.oneperm.events.item;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class MarriageRingCheckClick implements Listener {
    @EventHandler
    public void onClick(PlayerInteractAtEntityEvent e) {
        Player p = e.getPlayer();

        if(e.getRightClicked() instanceof Player) {
            final Player target = (Player) e.getRightClicked();

            if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.LIGHT_PURPLE + "[ 결혼 반지 ]")) {
                target.sendMessage(ChatColor.GOLD + "\n[ONEPERM] " + p.getDisplayName() + " 님이 " + target.getDisplayName() + " 님과 같이 생활하고 싶다고 합니다.\n[ONEPERM] 수락 하시겠습니까?\n");
                target.sendMessage(ChatColor.GREEN + "[ONEPERM]          [ 수락 ]         " + ChatColor.RED + "[ 거절 ]");
            }
        }
    }


}
