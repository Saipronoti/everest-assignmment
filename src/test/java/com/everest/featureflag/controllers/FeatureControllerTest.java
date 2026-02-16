package com.everest.featureflag.controllers;

import com.everest.featureflag.services.FeatureService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.web.servlet.function.RequestPredicates.param;

@WebMvcTest(FeatureController.class)
public class FeatureControllerTest {

    @Autowired
    @MockBean
    private FeatureService featureService;

    @Test
    public void testIsFeatureEnabled() throws Exception {
        String featureKey = "dark_mode";
        String scopeType = "USER";
        String scopeId = "u123";

        // Mock the service response
        Mockito.when(featureService.isFeatureEnabled(featureKey, scopeType, scopeId)).thenReturn(true);

        // Perform the GET request and verify the response
                        .param("scopeType", scopeType)
                .param("scopeId", scopeId))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }
}