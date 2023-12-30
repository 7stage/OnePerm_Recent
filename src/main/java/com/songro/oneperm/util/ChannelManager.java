package com.songro.oneperm.util;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;

public class ChannelManager {

    public HashMap<String, ArrayList<Player>> channels = new HashMap<String, ArrayList<Player>>();
    public HashMap<Player, String> playerChannel = new HashMap<Player,String>();

    /**
     *
     * @param player Player Object
     * @param channelName Current player channel name
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
     *
     * @param p Player Object
     * @param channelName Current Player Channel Name
     */
    public void leaveChannel(@NotNull Player p, @NotNull String channelName) {
        ArrayList<Player> plr = channels.get(channelName);
        plr.remove(p);
        channels.put(channelName, plr);
        playerChannel.remove(p);
    }

    /**
     *
     * @param player Player Object
     * @return channelName
     */
    public ArrayList<Player> getChannel(Player player){
        String channelName = playerChannel.get(player);
        return channels.get(channelName);
    }

}
