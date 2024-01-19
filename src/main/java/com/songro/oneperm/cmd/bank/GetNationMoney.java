package com.songro.oneperm.cmd.bank;

import com.songro.oneperm.OnePerm;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GetNationMoney implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        commandSender.sendMessage(ChatColor.GOLD + "[ONEPERM] 현재 국고는 " + OnePerm.plugin.getNationData().getInt("treasury") + "원 남았습니다.");
        return true;
    }
}
