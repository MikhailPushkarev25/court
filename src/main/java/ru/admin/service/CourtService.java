package ru.admin.service;

import org.springframework.stereotype.Service;
import ru.admin.model.Court;
import ru.admin.store.CourtStore;

import java.util.List;

@Service
public class CourtService {

    private final CourtStore store;

    public CourtService(CourtStore store) {
        this.store = store;
    }

    public List<Court> findAllCourt() {
        return store.findAllCourt();
    }

    public void add(Court court) {
        store.add(court);
    }
}
