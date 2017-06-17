package by.komposter.DB;

import by.komposter.Core.AppSettings;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

public class DBConnector {
    private String serverName;
    private String dbAdminName;
    private String adminPass;
    private String url;
    private static String driver;
    private Connection connection;
    String dbName = "";
    static Properties properties;
    AppSettings appS;

    public DBConnector() {
        appS = new AppSettings();
        this.driver = "com.mysql.jdbc.Driver";
        this.serverName = appS.getParamVal("servername");
        this.dbAdminName = appS.getParamVal("username");
        this.adminPass = appS.getParamVal("password");
        this.url = "jdbc:mysql://" + serverName + ":3306/" + dbName;
    }

    public Connection connect() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        properties = new Properties();
        properties.setProperty("user", dbAdminName);
        properties.setProperty("password", adminPass);
        properties.setProperty("useSSL", "false");
        properties.setProperty("autoReconnect", "true");
        Driver dr = (Driver) Class.forName(driver).newInstance();
        connection = DriverManager.getConnection(url,properties);
        return connection;
    }

    public void setDBName(String dbn) {
        appS.setParam("dbname", dbn);
    }
    public String getDBName(){return dbName;}

    public void dbCreate(String newdb) {
        PreparedStatement stm = null;
        try {
            String query = "CREATE DATABASE " + newdb;
            setDBName(newdb);
            new SQLFileReader().changeSQLscript(newdb);
            stm = connect().prepareStatement(query);
            stm.executeUpdate();
            stm.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loadScheme(SQLFileReader sqlfr) throws IOException,SQLException{
        ArrayList tmp = sqlfr.read();
        Iterator it = tmp.iterator();
        Statement stm = connection.createStatement();

        try {
            while (it.hasNext()) {
                stm.addBatch((String) it.next());
            }
            stm.executeBatch();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        finally {
            stm.close();
        }

    }
}
