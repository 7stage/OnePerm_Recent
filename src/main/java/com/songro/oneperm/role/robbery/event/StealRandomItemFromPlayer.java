package com.songro.oneperm.role.robbery.event;

import com.songro.oneperm.OnePerm;
import net.kyori.adventure.text.Component;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.Inventory;

import java.util.Objects;

public class StealRandomItemFromPlayer implements Listener {

    @EventHandler
    public void onShifting(PlayerToggleSneakEvent e) {
        Player p = e.getPlayer();
        LuckPerms api = LuckPermsProvider.get();
        User usr = api.getUserManager().getUser(p.getUniqueId());

        if(api != null) {
            if (e.isSneaking()) { // sneaking & punching
                assert usr != null;

                if (usr.getPrimaryGroup().equals("강도") || p.isOp()) {
                    World world = p.getWorld();
                    Player t = (Player) world.getNearbyPlayers(p.getLocation(), 1);
                    if (t != null) {
                        Inventory playerInv = p.getInventory();
                        Inventory targetInv = t.getInventory();
                        int itemSelected = 0;

                        if (!targetInv.isEmpty()) {
                            for (int i = 0; i < 10; i++) {
                                itemSelected = (int) (Math.random() * 40 + 1);
                            }
                            try {
                                playerInv.addItem(Objects.requireNonNull(targetInv.getItem(itemSelected)));
                                targetInv.removeItem(Objects.requireNonNull(targetInv.getItem(itemSelected)));
                                OnePerm.plugin.getLogger().info(p.getName() + " stole " + targetInv.getItem(itemSelected) + " from " + t.getName());
                            } catch (NullPointerException npe) {
                                p.sendMessage(ChatColor.YELLOW + "[ONEPERM] 소매치기를 할려는 플레이어의 인벤토리에 아무런 아이템이 없습니다!");
                            }
                        } else {
                            p.sendTitle("", ChatColor.RED + "소매치기 실패!");
                            p.playSound(p, Sound.BLOCK_ANVIL_USE, 5, 1);
                        }
                    }
                }
            }
        } else {
            OnePerm.plugin.getLogger().info("[ONEPERM] Cannot find LuckPerms API Provider");
            Bukkit.broadcast(Component.text(ChatColor.RED + "[ONEPERM] Cannot find LuckPerms API Provider."));
        }
    }

}
