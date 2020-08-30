package com.workspace.utill;

public class LogWriter {
    public void write(Level level, String message){
        switch (level){
            case INFO:
                writeToConsole("Writing to console: " + message);
                break;
            case ERROR:
                writeToFile("Writing to file: " + message);
                break;
            default:
                System.out.println("Invalid level\n");
        }
    }
    private void writeToConsole(String message){
        System.out.println(message);
    }
    private void writeToFile(String message){
        System.out.println(message);
    }
}
