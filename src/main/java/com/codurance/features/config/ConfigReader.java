package com.codurance.features.config;

import com.codurance.features.domain.EnvironmentFeaturesMap;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

import java.util.HashMap;
import java.util.Map;

@Component
public class ConfigReader {

    public Map<String, EnvironmentFeaturesMap> loadFeaturesFile(String fileName) {
        Map<String, Map<String, Boolean>> readConfiguration = readYamlContent(fileName);

        Map<String, EnvironmentFeaturesMap> configuredFeatures = new HashMap<>();

        for (String environment : readConfiguration.keySet()) {
            EnvironmentFeaturesMap environmentFeaturesMap =
                    new EnvironmentFeaturesMap(readConfiguration.get(environment));

            configuredFeatures.put(environment, environmentFeaturesMap);
        }

        return configuredFeatures;
    }

    private Map<String, Map<String, Boolean>> readYamlContent(String fileName) {

        return (new Yaml()).load(this.getClass()
                .getClassLoader()
                .getResourceAsStream(fileName));
    }

}
