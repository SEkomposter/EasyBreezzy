package Util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory = null;

    static SessionFactory getSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }

}
