package me.blueslime.scaredclans;

import me.blueslime.scaredclans.menus.MenuHandler;
import me.blueslime.slimelib.SlimeFiles;
import me.blueslime.slimelib.SlimePlatform;
import me.blueslime.slimelib.SlimePlugin;
import me.blueslime.slimelib.SlimePluginInformation;
import me.blueslime.slimelib.file.configuration.ConfigurationHandler;
import me.blueslime.slimelib.logs.SlimeLogger;
import me.blueslime.slimelib.logs.SlimeLogs;
import me.blueslime.scaredclans.files.Configuration;
import me.blueslime.scaredclans.loader.PluginLoader;
import me.blueslime.scaredclans.storage.ClanStorage;
import org.bukkit.plugin.java.JavaPlugin;


public final class ScaredClans extends JavaPlugin implements SlimePlugin<JavaPlugin> {

    private final ClanStorage clanStorage = new ClanStorage(this);
    private final MenuHandler menuHandler = new MenuHandler(this);

    private final SlimeLogs logs = SlimeLogger.createLogs(
            getServerType(),
            this,
            "ScaredClans"
    );


    @Override
    public SlimePluginInformation getPluginInformation() {
        return null;
    }

    @Override
    public PluginLoader getLoader() {
        return null;
    }

    public ClanStorage getStorage() {
        return clanStorage;
    }

    @Override
    public SlimePlatform getServerType() {
        return SlimePlatform.BUKKIT;
    }

    public ConfigurationHandler getCommand() {
        return getConfiguration(Configuration.COMMAND);
    }

    public ConfigurationHandler getMessages() {
        return getConfiguration(Configuration.MESSAGES);
    }

    public ConfigurationHandler getSettings() {
        return getConfiguration(Configuration.SETTINGS);
    }

    public ConfigurationHandler getConfiguration(SlimeFiles file) {
        return getConfigurationHandler(file);
    }

    @Override
    public SlimeLogs getLogs() {
        return logs;
    }

    @Override
    public JavaPlugin getPlugin() {
        return this;
    }

    @Override
    public void reload() {

        clanStorage.update();

        menuHandler.initialize();
    }

    public boolean hasPlaceholders() {
        return getServer().getPluginManager().isPluginEnabled("PlaceholderAPI");
    }
}
