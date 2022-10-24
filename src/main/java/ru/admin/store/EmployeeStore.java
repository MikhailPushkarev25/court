package ru.admin.store;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.admin.model.Court;
import ru.admin.model.Employee;

import java.util.List;

@Repository
public class EmployeeStore {

    private final SessionFactory sf;

    public EmployeeStore(SessionFactory sf) {
        this.sf = sf;
    }

    public void add(Employee employee) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        session.close();
    }

    public List all() {
        Session session = sf.openSession();
        session.beginTransaction();
        List result = session.createQuery("from Employee ").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public void update(Employee employee) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.createQuery("update Employee e set e.first_name = :fName, e.middle_name = :mName, e.last_name = :lName, " +
                        "e.address = :addName where e.id = :eId")
                .setParameter("fName", employee.getFirst_name())
                .setParameter("mName", employee.getMiddle_name())
                .setParameter("lName", employee.getLast_name())
                .setParameter("addName", employee.getAddress())
                .setParameter("eId", employee.getId())
                .executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    public Employee findById(int id) {
        Session session = sf.openSession();
        session.beginTransaction();
        Employee employee = session.get(Employee.class, id);
        session.getTransaction().commit();
        session.close();
        return employee;
    }

    public void delete(Employee employee) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.delete(employee);
        session.getTransaction().commit();
        session.close();
    }
}
