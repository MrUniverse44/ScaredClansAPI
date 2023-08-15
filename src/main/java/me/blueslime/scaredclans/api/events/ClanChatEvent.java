package me.blueslime.scaredclans.api.events;

import me.blueslime.scaredclans.clan.Clan;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ClanChatEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final String message;
    private final Player player;
    private final Clan clan;

    private boolean cancel = false;

    public ClanChatEvent(Clan clan, Player player, String message) {
        this.message = message;
        this.player = player;
        this.clan = clan;
    }

    public String getMessage() {
        return message;
    }

    public Player getPlayer() {
        return player;
    }

    public Clan getClan() {
        return clan;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }
}
