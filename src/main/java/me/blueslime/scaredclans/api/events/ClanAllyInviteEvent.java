package me.blueslime.scaredclans.api.events;

import me.blueslime.scaredclans.clan.Clan;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ClanAllyInviteEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    private final Player owner;

    private final Player invited;

    private final Clan clan;

    public ClanAllyInviteEvent(Player owner, Player invited, Clan clan) {
        this.invited = invited;
        this.owner = owner;
        this.clan = clan;
    }

    public Clan getClan() {
        return this.clan;
    }

    public Player getInvited() {
        return this.invited;
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
