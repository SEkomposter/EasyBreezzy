package by.komposter.Services;

import by.komposter.objectFactory.Node;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class NodeService extends NodeDaoIntImp{
    public Node create(SessionFactory sFactory) {
        Session session = sFactory.openSession();
        session.beginTransaction();
        Node node = new Node();
        session.save(node);
        session.getTransaction().commit();
        return node;
    }

    public Node read(SessionFactory sFactory, Object node) {
        Session session = sFactory.openSession();
        session.beginTransaction();
        (Node)session.get(Node.class, new Integer(((Node)node).getId()));
        return null;
    }

    public Object update(SessionFactory sFactory, Object o) {
        return null;
    }
    public boolean delete(SessionFactory sFactory, Object o) {
        return false;
    }
}
