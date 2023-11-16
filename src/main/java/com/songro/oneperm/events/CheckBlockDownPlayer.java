package com.songro.oneperm.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class CheckBlockDownPlayer implements Listener {

    @EventHandler
    public void onWalk(PlayerMoveEvent pme) {
        Player player = pme.getPlayer(); // 귀찮아서 그냥 복사함

        // op only
        if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getBlockData().getMaterial() == Material.YELLOW_WOOL) {
            if (player.hasPermission("role.op")) {
                return;
            } else {
                player.sendMessage(ChatColor.GOLD + "[ONEPERM]" + ChatColor.YELLOW + " 접근할수 없는 구역을 들어갈려고 합니다, 이 내용은 권한이 있는 사용자에게 전송됩니다.");
                Bukkit.broadcast( ChatColor.RED + "[ONEPERM] 권한이 없는 사용자" + player.getName() + "(이)가 특정 구역에 접근할려고 합니다.", "role.op");
            }
        }

        // guide
        if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getBlockData().getMaterial() == Material.RED_WOOL) {
            if (player.hasPermission("role.guide") || player.hasPermission("role.op")) {
                return;
            } else {
                player.sendMessage(ChatColor.GOLD + "[ONEPERM]" + ChatColor.YELLOW + " 접근할수 없는 구역을 들어갈려고 합니다, 이 내용은 권한이 있는 사용자에게 전송됩니다.");
                Bukkit.broadcast( ChatColor.RED + "[ONEPERM] 권한이 없는 사용자" + player.getName() + "(이)가 특정 구역에 접근할려고 합니다.", "role.guide");
            }
        }

        // citizen = non
        if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getBlockData().getMaterial() == Material.WHITE_WOOL) {
            return;
        }

        // firefighter
        if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getBlockData().getMaterial() == Material.ORANGE_WOOL) {
            if (player.hasPermission("role.fire") || player.hasPermission("role.op")) {
                return;
            } else {
                player.sendMessage(ChatColor.GOLD + "[ONEPERM]" + ChatColor.YELLOW + " 접근할수 없는 구역을 들어갈려고 합니다, 이 내용은 권한이 있는 사용자에게 전송됩니다.");
                Bukkit.broadcast( ChatColor.RED + "[ONEPERM] 권한이 없는 사용자" + player.getName() + "(이)가 특정 구역에 접근할려고 합니다.", "role.fire");
            }
        }

        // law
        if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getBlockData().getMaterial() == Material.BROWN_WOOL) {
            if (player.hasPermission("role.law") || player.hasPermission("role.op")) {
                return;
            } else {
                player.sendMessage(ChatColor.GOLD + "[ONEPERM]" + ChatColor.YELLOW + " 접근할수 없는 구역을 들어갈려고 합니다, 이 내용은 권한이 있는 사용자에게 전송됩니다.");
                Bukkit.broadcast( ChatColor.RED + "[ONEPERM] 권한이 없는 사용자" + player.getName() + "(이)가 특정 구역에 접근할려고 합니다.", "role.law");
            }
        }

        // mafia
        if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getBlockData().getMaterial() == Material.BLACK_WOOL) {
            if (player.hasPermission("role.mafia") || player.hasPermission("role.op")) {
                return;
            } else {
                player.sendMessage(ChatColor.GOLD + "[ONEPERM]" + ChatColor.YELLOW + " 접근할수 없는 구역을 들어갈려고 합니다, 이 내용은 권한이 있는 사용자에게 전송됩니다.");
                Bukkit.broadcast( ChatColor.RED + "[ONEPERM] 권한이 없는 사용자" + player.getName() + "(이)가 특정 구역에 접근할려고 합니다.", "role.mafia");
            }
        }

        // cop
        if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getBlockData().getMaterial() == Material.LIGHT_BLUE_WOOL) {
            if (player.hasPermission("role.cop") || player.hasPermission("role.op")) {
                return;
            } else {
                player.sendMessage(ChatColor.GOLD + "[ONEPERM]" + ChatColor.YELLOW + " 접근할수 없는 구역을 들어갈려고 합니다, 이 내용은 권한이 있는 사용자에게 전송됩니다.");
                Bukkit.broadcast( ChatColor.RED + "[ONEPERM] 권한이 없는 사용자" + player.getName() + "(이)가 특정 구역에 접근할려고 합니다.", "role.cop");
            }
        }

        // city hall
        if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getBlockData().getMaterial() == Material.GREEN_WOOL) {
            if (player.hasPermission("role.cityhall") || player.hasPermission("role.op")) {
                return;
            } else {
                player.sendMessage(ChatColor.GOLD + "[ONEPERM]" + ChatColor.YELLOW + " 접근할수 없는 구역을 들어갈려고 합니다, 이 내용은 권한이 있는 사용자에게 전송됩니다.");
                Bukkit.broadcast( ChatColor.RED + "[ONEPERM] 권한이 없는 사용자" + player.getName() + "(이)가 특정 구역에 접근할려고 합니다.", "role.cityhall");
            }
        }

        // high school
        if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getBlockData().getMaterial() == Material.LIME_WOOL) {
            if (player.hasPermission("role.cityhall") || player.hasPermission("role.op") || player.hasPermission("role.student")) {
                return;
            } else {
                player.sendMessage(ChatColor.GOLD + "[ONEPERM]" + ChatColor.YELLOW + " 접근할수 없는 구역을 들어갈려고 합니다, 이 내용은 권한이 있는 사용자에게 전송됩니다.");
                Bukkit.broadcast( ChatColor.RED + "[ONEPERM] 권한이 없는 사용자" + player.getName() + "(이)가 특정 구역에 접근할려고 합니다.", "role.cityhall");
            }
        }

        // idk
        if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getBlockData().getMaterial() == Material.MAGENTA_WOOL) {
            if (player.hasPermission("role.prosector") || player.hasPermission("role.op")) {
                return;
            } else {
                player.sendMessage(ChatColor.GOLD + "[ONEPERM]" + ChatColor.YELLOW + " 접근할수 없는 구역을 들어갈려고 합니다, 이 내용은 권한이 있는 사용자에게 전송됩니다.");
                Bukkit.broadcast( ChatColor.RED + "[ONEPERM] 권한이 없는 사용자" + player.getName() + "(이)가 특정 구역에 접근할려고 합니다.", "role.prosector");
            }
        }

        // election
        if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getBlockData().getMaterial() == Material.PURPLE_WOOL) {
            if (player.hasPermission("role.election") || player.hasPermission("role.op")) {
                return;
            } else {
                player.sendMessage(ChatColor.GOLD + "[ONEPERM]" + ChatColor.YELLOW + " 접근할수 없는 구역을 들어갈려고 합니다, 이 내용은 권한이 있는 사용자에게 전송됩니다.");
                Bukkit.broadcast( ChatColor.RED + "[ONEPERM] 권한이 없는 사용자" + player.getName() + "(이)가 특정 구역에 접근할려고 합니다.", "role.election");
            }
        }

        // broadcast
        if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getBlockData().getMaterial() == Material.PINK_WOOL) {
            if (player.hasPermission("role.broadcast") || player.hasPermission("role.op")) {
                return;
            } else {
                player.sendMessage(ChatColor.GOLD + "[ONEPERM]" + ChatColor.YELLOW + " 접근할수 없는 구역을 들어갈려고 합니다, 이 내용은 권한이 있는 사용자에게 전송됩니다.");
                Bukkit.broadcast( ChatColor.RED + "[ONEPERM] 권한이 없는 사용자" + player.getName() + "(이)가 특정 구역에 접근할려고 합니다.", "role.broadcast");
            }
        }

    }

}
