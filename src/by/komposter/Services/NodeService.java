package by.komposter.Services;

import by.komposter.objectFactory.Node;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;

public class NodeService{
    NodeService() {
    }

    public long createItem(Node item) throws Exception {
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


    public void updateItem(Node item) throws Exception {
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
            Node item = (Node)dao.delete(id);

            transaction.commit();

        } catch (HibernateException | NoResultException | IllegalArgumentException | IllegalStateException e) {
            DBService.transactionRollback(transaction);
            throw new Exception(e);
        }
    }
}
