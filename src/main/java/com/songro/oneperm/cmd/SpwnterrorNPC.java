package com.songro.oneperm.cmd;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Logger;

public class SpwnterrorNPC implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player player = (Player)commandSender;
        Logger log = Bukkit.getLogger();
        Location playerLocation = player.getLocation();

        log.info("[ONEPERM] Citizens Dependecy 불러오는중...");
        try {
            NPCRegistry registry =  CitizensAPI.getNPCRegistry();
            NPC npc = registry.createNPC(EntityType.PLAYER, ChatColor.YELLOW + "[ 테러 NPC ]");
            npc.spawn(playerLocation);
            log.info("[ONEPERM] 불러와짐.");
        } catch (Exception e) {
            log.severe("[ONEPERM] Citizens Dependecy를 로드하는중 오류가 발생하였습니다, Citizens2 플러그인이 있나요?");
            log.severe(e.getMessage());
        }

        return true ;
    }
}
