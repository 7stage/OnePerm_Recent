package com.songro.oneperm.events.player;

import com.songro.oneperm.util.ChannelManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class ChatChannel implements Listener {
    ChannelManager cm = new ChannelManager();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        new ChannelManager().joinChannel(e.getPlayer(), "일반1");
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        e.getRecipients().clear();
        cm.getChannel(p).stream().forEach(player -> e.getRecipients().add(player));
    }
}
