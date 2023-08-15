package me.blueslime.scaredclans.api.events;

import me.blueslime.scaredclans.clan.Clan;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ClanDeleteEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    private final Player owner;

    private final Clan clan;

    public ClanDeleteEvent(Player owner, Clan clan) {
        this.owner = owner;
        this.clan = clan;
    }

    public Clan getClan() {
        return this.clan;
    }

    public Player getOwner() {
        return this.owner;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
