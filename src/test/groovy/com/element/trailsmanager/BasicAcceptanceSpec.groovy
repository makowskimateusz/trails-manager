package com.element.trailsmanager

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.test.web.servlet.MockMvc

@AutoConfigureMockMvc
abstract class BasicAcceptanceSpec extends BasicIntegrationSpec {

    @Autowired
    MockMvc mockMvc

    ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule())

}
