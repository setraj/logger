package com.workspace.test;
import com.workspace.utill.Log;
public class Test {
    public static void main(String[] args){
        Log.info("Application Started!!");
        for(int i=0; i<1000000; i++){

        }
        Log.error("Bootstrapping took a lot of time!");
    }
}
