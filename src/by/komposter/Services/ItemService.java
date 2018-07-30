package by.komposter.Services;

import by.komposter.objectFactory.Item;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;

public class ItemService {
    ItemService() {
    }

    public long createItem(Item item) throws Exception {
        Transaction transaction = DBService.getTransaction();
        try {
            DaoInt dao = DaoFactory.getItemDAO();
            int id = (int)dao.create(item);

            transaction.commit();

            return id;
        } catch (HibernateException | NoResultException e) {
            DBService.transactionRollback(transaction);
            throw new Exception(e);
        }
    }


    public void updateItem(Item item) throws Exception {
        Transaction transaction = DBService.getTransaction();
        try {
            DaoInt dao = DaoFactory.getItemDAO();
            dao.update(item);

            transaction.commit();

        } catch (HibernateException | NoResultException e) {
            DBService.transactionRollback(transaction);
            throw new Exception(e);
        }
    }

    public void deleteItem(int id) throws Exception {
        Transaction transaction = DBService.getTransaction();
        try {
            DaoInt dao = DaoFactory.getItemDAO();
            Item item = (Item)dao.delete(id);

            transaction.commit();

        } catch (HibernateException | NoResultException | IllegalArgumentException | IllegalStateException e) {
            DBService.transactionRollback(transaction);
            throw new Exception(e);
        }
    }
}
