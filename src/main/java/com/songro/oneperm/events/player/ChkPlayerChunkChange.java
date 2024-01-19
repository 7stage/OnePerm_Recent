package com.songro.oneperm.events.player;

import com.songro.oneperm.OnePerm;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;


public class ChkPlayerChunkChange implements Listener {

    @EventHandler
    public void onChunkChange(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        Location playerLoc = p.getLocation();

        if(p.getWorld().getChunkAt(playerLoc).getChunkKey() == OnePerm.plugin.getWorldData().getLong(String.valueOf(p.getLocation().getChunk()))) {
            p.sendActionBar(ChatColor.GOLD + "[ 현재 " + OnePerm.plugin.getWorldData().getString(p.getLocation().getChunk() + ".chunkdata.name") + "을(를) 들어가고 있습니다. ]");
        }
    }

}
