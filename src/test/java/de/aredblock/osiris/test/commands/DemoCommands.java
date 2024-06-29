package de.aredblock.osiris.test.commands;

import de.aredblock.osiris.command.CommandInput;
import de.aredblock.osiris.command.CommandRegistry;
import de.aredblock.osiris.command.RegisterCommand;

public final class DemoCommands implements CommandRegistry {

    @RegisterCommand(name = "demo")
    public void demoCommand(CommandInput input){
        if(input.isFromPlayer()){
            var player = input.getPlayer();

            player.sendMessage("Hello World! From Osiris!");
        }
    }

}
