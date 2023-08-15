package me.blueslime.scaredclans.hooks;

import me.blueslime.scaredclans.api.ScaredClansAPI;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;

public class VaultHook {
    private static RegisteredServiceProvider<?> service = null;

    public static boolean executePayment(Player player) {
        return false;
    }
}
