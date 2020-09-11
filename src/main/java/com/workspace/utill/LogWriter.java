package com.workspace.utill;
import com.workspace.io.*;
public class LogWriter {
    private ConsoleWriter consoleWriter = null;
    private CustomFileWriter customFileWriter = null;
    private AsyncWriter asyncWriter=null;
    public LogWriter(){
        consoleWriter = new ConsoleWriter();
        customFileWriter = CustomFileWriter.getCustomFileWriter();
        asyncWriter = AsyncWriter.getAsyncWriter();
    }
    public void write(Level level, String message){
        switch (level){
            case INFO:
                consoleWriter.write(message);
                break;
            case ERROR:
                customFileWriter.write(message);
                break;
            case DEBUG:
                asyncWriter.write(message);
                break;
            default:
                System.out.println("Invalid level\n");
        }
    }
}
