package com.workspace.utill;
import com.workspace.io.*;
public class LogWriter {
    private ConsoleWriter consoleWriter = null;
    private CustomFileWriter customFileWriter = null;
    public LogWriter(){
        consoleWriter = new ConsoleWriter();
        customFileWriter = CustomFileWriter.getCustomFileWriter();
    }
    public void write(Level level, String message){
        switch (level){
            case INFO:
                consoleWriter.write(message);
                break;
            case ERROR:
                customFileWriter.write(message);
                break;
            default:
                System.out.println("Invalid level\n");
        }
    }
}
