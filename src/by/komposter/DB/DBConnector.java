package by.komposter.DB;

import by.komposter.Core.AppSettings;
import by.komposter.Notificator.Notificator;
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
    SQLFileReader sqlQuery = new SQLFileReader();

    public DBConnector() {
        appS = new AppSettings();
        this.driver = "com.mysql.jdbc.Driver";
        this.serverName = appS.getParamVal("servername");
        this.dbAdminName = appS.getParamVal("username");
        this.adminPass = appS.getParamVal("password");
        this.url = "jdbc:mysql://" + serverName + ":3306/" + dbName;
    }
    public String toString(){
        return this.getClass().getSimpleName() + ". \""+ url + "\", driver: \"" + driver + "\"";
    }

    public Connection connect() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Notificator.pushToScreenNlog("Preparing connection..." + toString(),this.getClass());
        properties = new Properties();
        properties.setProperty("user", dbAdminName);
        properties.setProperty("password", adminPass);
        properties.setProperty("useSSL", "false");
        properties.setProperty("autoReconnect", "true");
        Driver dr = (Driver) Class.forName(driver).newInstance();
        connection = DriverManager.getConnection(url,properties);
        Notificator.pushToScreenNlog("Connection established. " + toString(),this.getClass());
        return  connection;
    }
    public Connection connect(String db) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException{
        this.dbName = db;
        this.url = "jdbc:mysql://" + serverName + ":3306/" + dbName;
        setDBName(db);
        return connect();
    }
    public void disconnect() throws SQLException{
        if(!(connection==null)) {
            connection.close();
            Notificator.pushToScreenNlog("Connection closed. " + toString(),this.getClass());
        }
    }

    public void setDBName(String dbn) {
        appS.setParam("dbname", dbn);
    }
    public String getDBName(){return appS.getParamVal("dbName");}

    public void dbCreate(String newdb) {
        PreparedStatement stm = null;
        Notificator.pushToScreenNlog("Creating empty DB: \"" + newdb + "\"...", this.getClass() );
        try {
            String query = "CREATE DATABASE " + newdb;
            setDBName(newdb);
            stm = connect().prepareStatement(query);
            stm.executeUpdate();
            loadScheme(sqlQuery.changeSQLscript(sqlQuery.read(),newdb));
            stm.close();
            Notificator.pushToScreenNlog("DB: \"" + newdb + "\" created", this.getClass() );

        } catch (Exception e) {
            Notificator.pushToScreenNlog(e, this.getClass());
        }
    }
    public void loadScheme(ArrayList<String> qList) throws IOException,SQLException{
        Notificator.pushToScreenNlog("Loading scheme for DB...", this.getClass());
        Iterator it = qList.iterator();
        Statement stm = connection.createStatement();

        try {
            while (it.hasNext()) {
                stm.addBatch((String) it.next());
            }
            stm.executeBatch();
            Notificator.pushToScreenNlog("Loading scheme completed successfully", this.getClass());
        }catch(SQLException e){
            Notificator.pushToScreenNlog(e, this.getClass());
        }
        finally {
            stm.close();
        }

    }

}
