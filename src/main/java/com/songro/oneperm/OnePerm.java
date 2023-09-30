package com.songro.oneperm;

import com.songro.oneperm.cmd.CstbanPlayer;
import com.songro.oneperm.cmd.GivePermission2Player;
import com.songro.oneperm.events.ChangePrefixPlayerName;
import com.songro.oneperm.events.CheckIfPlayerOnVoidBlk;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.logging.Logger;

public final class OnePerm extends JavaPlugin {

    Logger log = Bukkit.getLogger();
    public static OnePerm plugin;

    @Override
    public void onEnable() {
        plugin = this;
        log.info("Enabling..");
        try { // enabling luckperm api
            log.info("[ONEPERM] Trying to add luckperms api.");
            RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        } catch (Exception e) {
            log.severe("LuckPerm API cannot start cause of service provider is off-line.");
            log.severe(e.getMessage());
        }

        try {
            Objects.requireNonNull(getCommand("giveperm")).setExecutor(new GivePermission2Player());
            Objects.requireNonNull(getCommand("banplayer")).setExecutor(new CstbanPlayer());
        } catch (Exception e) {
            log.severe("명령어 로드중 오류가 발생하였습니다.");
            log.severe(e.getMessage());
        }

        try {
            log.info("[ONEPERM] Loading Events..");
            getServer().getPluginManager().registerEvents(new CheckIfPlayerOnVoidBlk(), this);
            getServer().getPluginManager().registerEvents(new ChangePrefixPlayerName(), this);
            log.info("[ONEPERM] Loaded.");
        } catch (Exception e) {
            log.severe("이벤트 로드중 오류가 발생하였습니다.");
            log.severe(e.getMessage());
        }
    }

    @Override
    public void onDisable() {
        log.info("Disabling..");
    }
}
