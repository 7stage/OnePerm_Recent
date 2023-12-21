package com.songro.oneperm.events.player;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.logging.Logger;

public class OnPlayerDeath implements Listener {

    @EventHandler
    public void OnDeath(PlayerDeathEvent e) {
        EntityType entityType = e.getEntityType();
        Entity ent = e.getEntity();
        EntityDamageEvent.DamageCause dc = ent.getLastDamageCause().getCause();
        Logger log = Bukkit.getLogger();
        Player killedBy = e.getEntity().getKiller();
        Player player = e.getEntity().getPlayer();

        if (entityType == EntityType.PLAYER) {


            if (killedBy != null && player != null) {
                e.setDeathMessage(ChatColor.RED + "[ 🪚 ] " + killedBy.getName() + ChatColor.GOLD + " (이)가 " + ChatColor.AQUA + player.getName() + ChatColor.GOLD + "를 살해 하였습니다.");
                Bukkit.broadcast(ChatColor.RED + "[ONEPERM] " + killedBy.getName() + "(이)가 " + player.getName() + "를 살해 하였습니다.", "role.cop");
                log.info(e.getDeathMessage());
            } else if (killedBy == null) {
                assert player != null;
                e.setDeathMessage(ChatColor.GOLD + "[ 🪚 ] " + player.getName() + "(이)가 사망 하였습니다.");
                log.info(e.getDeathMessage());
            }
        }

        if (dc == EntityDamageEvent.DamageCause.FALL) {
            e.setDeathMessage(ChatColor.GOLD + "[ 🪚 ] " + player.getName() + "(이)가 높은 곳에서 떨어져 발목이 삐었습니다.");
        }

        if (dc == EntityDamageEvent.DamageCause.LAVA) {
            e.setDeathMessage(ChatColor.GOLD + "[ 🪚 ] " + player.getName() + "(이)가 바닥이 용암인걸 발견하였습니다.");
        }
        
        if (dc ==EntityDamageEvent.DamageCause.FIRE) {
            e.setDeathMessage(ChatColor.GOLD + "[ 🪚 ] " + player.getName() + "(이)가 불과 하나가 되었습니다.");
        }
    }
}
