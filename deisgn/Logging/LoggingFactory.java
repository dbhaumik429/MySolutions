package com.debu.deisgn.Logging;

/**
 * Created by Aspire V3 on 08-06-2018.
 */
public class LoggingFactory {

    public static Logger getLogger(String loggerName)
    {
        if(loggerName.equalsIgnoreCase("FileLogger"))
        {
            return new FileLogger();
        }else if(loggerName.equalsIgnoreCase("DBLogger"))
        {
            return new DBLogger();
        }
        else
        {
            return null;
        }
    }
}
