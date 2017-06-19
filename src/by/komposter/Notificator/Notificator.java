package by.komposter.Notificator;

import by.komposter.Core.AppSettings;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Notificator {

    String logFilePath;

    public static void pushToScreenNlog(Exception ex, String str, Class cl) {

        pushToScreenNlog(ex, cl);
        System.err.println(str);
    }
    public static void pushToScreenNlog(Exception ex, Class cl) {
        Logger log  = Logger.getLogger(cl.getName());
        try {
            LogManager.getLogManager().readConfiguration(Notificator.class.getResourceAsStream("logging.properties"));
            log.addHandler(new FileHandler(new AppSettings().getParamVal("appdir"+"log\\log.txt")));
        }
        catch (IOException ioe){
            Notificator.pushToScreenNlog(ex, Notificator.class);
        }
        log.log(Level.FINE,"Exception: ", ex);
        log.info(ex.getStackTrace().toString());

    }
    public static void pushToScreenNlog(Exception ex) {
        pushToScreenNlog(ex,Class.class);

    }
}

