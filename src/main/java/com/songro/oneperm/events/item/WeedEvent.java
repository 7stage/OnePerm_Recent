package com.songro.oneperm.events.item;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class WeedEvent implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        if(e.getAction() == Action.RIGHT_CLICK_AIR) {
            if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "[ 대막초 ]")) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 20 * 15, 0), true);
                p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20 * 15, 0), true);
                p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 20 * 30, 0), true);
                p.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 20 * 30, 1), true);
                p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 20 * 30, 1), true);
                p.setItemInHand(null);
            } else if(p.getItemInHand().getItemMeta().getDisplayName() == null) {
                p.sendMessage(ChatColor.YELLOW + "[ONEPERM] 이미 효과를 경험하고 있습니다.");
            }

            if(p.getItemInHand().getItemMeta() == null) {
                return;
            }
        }
    }
}
