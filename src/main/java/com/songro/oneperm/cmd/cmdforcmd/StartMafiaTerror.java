package com.songro.oneperm.cmd.cmdforcmd;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class StartMafiaTerror implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player player = (Player) commandSender;

        if (commandSender instanceof Player) {
            if (player.hasPermission("role.mafia") || player.hasPermission("role.op")) {
                TextComponent confirmMsg = new TextComponent(ChatColor.GREEN + "[ 시작 ]");
                confirmMsg.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/smt"));

                player.sendMessage(ChatColor.YELLOW + "[ONEPERM] 정말로 테러를 시작하시겠습니까?\n[ONEPERM] 테러를 시작할시 돈 5천만원이 나가며 시작합니다.");
                player.spigot().sendMessage(confirmMsg);
            } else {
                player.sendMessage(ChatColor.YELLOW + "[ONEPERM] 이 명령어는 오직 마피아만 사용할 수 있습니다.");
            }
        }

        return true;
    }
}
