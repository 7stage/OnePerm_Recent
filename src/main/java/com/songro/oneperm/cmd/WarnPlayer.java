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

public class WarnPlayer implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player p = (Player) commandSender;

        if(strings.length == 1) {
            if(p.isOp()) {
                Player t = Bukkit.getPlayer(strings[0]);

                try {
                    assert t != null;
                    try {
                        Objects.requireNonNull(OnePerm.plugin.getCustomConfig().getConfigurationSection(t.getName() + ".data")).set("playerWarnStack", Objects.requireNonNull(OnePerm.plugin.getCustomConfig().getConfigurationSection(t.getName() + ".data")).getInt("playerWarnStack") + 1);
                        OnePerm.plugin.getCustomConfig().save(OnePerm.plugin.customConfigFile);
                        p.sendMessage(ChatColor.GOLD + "[ONEPERM] " + ChatColor.WHITE + t.getName() + "님의 경고 횟수가 증가 하였습니다.");
                    } catch (NullPointerException e) {
                        p.sendMessage(ChatColor.GOLD + "[ONEPERM] " + ChatColor.WHITE + "해당 플레이어의 데이터가 존재하지 않습니다.\n[ONEPERM] " + e.getMessage());
                    }
                } catch (Exception e) {
                    p.sendMessage(ChatColor.RED + "[ONEPERM] 오류가 발생했습니다.\n[ONEPERM] " + e.getMessage());
                }
            } else {
                p.sendMessage(ChatColor.YELLOW + "You cannot use this command!");
            }
        } else {
            p.sendMessage(ChatColor.YELLOW + "[ONEPERM] 명령어 사용방식이 잘못되었습니다.");
            return false;
        }

        return true;
    }
}
