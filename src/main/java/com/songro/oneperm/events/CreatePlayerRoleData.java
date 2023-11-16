package com.songro.oneperm.events;

import com.songro.oneperm.OnePerm;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.logging.Logger;

public class CreatePlayerRoleData implements Listener {

    @EventHandler
    public void onJoinCreateData(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        Logger log = Bukkit.getLogger();

        if(OnePerm.plugin.getCustomConfig().getConfigurationSection(p.getName()) == null) {
            log.warning("[ONEPERM] Player " + p.getName() + " has no data on it, creating it.");
            OnePerm.plugin.getCustomConfig().set(p.getName() + ".cop", false);
            OnePerm.plugin.getCustomConfig().set(p.getName() + ".student", false);
            OnePerm.plugin.getCustomConfig().set(p.getName() + ".mafia", false);
            OnePerm.plugin.getCustomConfig().set(p.getName() + ".fire", false);
            OnePerm.plugin.getCustomConfig().set(p.getName() + ".guide", false);
            OnePerm.plugin.getCustomConfig().set(p.getName() + ".law", false);
            OnePerm.plugin.getCustomConfig().set(p.getName() + ".broadcast", false);
            OnePerm.plugin.getCustomConfig().set(p.getName() + ".prosector", false);
            OnePerm.plugin.getCustomConfig().set(p.getName() + ".cityhall", false);
            OnePerm.plugin.getCustomConfig().set(p.getName() + ".execution", false);
            OnePerm.plugin.getCustomConfig().set(p.getName() + ".election", false);
            OnePerm.plugin.getCustomConfig().set(p.getName() + ".colleage", false);
            OnePerm.plugin.getCustomConfig().set(p.getName() + ".bank", false);
            OnePerm.plugin.getCustomConfig().set(p.getName() + ".data.playerWarnStack", 0);
            OnePerm.plugin.getCustomConfig().set(p.getName() + ".data.mailcount", 0);
        } else {
            return;
        }
    }

}
