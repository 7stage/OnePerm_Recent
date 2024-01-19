package com.songro.oneperm.util;

import com.songro.oneperm.OnePerm;
import org.bukkit.Bukkit;
import org.kohsuke.github.*;

import java.io.IOException;
import java.util.logging.Logger;

public class UpdateFromGithub {

    Logger log = Bukkit.getLogger();

    public UpdateFromGithub() {
        try {
            log.info("[ONEPERM] Checking Updates..");
            GitHub gitAPI = new GitHubBuilder().withOAuthToken("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").build(); // need new token here.
            GHRepository repo = gitAPI.getRepository("sujeb2/OnePermReleases");
            GHRelease latestRelease = repo.getLatestRelease();

            if(latestRelease.getName() != OnePerm.plugin.ver) {
                log.warning("[ONEPERM] 오래된 버전의 OnePerm을 사용하고 있습니다, https://github.com/sujeb2/OnePermReleases/releases/latest 에서 최신버전의 OnePerm을 받아주세요.");
            } else {
                log.info("[ONEPERM] No Updates has been found.");
            }

            log.info("[ONEPERM] Done."); // done status
        } catch (IOException e) {
            log.severe("[ONEPERM] Cannot connect server.");
            log.severe("[ONEPERM] " + e);
        }
    }

}
