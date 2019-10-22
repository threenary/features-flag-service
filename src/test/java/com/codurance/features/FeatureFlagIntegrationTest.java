package com.codurance.features;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest()
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class FeatureFlagIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void
    return_the_feature_flag_value_for_the_component() throws Exception {
        MvcResult result = mockMvc.perform(get("/application/feature1"))
                .andExpect(status().isOk())
                .andReturn();

        assertTrue(Boolean.parseBoolean(result.getResponse().getContentAsString()));
    }

    @Test
    void
    return_false_when_feature_does_not_exist() throws Exception {
        MvcResult result = mockMvc.perform(get("/application/nonExistingFeature"))
                .andExpect(status().isOk())
                .andReturn();

        assertFalse(Boolean.parseBoolean(result.getResponse().getContentAsString()));
    }

    @Test
    void
    return_false_when_component_does_not_exist() throws Exception {
        MvcResult result = mockMvc.perform(get("/nonExistingComponent/feature1"))
                .andExpect(status().isOk())
                .andReturn();

        assertFalse(Boolean.parseBoolean(result.getResponse().getContentAsString()));
    }
}
