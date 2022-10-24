package ru.admin.service;

import org.springframework.stereotype.Service;
import ru.admin.model.Employee;
import ru.admin.store.EmployeeStore;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeStore store;

    public EmployeeService(EmployeeStore store) {
        this.store = store;
    }

    public void add(Employee employee) {
        store.add(employee);
    }

    public List all() {
        return store.all();
    }

    public void update(Employee employee) {
        store.update(employee);
    }

    public Employee findById(int id) {
        return store.findById(id);
    }

    public void delete(Employee employee) {
        store.delete(employee);
    }
}
