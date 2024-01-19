package com.songro.oneperm.cmd;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Version implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player player = (Player)commandSender;
        player.sendMessage( ChatColor.GREEN + "[ONEPERM] OnePerm - v1.9 BETA\n[ONEPERM] Made by. DONT PAN!C STUDIOS\n[ONEPERM] OnePerm 플러그인은 WeaponMechanicsAPI, Spigot API, Vault, MechanicsCore 그리고 Spigot API를 사용합니다.");
        return true;
    }
}
