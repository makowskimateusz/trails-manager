package com.element.trailsmanager.trail;

import com.element.trailsmanager.common.TrailAlreadyExistsException;
import com.element.trailsmanager.trail.dto.TrailRequest;
import com.element.trailsmanager.trail.dto.TrailResponse;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import static com.element.trailsmanager.trail.TrailMapper.toDto;
import static com.element.trailsmanager.trail.TrailMapper.toEntity;
import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
class TrailService {

    private final TrailRepository trailRepository;

    TrailResponse save(TrailRequest trailRequest) {
        trailRepository.findByNameIgnoreCase(trailRequest.getName())
                .ifPresent(trail -> {
                    throw new TrailAlreadyExistsException("Trail already exists");
                });
        final var trail = toEntity(trailRequest);
        final Trail saved = trailRepository.save(trail);
        return toDto(saved);
    }

    Optional<TrailResponse> findByName(String trailName) {
        return trailRepository.findByNameIgnoreCase(trailName)
                .map(TrailMapper::toDto);
    }

    List<TrailResponse> getAll() {
        return trailRepository.findAll()
                .stream()
                .map(TrailMapper::toDto)
                .collect(toList());
    }
}
