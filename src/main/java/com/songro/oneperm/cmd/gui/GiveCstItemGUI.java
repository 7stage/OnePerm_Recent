package com.songro.oneperm.cmd.gui;

import com.songro.oneperm.item.CopBulletProof;
import com.songro.oneperm.item.CopCustomItem;
import com.songro.oneperm.item.weapon.C4;
import com.songro.oneperm.item.weapon.Grenade;
import com.songro.oneperm.recipe.drug.cocaine;
import com.songro.oneperm.recipe.drug.heroine;
import com.songro.oneperm.recipe.drug.weed;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class GiveCstItemGUI implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player player = (Player) commandSender;
        Inventory cstItemGUI = Bukkit.createInventory(player, 54, "커스텀 아이템");
        ItemStack nonItem = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
        ItemMeta nonItemMeta = nonItem.getItemMeta();

        nonItemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        nonItemMeta.addItemFlags(ItemFlag.HIDE_ITEM_SPECIFICS);
        nonItemMeta.setDisplayName(ChatColor.BLACK + "[ ]");

        nonItem.setItemMeta(nonItemMeta);

        if(player.isOp()) {
            try {
                cstItemGUI.setItem(0, nonItem);
                cstItemGUI.setItem(8, nonItem);
                cstItemGUI.setItem(9, nonItem);
                cstItemGUI.setItem(1, new CopCustomItem().returnCopTopItem());
                cstItemGUI.setItem(2, new CopCustomItem().returnCopBottomItem());
                cstItemGUI.setItem(3, new CopCustomItem().retrunCopPantsItem());
                cstItemGUI.setItem(4, new CopCustomItem().returnCopShoesItem());
                cstItemGUI.setItem(5, new CopBulletProof().returnItem());
                cstItemGUI.setItem(6, new CopCustomItem().returnCopStickItem());
                cstItemGUI.setItem(19, new Grenade().returnGrenade());
                cstItemGUI.setItem(20, new C4().returnC4());
                cstItemGUI.setItem(28, new weed().weedItem());
                cstItemGUI.setItem(29, new cocaine().cocaineitem());
                cstItemGUI.setItem(30, new heroine().heroineitem());
                cstItemGUI.setItem(17, nonItem);
                cstItemGUI.setItem(18, nonItem);
                cstItemGUI.setItem(26, nonItem);
                cstItemGUI.setItem(27, nonItem);
            } catch (Exception e) {
                player.sendMessage("[ONEPERM] GUI를 로드하는중 오류가 발생하였습니다.\n[ONEPERM] " + e.getMessage());
            }

            player.openInventory(cstItemGUI);
        } else {
            player.sendMessage(ChatColor.YELLOW + "[ONEPERM] 권한이 부족하거나, 없습니다");
        }

        return true;
    }
}
