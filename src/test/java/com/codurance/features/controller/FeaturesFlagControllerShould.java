package com.codurance.features.controller;

import com.codurance.features.service.FeaturesService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FeaturesFlagControllerShould {

    @Mock
    private FeaturesService service;

    @Test
    void
    return_feature_flag_value_for_the_component() {
        when(service.getFeatureForComponent("component", "feature")).thenReturn(true);
        FeaturesFlagController controller = new FeaturesFlagController(service);

        assertThat(controller.getFeature("component", "feature")).isTrue();
    }
}