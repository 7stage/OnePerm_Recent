package com.songro.oneperm.cmd;

import com.songro.oneperm.OnePerm;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Mail2Player implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player p = (Player) commandSender;

        try {
            if(strings.length > 0) {
                Player t = Bukkit.getPlayer(strings[0]);

                if(OnePerm.plugin.getCustomConfig().getBoolean(t.getName() + ".setting.getMailFromPlayer")) {

                } else {
                    p.sendMessage(ChatColor.YELLOW + "[ONEPERM] 해당 플레이어는 메일을 받지 않기로 했습니다.");
                }
            } else {
                p.sendMessage(ChatColor.YELLOW + "[ONEPERM] 명령어가 완성되지 않았습니다.");
                return false;
            }
        } catch (Exception e) {
            p.sendMessage(ChatColor.RED + "[ONEPERM] 플레이어에게 메일을 전송하지 못했습니다.\n[ONEPERM] 사유: " + e.getCause());
        }

        return true;
    }
}
