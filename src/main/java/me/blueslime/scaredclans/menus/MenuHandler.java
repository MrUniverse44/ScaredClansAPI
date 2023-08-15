package me.blueslime.scaredclans.menus;

import me.blueslime.scaredclans.ScaredClans;
import me.blueslime.scaredclans.menus.types.LocalMenu;
import me.blueslime.scaredclans.storage.internal.PluginStorage;
import me.blueslime.slimelib.logs.SlimeLogs;

import java.io.File;

public class MenuHandler {

    private final PluginStorage<String, AbstractMenu> menuStorage = PluginStorage.initAsConcurrentHash();
    private final ScaredClans plugin;

    public MenuHandler(ScaredClans plugin) {
        this.plugin = plugin;
    }

    public void initialize() {

    }

    /**
     * Get a specified menu using the file name
     * @param key is the file name (including .yml)
     * @return null if the menu don't exist
     */
    public AbstractMenu getSpecifiedMenu(String key) {
        return null;
    }

    public void generateDefault(SlimeLogs logs, File folder, LocalMenu... menus) {
    }
}
