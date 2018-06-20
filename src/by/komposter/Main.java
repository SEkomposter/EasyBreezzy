package by.komposter;

import Util.HibernateUtil;
import by.komposter.DB.DBConnector;
import by.komposter.Notificator.Notificator;
import by.komposter.objectFactory.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {

    public static void main(String[] args) {
        try
        {
        DBConnector dbc = new DBConnector();
        try {
            //1 создание новой БД
            //dbc.dbCreate("EasyBreezzy");
            try
            {
                dbc.connect("easybreezzy");
            } catch (ExceptionInInitializerError e) {
                Notificator.pushToScreenNlog(e.getMessage(),e.getClass());
                dbc.dbCreate("EasyBreezzy");
            }
            HibernateUtil hibernateUtil = new HibernateUtil();
            SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            Node node1 = new Node();
            Host host1 = new Host();
            host1.setIdHost(1);


            node1.setNodeName("Иванов");
            node1.setDepartment("ОТО");
            node1.setSbe("АлюминТехно");
            node1.getHostSet().add(host1);
            node1.setIdHost(1);
            session.beginTransaction();
            session.saveOrUpdate(node1);
            session.getTransaction().commit();
            session.beginTransaction();

            session.saveOrUpdate(host1);
           //
            session.getTransaction().commit();
           // session.beginTransaction();

           // session.getTransaction().commit();
            session.close();
            sessionFactory.close();

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
}
