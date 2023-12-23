package com.songro.oneperm.cmd.gui;

import com.songro.oneperm.OnePerm;
import com.songro.oneperm.task.ChkPlayerPerm;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class CreateBankDataGUI implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player p = (Player) commandSender;
        Inventory bankgui = Bukkit.createInventory(p, 54, ChatColor.BOLD + "[ 계좌 신청 승인 ]");


        for (Player plr : Bukkit.getServer().getOnlinePlayers()) {
            if(OnePerm.plugin.getBankCreateData().getString(plr.getName()) != null && OnePerm.plugin.getBankCreateData().getBoolean(plr.getName() + ".askedcreation")) {
                ItemStack i = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) 3);
                SkullMeta im = (SkullMeta) i.getItemMeta();

                List<String> il = new ArrayList<>();
                il.add(ChatColor.GRAY + "- 요청한 날짜: " + OnePerm.plugin.getBankCreateData().getString(plr.getName() + ".data.date"));
                il.add(ChatColor.GRAY + "- 직업: " + new ChkPlayerPerm().chkperm(plr));
                il.add("");
                il.add(ChatColor.GREEN + "[ 좌클릭 ] : 허가");
                il.add(ChatColor.RED + "[ 우클릭 ] : 거부");
                im.setOwner(plr.getName());
                im.setLore(il);
                im.setDisplayName(plr.getName());
                i.setItemMeta(im);

                bankgui.addItem(i);
            }
        }

        if(p.hasPermission("role.bank") || p.isOp()) {
            p.openInventory(bankgui);
        } else {
            p.sendMessage(ChatColor.YELLOW + "[ONEPERM] 이 명령어는 은행원만 사용할수 있습니다!");
        }

        return true;
    }
}
