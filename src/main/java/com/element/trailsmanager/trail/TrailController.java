package com.element.trailsmanager.trail;

import com.element.trailsmanager.trail.dto.TrailRequest;
import com.element.trailsmanager.trail.dto.TrailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/trail")
@RequiredArgsConstructor
class TrailController {

    private final TrailFacade trailFacade;

    @PostMapping
    public TrailResponse addTrail(@RequestBody TrailRequest trailRequest) {
        return trailFacade.add(trailRequest);
    }

    @GetMapping("/{name}")
    public TrailResponse getTrailByName(@PathVariable String name) {
        return trailFacade.get(name);
    }

    @GetMapping()
    public List<TrailResponse> getAll() {
        return trailFacade.getAll();
    }

}
