package com.songro.oneperm.task;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.logging.Logger;

public class ChkPlayerPerm {

    public String chkperm(Player p) {
        Logger log = Bukkit.getLogger();

        //log.info("[ONEPERM] returning data..");
        if(p.hasPermission("role.cop")) {
            if(p.hasPermission("role.cop.cheif")) {
                return ChatColor.AQUA + "경찰청장";
            } else if(p.hasPermission("role.cop.superintendent")) {
                return ChatColor.AQUA + "경찰 치안총감";
            } else if(p.hasPermission("role.cop.sensesecurity")) {
                return ChatColor.AQUA + "경찰 치안정감";
            } else if(p.hasPermission("role.cop.alleviation")) {
                return ChatColor.AQUA + "경찰 경감";
            } else if(p.hasPermission("role.cop.boat")) {
                return ChatColor.AQUA + "경찰 경정";
            } else if(p.hasPermission("role.cop.inspector")) {
                return ChatColor.AQUA + "경찰 경위";
            } else if(p.hasPermission("role.cop.lightsuit")) {
                return ChatColor.AQUA + "경찰 경장";
            } else if(p.hasPermission("role.cop.cop")) {
                return ChatColor.AQUA + "순경";
            }
        } else if(p.hasPermission("role.mafia")) {
            if(p.hasPermission("role.mafia.boss")) {
                return ChatColor.DARK_GRAY + "마피아 보스";
            } else if(p.hasPermission("role.mafia.deputyboss")) {
                return ChatColor.DARK_GRAY + "마피아 부보스";
            } else if(p.hasPermission("role.mafia.cadre")) {
                return ChatColor.DARK_GRAY + "마피아 간부";
            } else if(p.hasPermission("role.mafia.mafia")) {
                return ChatColor.DARK_GRAY + "마피아";
            } else if(p.hasPermission("role.mafia.mafiasibo")) {
                return ChatColor.DARK_GRAY + "마피아 시보";
            }
        } else if(p.hasPermission("role.op")) {
            return ChatColor.RED + "관리자";
        } else if(p.hasPermission("role.fire")) {
            if(p.hasPermission("role.fire.cheif")) {
                return ChatColor.RED + "소방청장";
            } else if(p.hasPermission("role.fire.leader")) {
                return ChatColor.RED + "소방팀장";
            } else if(p.hasPermission("role.fire.fighter")) {
                return ChatColor.RED + "소방관";
            }
        } else if(p.hasPermission("role.guide")) {
            return ChatColor.DARK_PURPLE + "가이드";
        } else if(p.hasPermission("role.student")) {
            return ChatColor.DARK_GREEN + "학생";
        } else if(p.hasPermission("role.default")) {
            return ChatColor.DARK_GREEN + "시민";
        } else if(p.hasPermission("role.cityhall")) {
            return ChatColor.DARK_AQUA + "시청";
        } else if(p.hasPermission("role.election")) {
            return ChatColor.LIGHT_PURPLE + "선거위원회";
        } else if (p.hasPermission("role.colleage")) {
            if(p.hasPermission("role.colleage.leader")) {
                return ChatColor.BLUE + "대학교장";
            } else if(p.hasPermission("role.colleage.student")) {
                return ChatColor.BLUE + "대학교원";
            }
        } else if (p.hasPermission("role.bank")) {
            if (p.hasPermission("role.bank.president")) {
                return ChatColor.YELLOW + "은행 총재";
            } else if (p.hasPermission("role.bank.plan")) {
                return ChatColor.YELLOW + "은행 부총재";
            }
        } else if(p.hasPermission("role.broadcast")) {
            if(p.hasPermission("role.broadcast.leader")) {
                return ChatColor.GOLD + "방송관 원장";
            } else if(p.hasPermission("role.broadcast.deputyleader")) {
                return ChatColor.GOLD + "방송관 부원장";
            } else if(p.hasPermission("role.broadcast.director")) {
                return ChatColor.GOLD + "방송관 부장";
            } else if(p.hasPermission("role.broadcast.conductor")) {
                return ChatColor.GOLD + "방송관 차장";
            } else if(p.hasPermission("role.broadcast.headsection")) {
                return ChatColor.GOLD + "방송관 과장";
            } else if(p.hasPermission("role.broadcast.surrogate")) {
                return ChatColor.GOLD + "방송관 대리";
            } else if(p.hasPermission("role.cheif")) {
                return ChatColor.GOLD + "방송관 주임";
            } else if(p.hasPermission("role.broadcast.employee")) {
                return ChatColor.GOLD + "방송관 사원";
            }
        } else if(p.hasPermission("role.law")) {
            if(p.hasPermission("role.law.chiefjustice")) {
                return ChatColor.DARK_PURPLE + "대법원장";
            } else if(p.hasPermission("role.law.chancellor")) {
                return ChatColor.DARK_PURPLE + "대법관";
            } else if(p.hasPermission("role.law.cheifjudge")) {
                return ChatColor.DARK_PURPLE + "부장판사";
            } else if(p.hasPermission("role.law.reputable")) {
                return ChatColor.DARK_PURPLE + "평판사";
            } else if(p.hasPermission("role.law.judgepoetry")) {
                return ChatColor.DARK_PURPLE + "판사 시보";
            }
        } else if(p.hasPermission("role.execution")) {
            if(p.hasPermission("role.execution.chairmen")) {
                return ChatColor.DARK_RED + "집행위원장";
            } else if(p.hasPermission("role.execution.committee")) {
                return ChatColor.DARK_RED + "집행 위원회";
            }
        } else if(p.hasPermission("role.prosector")) {
            if(p.hasPermission("role.prosector.general")) {
                return ChatColor.DARK_BLUE + "검찰 총장";
            } else if(p.hasPermission("role.prosector.cheifinspection")) {
                return ChatColor.DARK_BLUE + "검사장";
            } else if(p.hasPermission("role.prosector.chief")) {
                return ChatColor.DARK_BLUE + "부장 검사";
            } else if(p.hasPermission("role.prosector.deputychief")) {
                return ChatColor.DARK_BLUE + "부부장검사";
            } else if(p.hasPermission("role.prosector.audit")) {
                return ChatColor.DARK_BLUE + "검사";
            } else if(p.hasPermission("role.prosector.inspection")) {
                return ChatColor.DARK_BLUE + "검사시보";
            }
        } else {
            return "none";
        }

        return "none";
    }
}
