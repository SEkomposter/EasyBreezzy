package by.komposter;

import Util.HibernateUtil;
import by.komposter.DB.DBConnector;
import by.komposter.Notificator.Notificator;
import by.komposter.Services.DBService;
import by.komposter.Services.Initializer;
import by.komposter.objectFactory.*;
import com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientConnectionException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {

    public static void main(String[] args) {
        try {
            DBService.getSessionFactory();
            Initializer.makeFirstInit();
            DBService.killSessionFactory();
        }
        catch (Exception e){
            Notificator.pushToScreenNlog(e,Main.class);
        }
    }
}
