package com.songro.oneperm.cmd;

import com.songro.oneperm.OnePerm;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;


public class SaveChunkData implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player p = (Player) commandSender;
        Location spawnLoc = p.getLocation();
        String chk = spawnLoc.getChunk().toString();

        try {
            if(commandSender instanceof Player) {
                if(p.isOp()) {
                    try {
                        if(strings[0].length() == 0) {
                            p.sendMessage(ChatColor.YELLOW + "[ONEPERM] 이름이 지정되지 않았습니다.");
                            return false;
                        }

                        OnePerm.plugin.getWorldData().set(chk, spawnLoc.getChunk().getChunkKey());
                        OnePerm.plugin.getWorldData().set(chk + ".chunkdata.name", strings[0]);
                        OnePerm.plugin.getWorldData().save(OnePerm.plugin.worlddatafile);
                        p.sendMessage(ChatColor.GREEN + "[ONEPERM] 청크 위치를 저장했습니다.");
                    } catch (Exception e) {
                        p.sendMessage(ChatColor.RED + "[ONEPERM] 저장중 오류가 발생했습니다.\n[ONEPERM] " + e.getMessage());
                    }
                } else {
                    p.sendMessage(ChatColor.YELLOW + "[ONEPERM] 이 명령어는 관리자만 사용할수 있습니다.");
                }
            } else {
                return true;
            }
        } catch (Exception e) {
            p.sendMessage(ChatColor.RED + "[ONEPERM] 에러가 발생했습니다.\n[ONEPERM] " + e.getMessage());
        }

        return true;
    }
}
