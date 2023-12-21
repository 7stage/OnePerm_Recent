package com.songro.oneperm.events.player;

import com.songro.oneperm.OnePerm;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.IOException;
import java.util.logging.Logger;

public class CreatePlayerRoleData implements Listener {

    @EventHandler
    public void onJoinCreateData(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        Logger log = Bukkit.getLogger();

        if(OnePerm.plugin.getCustomConfig().getConfigurationSection(p.getName()) == null) {
            try {
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
                OnePerm.plugin.getCustomConfig().set(p.getName() + ".data.department", "없음");
                OnePerm.plugin.getCustomConfig().save(OnePerm.plugin.customConfigFile);
            } catch (IOException er) {
                p.sendMessage(ChatColor.RED + "CRITICAL: COULDN'T SAVE FILE CAUSE OF: IOEXCEPTION OCCURRED\nCRITICAL: CAUSED PLUGIN: OnePerm\nCRITICAL: " + er.getLocalizedMessage());
            }
        } else {
            log.info("[ONEPERM] player " + p.getName() + " has data on it, ignoring.");
        }
    }

}
