package com.songro.oneperm.cmd.bank;

// LOL

import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static com.songro.oneperm.OnePerm.econ;

public class RemoveMoney implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player player = (Player)commandSender;

        if (strings.length == 0) {
            player.sendMessage(ChatColor.YELLOW + "[ONEPERM] 명령어 사용방식이 잘못되었습니다.");
            return false;
        }

        Player target = Bukkit.getPlayer(strings[0]);
        int addMoney = Integer.parseInt(strings[1]);

        try {
            if (commandSender instanceof Player) {
                if(strings.length == 2) {
                    if (target == null) {
                        player.sendMessage(ChatColor.YELLOW + "[ONEPERM] 존재하지 않는 플레이어거나, 현재 온라인이 아닙니다.");
                    }

                    if (player.hasPermission("role.bank") || player.isOp()) {
                        if (addMoney > 999999999) {
                            player.sendMessage(ChatColor.YELLOW + "[ONEPERM] 값이 너무 큽니다!");
                            return true;
                        } else if ((addMoney <= 0)) {
                            player.sendMessage(ChatColor.YELLOW + "[ONEPERM] 값이 너무 작습니다!");
                            return true;
                        }

                        EconomyResponse r = econ.withdrawPlayer(target, addMoney);
                        if (r.transactionSuccess()) {
                            assert target != null;
                            target.sendActionBar(ChatColor.RED + "- " + r.amount + "$ | " + r.balance);

                            player.sendMessage(ChatColor.RED + "[ONEPERM] " + target.getName() + "님에게 " + addMoney + "원을 뺐습니다.");

                            target.sendMessage(ChatColor.RED + "[ONEPERM] " + player.getName() + "님이 " + addMoney + "원을 출금하였습니다..");
                            target.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 9, 10);
                        } else {
                            player.sendMessage(ChatColor.RED + "[ONEPERM] 해당 플레이어의 돈이 부족하거나, 오류가 발생하였습니다.");
                        }
                    } else {
                        player.sendMessage(ChatColor.YELLOW + "[ONEPERM] 이 명령어를 사용하기 위한 권한이 없습니다.");
                    }
                } else {
                    player.sendMessage(ChatColor.YELLOW + "[ONEPERM] 명령어 사용방식이 잘못되었습니다.");
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            player.sendMessage(ChatColor.RED + "[ONEPERM] 오류가 발생했습니다.\n[ONEPERM] " + e.getCause());
        }

        return true;
    }
}
