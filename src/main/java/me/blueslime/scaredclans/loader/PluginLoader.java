package me.blueslime.scaredclans.loader;

import me.blueslime.slimelib.loader.BaseSlimeLoader;
import me.blueslime.scaredclans.ScaredClans;
import org.bukkit.plugin.java.JavaPlugin;

public class PluginLoader extends BaseSlimeLoader<JavaPlugin> {
    private final ScaredClans plugin;

    public PluginLoader(ScaredClans plugin) {
        super(plugin);

        this.plugin = plugin;
    }

    @Override
    public void init() {
        if (getFiles() != null) {
            getFiles().init();
        }
    }

    @Override
    public void shutdown() {
        getCommands().unregister();
    }

    @Override
    public void reload() {
        getFiles().reloadFiles();
    }
}
