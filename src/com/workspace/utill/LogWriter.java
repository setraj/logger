package com.workspace.utill;
import com.workspace.io.*;
public class LogWriter {
    private ConsoleWriter consoleWriter = null;
    private FileWriter fileWriter = null;
    public LogWriter(){
        consoleWriter = new ConsoleWriter();
        fileWriter = new FileWriter();
    }
    public void write(Level level, String message){
        switch (level){
            case INFO:
                consoleWriter.write(message);
                break;
            case ERROR:
                fileWriter.write(message);
                break;
            default:
                System.out.println("Invalid level\n");
        }
    }
}
