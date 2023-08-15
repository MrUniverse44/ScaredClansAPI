package me.blueslime.scaredclans.clan;

import me.blueslime.slimelib.file.configuration.ConfigurationHandler;
import me.blueslime.scaredclans.ScaredClans;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("unused")
public class Clan {
    private final List<String> members = new ArrayList<>();
    private final List<String> allies = new ArrayList<>();


    private Clan(ScaredClans plugin, String id, File file) {

    }

    private Clan(ConfigurationHandler settings, String id) {

    }

    public static Clan of(ScaredClans plugin, String id, File file) {
        return new Clan(plugin, id, file);
    }

    public static Clan of(ConfigurationHandler settings, String id) {
        return new Clan(settings, id);
    }

    public boolean contains(boolean online, Player player) {
        return false;
    }

    public void setKills(int kills) {
    }

    public String getLeader() {
        return "";
    }

    public String getName() {
        return "";
    }

    public String getTag() {
        return "";
    }

    public String getId() {
        return "";
    }

    public int getKills() {
        return 0;
    }

    public void addKill() {
        addKills(1);
    }

    public void removeKill() {
        removeKills(1);
    }

    public void setAllies(List<String> allies) {}

    public void addKills(int kills) {

    }

    public void removeKills(int kills) {
    }

    public void setName(String name) {
    }

    public boolean setTag(String tag, int limit) {
        return false;
    }

    public File getFile() {
        return null;
    }

    public List<String> getMembers() {
        return members;
    }

    public List<String> getAllies() {
        return allies;
    }

    public void addAlly(String id) {
    }

    public void removeAlly(String id) {
        removeAlly(id, false);
    }

    public void removeAlly(String id, boolean redirect) {

    }

    public List<String> getMembers(boolean includeLeader) {
        return Collections.emptyList();
    }

    public void save(ScaredClans plugin) {
    }
}
