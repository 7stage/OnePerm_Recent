package com.songro.oneperm.events.gui;

import com.songro.oneperm.OnePerm;
import com.songro.oneperm.item.CopCustomItem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

import java.io.IOException;
import java.util.logging.Logger;

public class InventoryClick implements Listener {

    Logger log = Bukkit.getLogger();

    @EventHandler
    public void onInvClick(InventoryClickEvent e) throws IOException {
        Player target = (Player)e.getWhoClicked();

        if(!(e.getWhoClicked() instanceof Player)) {
            return;
        }
        if(target.hasPermission("def.default")) {

            if (e.getView().getTitle().equalsIgnoreCase("직업 선택")) {
                if (e.getCurrentItem() == null || e.getCurrentItem().equals(Material.AIR)) {
                    return;
                }

                if (e.getCurrentItem().getType() == Material.DIAMOND_SWORD && e.getCurrentItem().getItemMeta().hasDisplayName()) { // cop
                    if (!target.hasPermission("role.cop")) {
                        target.addAttachment(OnePerm.plugin, "role.cop", true);
                        target.addAttachment(OnePerm.plugin, "role.student", false);
                        target.addAttachment(OnePerm.plugin, "role.mafia", false);
                        target.addAttachment(OnePerm.plugin, "role.fire", false);
                        target.addAttachment(OnePerm.plugin, "role.guide", false);
                        target.addAttachment(OnePerm.plugin, "role.law", false);
                        target.addAttachment(OnePerm.plugin, "role.broadcast", false);
                        target.addAttachment(OnePerm.plugin, "role.prosector", false);
                        target.addAttachment(OnePerm.plugin, "role.cityhall", false);
                        target.addAttachment(OnePerm.plugin, "role.execution", false);
                        target.addAttachment(OnePerm.plugin, "role.election", false);
                        target.addAttachment(OnePerm.plugin, "role.colleage", false);
                        target.sendMessage(ChatColor.GREEN + "[ONEPERM] " + ChatColor.BLUE + "경찰 " + ChatColor.WHITE + "역할을 획득했습니다!");
                        target.playSound(target, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 9, 1);
                        target.closeInventory();
                        log.info("Set " + target.getName() + "'s permission to cop");
                        log.info("Saving data..");
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".cop", true);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".student", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".mafia", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".fire", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".guide", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".law", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".broadcast", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".prosector", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".cityhall", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".execution", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".election", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".colleage", false);
                        OnePerm.plugin.getCustomConfig().save(OnePerm.plugin.customConfigFile);
                        target.addAttachment(OnePerm.plugin, "def.default", false);
                        Bukkit.broadcast(ChatColor.GREEN + "[ONEPERM] 경찰에 새로운 인원이 들어왔습니다!", "role.cop");
                        CopCustomItem.giveCopItem(target);
                        target.recalculatePermissions();
                    }
                }

                if (e.getCurrentItem().getType() == Material.SUGAR && e.getCurrentItem().getItemMeta().hasDisplayName()) { // mafia
                    if (!target.hasPermission("role.mafia")) {
                        target.addAttachment(OnePerm.plugin, "role.cop", false);
                        target.addAttachment(OnePerm.plugin, "role.student", false);
                        target.addAttachment(OnePerm.plugin, "role.mafia", true);
                        target.addAttachment(OnePerm.plugin, "role.fire", false);
                        target.addAttachment(OnePerm.plugin, "role.guide", false);
                        target.addAttachment(OnePerm.plugin, "role.law", false);
                        target.addAttachment(OnePerm.plugin, "role.broadcast", false);
                        target.addAttachment(OnePerm.plugin, "role.prosector", false);
                        target.addAttachment(OnePerm.plugin, "role.cityhall", false);
                        target.addAttachment(OnePerm.plugin, "role.execution", false);
                        target.addAttachment(OnePerm.plugin, "role.election", false);
                        target.addAttachment(OnePerm.plugin, "role.colleage", false);
                        target.sendMessage(ChatColor.GREEN + "[ONEPERM] " + ChatColor.BLACK + "마피아 " + ChatColor.WHITE + "역할을 획득했습니다!");
                        target.playSound(target, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 9, 1);
                        target.closeInventory();
                        log.info("Set " + target.getName() + "'s permission to mafia");
                        log.info("Saving data..");
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".cop", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".student", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".mafia", true);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".fire", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".guide", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".law", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".broadcast", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".prosector", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".cityhall", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".execution", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".election", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".colleage", false);
                        OnePerm.plugin.getCustomConfig().save(OnePerm.plugin.customConfigFile);
                        Bukkit.broadcast(ChatColor.GREEN + "[ONEPERM] 마피아에 새로운 인원이 들어왔습니다!", "role.mafia");
                        target.recalculatePermissions();
                    }
                }

                if (e.getCurrentItem().getType() == Material.LAVA_BUCKET && e.getCurrentItem().getItemMeta().hasDisplayName()) { // firefighter
                    if (!target.hasPermission("role.fire")) {
                        target.addAttachment(OnePerm.plugin, "role.cop", false);
                        target.addAttachment(OnePerm.plugin, "role.student", false);
                        target.addAttachment(OnePerm.plugin, "role.mafia", false);
                        target.addAttachment(OnePerm.plugin, "role.fire", true);
                        target.addAttachment(OnePerm.plugin, "role.guide", false);
                        target.addAttachment(OnePerm.plugin, "role.law", false);
                        target.addAttachment(OnePerm.plugin, "role.broadcast", false);
                        target.addAttachment(OnePerm.plugin, "role.prosector", false);
                        target.addAttachment(OnePerm.plugin, "role.cityhall", false);
                        target.addAttachment(OnePerm.plugin, "role.execution", false);
                        target.addAttachment(OnePerm.plugin, "role.election", false);
                        target.addAttachment(OnePerm.plugin, "role.colleage", false);
                        target.sendMessage(ChatColor.GREEN + "[ONEPERM] " + ChatColor.RED + "소방관 " + ChatColor.WHITE + "역할을 획득했습니다!");
                        target.playSound(target, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 9, 1);
                        target.closeInventory();
                        log.info("Set " + target.getName() + "'s permission to fire");
                        log.info("Saving data..");
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".cop", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".student", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".mafia", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".fire", true);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".guide", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".law", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".broadcast", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".prosector", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".cityhall", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".execution", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".election", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".colleage", false);
                        OnePerm.plugin.getCustomConfig().save(OnePerm.plugin.customConfigFile);
                        Bukkit.broadcast(ChatColor.GREEN + "[ONEPERM] 소방관에 새로운 인원이 들어왔습니다!", "role.fire");
                        target.recalculatePermissions();
                    }
                }

                if (e.getCurrentItem().getType() == Material.ENCHANTED_BOOK && e.getCurrentItem().getItemMeta().hasDisplayName()) { // law
                    if (!target.hasPermission("role.law")) {
                        target.addAttachment(OnePerm.plugin, "role.cop", false);
                        target.addAttachment(OnePerm.plugin, "role.student", false);
                        target.addAttachment(OnePerm.plugin, "role.mafia", false);
                        target.addAttachment(OnePerm.plugin, "role.fire", false);
                        target.addAttachment(OnePerm.plugin, "role.guide", false);
                        target.addAttachment(OnePerm.plugin, "role.law", true);
                        target.addAttachment(OnePerm.plugin, "role.broadcast", false);
                        target.addAttachment(OnePerm.plugin, "role.prosector", false);
                        target.addAttachment(OnePerm.plugin, "role.cityhall", false);
                        target.addAttachment(OnePerm.plugin, "role.execution", false);
                        target.addAttachment(OnePerm.plugin, "role.election", false);
                        target.addAttachment(OnePerm.plugin, "role.colleage", false);
                        target.sendMessage(ChatColor.GREEN + "[ONEPERM] " + ChatColor.LIGHT_PURPLE + "법무관" + ChatColor.WHITE + "역할을 획득했습니다!");
                        target.playSound(target, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 9, 1);
                        target.closeInventory();
                        log.info("Set " + target.getName() + "'s permission to law");
                        log.info("Saving data..");
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".cop", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".student", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".mafia", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".fire", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".guide", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".law", true);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".broadcast", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".prosector", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".cityhall", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".execution", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".election", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".colleage", false);
                        OnePerm.plugin.getCustomConfig().save(OnePerm.plugin.customConfigFile);
                        target.addAttachment(OnePerm.plugin, "def.default", false);
                        Bukkit.broadcast(ChatColor.GREEN + "[ONEPERM] 법무관에 새로운 인원이 들어왔습니다!", "role.law");
                        target.recalculatePermissions();
                    }
                }

                if (e.getCurrentItem().getType() == Material.OBSERVER && e.getCurrentItem().getItemMeta().hasDisplayName()) { // broadcast
                    if (!target.hasPermission("role.broadcast")) {
                        target.addAttachment(OnePerm.plugin, "role.cop", false);
                        target.addAttachment(OnePerm.plugin, "role.student", false);
                        target.addAttachment(OnePerm.plugin, "role.mafia", false);
                        target.addAttachment(OnePerm.plugin, "role.fire", false);
                        target.addAttachment(OnePerm.plugin, "role.guide", false);
                        target.addAttachment(OnePerm.plugin, "role.law", false);
                        target.addAttachment(OnePerm.plugin, "role.broadcast", true);
                        target.addAttachment(OnePerm.plugin, "role.prosector", false);
                        target.addAttachment(OnePerm.plugin, "role.cityhall", false);
                        target.addAttachment(OnePerm.plugin, "role.execution", false);
                        target.addAttachment(OnePerm.plugin, "role.election", false);
                        target.addAttachment(OnePerm.plugin, "role.colleage", false);
                        target.sendMessage(ChatColor.GREEN + "[ONEPERM] " + ChatColor.GOLD + "방송관" + ChatColor.WHITE + "역할을 획득했습니다!");
                        target.playSound(target, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 9, 1);
                        target.closeInventory();
                        log.info("Set " + target.getName() + "'s permission to broadcast");
                        log.info("Saving data..");
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".cop", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".student", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".mafia", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".fire", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".guide", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".law", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".broadcast", true);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".prosector", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".cityhall", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".execution", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".election", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".colleage", false);
                        OnePerm.plugin.getCustomConfig().save(OnePerm.plugin.customConfigFile);
                        Bukkit.broadcast(ChatColor.GREEN + "[ONEPERM] 방송관에 새로운 인원이 들어왔습니다!", "role.broadcast");
                        target.recalculatePermissions();
                    }
                }

                if (e.getCurrentItem().getType() == Material.LECTERN && e.getCurrentItem().getItemMeta().hasDisplayName()) { // cityhall
                    if (!target.hasPermission("role.cityhall")) {
                        target.addAttachment(OnePerm.plugin, "role.cop", false);
                        target.addAttachment(OnePerm.plugin, "role.student", false);
                        target.addAttachment(OnePerm.plugin, "role.mafia", false);
                        target.addAttachment(OnePerm.plugin, "role.fire", false);
                        target.addAttachment(OnePerm.plugin, "role.guide", false);
                        target.addAttachment(OnePerm.plugin, "role.law", false);
                        target.addAttachment(OnePerm.plugin, "role.broadcast", false);
                        target.addAttachment(OnePerm.plugin, "role.prosector", false);
                        target.addAttachment(OnePerm.plugin, "role.cityhall", true);
                        target.addAttachment(OnePerm.plugin, "role.execution", false);
                        target.addAttachment(OnePerm.plugin, "role.election", false);
                        target.addAttachment(OnePerm.plugin, "role.colleage", false);
                        target.addAttachment(OnePerm.plugin, "def.default", false);
                        target.sendMessage(ChatColor.GREEN + "[ONEPERM] " + ChatColor.DARK_AQUA + "시청" + ChatColor.WHITE + "역할을 획득했습니다!");
                        target.playSound(target, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 9, 1);
                        target.closeInventory();
                        log.info("Set " + target.getName() + "'s permission to cityhall");
                        log.info("Saving data..");
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".cop", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".student", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".mafia", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".fire", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".guide", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".law", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".broadcast", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".prosector", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".cityhall", true);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".execution", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".election", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".colleage", false);
                        OnePerm.plugin.getCustomConfig().save(OnePerm.plugin.customConfigFile);
                        target.recalculatePermissions();
                    }
                }

                if (e.getCurrentItem().getType() == Material.NETHERITE_AXE && e.getCurrentItem().getItemMeta().hasDisplayName()) { // execution
                    if (!target.hasPermission("role.execution")) {
                        target.addAttachment(OnePerm.plugin, "role.cop", false);
                        target.addAttachment(OnePerm.plugin, "role.student", false);
                        target.addAttachment(OnePerm.plugin, "role.mafia", false);
                        target.addAttachment(OnePerm.plugin, "role.fire", false);
                        target.addAttachment(OnePerm.plugin, "role.guide", false);
                        target.addAttachment(OnePerm.plugin, "role.law", false);
                        target.addAttachment(OnePerm.plugin, "role.broadcast", false);
                        target.addAttachment(OnePerm.plugin, "role.prosector", false);
                        target.addAttachment(OnePerm.plugin, "role.cityhall", false);
                        target.addAttachment(OnePerm.plugin, "role.execution", true);
                        target.addAttachment(OnePerm.plugin, "role.election", false);
                        target.addAttachment(OnePerm.plugin, "role.colleage", false);
                        target.addAttachment(OnePerm.plugin, "def.default", false);
                        target.sendMessage(ChatColor.GREEN + "[ONEPERM] " + ChatColor.DARK_RED + "집행위원회" + ChatColor.WHITE + "역할을 획득했습니다!");
                        target.playSound(target, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 9, 1);
                        target.closeInventory();
                        log.info("Set " + target.getName() + "'s permission to execution");
                        log.info("Saving data..");
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".cop", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".student", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".mafia", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".fire", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".guide", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".law", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".broadcast", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".prosector", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".cityhall", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".execution", true);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".election", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".colleage", false);
                        OnePerm.plugin.getCustomConfig().save(OnePerm.plugin.customConfigFile);
                        target.recalculatePermissions();
                    }
                }

                if (e.getCurrentItem().getType() == Material.PAPER && e.getCurrentItem().getItemMeta().hasDisplayName()) { // election
                    if (!target.hasPermission("role.election")) {
                        target.addAttachment(OnePerm.plugin, "role.cop", false);
                        target.addAttachment(OnePerm.plugin, "role.student", false);
                        target.addAttachment(OnePerm.plugin, "role.mafia", false);
                        target.addAttachment(OnePerm.plugin, "role.fire", false);
                        target.addAttachment(OnePerm.plugin, "role.guide", false);
                        target.addAttachment(OnePerm.plugin, "role.law", false);
                        target.addAttachment(OnePerm.plugin, "role.broadcast", false);
                        target.addAttachment(OnePerm.plugin, "role.prosector", false);
                        target.addAttachment(OnePerm.plugin, "role.cityhall", false);
                        target.addAttachment(OnePerm.plugin, "role.execution", false);
                        target.addAttachment(OnePerm.plugin, "role.election", true);
                        target.addAttachment(OnePerm.plugin, "role.colleage", false);
                        target.addAttachment(OnePerm.plugin, "def.default", false);
                        target.sendMessage(ChatColor.GREEN + "[ONEPERM] " + ChatColor.LIGHT_PURPLE + "선거위원회" + ChatColor.WHITE + "역할을 획득했습니다!");
                        target.playSound(target, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 9, 1);
                        target.closeInventory();
                        log.info("Set " + target.getName() + "'s permission to election");
                        log.info("Saving data..");
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".cop", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".student", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".mafia", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".fire", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".guide", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".law", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".broadcast", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".prosector", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".cityhall", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".execution", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".election", true);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".colleage", false);
                        OnePerm.plugin.getCustomConfig().save(OnePerm.plugin.customConfigFile);
                        target.recalculatePermissions();
                    }
                }

                if (e.getCurrentItem().getType() == Material.SPYGLASS && e.getCurrentItem().getItemMeta().hasDisplayName()) { // prosector
                    if (!target.hasPermission("role.prosector")) {
                        target.addAttachment(OnePerm.plugin, "role.cop", false);
                        target.addAttachment(OnePerm.plugin, "role.student", false);
                        target.addAttachment(OnePerm.plugin, "role.mafia", false);
                        target.addAttachment(OnePerm.plugin, "role.fire", false);
                        target.addAttachment(OnePerm.plugin, "role.guide", false);
                        target.addAttachment(OnePerm.plugin, "role.law", false);
                        target.addAttachment(OnePerm.plugin, "role.broadcast", false);
                        target.addAttachment(OnePerm.plugin, "role.prosector", true);
                        target.addAttachment(OnePerm.plugin, "role.cityhall", false);
                        target.addAttachment(OnePerm.plugin, "role.execution", false);
                        target.addAttachment(OnePerm.plugin, "role.election", false);
                        target.addAttachment(OnePerm.plugin, "role.colleage", false);
                        target.addAttachment(OnePerm.plugin, "def.default", false);
                        target.sendMessage(ChatColor.GREEN + "[ONEPERM] " + ChatColor.BLUE + "검찰" + ChatColor.WHITE + "역할을 획득했습니다!");
                        target.playSound(target, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 9, 1);
                        target.closeInventory();
                        log.info("Set " + target.getName() + "'s permission to prosector");
                        log.info("Saving data..");
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".cop", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".student", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".mafia", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".fire", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".guide", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".law", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".broadcast", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".prosector", true);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".cityhall", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".execution", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".election", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".colleage", false);
                        OnePerm.plugin.getCustomConfig().save(OnePerm.plugin.customConfigFile);
                        target.recalculatePermissions();
                    }
                }

                if (e.getCurrentItem().getType() == Material.BOOK && e.getCurrentItem().getItemMeta().hasDisplayName()) { // colleage
                    if (!target.hasPermission("role.colleage")) {
                        target.addAttachment(OnePerm.plugin, "role.cop", false);
                        target.addAttachment(OnePerm.plugin, "role.student", false);
                        target.addAttachment(OnePerm.plugin, "role.mafia", false);
                        target.addAttachment(OnePerm.plugin, "role.fire", false);
                        target.addAttachment(OnePerm.plugin, "role.guide", false);
                        target.addAttachment(OnePerm.plugin, "role.law", false);
                        target.addAttachment(OnePerm.plugin, "role.broadcast", false);
                        target.addAttachment(OnePerm.plugin, "role.prosector", false);
                        target.addAttachment(OnePerm.plugin, "role.cityhall", false);
                        target.addAttachment(OnePerm.plugin, "role.execution", false);
                        target.addAttachment(OnePerm.plugin, "role.election", false);
                        target.addAttachment(OnePerm.plugin, "role.colleage", true);
                        target.addAttachment(OnePerm.plugin, "def.default", true);
                        target.sendMessage(ChatColor.GREEN + "[ONEPERM] " + ChatColor.BLUE + "대학교원" + ChatColor.WHITE + "역할을 획득했습니다!");
                        target.playSound(target, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 9, 1);
                        target.closeInventory();
                        log.info("Set " + target.getName() + "'s permission to colleage");
                        log.info("Saving data..");
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".cop", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".student", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".mafia", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".fire", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".guide", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".law", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".broadcast", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".prosector", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".cityhall", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".execution", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".election", false);
                        OnePerm.plugin.getCustomConfig().set(target.getName() + ".colleage", true);
                        OnePerm.plugin.getCustomConfig().save(OnePerm.plugin.customConfigFile);
                        target.recalculatePermissions();
                    }
                }
                e.setCancelled(true);
            }

            if (e.getView().getTitle().equalsIgnoreCase("부직업 선택")) {
                if (e.getCurrentItem() == null || e.getCurrentItem().equals(Material.AIR)) {
                    return;
                }

                e.setCancelled(true);
            }
        } else {
            return;
        }
    }

    @EventHandler
    public void onDropItemFromInventory(PlayerDropItemEvent e) {
        if(e.getItemDrop().getItemStack().getType() == Material.DIAMOND_SWORD && e.getItemDrop().getItemStack().getItemMeta().hasDisplayName()) {
            e.setCancelled(true);
        } else if (e.getItemDrop().getItemStack().getType() == Material.SUGAR && e.getItemDrop().getItemStack().getItemMeta().hasDisplayName()) {
            e.setCancelled(true);
        } else if (e.getItemDrop().getItemStack().getType() == Material.LAVA_BUCKET && e.getItemDrop().getItemStack().getItemMeta().hasDisplayName()) {
            e.setCancelled(true);
        } else if (e.getItemDrop().getItemStack().getType() == Material.BOOK && e.getItemDrop().getItemStack().getItemMeta().hasDisplayName()) {
            e.setCancelled(true);
        } else if (e.getItemDrop().getItemStack().getType() == Material.LECTERN && e.getItemDrop().getItemStack().getItemMeta().hasDisplayName()) {
            e.setCancelled(true);
        } else if (e.getItemDrop().getItemStack().getType() == Material.OBSERVER && e.getItemDrop().getItemStack().getItemMeta().hasDisplayName()) {
            e.setCancelled(true);
        } else if (e.getItemDrop().getItemStack().getType() == Material.NETHERITE_AXE && e.getItemDrop().getItemStack().getItemMeta().hasDisplayName()) {
            e.setCancelled(true);
        } else if (e.getItemDrop().getItemStack().getType() == Material.PAPER && e.getItemDrop().getItemStack().getItemMeta().hasDisplayName()) {
            e.setCancelled(true);
        } else if (e.getItemDrop().getItemStack().getType() == Material.SPYGLASS && e.getItemDrop().getItemStack().getItemMeta().hasDisplayName()) {
            e.setCancelled(true);
        } else if (e.getItemDrop().getItemStack().getType() == Material.ENCHANTED_BOOK && e.getItemDrop().getItemStack().getItemMeta().hasDisplayName()) {
            e.setCancelled(true);
        }
    }
}
