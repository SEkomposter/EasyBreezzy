package by.komposter.Services;

import by.komposter.objectFactory.Item;
import by.komposter.objectFactory.Node;
import org.hibernate.LockMode;
import org.hibernate.Session;

public class ItemDaoImp implements DaoInt<Item>{

    public int create(Item item) {

        return (int)DBService.getSessionFactory()
                .getCurrentSession()
                .save(item);
    }
    public Item getById(int id) {
        return DBService.getSessionFactory()
                .getCurrentSession()
                .get(Item.class, id, LockMode.PESSIMISTIC_READ);
    }
    public Item getByStr(String str) {
        return DBService.getSessionFactory()
                .getCurrentSession()
                .get(Item.class, str, LockMode.PESSIMISTIC_READ);
    }

    public void update(Item item) {
        DBService.getSessionFactory().getCurrentSession()
                .update(item);
    }

    public Item delete(int id) {
        Session session = DBService.getSessionFactory().getCurrentSession();
        Item item = session.byId(Item.class).load(id);
        session.delete(item);
        return item;
    }
}
