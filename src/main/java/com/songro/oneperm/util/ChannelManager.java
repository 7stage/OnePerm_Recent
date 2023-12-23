package com.songro.oneperm.util;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class ChannelManager {

    public HashMap<String, ArrayList<Player>> channels = new HashMap<String, ArrayList<Player>>();
    public HashMap<Player, String> playerChannel = new HashMap<Player,String>();

    /**
     *  Apply user to join certain text channel.
     */
    public void joinChannel(Player player, String channelName) {
        if(playerChannel.get(player) != null) {
            String prevChannel = playerChannel.get(player);
            leaveChannel(player, prevChannel);
        }

        ArrayList<Player> plr = channels.get(channelName);

        if(plr == null) {
            plr = new ArrayList<Player>();
        }
        plr.add(player);
        channels.put(channelName, plr);
        playerChannel.put(player, channelName);
        player.sendMessage(ChatColor.GREEN + "[ONEPERM] " + ChatColor.GOLD + channelName + " 채팅 채널에 입장하였습니다.");
    }

    /**
     *  Removes user to join certain text channel.
     */
    public void leaveChannel(Player p, String channelName) {
        ArrayList<Player> plr = channels.get(channelName);
        plr.remove(p);
        channels.put(channelName, plr);
        playerChannel.remove(p);
    }

    public ArrayList<Player> getChannel(Player p) {
        String channelName = playerChannel.get(p);
        return channels.get(channelName);
    }

}
