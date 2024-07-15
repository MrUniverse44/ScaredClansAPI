package me.blueslime.scaredclans.hooks;

import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

public class VaultHook {
    private static RegisteredServiceProvider<?> service = null;

    public static boolean executePayment(Player player) {
        return false;
    }
}
