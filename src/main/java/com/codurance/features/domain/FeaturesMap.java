package com.codurance.features.domain;

import java.util.HashMap;
import java.util.Map;

public class FeaturesMap {

    private Map<String, Boolean> featuresMap = new HashMap<>();

    public boolean get(String feature){
        if (null!=featuresMap.get(feature)){
            return featuresMap.get(feature);
        }
        return false;
    }


}
