package by.komposter.Services;

import Util.HibernateUtil;
import by.komposter.DB.DBConnector;
import by.komposter.Main;
import by.komposter.Notificator.Notificator;
import com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientConnectionException;
import org.hibernate.*;
import org.hibernate.resource.transaction.spi.TransactionStatus;


public abstract class DBService {
    static SessionFactory sessionFactory;
    static{
        try
        {
            DBConnector dbc = new DBConnector();
            try {

                try
                {
                    dbc.connect("easybreezzy");

                } catch (MySQLNonTransientConnectionException e) {
                    Notificator.pushToScreenNlog(e.getMessage(),e.getClass());
                    dbc.dbCreate("EasyBreezzy");
                }
                HibernateUtil hibernateUtil = new HibernateUtil();
                sessionFactory = hibernateUtil.getSessionFactory();
                //Session session = sessionFactory.openSession();

            } catch (Exception e) {
                Notificator.pushToScreenNlog(e.getMessage(),e.getClass());
            }
            finally {
                dbc.disconnect();
            }
        }catch (Exception e){
        Notificator.pushToScreenNlog(e,Main.class);
    }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    public static void killSessionFactory(){
        sessionFactory.close();
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

