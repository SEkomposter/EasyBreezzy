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
            session.beginTransaction();
            Host host1 = new Host();
            Host host2 = new Host();
            host1.setHostName("ivanov");
            host2.setHostName("petrov");
            Node node1 = new Node();

            node1.getHostSet().add(host1);
            node1.setNodeName("Иванов");
            node1.setDepartment("ОТО");
            node1.setSbe("АлюминТехно");
            host1.setNode(node1);

            session.saveOrUpdate(node1);
            session.saveOrUpdate(host1);
            session.getTransaction().commit();
            session.close();
            session = sessionFactory.openSession();
            session.beginTransaction();
            node1.getHostSet().add(host2);
            host2.setNode(node1);
            session.saveOrUpdate(host2);
            session.getTransaction().commit();
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
