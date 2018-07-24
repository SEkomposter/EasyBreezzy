package by.komposter.Services;

import by.komposter.objectFactory.Node;
import org.hibernate.LockMode;
import org.hibernate.Session;

public class NodeDaoImp implements DaoInt<Node>{

    public Node create(Node nd) {
        return (Node) DBService.getSessionFactory()
                .getCurrentSession()
                .save(nd);
    }
    public Node getById(int id) {
        return DBService.getSessionFactory()
                .getCurrentSession()
                .get(Node.class, id, LockMode.PESSIMISTIC_READ);
    }
    public Node getByStr(String str) {
        return DBService.getSessionFactory()
                .getCurrentSession()
                .get(Node.class, str, LockMode.PESSIMISTIC_READ);
    }

    public void update(Node nd) {
        DBService.getSessionFactory().getCurrentSession()
                .update(nd);
    }

    public Node delete(int id) {
        Session session = DBService.getSessionFactory().getCurrentSession();
        Node nd = session.byId(Node.class).load(id);
        session.delete(nd);
        return nd;
    }
}
