package de.aredblock.osiris.feature.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

final class BlockPlacingListener implements Listener {

    @EventHandler
    public void onBlockPlaceEvent(BlockPlaceEvent event){
        event.setCancelled(true);
    }

}
