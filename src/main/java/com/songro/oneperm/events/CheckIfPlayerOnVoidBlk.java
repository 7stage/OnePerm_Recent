package com.songro.oneperm.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.logging.Logger;

public class CheckIfPlayerOnVoidBlk implements Listener {

    Logger log = Bukkit.getLogger();

    @EventHandler
    public void onWalk(PlayerMoveEvent pme) {
        Player player = pme.getPlayer(); // 귀찮아서 그냥 복사함

        if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getBlockData().getMaterial() == Material.RED_CARPET) { // dont
            if (player.hasPermission("role.op")) {
                return;
            } else {
                player.sendMessage(ChatColor.GOLD + "[ONEPERM]" + ChatColor.YELLOW + " 권한이 부족하여 접근할수 없는 구역입니다.");
                Bukkit.broadcast( ChatColor.RED + "[ONEPERM] 권한이 없는 사용자가 특정 구역에 접근할려고 합니다.", "role.op");
            }
        }

        // warn
        if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getBlockData().getMaterial() == Material.YELLOW_CARPET) { // dont
            if (player.hasPermission("role.cop")) {
                return;
            } else {
                player.sendMessage(ChatColor.GOLD + "[ONEPERM]" + ChatColor.YELLOW + " 권한이 부족하여 접근할수 없는 구역입니다.");
                Bukkit.broadcast( ChatColor.RED + "[ONEPERM] 권한이 없는 사용자가 특정 구역에 접근할려고 합니다.", "role.op");
            }
        }
    }

}
