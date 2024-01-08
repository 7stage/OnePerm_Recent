/**
@deprecated
*/

package com.songro.oneperm.cmd.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class GivePermissionGUI implements CommandExecutor, Listener {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player player = (Player)commandSender;

        // inventory
        Inventory firstRoleGUI = Bukkit.createInventory(player, 27, "직업 선택");

        // item
        ItemStack copRole = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemStack mafiaRole = new ItemStack(Material.SUGAR, 1);
        ItemStack fireRole = new ItemStack(Material.LAVA_BUCKET, 1);
        ItemStack lawRole = new ItemStack(Material.ENCHANTED_BOOK, 1);
        ItemStack broadCastRole = new ItemStack(Material.OBSERVER, 1);
        ItemStack cityhallRole = new ItemStack(Material.LECTERN, 1);
        ItemStack prosectorRole = new ItemStack(Material.SPYGLASS, 1);
        ItemStack electionRole = new ItemStack(Material.PAPER, 1);
        ItemStack colleageRole = new ItemStack(Material.BOOK, 1);
        ItemStack nonItem = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);

        // meta
        ItemMeta copMeta = copRole.getItemMeta();
        ItemMeta mafiaMeta = mafiaRole.getItemMeta();
        ItemMeta fireMeta = fireRole.getItemMeta();
        ItemMeta lawMeta = lawRole.getItemMeta();
        ItemMeta broadCastMeta = broadCastRole.getItemMeta();
        ItemMeta cityHallMeta = cityhallRole.getItemMeta();
        ItemMeta prosectorMeta = prosectorRole.getItemMeta();
        ItemMeta electionMeta = electionRole.getItemMeta();
        ItemMeta colleageMeta = colleageRole.getItemMeta();
        ItemMeta nonItemMeta = nonItem.getItemMeta();

        copMeta.setDisplayName(ChatColor.AQUA + "[ 경찰 ]");
        ArrayList<String> copLore = new ArrayList<>();
        copLore.add(ChatColor.WHITE + "경찰 역할을 획득할 수 있습니다.");
        copLore.add("");
        copLore.add(ChatColor.GOLD + "시작 역할: " + ChatColor.AQUA + "순경");
        copLore.add(ChatColor.GOLD + "지급 물품: " + ChatColor.BLUE + "[ 경찰 복장, 리볼버, M14, 나이프 ]");
        copLore.add(ChatColor.GOLD + "월급: " + ChatColor.GREEN + "1,000,000" + ChatColor.GOLD + " 부터 시작");
        copLore.add("");
        copLore.add(ChatColor.YELLOW + "경고: 이 역할을 선택하면 다시는 역할을 변경할 수 없습니다.");
        copMeta.setLore(copLore);

        mafiaMeta.setDisplayName(ChatColor.DARK_GRAY + "[ 마피아 ]");
        ArrayList<String> mafiaLore = new ArrayList<>();
        mafiaLore.add(ChatColor.WHITE + "마피아 역할을 획득할 수 있습니다.");
        mafiaLore.add("");
        mafiaLore.add(ChatColor.GOLD + "시작 역할: " + ChatColor.DARK_GRAY + "마피아 시보");
        mafiaLore.add(ChatColor.GOLD + "지급 물품: " + ChatColor.DARK_GRAY + "[ ? ]");
        mafiaLore.add(ChatColor.GOLD + "월급: " + ChatColor.RED + "X (작업 공간 제공)");
        mafiaMeta.setLore(mafiaLore);
        
        fireMeta.setDisplayName(ChatColor.RED + "[ 소방관 ]");
        ArrayList<String> fireLore = new ArrayList<>();
        fireLore.add(ChatColor.WHITE + "소방관 역할을 획득할 수 있습니다.");
        fireLore.add("");
        fireLore.add(ChatColor.GOLD + "시작 역할: " + ChatColor.RED + "소방관");
        fireLore.add(ChatColor.GOLD + "지급 물품: " + ChatColor.RED + "[ 소방관 복장 ]");
        fireLore.add(ChatColor.GOLD + "월급: " + ChatColor.GREEN + "500,000" + ChatColor.GOLD + " 부터 시작");
        fireMeta.setLore(fireLore);
        
        lawMeta.setDisplayName(ChatColor.DARK_PURPLE + "[ 법무관 ]");
        ArrayList<String> lawLore = new ArrayList<>();
        lawLore.add(ChatColor.WHITE + "법무관 역할을 획득할 수 있습니다.");
        lawLore.add("");
        lawLore.add(ChatColor.GOLD + "시작 역할: " + ChatColor.DARK_PURPLE + "판사 시보");
        lawLore.add(ChatColor.GOLD + "월급: " + ChatColor.GREEN + "1,000,000" + ChatColor.GOLD + " 부터 시작");
        lawLore.add("");
        lawLore.add(ChatColor.YELLOW + "경고: 이 역할을 선택하면 다시는 역할을 변경할 수 없습니다.");
        lawMeta.setLore(lawLore);

        broadCastMeta.setDisplayName(ChatColor.GOLD + "[ 방송관 ]");
        ArrayList<String> broadCastLore = new ArrayList<>();
        broadCastLore.add(ChatColor.WHITE + "방송관 역할을 획득할 수 있습니다.");
        broadCastLore.add("");
        broadCastLore.add(ChatColor.GOLD + "시작 역할: 사원");
        broadCastLore.add(ChatColor.GOLD + "월급: " + ChatColor.GREEN + "800,000" + ChatColor.GOLD + " 부터 시작");
        broadCastMeta.setLore(broadCastLore);

        cityHallMeta.setDisplayName(ChatColor.DARK_AQUA + "[ 시청 ]");
        ArrayList<String> cityHallLore = new ArrayList<>();
        cityHallLore.add(ChatColor.WHITE + "시청 역할을 획득할 수 있습니다.");
        cityHallLore.add("");
        cityHallLore.add(ChatColor.GOLD + "시작 역할: " + ChatColor.DARK_AQUA + "시청 공무원");
        cityHallLore.add(ChatColor.GOLD + "월급: " + ChatColor.GREEN + "3,000,000" + ChatColor.GOLD + " 부터 시작");
        cityHallLore.add("");
        cityHallLore.add(ChatColor.YELLOW + "경고: 이 역할을 선택하면 다시는 역할을 변경할 수 없습니다.");
        cityHallMeta.setLore(cityHallLore);

        prosectorMeta.setDisplayName(ChatColor.BLUE + "[ 검찰 ]");
        ArrayList<String> prosectorLore = new ArrayList<>();
        prosectorLore.add(ChatColor.WHITE + "검찰 역할을 획득할 수 있습니다.");
        prosectorLore.add("");
        prosectorLore.add(ChatColor.GOLD + "시작 역할: " + ChatColor.BLUE + "검사 시보");
        prosectorLore.add(ChatColor.GOLD + "월급: " + ChatColor.GREEN + "800,000" + ChatColor.GOLD + " 부터 시작");
        prosectorLore.add("");
        prosectorLore.add(ChatColor.YELLOW + "경고: 이 역할을 선택하면 다시는 역할을 변경할 수 없습니다.");
        prosectorMeta.setLore(prosectorLore);

        electionMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "[ 선거위원회 ]");
        ArrayList<String> electionLore = new ArrayList<>();
        electionLore.add(ChatColor.WHITE + "선거위원회 역할을 획득할 수 있습니다.");
        electionLore.add("");
        electionLore.add(ChatColor.GOLD + "시작 역할: " + ChatColor.LIGHT_PURPLE + "선거위원회");
        electionLore.add(ChatColor.GOLD + "월급: " + ChatColor.GOLD + "?" + ChatColor.GOLD + " 부터 시작");
        electionLore.add("");
        electionLore.add(ChatColor.YELLOW + "경고: 이 역할을 선택하면 다시는 역할을 변경할 수 없습니다.");
        electionMeta.setLore(electionLore);

        colleageMeta.setDisplayName(ChatColor.AQUA + "[ 대학교 ]");
        ArrayList<String> colleageLore = new ArrayList<>();
        colleageLore.add(ChatColor.WHITE + "대학교 역할을 획득할 수 있습니다.");
        colleageLore.add("");
        colleageLore.add(ChatColor.GOLD + "시작 역할: " + ChatColor.AQUA + "대학교원");
        colleageLore.add(ChatColor.GOLD + "월급: " + ChatColor.GREEN + "1,000,000" + ChatColor.GOLD + " 부터 시작");
        colleageMeta.setLore(colleageLore);

        nonItemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        nonItemMeta.addItemFlags(ItemFlag.HIDE_ITEM_SPECIFICS);
        nonItemMeta.setDisplayName(ChatColor.BLACK + "[ ]");

        copRole.setItemMeta(copMeta);
        mafiaRole.setItemMeta(mafiaMeta);
        fireRole.setItemMeta(fireMeta);
        lawRole.setItemMeta(lawMeta);
        broadCastRole.setItemMeta(broadCastMeta);
        cityhallRole.setItemMeta(cityHallMeta);
        prosectorRole.setItemMeta(prosectorMeta);
        electionRole.setItemMeta(electionMeta);
        colleageRole.setItemMeta(colleageMeta);
        nonItem.setItemMeta(nonItemMeta);

        firstRoleGUI.setItem(0, nonItem);
        firstRoleGUI.setItem(1, copRole);
        firstRoleGUI.setItem(2, mafiaRole);
        firstRoleGUI.setItem(3, fireRole);
        firstRoleGUI.setItem(4, lawRole);
        firstRoleGUI.setItem(5, broadCastRole);
        firstRoleGUI.setItem(6, cityhallRole);
        firstRoleGUI.setItem(7, prosectorRole);
        firstRoleGUI.setItem(8, nonItem);
        firstRoleGUI.setItem(9, nonItem);
        firstRoleGUI.setItem(10, electionRole);
        firstRoleGUI.setItem(11, colleageRole);
        firstRoleGUI.setItem(17, nonItem);
        firstRoleGUI.setItem(18, nonItem);
        firstRoleGUI.setItem(26, nonItem);


        try {
            if(player.hasPermission("def.default") || player.hasPermission("role.op")) {
                player.openInventory(firstRoleGUI);
            } else {
                player.sendMessage(ChatColor.YELLOW + "[ONEPERM] 권한이 없습니다.");
            }
        } catch (Exception e) {
            player.sendMessage(ChatColor.RED + "[ONEPERM] 오류가 발생하였습니다.\n[ONEPERM] " + e.getMessage());
        }

        return true;
    }
}
