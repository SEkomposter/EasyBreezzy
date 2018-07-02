package by.komposter;

import Util.HibernateUtil;
import by.komposter.DB.DBConnector;
import by.komposter.Notificator.Notificator;
import by.komposter.objectFactory.*;
import com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientConnectionException;
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

            } catch (MySQLNonTransientConnectionException e) {
                Notificator.pushToScreenNlog(e.getMessage(),e.getClass());
                dbc.dbCreate("EasyBreezzy");
            }
            HibernateUtil hibernateUtil = new HibernateUtil();
            SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            /*Host host1 = new Host();
            Host host2 = new Host();
            Host host3 = new Host();
            host1.setHostName("ivanov");
            host2.setHostName("petrov");
            host3.setHostName("sidorov");
            Node node1 = new Node();
            node1.setNodeName("Иванов");
            node1.setDepartment("ОТО");
            node1.setSbe("АлюминТехно");
            Node node2 = new Node();
            node2.setNodeName("Сидоров");
            node2.setDepartment("ИТ");
            node2.setSbe("АлюминТехно");

            host2.setNode(node1);
            host1.setNode(node1);
            host3.setNode(node2);
            session.beginTransaction();
            session.saveOrUpdate(host1);
            session.saveOrUpdate(host2);
            session.saveOrUpdate(node1);
            session.saveOrUpdate(host3);
            session.saveOrUpdate(node2);*/
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
