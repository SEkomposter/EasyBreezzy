package by.komposter.Services;

import by.komposter.objectFactory.Node;
import org.hibernate.Session;

public class NodeDaoImp implements DaoInt<Node>{

    private Session session;
    public NodeDaoImp(Session session){
        this.session = session;
    }
    @Override
    public Node create(Node node) {
        return (Node)session.save(node);
    }
    @Override
    public Node getById(int id) {
        return session.get(Node.class,id);
    }
    @Override
    public Node getByStr(String str) {
        return session.get(Node.class,str);
    }
    @Override
    public void update(Node node) {
        session.update(node);
    }
    @Override
    public Node delete(Node node) {
        session.delete(node);
        return node;
    }
}
