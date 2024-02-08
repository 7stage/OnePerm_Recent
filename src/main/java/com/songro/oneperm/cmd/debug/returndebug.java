package com.songro.oneperm.cmd.debug;

import com.songro.oneperm.OnePerm;
import net.luckperms.api.LuckPermsProvider;
import org.bukkit.ChatColor;
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

        if(p.getName().equals("notSongro_") || p.getName().equals("Dakeberry")) {
            p.sendMessage("start debugging information from: " + p.getName());
            p.sendMessage("mail count: ", String.valueOf(OnePerm.plugin.getCustomConfig().getInt(p.getName() + ".data.mailcount")));
            p.sendMessage("setting.getMailFromPlayer: " + OnePerm.plugin.getCustomConfig().getBoolean(p.getName() + ".setting.getMailFromPlayer"));
            p.sendMessage("active potion effect: \n" + p.getActivePotionEffects());
            p.sendMessage("warn count: " + OnePerm.plugin.getCustomConfig().getInt(p.getName() + ".data.playerWarnStack"));
            p.sendMessage("did command load? -> " + OnePerm.plugin.loadedCommand);
            p.sendMessage("did event load? -> " + OnePerm.plugin.loadedEvent);
            p.sendMessage("did player data load? -> " + OnePerm.plugin.loadedData);
            p.sendMessage("did nation data load? -> " + OnePerm.plugin.loadedNationData);
            p.sendMessage("did world data load? -> " + OnePerm.plugin.loadedNationData);
            p.sendMessage("did all configuration load? -> " + OnePerm.plugin.loadedAll);
            p.sendMessage("did vault api load? -> null");
            p.sendMessage("build date: 20240208");
            p.sendMessage("recent traceback: \n" + Thread.currentThread().getStackTrace()[0]);
            try {
                p.sendMessage("check luckperms api (from ServiceManager) -> " + OnePerm.plugin.api.getUserManager().isLoaded(p.getUniqueId()));
            } catch (NullPointerException e) {
                p.sendMessage(ChatColor.RED + "check luckperms api (from ServiceManager) -> CANNOT FIND API PROVIDER");
                p.sendMessage(ChatColor.YELLOW + "caused by: " + e.getCause().toString() + "\n Stacktrace: " + e.getStackTrace()[0]);
                OnePerm.plugin.getLogger().severe("[ONEPERM] 제대로된 LuckPerms API 제공자를 찾을수 없습니다.");
                OnePerm.plugin.getLogger().severe("[ONEPERM] 이 메세지가 나오는것은 플러그인 버그가 아닙니다, 서버와 통신에 문제가 있음을 의미합니다.");
                OnePerm.plugin.getLogger().severe("[ONEPERM] 다른 플러그인과 충돌이 발생한거일수도 있습니다.");
                OnePerm.plugin.getLogger().severe(String.format("[ONEPERM] 에러 스택 : %s", e.getStackTrace()[0]));
            }
            p.sendMessage("check luckperms api (from singleton method) -> " + LuckPermsProvider.get().getUserManager().isLoaded(p.getUniqueId()));
            if (strings.length > 0) {
                if (strings[0].length() > 0) {
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

        return true;
    }
}