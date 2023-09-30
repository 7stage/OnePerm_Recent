package com.songro.oneperm.cmd;

import com.songro.oneperm.OnePerm;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GivePermission2Player implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player player = (Player)commandSender;
        String roleSelection = strings[1];
        Player target = Bukkit.getPlayer(strings[0]);

        if (player.isOp()) {
            try {
                if (target.hasPermission("role.cop") | target.hasPermission("role.fire") | target.hasPermission("role.mafia") | target.hasPermission("role.guide") | target.hasPermission("role.law") | target.hasPermission("role.schoolmanage")) {
                    player.sendMessage(ChatColor.YELLOW + "[ONEPERM] 해당 플레이어는 " + roleSelection + " 권한을 이미 가지고 있습니다.");
                }

                if (target.isOp()) {
                    player.sendMessage(ChatColor.YELLOW + "[ONEPERM] 이미 해당 플레이어는 최상위 포식자입니다.");
                }

                if (roleSelection.equalsIgnoreCase("cop")) { // cop
                    if (target != null) {
                        target.addAttachment(OnePerm.plugin, "role.cop", true);
                        target.addAttachment(OnePerm.plugin, "role.mafia", false);
                        target.addAttachment(OnePerm.plugin, "role.guide", false);
                        target.addAttachment(OnePerm.plugin, "role.fire", false);
                        target.addAttachment(OnePerm.plugin, "role.law", false);
                        target.addAttachment(OnePerm.plugin, "role.schoolmanage", false);
                        target.addAttachment(OnePerm.plugin, "role.broadcast", false);
                        target.recalculatePermissions();
                        target.sendMessage(ChatColor.GREEN + "=====================\n\n[ONEPERM] " + ChatColor.BLUE + "경찰" + ChatColor.WHITE + "역할을 획득하셨습니다!\n\n=====================");
                        target.playSound(target.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 1);
                    }
                } else if (roleSelection.equalsIgnoreCase("firefighter")) { // firefighter
                    if (target != null) {
                        target.addAttachment(OnePerm.plugin, "role.cop", false);
                        target.addAttachment(OnePerm.plugin, "role.mafia", false);
                        target.addAttachment(OnePerm.plugin, "role.guide", false);
                        target.addAttachment(OnePerm.plugin, "role.fire", true);
                        target.addAttachment(OnePerm.plugin, "role.law", false);
                        target.addAttachment(OnePerm.plugin, "role.schoolmanage", false);
                        target.addAttachment(OnePerm.plugin, "role.broadcast", false);
                        target.recalculatePermissions();
                        target.sendMessage(ChatColor.GREEN + "=====================\n\n[ONEPERM] " + ChatColor.RED + "소방관" + ChatColor.WHITE + "역할을 획득하셨습니다!\n\n=====================");
                        target.playSound(target.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 1);
                    }
                    if (!target.isOnline()) {
                        // to-do
                        return true;
                    }
                } else if (roleSelection.equalsIgnoreCase("mafia")) { // mafia
                    if (target != null) {
                        target.addAttachment(OnePerm.plugin, "role.cop", false);
                        target.addAttachment(OnePerm.plugin, "role.mafia", true);
                        target.addAttachment(OnePerm.plugin, "role.guide", false);
                        target.addAttachment(OnePerm.plugin, "role.fire", false);
                        target.addAttachment(OnePerm.plugin, "role.law", false);
                        target.addAttachment(OnePerm.plugin, "role.schoolmanage", false);
                        target.addAttachment(OnePerm.plugin, "role.broadcast", false);
                        target.recalculatePermissions();
                        target.sendMessage(ChatColor.GREEN + "=====================\n\n[ONEPERM] " + ChatColor.GRAY + "마피아" + ChatColor.WHITE + "역할을 획득하셨습니다!\n\n=====================");
                        target.playSound(target.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 1);
                    }
                } else if (roleSelection.equalsIgnoreCase("guide")) { // guide
                    if (target != null) {
                        target.addAttachment(OnePerm.plugin, "role.cop", false);
                        target.addAttachment(OnePerm.plugin, "role.mafia", false);
                        target.addAttachment(OnePerm.plugin, "role.guide", true);
                        target.addAttachment(OnePerm.plugin, "role.fire", false);
                        target.addAttachment(OnePerm.plugin, "role.law", false);
                        target.addAttachment(OnePerm.plugin, "role.schoolmanage", false);
                        target.addAttachment(OnePerm.plugin, "role.broadcast", false);
                        target.recalculatePermissions();
                        target.sendMessage(ChatColor.GREEN + "=====================\n\n[ONEPERM] " + ChatColor.DARK_PURPLE + "가이드" + ChatColor.WHITE + "역할을 획득하셨습니다!\n\n=====================");
                        target.playSound(target.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 1);
                    }
                } else if (roleSelection.equalsIgnoreCase("law")) { // guide
                    if (target != null) {
                        target.addAttachment(OnePerm.plugin, "role.cop", false);
                        target.addAttachment(OnePerm.plugin, "role.mafia", false);
                        target.addAttachment(OnePerm.plugin, "role.guide", false);
                        target.addAttachment(OnePerm.plugin, "role.fire", false);
                        target.addAttachment(OnePerm.plugin, "role.law", true);
                        target.addAttachment(OnePerm.plugin, "role.schoolmanage", false);
                        target.addAttachment(OnePerm.plugin, "role.broadcast", false);
                        target.recalculatePermissions();
                        target.sendMessage(ChatColor.GREEN + "=====================\n\n[ONEPERM] " + ChatColor.DARK_PURPLE + "가이드" + ChatColor.WHITE + "역할을 획득하셨습니다!\n\n=====================");
                        target.playSound(target.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 1);
                    } else if (roleSelection.equalsIgnoreCase("school")) { // guide
                        if (target != null) {
                            target.addAttachment(OnePerm.plugin, "role.cop", false);
                            target.addAttachment(OnePerm.plugin, "role.mafia", false);
                            target.addAttachment(OnePerm.plugin, "role.guide", false);
                            target.addAttachment(OnePerm.plugin, "role.fire", false);
                            target.addAttachment(OnePerm.plugin, "role.law", false);
                            target.addAttachment(OnePerm.plugin, "role.schoolmanage", true);
                            target.addAttachment(OnePerm.plugin, "role.broadcast", false);
                            target.recalculatePermissions();
                            target.sendMessage(ChatColor.GREEN + "=====================\n\n[ONEPERM] " + ChatColor.DARK_PURPLE + "가이드" + ChatColor.WHITE + "역할을 획득하셨습니다!\n\n=====================");
                            target.playSound(target.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 1);
                        }
                    }
                }
                player.sendMessage(ChatColor.GREEN + "[ONEPERM] " + target + "님에게 " + roleSelection + "역할을 주었습니다.");
            } catch (Exception e) {
                player.sendMessage(ChatColor.RED + "[ONEPERM] 플레이어에게 권한을 주는중에 오류가 발생하였습니다.\n[ONEPERM] " + e.getMessage());
            }
        } else {
            player.sendMessage(ChatColor.RED + "[ONEPERM] 이 명령어는 관리자만 사용이 가능한 명령어입니다.");
        }

        return true;
    }
}
