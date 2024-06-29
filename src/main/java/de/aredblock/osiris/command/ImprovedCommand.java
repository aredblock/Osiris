package de.aredblock.osiris.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginIdentifiableCommand;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Method;

class ImprovedCommand extends Command implements PluginIdentifiableCommand {

    private final JavaPlugin plugin;

    private final Method method;
    private final Object instance;

    protected ImprovedCommand(String name, JavaPlugin plugin, Method method, Object instance) {
        super(name);
        this.plugin = plugin;
        this.method = method;
        this.instance = instance;
    }

    @Override
    public boolean execute(@NotNull CommandSender commandSender, @NotNull String s, @NotNull String[] strings) {
        try {
            var input = new CommandInput(commandSender, strings);
            method.invoke(instance, input);

            return !input.isCancelled();
        }catch (Exception ignore){}
        return false;
    }

    @Override
    public @NotNull Plugin getPlugin() {
        return plugin;
    }

}
