package me.blueslime.scaredclans.api;

import me.blueslime.bukkitmeteor.implementation.Implements;
import me.blueslime.scaredclans.ScaredClans;

public class ScaredClansAPI {

    public static ScaredClans get() {
        return Implements.fetch(ScaredClans.class);
    }

}
