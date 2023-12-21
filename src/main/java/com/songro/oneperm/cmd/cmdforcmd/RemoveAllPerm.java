package com.songro.oneperm.cmd.cmdforcmd;

import com.songro.oneperm.OnePerm;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class RemoveAllPerm implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player player = (Player) commandSender;

        if (player.isOp()) {
            if (strings.length == 1) {
                Player target = Bukkit.getPlayer(strings[0]);
                try {
                    assert target != null;

                    if (target.isOp()) {
                        player.sendMessage( ChatColor.YELLOW + "[ONEPERM] 해당 플레이어는 관리자입니다.");
                    }

                    target.addAttachment(OnePerm.plugin, "role.cop", false);
                    target.addAttachment(OnePerm.plugin, "role.student", false);
                    target.addAttachment(OnePerm.plugin, "role.mafia", false);
                    target.addAttachment(OnePerm.plugin, "role.fire", false);
                    target.addAttachment(OnePerm.plugin, "role.guide", false);
                    target.addAttachment(OnePerm.plugin, "role.law", false);
                    target.addAttachment(OnePerm.plugin, "role.broadcast", false);
                    target.addAttachment(OnePerm.plugin, "role.prosector", false);
                    target.addAttachment(OnePerm.plugin, "role.cityhall", false);
                    target.addAttachment(OnePerm.plugin, "role.execution", false);
                    target.addAttachment(OnePerm.plugin, "role.election", false);
                    target.addAttachment(OnePerm.plugin, "role.colleage", false);
                    target.addAttachment(OnePerm.plugin, "def.default", false);
                    OnePerm.plugin.getCustomConfig().set(target.getName() + ".cop", false);
                    OnePerm.plugin.getCustomConfig().set(target.getName() + ".student", false);
                    OnePerm.plugin.getCustomConfig().set(target.getName() + ".mafia", false);
                    OnePerm.plugin.getCustomConfig().set(target.getName() + ".fire", false);
                    OnePerm.plugin.getCustomConfig().set(target.getName() + ".guide", false);
                    OnePerm.plugin.getCustomConfig().set(target.getName() + ".law", false);
                    OnePerm.plugin.getCustomConfig().set(target.getName() + ".broadcast", false);
                    OnePerm.plugin.getCustomConfig().set(target.getName() + ".prosector", false);
                    OnePerm.plugin.getCustomConfig().set(target.getName() + ".cityhall", false);
                    OnePerm.plugin.getCustomConfig().set(target.getName() + ".execution", false);
                    OnePerm.plugin.getCustomConfig().set(target.getName() + ".election", false);
                    OnePerm.plugin.getCustomConfig().set(target.getName() + ".colleage", false);
                    OnePerm.plugin.getCustomConfig().save(OnePerm.plugin.customConfigFile);
                    target.addAttachment(OnePerm.plugin, "def.default", true);
                    target.recalculatePermissions();
                    player.sendMessage(ChatColor.GREEN + "[ONEPERM] " + target.getName() + "님의 권한을 전부 다 삭제하였습니다.");
                } catch (Exception e) {
                    player.sendMessage(ChatColor.RED + "[ONEPERM] 오류가 발생하였습니다.\n[ONEPERM] " + e.getMessage());
                }
            } else {
                player.sendMessage(ChatColor.YELLOW + "[ONEPERM] 명령어 사용방식이 잘못되었습니다.");
                return false;
            }
        } else {
            player.sendMessage(ChatColor.YELLOW + "You have no permission to use this command!");
        }

        return true;
    }
}
