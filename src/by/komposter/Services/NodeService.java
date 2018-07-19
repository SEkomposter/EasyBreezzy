package by.komposter.Services;

import by.komposter.objectFactory.Node;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;

public class NodeService{
    NodeService() {
    }

    @Override
    public Node createItem(Node node) throws DBException {
        Transaction transaction = DBService.getTransaction();
        try {
            NodeDaoImp dao = DaoFactory.getItemDAO();
            Node nd = dao.create(node);

            transaction.commit();

            return nd;
        } catch (HibernateException | NoResultException e) {
            DBService.transactionRollback(transaction);
            throw new DBException(e);
        }
    }

    @Override
    public void updateItem(Node node) throws DBException {
        Transaction transaction = DBService.getTransaction();
        try {
            NodeDaoImp dao = DaoFactory.getItemDAO();
            dao.update(node);

            transaction.commit();

        } catch (HibernateException | NoResultException e) {
            DBService.transactionRollback(transaction);
            throw new DBException(e);
        }
    }

    @Override
    public void deleteItem(long id) throws DBException {
        Transaction transaction = DBService.getTransaction();
        try {
            ItemDAO dao = DaoFactory.getItemDAO();
            Item item = dao.delete(id);

            transaction.commit();

        } catch (HibernateException | NoResultException | IllegalArgumentException | IllegalStateException e) {
            DBService.transactionRollback(transaction);
            throw new DBException(e);
        }
    }
}
