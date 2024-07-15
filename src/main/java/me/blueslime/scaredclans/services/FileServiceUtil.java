package me.blueslime.scaredclans.services;

import me.blueslime.bukkitmeteor.implementation.Implements;
import me.blueslime.bukkitmeteor.utils.FileUtil;
import me.blueslime.scaredclans.ScaredClans;
import me.blueslime.scaredclans.utils.resource.LocalResource;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.InputStream;

public class FileServiceUtil {
    public static InputStream fetchResource(ScaredClans plugin, String location) {
        InputStream src = FileUtil.build(location);
        return src != null ? src : plugin.getResource(location);
    }

    public static InputStream fetchResource(String location) {
        return fetchResource(Implements.fetch(ScaredClans.class), location);
    }

    public static FileConfiguration fetch(ScaredClans plugin, String location) {
        InputStream src = FileUtil.build(location);
        src = src == null ? plugin.getResource(location) : src;

        File fetchFile = new File(plugin.getDataFolder(), location);

        FileUtil.saveResource(fetchFile, src);

        return YamlConfiguration.loadConfiguration(
                fetchFile
        );
    }

    public static void generateDefault(File folder, LocalResource... menus) {
        ScaredClans plugin = Implements.fetch(ScaredClans.class);
        for (LocalResource menu : menus) {
            FileUtil.saveResource(
                    new File(
                            folder,
                            menu.getFile()
                    ),
                    menu.getSrc() != null ?
                            menu.getSrc() :
                            menu.getResource() != null ?
                                    plugin.getResource(menu.getResource()) : null
            );
        }
    }
}

