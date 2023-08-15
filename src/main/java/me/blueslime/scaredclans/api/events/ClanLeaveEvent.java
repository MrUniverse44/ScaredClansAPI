package me.blueslime.scaredclans.api.events;

import me.blueslime.scaredclans.clan.Clan;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ClanLeaveEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    private final Player player;

    private final Clan clan;

    public ClanLeaveEvent(Player player, Clan clan) {
        this.player = player;
        this.clan = clan;
    }

    public Clan getClan() {
        return this.clan;
    }

    public Player getPlayer() {
        return this.player;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}

