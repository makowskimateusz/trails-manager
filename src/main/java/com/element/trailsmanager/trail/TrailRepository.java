package com.element.trailsmanager.trail;

import org.springframework.data.repository.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

interface TrailRepository extends Repository<Trail, UUID> {
    Trail save(Trail trail);

    Optional<Trail> findByNameIgnoreCase(String name);

    List<Trail> findAll();
}

class InMemoryTrailRepository implements TrailRepository {

    private HashMap<UUID, Trail> db = new HashMap<>();

    @Override
    public Trail save(Trail trail) {
        db.put(trail.getId(), trail);
        return trail;
    }

    @Override
    public Optional<Trail> findByNameIgnoreCase(String name) {
        return db.values()
                .stream()
                .filter(trail -> trail.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    @Override
    public List<Trail> findAll() {
        return new ArrayList<>(db.values());
    }
}
