package com.workspace.test;
import java.util.Map;
import com.workspace.utill.*;
public class Test {
    public static void main(String[] args){
        Logger logger = Logger.getLogger();
        logger.info("Application Started!!");
        try{
            int a = 1/0;
        }catch(Exception e){
            logger.error(e.getMessage());
            logger.debug(e.getMessage());
        }
        try{
            int a = 1/0;
        }catch(Exception e){
            logger.error(e.getMessage());
            logger.debug(e.getMessage());
        }
        try{
            int a = 1/0;
        }catch(Exception e){
            logger.error(e.getMessage());
            logger.debug(e.getMessage());
        }

        logger.info("Application closing!!");
    }
}