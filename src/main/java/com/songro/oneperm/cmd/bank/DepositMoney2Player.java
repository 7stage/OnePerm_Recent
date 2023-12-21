package com.songro.oneperm.cmd.bank;

import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static com.songro.oneperm.OnePerm.econ;

public class DepositMoney2Player implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player player = (Player)commandSender;

        if (strings.length == 0) {
            player.sendMessage(ChatColor.YELLOW + "[ONEPERM] 명령어 사용방식이 잘못되었습니다.");
            return false;
        }

        Player target = Bukkit.getPlayer(strings[0]);

        assert target != null;
        if(!target.isOnline()) {
            target = (Player) Bukkit.getOfflinePlayer(strings[0]);
        }

        double addMoney = Integer.parseInt(strings[1]);

        try {
            if (commandSender instanceof Player) {
                if(strings.length == 2) {
                    if(strings[1].length() == 1) {
                        if (target == null) {
                            player.sendMessage(ChatColor.YELLOW + "[ONEPERM] 존재하지 않는 플레이어거나, 현재 온라인이 아닙니다.");
                        }

                        if (addMoney > 999999999) {
                            player.sendMessage(ChatColor.YELLOW + "[ONEPERM] 값이 너무 큽니다!");
                            return true;
                        } else if ((addMoney <= 0)) {
                            player.sendMessage(ChatColor.YELLOW + "[ONEPERM] 값이 너무 작습니다!");
                            return true;
                        }

                        if(target == player) {
                            player.sendMessage(ChatColor.YELLOW + "[ONEPERM] 자기 자신에게 돈을 받을수 없습니다!");
                        }

                        EconomyResponse r = econ.depositPlayer(target, addMoney);

                        if (addMoney > r.balance) {
                            player.sendMessage("[ONEPERM] 돈이 부족합니다. 입금할려는 돈: $" + r.amount + " 지갑에 있는 돈: " + r.balance);
                            return true;
                        }

                        if (r.transactionSuccess()) {
                            target.sendActionBar(ChatColor.GREEN + "+ " + r.amount + "$ | " + r.balance);

                            player.sendMessage(ChatColor.GREEN + "[ONEPERM] " + target.getName() + "님에게 " + addMoney + "원을 입금했습니다.");

                            target.sendMessage(ChatColor.GREEN + "[ONEPERM] " + player.getName() + "님이 " + addMoney + "원을 입금하였습니다.");
                            target.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 9, 10);

                        } else {
                            player.sendMessage(ChatColor.RED + "[ONEPERM] 오류가 발생했습니다.\n[ONEPERM] 이 문제는 Vault 자체의 문제입니다! (혹은 플레이어가 존재하지 않거나) 개발자에게 문의하지 마세요.\n[ONEPERM] " + r.errorMessage);
                        }
                    } else {
                        player.sendMessage(ChatColor.YELLOW + "[ONEPERM] 명령어 사용방식이 잘못되었습니다.");
                        return false;
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
