package me.blueslime.scaredclans.api.command;

import me.blueslime.slimelib.commands.command.Command;
import me.blueslime.slimelib.commands.command.SlimeCommand;
import me.blueslime.scaredclans.api.ScaredClansAPI;

@Command()
public abstract class AddonCommand implements SlimeCommand {

    public void register() {
        ScaredClansAPI.get().getCommands().register(this);
    }

}
