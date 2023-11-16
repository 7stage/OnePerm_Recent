package com.songro.oneperm.cmd.giveperm;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Police implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player p = (Player)commandSender;

        try {
            if (strings.length == 2) {
                if (strings[0].equalsIgnoreCase("채용") || strings[0].equalsIgnoreCase("apply")) {
                    Player t = Bukkit.getOfflinePlayer(strings[1]).getPlayer();
                    String applyMsg = strings[3];

                    if (applyMsg == null) {
                        p.sendMessage(ChatColor.YELLOW + "[ONEPERM] 명령어 사용방식이 잘못되었습니다.");
                        return false;
                    }

                    if(applyMsg.equalsIgnoreCase("test1")) {
                        p.sendMessage(ChatColor.GREEN + "[ONEPERM] " + t.getName() + "님을 " + applyMsg + "부서에 추가하였습니다.");
                        p.playSound(p, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 9, 10);
                    } else if(applyMsg.equalsIgnoreCase("test2")) {
                        p.sendMessage(ChatColor.GREEN + "[ONEPERM] " + t.getName() + "님을 " + applyMsg + "부서에 추가하였습니다.");
                        p.playSound(p, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 9, 10);
                    }
                }

            } else {
                p.sendMessage(ChatColor.YELLOW + "[ONEPERM] 명령어 사용방식이 잘못되었습니다.");
                return false;
            }
        } catch (Exception e) {
            p.sendMessage(ChatColor.RED + "[ONEPERM] 오류가 발생했습니다.\n[ONEPERM] " + e.getMessage() + ", Caused by: " + e.getClass());
        }
        return true;
    }
}
