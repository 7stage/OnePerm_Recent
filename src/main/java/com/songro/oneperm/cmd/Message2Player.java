package com.songro.oneperm.cmd;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Logger;

public class Message2Player implements CommandExecutor {

    Logger log = Bukkit.getLogger();

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender == Bukkit.getConsoleSender()) {
            log.warning("[ONEPERM] 이 명령어는 콘솔에서 사용이 불가능합니다.");
        }

        Player player = (Player) commandSender;

        if (strings.length == 2) {
            Player target = Bukkit.getPlayer(strings[0]);

            if (target == null) {
                try {
                    player.sendMessage(ChatColor.RED + "[ONEPERM] " + target.getDisplayName() + " 이라는 플레이어가 존재하지 않거나, 서버에 들어온적이 없습니다.");
                } catch (NullPointerException npe) {
                    player.sendMessage(ChatColor.RED + "[ONEPERM] 오류가 발생했습니다");
                    player.sendMessage(ChatColor.YELLOW + "[ONEPERM] 오류 로그: " + npe);
                    return false;
                }
            }

            StringBuilder builder = new StringBuilder();
            String msg = strings[1];

            if (commandSender instanceof Player) {
                try {
                    try {
                        if (strings.length == 1) {
                            if (target.equals(player)) {
                                player.sendMessage(ChatColor.YELLOW + "[ONEPERM] 자기 자신에게 메세지를 보낼수 없습니다.");
                            } else {
                                for (int i = 1; i < msg.length(); i++) {
                                    builder.append(strings[i]);
                                    builder.append(" ");
                                }

                                String finalMessage = builder.toString();
                                if (target.equals(player)) {
                                    player.sendMessage(ChatColor.YELLOW + "[ONEPERM] 자기 자신에게 메세지를 보낼수 없습니다.");
                                } else {
                                    target.sendMessage(ChatColor.DARK_GRAY + "[ONEPERM] " + ChatColor.DARK_PURPLE + player.getDisplayName() + ChatColor.DARK_GRAY + " >> " + target.getDisplayName() + "\n• " + finalMessage);
                                    player.sendMessage(ChatColor.DARK_GRAY + "[ONEPERM] " + ChatColor.GREEN + target.getDisplayName() + ChatColor.GREEN + "에게 성공적으로 " + finalMessage + " 라고 메세지를 보냈습니다.");
                                    return true;
                                }
                            }
                        } else {
                            player.sendMessage(ChatColor.YELLOW + "[ONEPERM] 명령어 사용방식이 잘못되었습니다.");
                            return false;
                        }


                    } catch (IndexOutOfBoundsException e2) {
                        player.sendMessage(ChatColor.RED + "[ONEPERM] 오류가 발생했습니다");
                        player.sendMessage(ChatColor.YELLOW + "[ONEPERM] 오류 로그: " + e2);
                        return false;
                    }
                } catch (Exception e) {
                    player.sendMessage(ChatColor.RED + "[ONEPERM] 오류를 보내는중에 오류가 발생했습니다");
                    player.sendMessage(ChatColor.YELLOW + "[ONEPERM] 오류 로그: " + e);
                    return false;
                }
            } else {
                player.sendMessage(ChatColor.YELLOW + "[ONEPERM] 명령어 사용방식이 잘못되었습니다.");
                return false;
            }
        } else {
            Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW +"[ONEPERM] 해당 명령어는 콘솔에서 사용이 불가능합니다.");
            return false;
        }
        return true;
    }
}
