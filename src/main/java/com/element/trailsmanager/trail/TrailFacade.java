package com.element.trailsmanager.trail;

import com.element.trailsmanager.common.NotFoundException;
import com.element.trailsmanager.trail.dto.TrailRequest;
import com.element.trailsmanager.trail.dto.TrailResponse;
import lombok.RequiredArgsConstructor;

import java.util.List;

public interface TrailFacade {

    TrailResponse add(TrailRequest trailRequest);

    TrailResponse get(String trailName);

    List<TrailResponse> getAll();

}

@RequiredArgsConstructor
class TrailFacadeImpl implements TrailFacade {

    private final TrailService trailService;

    @Override
    public TrailResponse add(TrailRequest trailRequest) {
        return trailService.save(trailRequest);
    }

    @Override
    public TrailResponse get(String trailName) {
        return trailService.findByName(trailName)
                .orElseThrow(() -> new NotFoundException("Trail not found"));
    }

    @Override
    public List<TrailResponse> getAll() {
        return trailService.getAll();
    }
}
