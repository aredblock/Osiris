package de.aredblock.osiris;

import de.aredblock.osiris.feature.Feature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class OsirisBuilder {

    private final List<Feature> disabledFeatures = new ArrayList<>();

    boolean registered = false;

    public OsirisBuilder disable(Feature feature){
        disabledFeatures.add(feature);
        return this;
    }

    public OsirisBuilder disable(Feature... features){
        Arrays.stream(features).forEach(this::disable);
        return this;
    }

    public boolean isDisabled(Feature feature){
        return disabledFeatures.contains(feature);
    }

    public static OsirisBuilder builder(){
        return new OsirisBuilder();
    }

    List<Feature> getDisabledFeatures() {
        return disabledFeatures;
    }

}
