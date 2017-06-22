package by.komposter;

import by.komposter.DB.DBConnector;
import by.komposter.Notificator.Notificator;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        try{
        DBConnector dbc = new DBConnector();
        try {
            //1 создание новой БД
            //dbc.dbCreate("db4");
            dbc.connect("db4");
            //System.out.println("pause");

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
