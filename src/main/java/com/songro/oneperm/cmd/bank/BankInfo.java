package com.songro.oneperm.cmd.bank;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static com.songro.oneperm.OnePerm.econ;

public class BankInfo implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player p = (Player) commandSender;
        double bankMoneyInfo = econ.getBalance(p.getName());

        try {
                p.sendMessage(ChatColor.GOLD + "[ONEPERM] " + p.getName() + "님의 계좌 정보");
                p.sendMessage(ChatColor.GRAY + "[ONEPERM]  - 돈: " + econ.format(bankMoneyInfo));
        } catch (Exception e) {
            p.sendMessage(ChatColor.YELLOW + "[ONEPERM] 계좌가 존재하지 않습니다!");
        }

        return true;
    }
}
