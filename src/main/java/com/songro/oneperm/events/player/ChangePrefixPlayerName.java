package com.songro.oneperm.events.player;

import com.songro.oneperm.OnePerm;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.logging.Logger;

public class ChangePrefixPlayerName implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        Logger log = Bukkit.getLogger();
        //TODO Even tho this function didn't included to main branch but this has to be cleaned up.

        // info: should change this function without if
        if(player.hasPermission("role.op")) {
            player.setDisplayName(ChatColor.RED + "[ 관리자 ] " + ChatColor.WHITE + player.getName());
            player.setPlayerListName(ChatColor.RED + "[ 관리자 ] " + ChatColor.WHITE + player.getName());
        } else if (OnePerm.plugin.getCustomConfig().getConfigurationSection(player.getName()) == null) {
            log.warning("player " + player.getName() + " information is not found.");
        } else if (OnePerm.plugin.getCustomConfig().getConfigurationSection(player.getName()).getBoolean("cop")) {
            player.setDisplayName(ChatColor.AQUA + "[ 경찰 ] " + ChatColor.WHITE + player.getName());
            player.addAttachment(OnePerm.plugin, "role.cop", true);
            player.addAttachment(OnePerm.plugin, "role.student", false);
            player.addAttachment(OnePerm.plugin, "role.mafia", false);
            player.addAttachment(OnePerm.plugin, "role.fire", false);
            player.addAttachment(OnePerm.plugin, "role.guide", false);
            player.addAttachment(OnePerm.plugin, "role.law", false);
            player.addAttachment(OnePerm.plugin, "role.broadcast", false);
            player.addAttachment(OnePerm.plugin, "role.prosector", false);
            player.addAttachment(OnePerm.plugin, "role.cityhall", false);
            player.addAttachment(OnePerm.plugin, "role.execution", false);
            player.addAttachment(OnePerm.plugin, "role.election", false);
            player.addAttachment(OnePerm.plugin, "role.colleage", false);
            player.setPlayerListName(ChatColor.AQUA + "[ 경찰 ] " + ChatColor.WHITE + player.getName());
            player.recalculatePermissions();
        } else if (OnePerm.plugin.getCustomConfig().getConfigurationSection(player.getName()).getBoolean("citizen")) {
            player.setDisplayName(ChatColor.GREEN + "[ 시민 ] " + ChatColor.WHITE + player.getName());
            player.setPlayerListName(ChatColor.GREEN + "[ 시민 ] " + ChatColor.WHITE + player.getName());
            player.recalculatePermissions();
        } else if (OnePerm.plugin.getCustomConfig().getConfigurationSection(player.getName()).getBoolean("guide")) {
            player.setDisplayName(ChatColor.DARK_PURPLE + "[ 가이드 ] " + ChatColor.WHITE + player.getName());
            player.addAttachment(OnePerm.plugin, "role.cop", false);
            player.addAttachment(OnePerm.plugin, "role.student", false);
            player.addAttachment(OnePerm.plugin, "role.mafia", false);
            player.addAttachment(OnePerm.plugin, "role.fire", false);
            player.addAttachment(OnePerm.plugin, "role.guide", true);
            player.addAttachment(OnePerm.plugin, "role.law", false);
            player.addAttachment(OnePerm.plugin, "role.broadcast", false);
            player.addAttachment(OnePerm.plugin, "role.prosector", false);
            player.addAttachment(OnePerm.plugin, "role.cityhall", false);
            player.addAttachment(OnePerm.plugin, "role.execution", false);
            player.addAttachment(OnePerm.plugin, "role.election", false);
            player.addAttachment(OnePerm.plugin, "role.colleage", false);
            player.setPlayerListName(ChatColor.DARK_PURPLE + "[ 가이드 ] " + ChatColor.WHITE + player.getName());
            player.recalculatePermissions();
        } else if (OnePerm.plugin.getCustomConfig().getConfigurationSection(player.getName()).getBoolean("mafia")) {
            player.setDisplayName(ChatColor.DARK_GRAY + "[ 마피아 ] " + ChatColor.WHITE + player.getName());
            player.addAttachment(OnePerm.plugin, "role.cop", false);
            player.addAttachment(OnePerm.plugin, "role.student", false);
            player.addAttachment(OnePerm.plugin, "role.mafia", true);
            player.addAttachment(OnePerm.plugin, "role.fire", false);
            player.addAttachment(OnePerm.plugin, "role.guide", false);
            player.addAttachment(OnePerm.plugin, "role.law", false);
            player.addAttachment(OnePerm.plugin, "role.broadcast", false);
            player.addAttachment(OnePerm.plugin, "role.prosector", false);
            player.addAttachment(OnePerm.plugin, "role.cityhall", false);
            player.addAttachment(OnePerm.plugin, "role.execution", false);
            player.addAttachment(OnePerm.plugin, "role.election", false);
            player.addAttachment(OnePerm.plugin, "role.colleage", false);
            player.setPlayerListName(ChatColor.DARK_GRAY + "[ 마피아 ] " + ChatColor.WHITE + player.getName());
            player.recalculatePermissions();
        } else if (OnePerm.plugin.getCustomConfig().getConfigurationSection(player.getName()).getBoolean("fire")) {
            player.setDisplayName(ChatColor.RED + "[ 소방관 ] " + ChatColor.WHITE + player.getName());
            player.addAttachment(OnePerm.plugin, "role.cop", false);
            player.addAttachment(OnePerm.plugin, "role.student", false);
            player.addAttachment(OnePerm.plugin, "role.mafia", false);
            player.addAttachment(OnePerm.plugin, "role.fire", true);
            player.addAttachment(OnePerm.plugin, "role.guide", false);
            player.addAttachment(OnePerm.plugin, "role.law", false);
            player.addAttachment(OnePerm.plugin, "role.broadcast", false);
            player.addAttachment(OnePerm.plugin, "role.prosector", false);
            player.addAttachment(OnePerm.plugin, "role.cityhall", false);
            player.addAttachment(OnePerm.plugin, "role.execution", false);
            player.addAttachment(OnePerm.plugin, "role.election", false);
            player.addAttachment(OnePerm.plugin, "role.colleage", false);
            player.setPlayerListName(ChatColor.RED + "[ 소방관 ] " + ChatColor.WHITE + player.getName());
            player.recalculatePermissions();
        } else if (OnePerm.plugin.getCustomConfig().getConfigurationSection(player.getName()).getBoolean("broadcast")) {
            player.setDisplayName(ChatColor.GOLD + "[ 방송관 ] " + ChatColor.WHITE + player.getName());
            player.addAttachment(OnePerm.plugin, "role.cop", false);
            player.addAttachment(OnePerm.plugin, "role.student", false);
            player.addAttachment(OnePerm.plugin, "role.mafia", false);
            player.addAttachment(OnePerm.plugin, "role.fire", false);
            player.addAttachment(OnePerm.plugin, "role.guide", false);
            player.addAttachment(OnePerm.plugin, "role.law", false);
            player.addAttachment(OnePerm.plugin, "role.broadcast", true);
            player.addAttachment(OnePerm.plugin, "role.prosector", false);
            player.addAttachment(OnePerm.plugin, "role.cityhall", false);
            player.addAttachment(OnePerm.plugin, "role.execution", false);
            player.addAttachment(OnePerm.plugin, "role.election", false);
            player.addAttachment(OnePerm.plugin, "role.colleage", false);
            player.setPlayerListName(ChatColor.GOLD + "[ 방송관 ] " + ChatColor.WHITE + player.getName());
            player.recalculatePermissions();
        } else if (OnePerm.plugin.getCustomConfig().getConfigurationSection(player.getName()).getBoolean("law")) {
            player.setDisplayName(ChatColor.DARK_PURPLE + "[ 판사 ] " + ChatColor.WHITE + player.getName());
            player.addAttachment(OnePerm.plugin, "role.cop", false);
            player.addAttachment(OnePerm.plugin, "role.student", false);
            player.addAttachment(OnePerm.plugin, "role.mafia", false);
            player.addAttachment(OnePerm.plugin, "role.fire", false);
            player.addAttachment(OnePerm.plugin, "role.guide", false);
            player.addAttachment(OnePerm.plugin, "role.law", true);
            player.addAttachment(OnePerm.plugin, "role.broadcast", false);
            player.addAttachment(OnePerm.plugin, "role.prosector", false);
            player.addAttachment(OnePerm.plugin, "role.cityhall", false);
            player.addAttachment(OnePerm.plugin, "role.execution", false);
            player.addAttachment(OnePerm.plugin, "role.election", false);
            player.addAttachment(OnePerm.plugin, "role.colleage", false);
            player.setPlayerListName(ChatColor.DARK_PURPLE + "[ 판사 ] " + ChatColor.WHITE + player.getName());
            player.recalculatePermissions();
        } else if (OnePerm.plugin.getCustomConfig().getConfigurationSection(player.getName()).getBoolean("student")) { // student
            player.setDisplayName(ChatColor.DARK_GREEN + "[ 학생 ] " + ChatColor.WHITE + player.getName());
            player.addAttachment(OnePerm.plugin, "role.cop", false);
            player.addAttachment(OnePerm.plugin, "role.student", true);
            player.addAttachment(OnePerm.plugin, "role.mafia", false);
            player.addAttachment(OnePerm.plugin, "role.fire", false);
            player.addAttachment(OnePerm.plugin, "role.guide", false);
            player.addAttachment(OnePerm.plugin, "role.law", false);
            player.addAttachment(OnePerm.plugin, "role.broadcast", false);
            player.addAttachment(OnePerm.plugin, "role.prosector", false);
            player.addAttachment(OnePerm.plugin, "role.cityhall", false);
            player.addAttachment(OnePerm.plugin, "role.execution", false);
            player.addAttachment(OnePerm.plugin, "role.election", false);
            player.addAttachment(OnePerm.plugin, "role.colleage", false);
            player.setPlayerListName(ChatColor.DARK_GREEN + "[ 학생 ] " + ChatColor.WHITE + player.getName());
            player.recalculatePermissions();
        } else if (OnePerm.plugin.getCustomConfig().getConfigurationSection(player.getName()).getBoolean("prosector")) {
            player.setDisplayName(ChatColor.DARK_BLUE + "[ 검찰 ] " + ChatColor.WHITE + player.getName());
            player.addAttachment(OnePerm.plugin, "role.cop", false);
            player.addAttachment(OnePerm.plugin, "role.student", false);
            player.addAttachment(OnePerm.plugin, "role.mafia", false);
            player.addAttachment(OnePerm.plugin, "role.fire", false);
            player.addAttachment(OnePerm.plugin, "role.guide", false);
            player.addAttachment(OnePerm.plugin, "role.law", false);
            player.addAttachment(OnePerm.plugin, "role.broadcast", false);
            player.addAttachment(OnePerm.plugin, "role.prosector", true);
            player.addAttachment(OnePerm.plugin, "role.cityhall", false);
            player.addAttachment(OnePerm.plugin, "role.execution", false);
            player.addAttachment(OnePerm.plugin, "role.election", false);
            player.addAttachment(OnePerm.plugin, "role.colleage", false);
            player.setPlayerListName(ChatColor.DARK_BLUE + "[ 검찰 ] " + ChatColor.WHITE + player.getName());
            player.recalculatePermissions();
        } else if (OnePerm.plugin.getCustomConfig().getConfigurationSection(player.getName()).getBoolean("cityhall")) {
            player.setDisplayName(ChatColor.DARK_AQUA + "[ 시청 ] " + ChatColor.WHITE + player.getName());
            player.addAttachment(OnePerm.plugin, "role.cop", false);
            player.addAttachment(OnePerm.plugin, "role.student", false);
            player.addAttachment(OnePerm.plugin, "role.mafia", false);
            player.addAttachment(OnePerm.plugin, "role.fire", false);
            player.addAttachment(OnePerm.plugin, "role.guide", false);
            player.addAttachment(OnePerm.plugin, "role.law", false);
            player.addAttachment(OnePerm.plugin, "role.broadcast", false);
            player.addAttachment(OnePerm.plugin, "role.prosector", false);
            player.addAttachment(OnePerm.plugin, "role.cityhall", true);
            player.addAttachment(OnePerm.plugin, "role.execution", false);
            player.addAttachment(OnePerm.plugin, "role.election", false);
            player.addAttachment(OnePerm.plugin, "role.colleage", false);
            player.setPlayerListName(ChatColor.DARK_AQUA + "[ 시청 ] " + ChatColor.WHITE + player.getName());
            player.recalculatePermissions();
        } else if (OnePerm.plugin.getCustomConfig().getConfigurationSection(player.getName()).getBoolean("execution")) {
            player.setDisplayName(ChatColor.DARK_RED + "[ 집행위원회 ] " + ChatColor.WHITE + player.getName());
            player.addAttachment(OnePerm.plugin, "role.cop", false);
            player.addAttachment(OnePerm.plugin, "role.student", false);
            player.addAttachment(OnePerm.plugin, "role.mafia", false);
            player.addAttachment(OnePerm.plugin, "role.fire", false);
            player.addAttachment(OnePerm.plugin, "role.guide", false);
            player.addAttachment(OnePerm.plugin, "role.law", false);
            player.addAttachment(OnePerm.plugin, "role.broadcast", false);
            player.addAttachment(OnePerm.plugin, "role.prosector", false);
            player.addAttachment(OnePerm.plugin, "role.cityhall", false);
            player.addAttachment(OnePerm.plugin, "role.execution", true);
            player.addAttachment(OnePerm.plugin, "role.election", false);
            player.addAttachment(OnePerm.plugin, "role.colleage", false);
            player.setPlayerListName(ChatColor.DARK_RED + "[ 집행위원회 ] " + ChatColor.WHITE + player.getName());
            player.recalculatePermissions();
        } else if (OnePerm.plugin.getCustomConfig().getConfigurationSection(player.getName()).getBoolean("election")) {
            player.setDisplayName(ChatColor.LIGHT_PURPLE + "[ 선거위원회 ] " + ChatColor.WHITE + player.getName());
            player.addAttachment(OnePerm.plugin, "role.cop", false);
            player.addAttachment(OnePerm.plugin, "role.student", false);
            player.addAttachment(OnePerm.plugin, "role.mafia", false);
            player.addAttachment(OnePerm.plugin, "role.fire", false);
            player.addAttachment(OnePerm.plugin, "role.guide", false);
            player.addAttachment(OnePerm.plugin, "role.law", false);
            player.addAttachment(OnePerm.plugin, "role.broadcast", false);
            player.addAttachment(OnePerm.plugin, "role.prosector", false);
            player.addAttachment(OnePerm.plugin, "role.cityhall", false);
            player.addAttachment(OnePerm.plugin, "role.execution", false);
            player.addAttachment(OnePerm.plugin, "role.election", true);
            player.addAttachment(OnePerm.plugin, "role.colleage", false);
            player.setPlayerListName(ChatColor.LIGHT_PURPLE + "[ 선거위원회 ] " + ChatColor.WHITE + player.getName());
            player.recalculatePermissions();
        } else {
            player.setDisplayName(ChatColor.GREEN + "[ 시민 ] " + ChatColor.WHITE + player.getName());
            player.addAttachment(OnePerm.plugin, "role.cop", false);
            player.addAttachment(OnePerm.plugin, "role.student", false);
            player.addAttachment(OnePerm.plugin, "role.mafia", false);
            player.addAttachment(OnePerm.plugin, "role.fire", false);
            player.addAttachment(OnePerm.plugin, "role.guide", false);
            player.addAttachment(OnePerm.plugin, "role.law", false);
            player.addAttachment(OnePerm.plugin, "role.broadcast", false);
            player.addAttachment(OnePerm.plugin, "role.prosector", false);
            player.addAttachment(OnePerm.plugin, "role.cityhall", false);
            player.addAttachment(OnePerm.plugin, "role.execution", false);
            player.addAttachment(OnePerm.plugin, "role.election", false);
            player.addAttachment(OnePerm.plugin, "role.colleage", false);
            player.addAttachment(OnePerm.plugin, "role.default", true);
            player.setPlayerListName(ChatColor.GREEN + "[ 시민 ] " + ChatColor.WHITE + player.getName());
            player.recalculatePermissions();
        }
    }

}
