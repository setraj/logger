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
    public static void error(String message){
        logWriter.write(Level.ERROR, message);
    }
    public static void info(String message){
        logWriter.write(Level.INFO, message);
    }
}
