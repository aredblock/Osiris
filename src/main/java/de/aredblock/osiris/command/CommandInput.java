package de.aredblock.osiris.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class CommandInput {

    private final CommandSender sender;
    private final String[] args;

    private boolean cancelled = false;

    public CommandInput(CommandSender sender, String[] args) {
        this.sender = sender;
        this.args = args;
    }

    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }

    public boolean isFromPlayer(){
        return sender instanceof Player;
    }

    public Player getPlayer() {
        return isFromPlayer() ? (Player) sender : null;
    }

    public CommandSender getSender() {
        return sender;
    }

    public boolean isCancelled() {
        return cancelled;
    }

}
