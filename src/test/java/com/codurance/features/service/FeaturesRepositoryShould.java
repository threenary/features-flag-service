package com.codurance.features.service;

import com.codurance.features.config.ConfigReader;
import com.codurance.features.domain.ComponentFeaturesMap;
import com.codurance.features.domain.EnvironmentFeaturesMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FeaturesRepositoryShould {

    private static final String APPLICATION = "application";
    private static final String NON_EXISTING_COMPONENT = "anyOtherComponent";
    private static final String DEVELOPMENT = "development";
    private static final String ENABLED_FEATURE = "enabled_feature";
    private static final String DISABLED_FEATURE = "disabled_feature";

    private FeaturesRepository featuresFlagRepository;

    @Mock
    ConfigReader reader;

    @BeforeEach
    void setUp() {
        featuresFlagRepository = new FeaturesRepository(DEVELOPMENT, "someFile.yaml", reader);
    }

    @Test
    void
    return_flags_map_for_the_component_in_the_environment() {
        when(reader.loadFeaturesFile(anyString())).thenReturn(buildApplicationFeaturesMap());

        assertNotNull(featuresFlagRepository.getFeaturesForComponent(APPLICATION));
        assertTrue(featuresFlagRepository.getFeaturesForComponent(APPLICATION).get(ENABLED_FEATURE));
        assertFalse(featuresFlagRepository.getFeaturesForComponent(APPLICATION).get(DISABLED_FEATURE));
    }

    @Test
    void
    return_null_flags_map_for_non_existing_component() {
        when(reader.loadFeaturesFile(anyString())).thenReturn(buildApplicationFeaturesMap());

        assertNull(featuresFlagRepository.getFeaturesForComponent(NON_EXISTING_COMPONENT));
    }

    private Map<String, ComponentFeaturesMap> buildApplicationFeaturesMap() {
        Map<String, ComponentFeaturesMap> applicationFeaturesMap = new HashMap<>();
        ComponentFeaturesMap componentFeaturesMap = new ComponentFeaturesMap();
        componentFeaturesMap.put(DEVELOPMENT, buildEnvironmentFeaturesMap());
        applicationFeaturesMap.put(APPLICATION, componentFeaturesMap);

        return applicationFeaturesMap;
    }

    private EnvironmentFeaturesMap buildEnvironmentFeaturesMap() {
        EnvironmentFeaturesMap environmentFeaturesMap = new EnvironmentFeaturesMap();
        environmentFeaturesMap.put(ENABLED_FEATURE, true);
        environmentFeaturesMap.put(DISABLED_FEATURE, false);
        return environmentFeaturesMap;
    }
}