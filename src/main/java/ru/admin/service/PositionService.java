package ru.admin.service;

import org.springframework.stereotype.Service;
import ru.admin.model.Position;
import ru.admin.store.PositionStore;

import java.util.List;

@Service
public class PositionService {

    private final PositionStore store;

    public PositionService(PositionStore store) {
        this.store = store;
    }

    public void add(Position position) {
        store.add(position);
    }

    public List allPos() {
        return store.allPos();
    }

    public void update(Position position) {
        store.update(position);
    }

    public Position findById(int id) {
        return store.findById(id);
    }

    public void delete(Position position) {
        store.delete(position);
    }
}
