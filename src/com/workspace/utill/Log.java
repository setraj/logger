package com.workspace.utill;

public class Log {

    public static LogWriter logWriter = new LogWriter();
    public static void error(String message){
        logWriter.write(Level.ERROR, message);
    }
    public static void info(String message){
        logWriter.write(Level.INFO, message);
    }
}
