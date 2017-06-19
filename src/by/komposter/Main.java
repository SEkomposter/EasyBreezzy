package by.komposter;

import by.komposter.DB.DBConnector;
import by.komposter.Notificator.Notificator;

public class Main {

    public static void main(String[] args) {
        DBConnector dbc = new DBConnector();
        try {
            //1 создание новой БД
            dbc.dbCreate("db3");

//dbc.connect();

//конец1*/
            // AppSettings appSettings = new AppSettings();
            //System.out.println(appSettings.getParamVal("dbname"));
            //appSettings.setParam("dbname", "EasyInv2");
            //System.out.println(appSettings.getParamVal("dbname"));
            //appSettings.setParam("dbname", "EasyInv2");

        } catch (Exception e) {
            Notificator.pushToScreenNlog(e,Main.class);
        }
    }
}
