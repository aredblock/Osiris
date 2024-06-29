package de.aredblock.osiris;

import de.aredblock.osiris.command.CommandManager;
import de.aredblock.osiris.command.CommandRegistry;
import de.aredblock.osiris.feature.listener.FeatureListenerInstaller;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.ApiStatus;

public abstract class OsirisPlugin extends JavaPlugin {

    private final OsirisBuilder builder;

    protected OsirisPlugin(OsirisBuilder builder) {
        this.builder = builder;
    }

    @ApiStatus.Internal
    @Override
    public void onEnable() {
        builder.getDisabledFeatures().forEach(feature -> {
            FeatureListenerInstaller.install(feature, this);
        });
        builder.registered = true;
        onInitialize();
    }

    @ApiStatus.Internal
    @Override
    public void onDisable() {
        onShutdown();
    }

    public void registerCommandRegistry(CommandRegistry registry){
        CommandManager.registerCommands(registry, this);
    }

    public OsirisBuilder getBuilder() {
        return builder;
    }

    public abstract void onInitialize();
    public abstract void onShutdown();

}
