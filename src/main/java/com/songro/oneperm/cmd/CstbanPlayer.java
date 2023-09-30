package com.songro.oneperm.cmd;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CstbanPlayer implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player player = (Player)commandSender;
        Player target = Bukkit.getPlayer(strings[0]);
        String banReason = strings[1];
        StringBuilder builder = new StringBuilder();

        try {
            if (strings.length == 1) {
                if (target.equals(player)) {
                    player.sendMessage(ChatColor.YELLOW + "[ONEPERM] 자기 자신에게 밴을 시도하면 이 세상에서 없어질 위험이있을수 있어요.");
                } else if (target.isBanned()) {
                    player.sendMessage(ChatColor.YELLOW + "[ONEPERM] 해당 플레이어는 이미 밴 당했습니다.");
                } else {
                    Bukkit.getBanList(BanList.Type.NAME).addBan(String.valueOf(target), ChatColor.RED + "밴을 영.구.적. 으로 당했습니다!\n\n" + ChatColor.YELLOW + "밴 사유: " + banReason +  "\n자세한 문의는 디스코드를 참고하시길 바랍니다.", null, "console");
                }
            } else {
                if (target.equals(player)) {
                    player.sendMessage(ChatColor.YELLOW + "[ONEPERM] 자기 자신에게 밴을 시도하면 이 세상에서 없어질 위험이 있을수 있어요.");
                } else if (target.isBanned()) {
                    player.sendMessage(ChatColor.YELLOW + "[ONEPERM] 해당 플레이어는 이미 밴 당했습니다.");
                } else {
                    for (int i = 1; i < strings.length; i++) {
                        builder.append(strings[i]);
                        builder.append(" ");
                    }

                    String finReason = builder.toString();
                    Bukkit.getBanList(BanList.Type.NAME).addBan(String.valueOf(target), ChatColor.RED + "밴을 영.구.적. 으로 당했습니다!\n\n" + ChatColor.YELLOW + "밴 사유: " + finReason +  "\n자세한 문의는 디스코드를 참고하시길 바랍니다.", null, "console");
                }
            }
        } catch (Exception e) {
            player.sendMessage( ChatColor.RED + "[ONEPERM] 해당 플레이어를 밴을 시도하는중 오류가 발생하였습니다.\n[ONEPERM] " + e.getMessage());
        }


        return true;
    }
}
