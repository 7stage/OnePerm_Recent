package com.songro.oneperm.events.gui;

import com.songro.oneperm.OnePerm;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.io.IOException;

import static com.songro.oneperm.OnePerm.econ;

public class BankCreationClickEvent implements Listener {

    @EventHandler
    public void onClickInv(InventoryClickEvent e) throws IOException {
        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.BOLD + "[ 계좌 신청 승인 ]")) {
            e.setCancelled(true);
            Player p = (Player) e.getWhoClicked();

            if(e.getClick() == ClickType.RIGHT) {
                if(e.getCurrentItem() != null) {
                    OfflinePlayer t = Bukkit.getOfflinePlayer(e.getCurrentItem().getItemMeta().getDisplayName());
                    OnePerm.plugin.getBankCreateData().set(t.getName() + ".askedcreation", false);
                    OnePerm.plugin.getBankCreateData().save(OnePerm.plugin.bankCreationFile);
                    p.sendMessage(ChatColor.RED + "[ONEPERM] 거부됨");
                    p.closeInventory();
                }
            }

            if(e.getClick() == ClickType.LEFT) {
                if(e.getCurrentItem() != null) {
                    OfflinePlayer t = Bukkit.getOfflinePlayer(e.getCurrentItem().getItemMeta().getDisplayName());
                    EconomyResponse r = econ.createBank("pbank", t);
                    if(r.transactionSuccess()) {
                        OnePerm.plugin.getBankCreateData().set(t.getName() + ".data.iscreated", true);
                        OnePerm.plugin.getBankCreateData().save(OnePerm.plugin.bankCreationFile);
                        p.playSound(p, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 9, 1);
                        p.sendMessage(ChatColor.GREEN + "[ONEPERM] 생성됨");
                        p.closeInventory();
                    } else {
                        p.sendMessage(ChatColor.RED + "[ONEPERM] " + t.getName() + " 님의 계좌를 생성할수 없어요.");
                    }
                }
            }
        }
    }

}
