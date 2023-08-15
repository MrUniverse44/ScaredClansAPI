package me.blueslime.scaredclans.api;

import me.blueslime.slimelib.file.configuration.ConfigurationHandler;
import me.blueslime.scaredclans.ScaredClans;
import me.blueslime.scaredclans.storage.ClanStorage;
import org.bukkit.plugin.java.JavaPlugin;

public class ScaredClansAPI {

    public static ScaredClans get() {
        return JavaPlugin.getPlugin(ScaredClans.class);
    }

    public static ConfigurationHandler getSettings() {
        return get().getSettings();
    }

    public static ConfigurationHandler getMessages() {
        return get().getMessages();
    }

    public static ClanStorage getStorage() {
        return get().getStorage();
    }
}
