package me.blueslime.scaredclans;

import me.blueslime.bukkitmeteor.BukkitMeteorPlugin;

public final class ScaredClans extends BukkitMeteorPlugin {

    @Override
    public void onEnable() {
        initialize(this);
    }

    @Override
    public void registerModules() {
        registerModule(

        ).finish();
    }

    public boolean hasPlaceholders() {
        return getServer().getPluginManager().isPluginEnabled("PlaceholderAPI");
    }
}
