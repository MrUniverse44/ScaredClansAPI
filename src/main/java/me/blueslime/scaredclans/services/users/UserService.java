package me.blueslime.scaredclans.services.users;

import me.blueslime.bukkitmeteor.implementation.module.RegisteredModule;
import me.blueslime.scaredclans.storage.internal.PluginStorage;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserService implements RegisteredModule {

    public void enableChat(Player player) {

    }

    public void disableChat(Player player) {

    }

    public List<UUID> getChats() {
        return new ArrayList<>();
    }

    public PluginStorage<UUID, UUID> getDamageTable() {
        return PluginStorage.initAsHash();
    }

    public PluginStorage<UUID, Long> getExpirationTable() {
        return PluginStorage.initAsHash();
    }
}


