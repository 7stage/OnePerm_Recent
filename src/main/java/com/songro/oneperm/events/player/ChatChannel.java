package com.songro.oneperm.events.player;

import com.songro.oneperm.OnePerm;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class ChatChannel implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        OnePerm.plugin.channelManager.joinChannel(e.getPlayer(), "일반1");
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        e.getRecipients().clear();
        OnePerm.plugin.channelManager.getChannel(p).stream().forEach(player -> e.getRecipients().add(player));
    }
}
