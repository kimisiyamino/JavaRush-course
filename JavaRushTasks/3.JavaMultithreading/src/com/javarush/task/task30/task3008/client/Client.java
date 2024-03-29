package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.awt.*;
import java.io.IOException;
import java.net.Socket;

public class Client {
    protected Connection connection;

    public boolean isClientConnected() {
        return clientConnected;
    }

    public void setClientConnected(boolean clientConnected) {
        this.clientConnected = clientConnected;
    }

    private volatile boolean clientConnected = false;

    public void run(){
        synchronized (this) {
            SocketThread socketThread = getSocketThread();
            socketThread.setDaemon(true);
            socketThread.start();

            try {
                this.wait();
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage("socket thread wait gg");
                System.exit(-1);
            }

            if(clientConnected){
                ConsoleHelper.writeMessage("Соединение установлено.");
            }else {
                ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
            }

            while (clientConnected){
                String input = ConsoleHelper.readString();
                if(input.equals("exit")){
                    break;
                }
                if(shouldSendTextFromConsole()){
                    sendTextMessage(input);
                }
            }
        }
    }

    public class SocketThread extends Thread{

        @Override
        public void run(){
            String address = getServerAddress();
            int port = getServerPort();
            try {
                Socket socket = new Socket(address, port);
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();

            } catch (IOException | ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException{
            while(true){
                Message message = connection.receive();
                if(message.getType()==MessageType.NAME_REQUEST){
                    String userName = getUserName();
                    connection.send(new Message(MessageType.USER_NAME, userName));
                }else if(message.getType()==MessageType.NAME_ACCEPTED){
                    notifyConnectionStatusChanged(true);
                    break;
                }else{
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException{
            while(true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    processIncomingMessage(message.getData());
                } else if (message.getType() == MessageType.USER_ADDED) {
                    informAboutAddingNewUser(message.getData());
                } else if (message.getType() == MessageType.USER_REMOVED) {
                    informAboutDeletingNewUser(message.getData());
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }


        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName){
            ConsoleHelper.writeMessage(userName + " connected to chat");
        }

        protected void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage(userName + " leave chat");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected){
            synchronized (Client.this) {
                Client.this.clientConnected = clientConnected;
                Client.this.notify();
            }
            //Client.this.notify();
        }
    }

    protected String getServerAddress(){
//        String serverAddress = ConsoleHelper.readString();
////        if(serverAddress.equals("localhost")){
////            return serverAddress;
////        }
////
////        Matcher matcher = Pattern.compile("\\b\\d{1,3}+\\.\\d{1,3}+\\.\\d{1,3}+\\.\\d{1,3}+\\b").matcher(serverAddress);
////        if(matcher.find()){
////            String[] ip = serverAddress.split("\\.");
////            for(String num : ip){
////                if(!(Integer.parseInt(num) <= 255 && Integer.parseInt(num) >= 0)){
////                    return null;
////                }
////            }
////            return serverAddress;
////        }else{
////            return null;
////        }

        return ConsoleHelper.readString();
    }

    protected int getServerPort(){
        return ConsoleHelper.readInt();
    }

    protected String getUserName(){
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole(){
        return true;
    }

    protected SocketThread getSocketThread(){
        return new SocketThread();
    }

    protected void sendTextMessage(String text){
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            clientConnected = false;
            ConsoleHelper.writeMessage("message not send");
        }
    }

    // TEST
    public static void main(String[] args) {
        Client client = new Client();
        client.run();
        //SocketThread socketThread = client.new SocketThread();
        //client.run();
        //System.out.println(client.clientConnected);
        //socketThread.notifyConnectionStatusChanged(true);
        //System.out.println(client.clientConnected);
        //System.out.println(client.getServerAddress());
    }

}
