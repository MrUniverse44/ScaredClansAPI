package me.blueslime.scaredclans.runnable;

import me.blueslime.slimelib.logs.SlimeLogs;
import me.blueslime.scaredclans.ScaredClans;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.Collection;

@SuppressWarnings({"UnusedReturnValue", "unused"})
public abstract class PluginRunnable extends BukkitRunnable {

    private final ScaredClans plugin;

    private boolean initialized = false;

    public PluginRunnable(ScaredClans plugin) {
        this.plugin = plugin;
    }

    public abstract void run();

    public void update() {

    }

    public void silencedCancellation() {
        initialized = false;
        try {
            cancel();
        } catch (Exception ignored) {}
    }

    public Collection<? extends Player> getOnlinePlayers() {
        return plugin.getServer().getOnlinePlayers();
    }

    public ScaredClans getPlugin() {
        return plugin;
    }

    public SlimeLogs getLogs() {
        return plugin.getLogs();
    }

    public synchronized BukkitTask runTask() throws IllegalArgumentException, IllegalStateException {
        initialized = true;
        return super.runTask(plugin);
    }

    public synchronized BukkitTask runTaskAsynchronously() throws IllegalArgumentException, IllegalStateException {
        initialized = true;
        return super.runTaskAsynchronously(plugin);
    }

    public synchronized BukkitTask runTaskLater(long delay) throws IllegalArgumentException, IllegalStateException {
        initialized = true;
        return super.runTaskLater(plugin, delay);
    }

    public synchronized BukkitTask runTaskLaterAsynchronously(long delay) throws IllegalArgumentException, IllegalStateException {
        initialized = true;
        return super.runTaskLaterAsynchronously(plugin, delay);
    }

    public synchronized BukkitTask runTaskTimer(long delay, long period) throws IllegalArgumentException, IllegalStateException {
        initialized = true;
        return super.runTaskTimer(plugin, delay, period);
    }

    public synchronized BukkitTask runTaskTimerAsynchronously(long delay, long period) throws IllegalArgumentException, IllegalStateException {
        initialized = true;
        return super.runTaskTimerAsynchronously(plugin, delay, period);
    }
}
