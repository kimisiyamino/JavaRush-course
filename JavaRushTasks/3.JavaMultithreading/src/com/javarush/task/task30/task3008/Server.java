package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    // Пользователь - Сокет соединения с ним
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    // Поток для клиента
    private static class Handler extends Thread{
        private Socket socket;

        public Handler(Socket socket){
            this.socket = socket;
        }

        // Валидация клиента
        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            String newUser = "";

            do{
                connection.send(new Message(MessageType.NAME_REQUEST, "Login: "));
                Message message = connection.receive();

                if(!message.getType().equals(MessageType.USER_NAME) || message.getData().equals("") || connectionMap.containsKey(message.getData())){
                    //connection.send(new Message(MessageType.TEXT, "Bad login! Try again"));
                    continue;
                }

                connectionMap.put(message.getData(), connection);
                connection.send(new Message(MessageType.NAME_ACCEPTED, "Good! Connection established!"));
                newUser = message.getData();
                break;

            }while(true);

            return newUser;
        }

        // Оповещаем клиента о доругих пользователях в сети
        private void notifyUsers(Connection connection, String userName) throws IOException{
            for(String e : connectionMap.keySet()){
                if(!e.equals(userName)){
                    connection.send(new Message(MessageType.USER_ADDED, e));
                }
            }
        }

        // Основной цикл, Ждём сообщения и оповещаем всех
        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    String mess = userName + ": " + message.getData();
                    sendBroadcastMessage(new Message(MessageType.TEXT, mess));
                } else {
                    ConsoleHelper.writeMessage("bad message");
                }
            }
        }


        // run()
        @Override
        public void run(){
            Connection connection = null;
            String newUser ="";
            try {
                ConsoleHelper.writeMessage("connected: " + socket.getRemoteSocketAddress().toString()); //
                connection = new Connection(socket);
                newUser = serverHandshake(connection);                                           // Авторизация пользователя
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, newUser));                     // Оповещаем весь сервер о новом подключении
                notifyUsers(connection, newUser);                                                       // Оповещаем клиента о доругих пользователях в сети
                serverMainLoop(connection, newUser);                                                    // Запускаем чат



            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("error, remote socket gg");

            }finally {
                connectionMap.remove(newUser);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, newUser));
                try {
                    assert connection != null;
                    connection.close();
                } catch (Exception ex) {
                    ConsoleHelper.writeMessage("error, connection socket close gg");
                }
            }
        }
    }

    //

    public static void main(String[] args) {
        int port = ConsoleHelper.readInt();
        ServerSocket serverSocket = null;
        try {
            Handler handler = null;
            Socket socket = null;
            serverSocket = new ServerSocket(port);
            System.out.println("Server is start");
            while (true) {
                socket = serverSocket.accept();
                handler = new Handler(socket);
                handler.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                serverSocket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


    // Бродкаст, отправляет сообщение всем пользователям
    public static void sendBroadcastMessage(Message message){
        for (Connection connection : connectionMap.values()) {
            try {
                connection.send(message);
            }catch (IOException e){
                try {
                    connection.send(new Message(MessageType.TEXT, "error"));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

    }
}
