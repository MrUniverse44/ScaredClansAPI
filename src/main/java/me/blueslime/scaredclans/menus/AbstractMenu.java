package me.blueslime.scaredclans.menus;

import me.blueslime.scaredclans.ScaredClans;
import me.blueslime.scaredclans.storage.ClanStorage;
import me.blueslime.scaredclans.storage.UserStorage;
import me.blueslime.slimelib.file.configuration.ConfigurationHandler;
import me.blueslime.slimelib.logs.SlimeLogs;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.Locale;

public abstract class AbstractMenu {
    private final ConfigurationHandler configuration;
    private final ScaredClans plugin;
    private final File file;

    public AbstractMenu(ScaredClans plugin, ConfigurationHandler configuration, File file) {
        this.configuration = configuration;
        this.plugin = plugin;
        this.file = file;

        load();
    }

    public abstract void load();

    public abstract void openMenu(Player player);

    public void openMenu(Player player, String extraData) {
        openMenu(player);
    }

    public ConfigurationHandler getConfiguration() {
        return configuration;
    }

    public SlimeLogs getLogs() {
        return plugin.getLogs();
    }

    public ScaredClans getPlugin() {
        return plugin;
    }

    public ClanStorage getClans() {
        return plugin.getStorage();
    }

    public UserStorage getUsers() {
        return plugin.getUserLoader();
    }

    public String getUniqueId() {
        return getFile().getName()
                .toLowerCase(Locale.ENGLISH)
                .replace(".yml", "");
    }

    public boolean hasPlaceholders() {
        return plugin.getServer().getPluginManager().isPluginEnabled("PlaceholderAPI");
    }

    public File getFile() {
        return file;
    }
}
