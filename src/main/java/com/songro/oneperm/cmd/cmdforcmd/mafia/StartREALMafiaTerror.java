package com.songro.oneperm.cmd.cmdforcmd.mafia;

import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

import static com.songro.oneperm.OnePerm.econ;

public class StartREALMafiaTerror implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player player = (Player) commandSender;
        try {
            if (!player.hasPermission("role.mafia") || !player.isOp()) {
                player.sendMessage(ChatColor.YELLOW + "You have no permission to use this command!");
                return true;
            } else {
                EconomyResponse r = econ.withdrawPlayer(player, 50000000);
                if (r.transactionSuccess()) {
                    Bukkit.broadcast(ChatColor.RED + "\n\n[ONEPERM] 테러가 시작되었습니다.\n\n", "role.cop");
                    for (Player p : Bukkit.getOnlinePlayers()) {
                        p.playSound(p, Sound.ENTITY_TNT_PRIMED, 9, 1);
                        p.sendTitle("", ChatColor.RED + "[ 테러가 시작되었습니다! ]");
                    }
                    Bukkit.broadcast(ChatColor.GOLD + "===========================================================\n\n - 당신의 직업:  " + ChatColor.GRAY + "마피아\n" + ChatColor.GOLD + " - 목표: " + ChatColor.YELLOW + "경찰이 건물안에 있는 NPC를 못 누르게 막으세요!\n\n" + ChatColor.GOLD + "===========================================================", "role.mafia");
                    Bukkit.broadcast(ChatColor.GOLD + "===========================================================\n\n - 당신의 직업:  " + ChatColor.AQUA + "경찰\n" + ChatColor.GOLD + " - 목표: " + ChatColor.YELLOW + "마피아의 공격을 피해 건물안에 있는 NPC를 누르세요! \n\n" + ChatColor.GOLD + "===========================================================", "role.mafia");
                } else {
                    player.sendMessage(ChatColor.YELLOW + "[ONEPERM] 돈이 부족합니다.\n[ONEPERM] 현재 돈: " + econ.getBalance(player.getName()) + ", 테러를 시작하기 필요한 돈: 50,000,000원");
                    return true;
                }
            }
        } catch (Exception e) {
            player.sendMessage(ChatColor.RED + "[ONEPERM] 오류가 발생했습니다.\n[ONEPERM] " + Arrays.toString(e.getStackTrace()));
        }

        return true;
    }
}
