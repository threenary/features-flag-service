package com.codurance.features.service;

import com.codurance.features.config.ConfigReader;
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

    private Map<String, EnvironmentFeaturesMap> repository = new HashMap<>();

    @Autowired
    public FeaturesRepository(
            @Value("${spring.profiles.active}") String activeProfile,
            @Value("${features.configuration.file}") String configurationFile,
            ConfigReader configReader) {
        this.configReader = configReader;
        this.activeProfile = activeProfile;
        this.configurationFile = configurationFile;
    }

    public Boolean getFeatureFlagValue(String feature) {
        if (repository.isEmpty()) {
            init();
        }
        return retrieveFeaturesForProfile(feature);
    }

    private Boolean retrieveFeaturesForProfile(String feature) {
        return (null != repository.get(activeProfile))
                ? repository.get(activeProfile).get(feature)
                : null;
    }

    @PostConstruct
    public void init() {
        repository = configReader.loadFeaturesFile(configurationFile);
    }

}
