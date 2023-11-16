package com.songro.oneperm.task;

import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.songro.oneperm.OnePerm.econ;

public class DailyWage {

    public void Daily() {
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

        if(format.format(now).equals("00:00:00")) {
            for (OfflinePlayer p : Bukkit.getOfflinePlayers()) {
                EconomyResponse r = econ.depositPlayer(p, 100);
                if (r.transactionSuccess()) {
                    return;
                }
            }
        }
    }

}
