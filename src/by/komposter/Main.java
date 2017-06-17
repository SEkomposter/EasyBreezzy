package by.komposter;
import by.komposter.*;
import by.komposter.DB.DBConnector;
import by.komposter.DB.SQLFileReader;

public class Main {

    public static void main(String[] args) {
        DBConnector dbc = new DBConnector();
        SQLFileReader sfr = new SQLFileReader();
        try {
            //1 создание новой БД
            sfr.read();
//System.out.print(sfr.toString());
            dbc.dbCreate("wow");
            dbc.setDBName("EasyBreezzy");
//dbc.connect();
            dbc.loadScheme(sfr);
//конец1*/
            // AppSettings appSettings = new AppSettings();
            //System.out.println(appSettings.getParamVal("dbname"));
            //appSettings.setParam("dbname", "EasyInv2");
            //System.out.println(appSettings.getParamVal("dbname"));
            //appSettings.setParam("dbname", "EasyInv2");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
