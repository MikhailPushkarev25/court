package ru.admin.store;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.admin.model.Position;

import java.util.List;

@Repository
public class PositionStore {

    private final SessionFactory sf;

    public PositionStore(SessionFactory sf) {
        this.sf = sf;
    }

    public void add(Position position) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(position);
        session.getTransaction().commit();
        session.close();
    }

    public List allPos() {
        Session session = sf.openSession();
        session.beginTransaction();
        List result = session.createQuery("from Position ").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public void update(Position position) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.createQuery("update Position p set p.position_name = :pName where p.id = :pId")
                .setParameter("pName", position.getPosition_name())
                .setParameter("pId", position.getId())
                .executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    public Position findById(int id) {
        Session session = sf.openSession();
        session.beginTransaction();
        Position position = session.get(Position.class, id);
        session.getTransaction().commit();
        session.close();
        return position;
    }

    public void delete(Position position) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.delete(position);
        session.getTransaction().commit();
        session.close();
    }
}
