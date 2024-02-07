package com.songro.oneperm.role.fisher.cmd;

import com.songro.oneperm.OnePerm;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static com.songro.oneperm.OnePerm.econ;

public class SellFish implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player p = (Player) commandSender;

        if (!p.getItemInHand().equals(ItemStack.empty())) {
            PlayerInventory inv = p.getInventory();
            ItemStack itemInMainHand = inv.getItemInMainHand();

            switch (itemInMainHand.getType()) {
                case COD:
                    if(Objects.requireNonNull(itemInMainHand.getItemMeta().getLore()).contains("레어")) {
                        sellFishOnType(p, itemInMainHand, 20000, "익히지 않은 대구", 15);
                    } else {
                        sellFishOnType(p, itemInMainHand, 15000, "익히지 않은 대구", 15);
                    }
                    break;
                case SALMON:
                    sellFishOnType(p, itemInMainHand, 20000, "익히지 않은 연어", 30);
                    break;
                case TROPICAL_FISH:
                    sellFishOnType(p, itemInMainHand, 30000, "열대어", 50);
                    break;
                case PUFFERFISH:
                    sellFishOnType(p, itemInMainHand, 25000, "복어", 35);
                    break;
                default:
                    p.sendMessage(ChatColor.RED + "[ONEPERM] 해당 아이템은 팔수 없습니다!");
                    break;
            }

        } else {
            p.sendMessage(ChatColor.YELLOW + "[ONEPERM] 손에 아무것도 들고있지 않습니다!");
        }

        return true;
    }

    public void sellFishOnType(Player pl, ItemStack item, int amount, String whatType, int exp) {
        EconomyResponse recon = econ.depositPlayer(pl, amount);
        if(recon.transactionSuccess()) {
            item.setAmount(item.getAmount() - 1);
            pl.playSound(pl, Sound.BLOCK_AMETHYST_BLOCK_BREAK, 9, 1);
            pl.sendMessage(ChatColor.GREEN + "[ONEPERM] " + whatType + " (을)를 " + amount + "원으로 파는데 성공하였습니다!");
            OnePerm.plugin.getCustomConfig().set(pl.getName() + ".data.exp.fishing", OnePerm.plugin.getCustomConfig().getInt(pl.getName() + ".data.exp.fishing") + exp);
        } else {
            pl.sendMessage(ChatColor.RED + "[ONEPERM] 물고기를 파는데 실패하였습니다.\n[ONEPERM] 사유: " + recon.errorMessage);
        }

    }
}
