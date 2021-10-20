package com.element.trailsmanager.trail

import com.element.trailsmanager.BasicSpec

import static org.assertj.core.api.Assertions.assertThat

class TrailFacadeSpec extends BasicSpec implements TrailsExamples {

    def "should get all available trails"() {
        given:
        trailFacade.add(shireTrail)
        trailFacade.add(gondorTrail)
        trailFacade.add(mordorTrail)
        when:
        def result = trailFacade.getAll()
        then:
        assertThat(result)
                .hasSize(3)
                .extracting("name")
                .contains("Shire", "Gondor", "Mordor")
    }

    def "should get one trail by name ignoring case"() {
        given:
        trailFacade.add(shireTrail)
        when:
        def result = trailFacade.get(name)
        then:
        assertThat(result)
                .isNotNull()
                .hasFieldOrPropertyWithValue("name", "Shire")
                .hasFieldOrProperty("startAt")
                .hasFieldOrProperty("endAt")
                .hasFieldOrPropertyWithValue("minimumAge", 5)
                .hasFieldOrPropertyWithValue("maximumAge", 100)
        where:
        name << ["Shire", "shire"]
    }
}
