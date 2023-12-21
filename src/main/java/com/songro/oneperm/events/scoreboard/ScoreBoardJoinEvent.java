package com.songro.oneperm.events.scoreboard;

import com.songro.oneperm.OnePerm;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.*;

import java.util.Arrays;
import java.util.logging.Logger;

public class ScoreBoardJoinEvent implements Listener {

    @EventHandler
    public void onJoinCreateScore(PlayerJoinEvent e) {
        Logger log = Bukkit.getLogger();
        Player player = e.getPlayer();

        ScoreboardManager scoreBoardM = OnePerm.plugin.getServer().getScoreboardManager();
            Scoreboard scoreBoard = scoreBoardM.getNewScoreboard();
            Objective obj = scoreBoard.registerNewObjective("plhealth", Criteria.HEALTH, "health");

            obj.setDisplaySlot(DisplaySlot.BELOW_NAME);
            obj.setDisplayName(ChatColor.RED + "❤");

                log.info("added.");


        player.setScoreboard(scoreBoard);
    }

}
