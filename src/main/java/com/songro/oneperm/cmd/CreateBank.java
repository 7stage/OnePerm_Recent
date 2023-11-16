package com.songro.oneperm.cmd;

import com.songro.oneperm.OnePerm;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CreateBank implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player p = (Player) commandSender;
        LocalDate now = LocalDate.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd");
        String curDate = now.format(format);

        try {
            /*
            if(p.hasPermission("role.student") || !p.isOp()) {
                p.sendMessage(ChatColor.YELLOW + "[ONEPERM] 학생은 계좌를 생성할수 없습니다!");
            } else {
             */
            if(OnePerm.plugin.getBankCreateData().getBoolean(p.getName() + ".askedcreation") == true) {
                p.sendMessage(ChatColor.YELLOW + "[ONEPERM] 이미 계좌 생성을 신청했습니다.");
                return true;
            }
                p.sendMessage(ChatColor.GREEN + "[ONEPERM] 은행원에게 계좌 생성을 신청했습니다.");
                p.playSound(p, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 9, 1);
                Bukkit.broadcast(ChatColor.GOLD + "[ONEPERM] " + p.getName() + "님이 계좌 신청을 하였습니다, 확인해주시길 바랍니다.", "role.bank");
                OnePerm.plugin.getBankCreateData().set(p.getName() + ".askedcreation", true);
                OnePerm.plugin.getBankCreateData().set(p.getName() + ".data.date", curDate);
                OnePerm.plugin.getBankCreateData().set(p.getName() + ".data.name", p.getName());
                OnePerm.plugin.getBankCreateData().save(OnePerm.plugin.bankCreationFile);
        } catch (Exception e) {
            p.sendMessage(ChatColor.RED + "[ONEPERM] 데이터를 저장중 오류가 발생했습니다.\n[ONEPERM] " + e.getMessage());
        }

        return true;
    }
}
