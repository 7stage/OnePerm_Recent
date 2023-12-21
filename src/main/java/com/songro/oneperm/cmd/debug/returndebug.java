package com.songro.oneperm.cmd.debug;

import com.songro.oneperm.OnePerm;
import com.songro.oneperm.task.ChkPlayerPerm;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class returndebug implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player p = (Player) commandSender;

        if(p.getName() == "notSongro_" || p.getName() == "Dakeberry") {
            p.sendMessage("start debugging information from: " + p.getName());
            p.sendMessage("role data: \n", String.valueOf(OnePerm.plugin.getCustomConfig().getBoolean(p.getName() + ".role")));
            p.sendMessage("mailcount: ", String.valueOf(OnePerm.plugin.getCustomConfig().getInt(p.getName() + ".data.mailcount")));
            p.sendMessage("department: " + OnePerm.plugin.getCustomConfig().getString(p.getName() + ".data.department"));
            p.sendMessage("active potion effect: \n" + p.getActivePotionEffects());
            p.sendMessage("did command load? -> " + OnePerm.plugin.loadedCommand);
            p.sendMessage("did event load? -> " + OnePerm.plugin.loadedEvent);
            p.sendMessage("did player data load? -> " + OnePerm.plugin.loadedData);
            p.sendMessage("did nation data load? -> " + OnePerm.plugin.loadedNationData);
            p.sendMessage("did world data load? -> " + OnePerm.plugin.loadedNationData);
            p.sendMessage("did all configuration load? -> " + OnePerm.plugin.loadedAll);
            p.sendMessage("current player role (return from func): " + new ChkPlayerPerm().chkperm(p));
            if (strings.length > 0) {
                if (strings[0].length() > 0) {
                    p.sendMessage("specfic player uuid: " + Bukkit.getPlayerUniqueId(strings[0]).toString());

                }
            }
            p.sendMessage("info end.");
        }

        return true;
    }
}
