package com.songro.oneperm.events.scoreboard;

import com.songro.oneperm.OnePerm;
import com.songro.oneperm.task.ChkPlayerPerm;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

import static com.songro.oneperm.OnePerm.econ;

public class ScoreBoardLeftEvent implements Listener {

    final Map<UUID, Scoreboard> boards = new HashMap<>();
    private static final Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();

    @EventHandler
    public void onJoinPlayer(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        Logger log = Bukkit.getLogger();

        boards.put(p.getUniqueId(), board);

        OnePerm.plugin.getServer().getScheduler().runTaskTimer(OnePerm.plugin, () -> {
            for(Player player : Bukkit.getOnlinePlayers()) {
                updateScoreboard(player, board);
            }
        }, 0, 20);

        log.info("added sidebar.");
    }

    public void updateScoreboard(Player p, Scoreboard board) {
        String roleName = new ChkPlayerPerm().chkperm(p);
        Objective obj = board.registerNewObjective("playerside", "sidebar");

        obj.setDisplayName(ChatColor.GOLD + "servernamehere");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);

        setObjective(obj, ChatColor.STRIKETHROUGH + "◆                              ◆", 11);
        setObjective(obj, ChatColor.BOLD + "[ 플레이어 ]", 10);
        setObjective(obj, ChatColor.GOLD + " ◼ " + ChatColor.WHITE + "직업: " + roleName, 9);
        setObjective(obj, ChatColor.GOLD + " ◼ " + ChatColor.WHITE + "지갑: " + econ.format(econ.getBalance(p.getName())), 8);
        setObjective(obj, "", 7);
        setObjective(obj, ChatColor.BOLD + "[ 서버 ]", 6);
        setObjective(obj, ChatColor.GOLD + " ◼ " + ChatColor.WHITE + "인구: " + Bukkit.getServer().getOnlinePlayers().size() + " / " + Bukkit.getServer().getMaxPlayers(), 5);
        setObjective(obj, ChatColor.GOLD + " ◼ " + ChatColor.WHITE + "서버 핑: " + p.getPing() + "ms", 4);
        setObjective(obj, "", 3);
        setObjective(obj, ChatColor.GOLD + "    SERVERLINKHERE    ", 2);
        setObjective(obj, ChatColor.STRIKETHROUGH + "◆                              ◆", 1);

        p.setScoreboard(boards.get(p.getUniqueId()));
    }

    private void setObjective(Objective obj, String name, int score) {
        Score scr = obj.getScore(name);
        scr.setScore(score);
    }
}
