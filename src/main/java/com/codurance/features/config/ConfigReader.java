package com.codurance.features.config;

import com.codurance.features.domain.ComponentFeaturesMap;
import com.codurance.features.domain.EnvironmentFeaturesMap;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

import java.util.HashMap;
import java.util.Map;

@Component
public class ConfigReader {

    public Map<String, ComponentFeaturesMap> loadFeaturesFile(String fileName) {
        Map<String, Map<String, Map<String, Boolean>>> configuration = readYamlContent(fileName);

        Map<String, ComponentFeaturesMap> configurationFeatures = new HashMap<>();
        for (String component : configuration.keySet()) {
            Map<String, Map<String, Boolean>> applicationMap = configuration.get(component);
            ComponentFeaturesMap componentsMap = new ComponentFeaturesMap();

            for (String environment : applicationMap.keySet()) {
                EnvironmentFeaturesMap environmentsMap = new EnvironmentFeaturesMap();
                environmentsMap.setEnvironmentFeaturesMap(applicationMap.get(environment));

                componentsMap.put(environment, environmentsMap);
            }
            configurationFeatures.put(component, componentsMap);
        }
        return configurationFeatures;
    }

    private Map<String, Map<String, Map<String, Boolean>>> readYamlContent(String fileName) {
        Yaml yaml = new Yaml();

        return yaml.load(this.getClass()
                .getClassLoader()
                .getResourceAsStream(fileName));
    }

}
