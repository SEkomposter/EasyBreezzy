package by.komposter.Notificator;

import java.util.logging.Logger;

public class Notificator {

    String logFilePath;

    public static void pushToScreenNlog(Exception ex, String str, Class cl) {
        Logger log  = Logger.getLogger(cl.getName());
        pushToScreenNlog(ex, cl);
        System.err.println(str);
    }
    public static void pushToScreenNlog(Exception ex, Class cl) {


    }
}

