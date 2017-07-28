package by.komposter;

import Util.HibernateUtil;
import by.komposter.DB.DBConnector;
import by.komposter.Notificator.Notificator;
import by.komposter.ObjectFactory.*;
import org.hibernate.SessionFactory;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        try{
        DBConnector dbc = new DBConnector();
        try {
            //1 создание новой БД
            //dbc.dbCreate("db5");
            //dbc.connect("db4");
            HibernateUtil hibernateUtil = new HibernateUtil();
            SessionFactory sessionFactory = hibernateUtil.getSessionFactory();

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
