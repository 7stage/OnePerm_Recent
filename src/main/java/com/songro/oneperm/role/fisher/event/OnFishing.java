package com.songro.oneperm.role.fisher.event;

import com.songro.oneperm.OnePerm;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

import java.io.IOException;
import java.util.logging.Logger;

public class OnFishing implements Listener {

    @EventHandler
    public void onFish(PlayerFishEvent e) {
        String[] failedMsg = {"물고기가 도망쳤네,,", "앗!! 낚시줄이 끊어졌다...", "또?", "태초마을이다!", "물고기가 먹이만 먹고 도망쳤다!"};
        Player p = e.getPlayer();
        Logger log = Bukkit.getLogger();

        switch (e.getState()) {
            case BITE:
                p.playSound(p, Sound.ITEM_GOAT_HORN_SOUND_0, 8, 1);
                p.sendTitle("잡혔다!!", ChatColor.YELLOW + "이제 눌러보자!");

            case CAUGHT_FISH:
                if(e.getCaught() != null) {
                    p.playSound(p, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 9, 1);
                    p.sendTitle(ChatColor.GREEN + "잡았다!!", e.getCaught().getName() + " 을(를) 잡았다!");
                }
                try {
                    log.info("player " + p.getName() + " caught " + e.getCaught().getName());
                } catch (NullPointerException npe) {
                    log.warning("i don't know what " + p.getName() + " caught.");
                }

            case REEL_IN:
                p.sendActionBar(ChatColor.GRAY + "끌어 당기는중");

            case FISHING:
                p.playSound(p, Sound.BLOCK_COMPOSTER_FILL, 9, 1);
        }

        // failed state
        if(e.getState() == PlayerFishEvent.State.FISHING && e.getState() == PlayerFishEvent.State.FAILED_ATTEMPT) {
            double setRand = Math.random();
            int num = (int)Math.round(setRand * (failedMsg.length - 1));

            OnePerm.plugin.getCustomConfig().set(p.getName() + ".data.failedAttempt", OnePerm.plugin.getCustomConfig().getInt(p.getName() + ".data.failedAttempt") + 1);
            try {
                OnePerm.plugin.getCustomConfig().save(OnePerm.plugin.customConfigFile);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            p.sendTitle(ChatColor.RED + "실패..", ChatColor.GRAY + failedMsg[num]);
        }
    }

}
