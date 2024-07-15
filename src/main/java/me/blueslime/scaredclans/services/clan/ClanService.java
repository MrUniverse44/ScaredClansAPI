package me.blueslime.scaredclans.services.clan;

import java.io.File;
import java.util.*;

import me.blueslime.bukkitmeteor.implementation.module.RegisteredModule;
import me.blueslime.scaredclans.clan.Clan;
import me.blueslime.scaredclans.storage.internal.PluginStorage;
import org.bukkit.entity.Player;

@SuppressWarnings("unused")
public class ClanService implements RegisteredModule {

    private static final PluginStorage<String, String> USER_CLAN_STORAGE = PluginStorage.initAsConcurrentHash();
    private static final PluginStorage<String, Clan> CLAN_STORAGE = PluginStorage.initAsHash();

    public ClanService() {
    }

    public void update() {

    }

    public String getNameMatch() {
        return "";
    }

    public boolean hasPayment() {
        return false;
    }

    public List<String> getBlacklistedNames() {
        return Collections.emptyList();
    }

    public boolean isVaultEnabled() {
        return false;
    }

    public double getPrice() {
        return 0;
    }

    public boolean exists(String name) {
        return false;
    }

    public boolean createClan(String name, Player owner) {
        return true;
    }

    public boolean removeClan(Clan clan) {
        return true;
    }

    public boolean removeClan(String name) {
        return true;
    }

    public File getClanFile(String name) {
        return null;
    }

    public Clan fetchClan(String userId) {
        return null;
    }

    public Clan fetchClan(Player player) {
        return fetchClan(
                isOnlineMode() ?
                        player.getUniqueId().toString() :
                        player.getName()
        );
    }

    public void join(Clan clan, String userId) {
    }

    public Clan fromCache(String clanID) {
        return null;
    }

    public Clan fromCache(Clan clan) {
        return null;
    }

    public void quit(String userId) {
    }

    public void quit(Player player) {
        quit(
                isOnlineMode() ?
                        player.getUniqueId().toString() :
                        player.getName()
        );
    }

    public Clan getClan(Player player) {
        return null;
    }

    public static PluginStorage<String, Clan> getClanStorage() {
        return CLAN_STORAGE;
    }

    public Clan getClan(String name) {
        return null;
    }

    public boolean addMember(Clan clan, Player player) {
        return true;
    }

    public Clan fromUser(String user) {
        return null;
    }

    public Clan fromUser(Player player) {
        return null;
    }

    public boolean removeMember(Clan clan, String name) {
        return true;
    }

    public String getUUID(String name) {
        return "";
    }

    public List<String> getTopStats() {
        return Collections.emptyList();
    }

    @SuppressWarnings("SameParameterValue")
    private Map<String, Integer> sortByComparator(final boolean order) {
        Map<String, Integer> TOP_MAP = new HashMap<>();

        return TOP_MAP;
    }

    public String getMembers(Clan clan) {
        return "";

    }

    public String getOwner(Clan clan) {
        return "";
    }

    public String getLeader(Clan clan) {
        return "";
    }

    public int getKills(Clan clan) {
        return 0;
    }

    public boolean hasTeamDamage() {
        return false;
    }

    public boolean hasSelfDamage() {
        return false;
    }

    public boolean isOnlineMode() {
        return true;
    }

    public int getLength() {
        return 0;
    }

    public int getLimit() {
        return 5;
    }
}
