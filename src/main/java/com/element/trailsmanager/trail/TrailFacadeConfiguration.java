package com.element.trailsmanager.trail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public
class TrailFacadeConfiguration {

    @Bean
    TrailFacade trailFacade(TrailRepository trailRepository) {
        return new TrailFacadeImpl(new TrailService(trailRepository));
    }

    public TrailFacade trailFacade() {
        return trailFacade(new InMemoryTrailRepository());
    }

}
