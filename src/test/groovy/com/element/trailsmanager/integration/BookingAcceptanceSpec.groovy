package com.element.trailsmanager.integration

import com.element.trailsmanager.BasicAcceptanceSpec
import com.element.trailsmanager.booking.BookingExamples
import com.element.trailsmanager.trail.TrailsExamples
import com.jayway.jsonpath.JsonPath

import static org.springframework.http.MediaType.APPLICATION_JSON
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

class BookingAcceptanceSpec extends BasicAcceptanceSpec implements BookingExamples, TrailsExamples {

    def "booking scenario with cancelling"() {
        given: 'Shire trail available for bookings'
        mockMvc.perform(post("/trail")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(shireTrail)))
                .andExpect(status().isOk())
        when: 'All available trails contains only shire trail'
        mockMvc.perform(get("/trail")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                    [
                    {
                        "name": "Shire",
                        "startAt": "07:00:00",
                        "endAt": "09:00:00",
                        "minimumAge": 5,
                        "maximumAge": 100,
                        "unitPrice": 29.9
                        }
                    ]
                """))
        and: 'Book shire trail for Mateusz, 27 year old'
        def resultActions = mockMvc.perform(post("/booking")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(bookingRequestWithSingleHiker)))
                .andExpect(status().isOk())
                .andExpect(jsonPath('$.bookingId').exists())
                .andExpect(jsonPath('$.totalCost').value(new BigDecimal("29.9")))
                .andExpect(jsonPath('$.bookingStatus').value("OPEN"))
                .andExpect(jsonPath('$.hikers').value("Mateusz"))
                .andReturn()
        def bookingId = JsonPath.read(resultActions.getResponse().getContentAsString(), "bookingId")
        then: 'Cancel booking'
        mockMvc.perform(delete("/booking/" + bookingId)
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
        and: 'Verify if it was cancelled'
        mockMvc.perform(get("/booking/" + bookingId)
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath('$.bookingId').exists())
                .andExpect(jsonPath('$.totalCost').value(new BigDecimal("29.9")))
                .andExpect(jsonPath('$.bookingStatus').value("CANCEL"))
                .andExpect(jsonPath('$.hikers').value("Mateusz"))
    }
}
