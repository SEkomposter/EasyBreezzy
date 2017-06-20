package by.komposter;

import by.komposter.DB.DBConnector;
import by.komposter.Notificator.Notificator;

public class Main {

    public static void main(String[] args) {
        DBConnector dbc = new DBConnector();
        try {
            //1 создание новой БД
            dbc.dbCreate("db4");


        } catch (Exception e) {
            Notificator.pushToScreenNlog(e,Main.class);
        }
    }
}
