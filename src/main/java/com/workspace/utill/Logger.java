package com.workspace.utill;

public class Logger {
    private static Logger logger = null;
    private static LogWriter logWriter = null;
    private Logger(){
        logWriter = new LogWriter();
    }
    public static Logger getLogger(){
        if(logger == null){
            logger = new Logger();
        }
        return logger;
    }
    //write to a log file
    public static void error(String message){
        logWriter.write(Level.ERROR, message);
    }
    //write to console
    public static void info(String message){
        logWriter.write(Level.INFO, message);
    }
    //write to message queue
    public static void debug(String message){
        logWriter.write(Level.DEBUG, message);
    }
}
