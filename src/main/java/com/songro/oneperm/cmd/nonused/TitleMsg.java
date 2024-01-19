package com.songro.oneperm.cmd.nonused;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class TitleMsg implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player player = (Player) commandSender;
        String msg = strings[0];
        StringBuilder builder = new StringBuilder();

        if(player.isOp()) {
            try {
                if(msg.length() >= 1) {
                        for (int i = 1; i < msg.length(); i++) {
                            builder.append(strings[i]);
                            builder.append(" ");
                        }
                        String finalMessage = builder.toString();
                        for (Player p : Bukkit.getOnlinePlayers()) { p.sendTitle("[ ! ]", finalMessage); }
                } else {
                    player.sendMessage(ChatColor.YELLOW + "[ONEPERM] 명령어 사용방식이 잘못되었습니다.");
                    return false;
                }
            } catch (Exception e) {
                player.sendMessage(ChatColor.RED + "[ONEPERM] 잘못된 커맨드 사용이거나, 오류가 발생하였습니다.\n[ONEPERM] " + e.getMessage());
                return false;
            }
        } else {
            player.sendMessage(ChatColor.YELLOW + "[ONEPERM] 권한이 부족합니다.");
        }

        return true;
    }
}
