package com.songro.oneperm.events.item.drug;

import com.songro.oneperm.recipe.drug.weed;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CocaineEvent implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack holdingItem = p.getInventory().getItemInMainHand();

        if(e.getAction() == Action.RIGHT_CLICK_AIR) {
            if(p.getItemInHand() != null) {
                if (p.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.RED + "[ 코케인 ]") && p.getItemInHand().getItemMeta() != null) {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 20 * 15, 0), true);
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20 * 15, 1), true);
                    p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 20 * 30, 0), true);
                    p.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 20 * 30, 1), true);
                    p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 20 * 30, 1), true);
                    if (holdingItem.getAmount() == 1) {
                        p.getInventory().removeItem(new weed().weedItem());
                    } else {
                        p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount() - 1);
                    }
                    holdingItem.setAmount(holdingItem.getAmount() - 1);
                }
            }
        } else {
            return;
        }
    }
}
