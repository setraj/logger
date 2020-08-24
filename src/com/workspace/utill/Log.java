package com.workspace.utill;

public class Log {

    public static LogWriter logWriter = new LogWriter();
    public static void error(String msg){
        logWriter.write(2,msg);
    }
    public static void info(String msg){
        logWriter.write(1,msg);
    }
}
