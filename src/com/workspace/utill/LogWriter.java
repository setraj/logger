package com.workspace.utill;

public class LogWriter {
    public void write(int level, String msg){
        switch (level){
            case 1:
                writeToConsole("Writing to console: " + msg);
                break;
            case 2:
                writeToFile("Writing to file: " + msg);
                break;
        }
    }
    public void writeToConsole(String msg){
        System.out.println(msg);
    }
    public void writeToFile(String msg){
        System.out.println(msg);
    }
}
