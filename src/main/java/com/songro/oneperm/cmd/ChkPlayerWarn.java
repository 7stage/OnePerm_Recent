package com.songro.oneperm.cmd;

import com.songro.oneperm.OnePerm;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ChkPlayerWarn implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player p = (Player) commandSender;
        int playerWarnStack = 0;
        try {
            playerWarnStack = OnePerm.plugin.getCustomConfig().getConfigurationSection(p.getName() + ".data").getInt("playerWarnStack");
        } catch (NullPointerException e) {
            p.sendMessage(ChatColor.RED + "[ONEPERM] 데이터가 존재하지 않습니다.\n[ONEPERM] " + e.getCause());
        }
        if(commandSender instanceof Player) {
            try {
                if(playerWarnStack == 0) {
                    p.sendMessage(ChatColor.GOLD + "[ONEPERM] " + ChatColor.WHITE + p.getName() + "님은 현재 아무런 경고가 없습니다.");
                } else {
                    p.sendMessage(ChatColor.GOLD + "[ONEPERM] " + ChatColor.WHITE + p.getName() + "님은 현재 " + playerWarnStack + "번 경고를 받았습니다.");
                }
            } catch (Exception e) {
                p.sendMessage(ChatColor.RED + "[ONEPERM] 오류가 발생했습니다.\n[ONEPERM] " + e.getCause());
            }
        } else {
            return true;
        }
        return true;
    }
}
