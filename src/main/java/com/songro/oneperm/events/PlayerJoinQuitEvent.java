package com.songro.oneperm.events;

import com.songro.oneperm.OnePerm;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Objects;

public class PlayerJoinQuitEvent implements Listener {

    @EventHandler
    public void onJoinMessage(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        e.setJoinMessage("[" + ChatColor.GREEN + "+" + ChatColor.WHITE + "] " + player.getDisplayName());
        if(OnePerm.plugin.getCustomConfig().getInt(player.getName() + ".data.mailcount") > 0) {
            player.sendMessage(ChatColor.GREEN + "[ONEPERM] 메일이 도착했습니다!");
        }
    }

    @EventHandler
    public void onQuitMessage(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        e.setQuitMessage("[" + ChatColor.RED + "-" + ChatColor.WHITE + "] " + player.getDisplayName());
    }

}
