package by.komposter.Services;

import org.hibernate.*;
import org.hibernate.resource.transaction.spi.TransactionStatus;


public abstract class DBService {
    static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    public static Transaction getTransaction(){
        Session session = DBService.getSessionFactory().getCurrentSession();
        Transaction transaction = DBService.getSessionFactory().getCurrentSession().getTransaction();
        if (!transaction.isActive()) {
            transaction = session.beginTransaction();
        }
        return transaction;
    }

    public static void transactionRollback(Transaction transaction){
        if (transaction.getStatus() == TransactionStatus.ACTIVE
                || transaction.getStatus() == TransactionStatus.MARKED_ROLLBACK) {
            transaction.rollback();
        }
    }
}

