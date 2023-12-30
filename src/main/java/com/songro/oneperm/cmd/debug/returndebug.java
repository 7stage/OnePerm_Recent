package com.songro.oneperm.cmd.debug;

import com.songro.oneperm.OnePerm;
import com.songro.oneperm.task.ChkPlayerPerm;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.File;

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
                    if(strings[0].equalsIgnoreCase("serverinfo")) {
                        long maxMemory = Runtime.getRuntime().maxMemory();
                        p.sendMessage("---------------------------------\nserver information start");
                        p.sendMessage("");
                        p.sendMessage("SERVER OS -> " + System.getProperty("os.name") + " " + System.getProperty("os.version") + " " + System.getProperty("os.arch"));
                        p.sendMessage("RAM -> " + Runtime.getRuntime().freeMemory() + "MB / " + (maxMemory == Long.MAX_VALUE ? "no limit" : maxMemory) + "MB");
                        p.sendMessage("TOTAL JVM RAM -> " + Runtime.getRuntime().totalMemory() + "MB");
                        p.sendMessage("JAVA VER -> " + System.getProperty("java.version"));
                        p.sendMessage("JAVA HOME DIR -> " + System.getProperty("java.home"));

                        File[] roots = File.listRoots();
                        for (File root : roots) {
                            p.sendMessage("ROOT -> " + root.getAbsolutePath());
                            p.sendMessage("TOTAL SPACE (bytes) -> " + root.getTotalSpace());
                            p.sendMessage("FREE SPACE (bytes) -> " + root.getFreeSpace());
                            p.sendMessage("USABLE SPACE (bytes) -> " + root.getUsableSpace());
                        }
                    }
                }
            }
            p.sendMessage("info end.");
        }

        return true;
    }
}
