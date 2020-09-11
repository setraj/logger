package com.workspace.io;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import java.io.IOException;

public class AsyncWriter {

    private static String uri=null;
    private static Connection connection = null;
    private static Channel channel=null;
    private static ConnectionFactory factory = null;
    private static AsyncWriter asyncWriter = null;
    void init() throws Exception{
            uri = System.getenv("RMQ_URL");
        factory = new ConnectionFactory();
        factory.setUri(uri);
        factory.setConnectionTimeout(30000);
        factory.useSslProtocol("TLSv1.2");
        try{
        connection = factory.newConnection();
        }catch (Exception e){
            System.out.println("CONN ERR: "+ e.fillInStackTrace());
        }
        channel = connection.createChannel();
        try {
            declareQueue();
        }catch (Exception e){
            throw e;
        }

    }
    void declareQueue() throws IOException {
        channel.queueDeclare("msjq",true,false,false,null);
    }
    public void write(String message){
        try {
            init();
        }catch (Exception e){
            System.out.println("RMQ ERROR: " + e.getMessage());
        }
        try{
            System.out.println("writing to Q!");
        channel.basicPublish("", "msjq",null,message.getBytes());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try{
            channel.close();
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
//    public void read(){
//        try {
//            init();
//        }catch (Exception e){
//            System.out.println("RMQ ERROR: " + e.getMessage());
//        }
//        QueueingConsumer consumer = new QueueingConsumer(channel);
//        try {
//            channel.basicConsume("msjq", true, consumer);
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        QueueingConsumer.Delivery delivery = null;
//
//            try{
//             delivery = consumer.nextDelivery();
//            }catch (Exception e){
//                System.out.println(e.getMessage());
//            }
//            String message = new String(delivery.getBody());
//            System.out.println(" [x] Received '" + message + "'");
//        try{
//            channel.close();
//        connection.close();
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//
//    }

    public static AsyncWriter getAsyncWriter() {
        if(asyncWriter == null){
            asyncWriter = new AsyncWriter();
        }
        return asyncWriter;
    }

}
