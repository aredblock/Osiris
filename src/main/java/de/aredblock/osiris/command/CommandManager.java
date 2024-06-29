package de.aredblock.osiris.command;

import de.aredblock.osiris.OsirisPlugin;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class CommandManager {

    @ApiStatus.Internal
    public static void registerCommands(CommandRegistry registry, OsirisPlugin plugin){
        var clazz = registry.getClass();
        var methods = clazz.getDeclaredMethods();

        for (var method : methods) {
            if(method.isAnnotationPresent(RegisterCommand.class)){
                var annotation = method.getAnnotation(RegisterCommand.class);

                Bukkit.getCommandMap().register(annotation.name(), new ImprovedCommand(annotation.name(), plugin, method, registry));
            }
        }
    }

}