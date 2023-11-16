package com.songro.oneperm.cmd;

import net.kyori.adventure.text.event.ClickCallback;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.logging.Logger;

public class RemovePlayerPermission implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player player = (Player) commandSender;
        Logger log = Bukkit.getLogger();

        if (commandSender instanceof Player) {
            if (player.isOp()) {
                if(strings.length == 1) {
                    Player target = Bukkit.getPlayer(strings[0]);
                    try {
                        assert target != null;
                        if (target == null) {
                            player.sendMessage(ChatColor.YELLOW + "[ONEPERM] 명령어 사용방식이 잘못되었습니다.");
                            return false;
                        } else {
                            TextComponent confirmMsg = new TextComponent(ChatColor.GREEN + "                              [ 확인하였습니다 ]");
                            confirmMsg.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/rmp " + target.getName()));

                            log.warning("[ONEPERM] Player " + player.getName() + " is trying to remove " + target.getName() + "'s permission.");
                            player.sendMessage(ChatColor.YELLOW + "[ONEPERM] 정말로 " + target.getName() + " 님의 모든 권한을 삭제하실껀가요?");
                            player.sendMessage(ChatColor.YELLOW + "[ONEPERM] 해당 플레이어는 권한이 삭제되면 시민 권한을 얻을수 있게 됩니다.\n");
                            player.spigot().sendMessage(confirmMsg);
                        }
                    } catch (Exception e) {
                        player.sendMessage(ChatColor.RED + "[ONEPERM] 오류가 발생했습니다.\n[ONEPERM] " + e.getMessage());
                    }
                } else {
                    player.sendMessage(ChatColor.YELLOW + "[ONEPERM] 명령어 사용방식이 잘못되었습니다.");
                    return false;
                }
            } else {
                player.sendMessage(ChatColor.YELLOW + "[ONEPERM] 권한이 없습니다.");
            }
        }

        return true;
    }
}
