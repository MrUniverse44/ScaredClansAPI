package me.blueslime.scaredclans.api.events;

import me.blueslime.scaredclans.clan.Clan;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ClanKickEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    private final String kickedUUID;

    private final String kickedName;

    private final Player owner;

    private final Clan clan;

    public ClanKickEvent(Player owner, String kickedId, Clan clan) {
        this.owner = owner;
        this.kickedUUID = kickedId.contains("-") ? kickedId : null;
        this.kickedName = (this.kickedUUID == null) ? kickedId : null;
        this.clan = clan;
    }

    public Clan getClan() {
        return this.clan;
    }

    public String getKickedUUID() {
        return this.kickedUUID;
    }

    public String getKickedName() {
        return this.kickedName;
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
