package com.songro.oneperm;

/*
 _____  _____  _____  _____  _____  _____  _____
|     ||   | ||   __||  _  ||   __|| __  ||     |
|  |  || | | ||   __||   __||   __||    -|| | | |
|_____||_|___||_____||__|   |_____||__|__||_|_|_|
BY. NOTSONGRO_

주의사항:
    코드를 수정하기 전에:
       - 코맨트가 되어있고, 옆에 특이사항이 적혀있지 않는 이상
       - 왠만하면 비활성화된 명령어 입니다.
       - 코드의 주석은 총 3단계로 나눠집니다 (info, warn, to-do), info는 말그대로 정보 warn은 경고, to-do는 해야할껄 적어두었습니다.

    코드의 저작권 관련해서:
       - 모든 코드는 GPL-3.0 License 의 라이선스를 따릅니다.
       - 수정을 허가하되, 소스코드로 배포시 모든 저작권및 라이선스 정보를 유지및 수정 사항에 대한 고지 포함.
       - 또는, 바이너리 형태로 배포시 오픈소스 고지문 작성및 프로그램과 같이 동봉, 수정 사항에 대한 고지 포함 필요.

    이러한 점 정말로 죄송해요:
       - 코드가 생각보다 스파게티 형식입니다, 처음 소스코드를 봤을때 뭐가 어디로 연결되는지 이해가 잘 안되실꺼에요.
       - 대부분의 코드는 야매로(?) 만들어졌습니다
 */

import com.songro.oneperm.cmd.*;
import com.songro.oneperm.cmd.bank.*;
import com.songro.oneperm.cmd.cmdforcmd.RemoveAllPerm;
import com.songro.oneperm.cmd.cmdforcmd.StartMafiaTerror;
import com.songro.oneperm.cmd.cmdforcmd.mafia.StartREALMafiaTerror;
import com.songro.oneperm.cmd.debug.ConnectExternServer;
import com.songro.oneperm.cmd.debug.GetGroupFromPlayer;
import com.songro.oneperm.cmd.debug.returndebug;
import com.songro.oneperm.cmd.gui.GiveCstItemGUI;
import com.songro.oneperm.events.gui.BankCreationClickEvent;
import com.songro.oneperm.events.gui.InventoryClick;
import com.songro.oneperm.events.item.IfDroppedItemGrenade;
import com.songro.oneperm.events.item.MarriageRingCheckClick;
import com.songro.oneperm.events.item.drug.CocaineEvent;
import com.songro.oneperm.events.item.drug.HeroineEvent;
import com.songro.oneperm.events.item.drug.WeedEvent;
import com.songro.oneperm.events.player.CreatePlayerRoleData;
import com.songro.oneperm.events.player.OnPlayerDeath;
import com.songro.oneperm.events.player.PlayerJoinQuitEvent;
import com.songro.oneperm.events.scoreboard.ScoreBoardJoinEvent;
import com.songro.oneperm.recipe.drug.cocaine;
import com.songro.oneperm.recipe.drug.heroine;
import com.songro.oneperm.recipe.drug.weed;
import com.songro.oneperm.role.fisher.cmd.SellFish;
import com.songro.oneperm.role.fisher.event.OnFishing;
import com.songro.oneperm.role.fisher.event.SetFishItem;
import com.songro.oneperm.role.robbery.event.StealRandomItemFromPlayer;
import com.songro.oneperm.task.DailyWage;
import net.luckperms.api.LuckPerms;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.logging.Logger;

public final class OnePerm extends JavaPlugin {

    Logger log = Bukkit.getLogger();
    public static OnePerm plugin;

    public String ver = "2.0";
    private FileConfiguration config;
    private FileConfiguration worlddata;
    private FileConfiguration nationdata;
    private FileConfiguration bankcreatedata;
    public File customConfigFile;
    public File worlddatafile;
    public File nationDatafile;
    public File bankCreationFile;


    public boolean loadedCommand = false;
    public boolean loadedEvent = false;
    public boolean loadedAll = false;
    public boolean loadedNationData = false;
    public boolean loadedBankData = false;
    public boolean loadedData = false;

    public static Economy econ = null;
    public LuckPerms api;

    @Override
    public void onEnable() {
        plugin = this;
        log.info("[ONEPERM] Enabling..");

        log.info("[ONEPERM] Setup LuckPermsAPI..");
        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        if (provider != null) {
            log.warning("[ONEPERM] API not set, resetting..");
            api = provider.getProvider();
        }
        log.info("[ONEPERM] Done.");

        if(!setupEconomy()) {
            log.severe("[ONEPERM] Vault dependency(이)가 발견되지 않아. 플러그인을 종료합니다, Vault 플러그인이 있는게 맞나요?");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        try {
            log.info("[ONEPERM] Loading player permission config..");
            createCustomConfig();
            log.info("[ONEPERM] Loading world data..");
            createWorldData();
            log.info("[ONEPERM] Loading nation data..");
            createNationData();
            log.info("[ONEPERM] Loading bank data..");
            createBankCreationData();
            log.info("[ONEPERM] Loading commands...");
            Objects.requireNonNull(getCommand("reloadconfiguration")).setExecutor(new ReloadConfig());
            Objects.requireNonNull(getCommand("version")).setExecutor(new Version());
            Objects.requireNonNull(getCommand("qmessage")).setExecutor(new Message2Player());
            Objects.requireNonNull(getCommand("giveallcstitem")).setExecutor(new GiveAllCustomItem());
            Objects.requireNonNull(getCommand("rmp")).setExecutor(new RemoveAllPerm());
            Objects.requireNonNull(getCommand("removeallpermission")).setExecutor(new RemovePlayerPermission());
            Objects.requireNonNull(getCommand("givecstitem")).setExecutor(new GiveCstItemGUI());
            Objects.requireNonNull(getCommand("smf")).setExecutor(new StartMafiaTerror());
            Objects.requireNonNull(getCommand("smt")).setExecutor(new StartREALMafiaTerror());
            Objects.requireNonNull(getCommand("genterrornpc")).setExecutor(new SpwnterrorNPC());
            Objects.requireNonNull(getCommand("deposit")).setExecutor(new CreateMoney());
            Objects.requireNonNull(getCommand("depositplayer")).setExecutor(new DepositMoney2Player());
            Objects.requireNonNull(getCommand("removemoney")).setExecutor(new RemoveMoney());
            Objects.requireNonNull(getCommand("resetbank")).setExecutor(new ResetPlayerBank());
            Objects.requireNonNull(getCommand("chkwarn")).setExecutor(new ChkPlayerWarn()); // warn: these commands were disabled due the admin told to.
            Objects.requireNonNull(getCommand("warnplayer")).setExecutor(new WarnPlayer()); // warn: same one as before.
            Objects.requireNonNull(getCommand("treasury")).setExecutor(new GetNationMoney());
            Objects.requireNonNull(getCommand("savechunk")).setExecutor(new SaveChunkData());
            //Objects.requireNonNull(getCommand("createbank")).setExecutor(new CreateBank()); // warn: due to bankaccept command has been disabled, this one too.
            Objects.requireNonNull(getCommand("bankinfo")).setExecutor(new BankInfo());
            //Objects.requireNonNull(getCommand("bankaccept")).setExecutor(new CreateBankDataGUI()); // warn: this command were disabled due to EssentialX Plugin won't accept bank creation.
            Objects.requireNonNull(getCommand("rtndbginf")).setExecutor(new returndebug());
            Objects.requireNonNull(getCommand("send")).setExecutor(new ConnectExternServer());
            Objects.requireNonNull(getCommand("rtngroup")).setExecutor(new GetGroupFromPlayer());
            Objects.requireNonNull(getCommand("sellfish")).setExecutor(new SellFish());
            log.info("[ONEPERM] Loaded.");
            loadedCommand = true;
        } catch (Exception e) {
            log.severe("명령어 로드중 오류가 발생하였습니다.");
            e.printStackTrace();
        }

        try {
            log.info("[ONEPERM] Loading Events..");
            //getServer().getPluginManager().registerEvents(new ChangePrefixPlayerName(), this); // info: disabled due to some minor changes to main server skript func.
            //getServer().getPluginManager().registerEvents(new CheckPlayerPermission(), this); // info: same as up
            getServer().getPluginManager().registerEvents(new InventoryClick(), this);
            getServer().getPluginManager().registerEvents(new PlayerJoinQuitEvent(), this);
            getServer().getPluginManager().registerEvents(new IfDroppedItemGrenade(), this);
            getServer().getPluginManager().registerEvents(new ScoreBoardJoinEvent(), this);
            //getServer().getPluginManager().registerEvents(new ScoreboardSideBarEvent(), this); // info: this event has been disabled due to change to skript.
            getServer().getPluginManager().registerEvents(new MarriageRingCheckClick(), this);
            getServer().getPluginManager().registerEvents(new OnPlayerDeath(), this);
            getServer().getPluginManager().registerEvents(new CreatePlayerRoleData(), this);
            getServer().getPluginManager().registerEvents(new WeedEvent(), this);
            //getServer().getPluginManager().registerEvents(new ChkPlayerChunkChange(), this); // info: this feature is disabled due to some bugs on main server
            getServer().getPluginManager().registerEvents(new BankCreationClickEvent(), this);
            getServer().getPluginManager().registerEvents(new CocaineEvent(), this);
            getServer().getPluginManager().registerEvents(new HeroineEvent(), this);
            getServer().getPluginManager().registerEvents(new OnFishing(), this);
            getServer().getPluginManager().registerEvents(new SetFishItem(), this);
            getServer().getPluginManager().registerEvents(new StealRandomItemFromPlayer(), this);
            log.info("[ONEPERM] Loaded.");
            loadedEvent = true;
        } catch (Exception e) {
            log.severe("[ONEPERM] 이벤트 로드중 오류가 발생하였습니다.");
            e.printStackTrace();
        }

        try {
            log.info("[ONEPERM] 등록중..");
            new BukkitRunnable() {
                @Override
                public void run() {
                    new DailyWage().Daily();
                }
            }.runTaskTimerAsynchronously(this, 0, 20);
        } catch (Exception e) {
            log.severe("[ONEPERM] 등록중 오류가 발생했습니다.");
            e.printStackTrace();
        }

        try {
            log.info("[ONEPERM] 레시피 등록중..");
            new weed().recipe();
            new heroine().recipe();
            new cocaine().recipe();
        } catch (Exception e) {
            log.severe("[ONEPERM] 등록중 오류가 발생했습니다.");
            e.printStackTrace();
        }

        //new UpdateFromGithub();

        if(loadedBankData && loadedNationData && loadedData) {
            loadedAll = true;
        }

        if (loadedCommand && loadedEvent && loadedAll) {
            log.info("[ONEPERM] 모든 이벤트가 로드되었습니다.");
            log.info("[ONEPERM] OnePerm - SOE");
        } else {
            log.warning("[ONEPERM] 모든 이벤트가 로드되지 못했습니다!");
            log.warning("[ONEPERM] 개발자에게 문의해주세요.");
        }
    }

    @Override
    public void onDisable() {
        log.info("[ONEPERM] Disabling..");
        log.info("[ONEPERM] Saving..");
        try {
            if(getCustomConfig() == null) {
                return;
            }
            getCustomConfig().save(customConfigFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void createCustomConfig() {
        customConfigFile = new File(getDataFolder(), "playerRoleData.yml");
        if (!customConfigFile.exists()) {
            log.warning("[ONEPERM] File not found, creating..");
            customConfigFile.getParentFile().mkdirs();
            saveResource("playerRoleData.yml", false);
            log.info("[ONEPERM] Created.");
        } else {
            log.info("[ONEPERM] File checked.");
        }

        config = new YamlConfiguration();
        try {
            config.load(customConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            log.severe("[ONEPERM] 설정을 불러오는중에 오류가 발생했습니다, 파일이 유효한가요?");
            e.printStackTrace();
            plugin.setEnabled(false);
        }
        loadedData = true;
    }

    public void createWorldData() {
        worlddatafile = new File(getDataFolder(), "worldData.yml");
        if (!worlddatafile.exists()) {
            log.warning("[ONEPERM] File not found, creating..");
            worlddatafile.getParentFile().mkdirs();
            saveResource("worldData.yml", false);
            log.info("[ONEPERM] Created.");
        } else {
            log.info("[ONEPERM] File checked.");
        }

        worlddata = new YamlConfiguration();
        try {
            worlddata.load(worlddatafile);
        } catch (IOException | InvalidConfigurationException e) {
            log.severe("[ONEPERM] 월드 설정을 불러오는중에 오류가 발생했습니다, 파일이 유효한가요?");
            e.printStackTrace();
            plugin.setEnabled(false);
        }
        loadedNationData = true;
    }

    public void createNationData() {
        nationDatafile = new File(getDataFolder(), "nationData.yml");
        if (!nationDatafile.exists()) {
            log.warning("[ONEPERM] File not found, creating..");
            nationDatafile.getParentFile().mkdirs();
            saveResource("nationData.yml", false);
            log.info("[ONEPERM] Created.");
        } else {
            log.info("[ONEPERM] File checked.");
        }

        nationdata = new YamlConfiguration();
        try {
            nationdata.load(nationDatafile);
        } catch (IOException | InvalidConfigurationException e) {
            log.severe("[ONEPERM] 국가 설정을 불러오는중에 오류가 발생했습니다, 파일이 유효한가요?");
            e.printStackTrace();
            plugin.setEnabled(false);
        }
        loadedNationData = true;
    }

    public void createBankCreationData() {
        bankCreationFile = new File(getDataFolder(), "bankCreationData.yml");
        if (!bankCreationFile.exists()) {
            log.warning("[ONEPERM] File not found, creating..");
            bankCreationFile.getParentFile().mkdirs();
            saveResource("bankCreationData.yml", false);
            log.info("[ONEPERM] Created.");
        } else {
            log.info("[ONEPERM] File checked.");
        }

        bankcreatedata = new YamlConfiguration();
        try {
            bankcreatedata.load(bankCreationFile);
        } catch (IOException | InvalidConfigurationException e) {
            log.severe("[ONEPERM] 국가 설정을 불러오는중에 오류가 발생했습니다, 파일이 유효한가요?");
            e.printStackTrace();
            plugin.setEnabled(false);
        }
        loadedBankData = true;
    }

    private boolean setupEconomy() {
        try {
            if (getServer().getPluginManager().getPlugin("Vault") == null) {
                log.warning("[ONEPERM] Vault 플러그인이 발견되지 않았습니다.");
                return false;
            } else {
                log.info("[ONEPERM] Found vault plugin.");
            }
            RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
            if (rsp == null) {
                log.warning("[ONEPERM] 이코노미 확장 플러그인이 발견되지 않았습니다.");
                return false;
            } else {
                log.info("[ONEPERM] Found Economy.");
            }
            econ = rsp.getProvider();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public FileConfiguration getCustomConfig() {
        return this.config;
    }
    public FileConfiguration getWorldData() {
        return worlddata;
    }
    public FileConfiguration getNationData() {
        return nationdata;
    }
    public FileConfiguration getBankCreateData() { return bankcreatedata; }
}
