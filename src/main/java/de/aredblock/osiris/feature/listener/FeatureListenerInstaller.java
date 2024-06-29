package de.aredblock.osiris.feature.listener;

import de.aredblock.osiris.OsirisPlugin;
import de.aredblock.osiris.feature.Feature;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.ApiStatus;

import java.util.HashMap;
import java.util.Map;

@ApiStatus.Internal
public final class FeatureListenerInstaller {

    @Deprecated
    private static final Map<Feature, Listener> listeners = new HashMap<>();

    @ApiStatus.Internal
    public static void install(Feature feature, OsirisPlugin plugin){
        switch (feature){
            case BLOCK_BREAKING -> {
                var listener = new BlockBreakListener();
                listeners.put(feature, listener);
                Bukkit.getPluginManager().registerEvents(listener, plugin);
            }
            case BLOCK_PLACING -> {
                var listener = new BlockPlacingListener();
                listeners.put(feature, listener);
                Bukkit.getPluginManager().registerEvents(listener, plugin);
            }

            case FALL_DAMAGE -> {
                var listener = new FallDamageListener();
                listeners.put(feature, listener);
                Bukkit.getPluginManager().registerEvents(listener, plugin);
            }
            case HUNGER -> {
                var listener = new HungerListener();
                listeners.put(feature, listener);
                Bukkit.getPluginManager().registerEvents(listener, plugin);
            }
        }
    }

}
