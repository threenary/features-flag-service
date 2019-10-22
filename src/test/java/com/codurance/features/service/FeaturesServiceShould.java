package com.codurance.features.service;

import com.codurance.features.domain.ComponentFeaturesMap;
import com.codurance.features.domain.EnvironmentFeaturesMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class FeaturesServiceShould {

    private static final String COMPONENT = "component";
    private static final String EXISTING_FLAG = "feature";
    private static final String NON_EXISTING_COMPONENT = "non_existing_component";
    private static final String NON_EXISTING_FEATURE = "nonExistingFlag";

    private FeaturesService service;

    @Mock
    FeaturesRepository reader;
    @Mock
    EnvironmentFeaturesMap environmentFlagMap;

    @BeforeEach
    void setUp() {
        service = new FeaturesService(reader);
    }

    @Test
    void
    return_feature_flag_value_when_the_feature_exists_for_the_given_component() {
        when(reader.getFeaturesForComponent(anyString())).thenReturn(environmentFlagMap);
        when(environmentFlagMap.get(anyString())).thenReturn(true);

        assertTrue(service.getFeatureForComponent(COMPONENT, EXISTING_FLAG));
    }

    @Test
    void
    return_false_when_the_feature_does_not_exists_for_the_given_component() {
        when(reader.getFeaturesForComponent(anyString())).thenReturn(environmentFlagMap);
        when(environmentFlagMap.get(anyString())).thenReturn(false);

        assertFalse(service.getFeatureForComponent(COMPONENT, NON_EXISTING_FEATURE));
    }

    @Test
    void
    return_false_when_the_component_does_not_exist() {
        when(reader.getFeaturesForComponent(anyString())).thenReturn(environmentFlagMap);

        assertFalse(service.getFeatureForComponent(NON_EXISTING_COMPONENT, NON_EXISTING_FEATURE));
    }

    @Test
    void
    return_false_when_the_environment_does_not_exist() {
        when(reader.getFeaturesForComponent(anyString())).thenReturn(null);

        assertFalse(service.getFeatureForComponent(NON_EXISTING_COMPONENT, NON_EXISTING_FEATURE));
    }
}
