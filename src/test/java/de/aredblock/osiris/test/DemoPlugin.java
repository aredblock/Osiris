package de.aredblock.osiris.test;

import de.aredblock.osiris.OsirisBuilder;
import de.aredblock.osiris.OsirisPlugin;
import de.aredblock.osiris.feature.Feature;
import de.aredblock.osiris.test.commands.DemoCommands;

public final class DemoPlugin extends OsirisPlugin {

    public DemoPlugin() {
        super(OsirisBuilder.builder()
                .disable(Feature.FALL_DAMAGE, Feature.BLOCK_PLACING, Feature.BLOCK_BREAKING, Feature.HUNGER));
    }

    @Override
    public void onInitialize() {
        registerCommandRegistry(new DemoCommands());

        getLogger().info("OsirisPlugin loaded!");
    }

    @Override
    public void onShutdown() {

    }

}
