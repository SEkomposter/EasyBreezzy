package by.komposter.Notificator;

import by.komposter.Core.AppSettings;
import org.apache.log4j.*;
import org.apache.log4j.spi.*;
import org.apache.log4j.spi.ErrorHandler;
import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.logging.log4j.core.appender.FileAppender;

import java.io.IOException;

public class Notificator {
    static Logger LOGGER = null;

    public static void pushToScreenNlog(Exception ex, Class cl, String str) {
        pushToScreenNlog(ex, cl);
        System.err.println(str);
    }
    public static void pushToScreenNlog(Exception ex, Class cl) {
        LOGGER  = Logger.getLogger("EasyBreezzy");
        LOGGER.error("Error",ex);

        }

    }

