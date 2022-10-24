package ru.admin.store;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.admin.model.Court;
import ru.admin.model.Employee;

import java.util.List;

@Repository
public class CourtStore {

    private final SessionFactory sf;

    public CourtStore(SessionFactory sf) {
        this.sf = sf;
    }

    public List<Court> findAllCourt() {
        Session session = sf.openSession();
        session.beginTransaction();
        List result = session.createQuery("from Court ").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public void add(Court court) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(court);
        session.getTransaction().commit();
        session.close();
    }
}
