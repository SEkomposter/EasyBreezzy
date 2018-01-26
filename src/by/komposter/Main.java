package by.komposter;

import Util.HibernateUtil;
import by.komposter.DB.DBConnector;
import by.komposter.Notificator.Notificator;
import by.komposter.objectFactory.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {

    public static void main(String[] args) {
        try{
        DBConnector dbc = new DBConnector();
        try {
            //1 создание новой БД
            // dbc.dbCreate("EasyBreezzy");
            HibernateUtil hibernateUtil = new HibernateUtil();
            SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
            Node node1 = new Node();
            node1.setNodeName("Иванов");
            node1.setDepartment("ОТО");
            node1.setSbe("АлюминТехно");
            Session session = sessionFactory.openSession();
            session.save(node1);
            session.getTransaction().commit();
            session.close();
            sessionFactory.close();

        } catch (Exception e) {
            Notificator.pushToScreenNlog(e,Main.class);
        }
        finally {
            dbc.disconnect();
        }
        }catch (Exception e){
            Notificator.pushToScreenNlog(e,Main.class);
        }
    }
}
