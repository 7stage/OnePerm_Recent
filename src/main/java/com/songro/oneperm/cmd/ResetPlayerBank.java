package com.songro.oneperm.cmd;

import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static com.songro.oneperm.OnePerm.econ;

public class ResetPlayerBank implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player p = (Player) commandSender;
        Player t = Bukkit.getPlayer(strings[0]);

        if(p.isOp()) {
            assert t != null;
            EconomyResponse r = econ.deleteBank(t.getName());
            if (r.transactionSuccess()) {
                EconomyResponse r2 = econ.createBank(t.getName(), t);
                p.sendMessage(ChatColor.GREEN + "[ONEPERM] " + t.getName() + "님의 계좌를 초기화하였습니다.");
            }
        } else {
            p.sendMessage(ChatColor.YELLOW + "[ONEPERM] 이 명령어를 사용하기 위한 권한이 없습니다!");
        }

        return true;
    }
}
