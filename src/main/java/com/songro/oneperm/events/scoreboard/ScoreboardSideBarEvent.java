package com.songro.oneperm.events.scoreboard;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;


public class ScoreboardSideBarEvent implements Listener {

    @EventHandler
    public void onJoinServer(PlayerJoinEvent e) {
        Player p = e.getPlayer();
    }

    @EventHandler
    public void onQuitServer(PlayerQuitEvent e) {
        Player p = e.getPlayer();
    }

}
