package com.workspace.io;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class CustomFileWriter {
        private static CustomFileWriter customFileWriter=null;
        private static FileWriter fileWriter = null;
    public static CustomFileWriter getCustomFileWriter(){
            if(customFileWriter == null){
                customFileWriter = new CustomFileWriter();
            }
            return customFileWriter;
    }
    private FileWriter openFile() throws IOException{
            return new FileWriter("../errorlog.txt");
    }
    private void closeFile(){
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private CustomFileWriter() {
        try{
        fileWriter = openFile();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void closeCustomFileWriter(){
        closeFile();
    }
    public void write(String message){
       try{
           System.out.println("writing to file");
        fileWriter.write(message);
       }catch (Exception e){
           System.out.println(e.getMessage());
       }
    }
}
