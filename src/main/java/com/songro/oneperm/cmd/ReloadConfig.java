package com.songro.oneperm.cmd;

import com.songro.oneperm.OnePerm;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.logging.Logger;

public class ReloadConfig implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player player = (Player)commandSender;
        Logger log = Bukkit.getLogger();

        try {
            if (player.isOp()) {
                player.sendMessage("Reloading...");
                log.warning("[ONEPERM] Plugin config files are reloading, do not attempt to disrupt.");
                OnePerm.plugin.reloadConfig();
                player.sendMessage(ChatColor.GREEN + "Reloaded!");
            } else {
                player.sendMessage(ChatColor.YELLOW + "You have no permission to use this command!");
            }
        } catch (Exception e) {
            player.sendMessage(ChatColor.RED + "[ONEPERM] 오류가 발생하였습니다.\n[ONEPERM] " + e.getMessage());
        }
        return true;
    }
}
