package ru.admin.service;

import org.springframework.stereotype.Service;
import ru.admin.model.User;
import ru.admin.store.UserStore;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserStore store;

    public UserService(UserStore store) {
        this.store = store;
    }

    public Optional<User> create(User user) {
        return store.create(user);
    }

    public List<User> findAll() {
        return store.findAll();
    }

    public Optional<User> findEmailAndPwd(String email, String password) {
        return store.findEmailAndPwd(email, password);
    }
}
