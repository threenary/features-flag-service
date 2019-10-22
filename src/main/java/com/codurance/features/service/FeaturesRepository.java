package com.codurance.features.service;

import com.codurance.features.config.ConfigReader;
import com.codurance.features.domain.ComponentFeaturesMap;
import com.codurance.features.domain.EnvironmentFeaturesMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class FeaturesRepository {

    private final String activeProfile;
    private final String configurationFile;
    private final ConfigReader configReader;

    private Map<String, ComponentFeaturesMap> repository = new HashMap<>();

    @Autowired
    public FeaturesRepository(
            @Value("${spring.profiles.active}") String activeProfile,
            @Value("${features.configuration.file}") String configurationFile,
            ConfigReader configReader) {
        this.configReader = configReader;
        this.activeProfile = activeProfile;
        this.configurationFile = configurationFile;
    }

    public EnvironmentFeaturesMap getFeaturesForComponent(String component) {
        if (repository.isEmpty()) {
            init();
        }
        return retrieveFeaturesForProfile(component);
    }

    private EnvironmentFeaturesMap retrieveFeaturesForProfile(String component) {
        return (null != repository.get(component))
                ? repository.get(component).get(activeProfile)
                : null;
    }

    @PostConstruct
    public void init() {
        repository = configReader.loadFeaturesFile(configurationFile);
    }

}
