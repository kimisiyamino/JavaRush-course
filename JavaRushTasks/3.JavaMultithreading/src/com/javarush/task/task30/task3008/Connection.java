package com.javarush.task.task30.task3008;

import java.io.*;
import java.net.Socket;
import java.net.SocketAddress;

public class Connection implements Closeable {
    final private Socket socket;
    final private ObjectOutputStream out;
    final private ObjectInputStream in;

    public Connection(Socket socket) throws IOException{
        this.socket = socket;

        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());

    }

    public void send(Message message) throws IOException{
        synchronized(out) {
            out.writeObject(message);
            out.flush();
        }
    }

    public Message receive() throws IOException, ClassNotFoundException{
        synchronized(in) {
            return (Message) in.readObject();
        }
    }

    public SocketAddress getRemoteSocketAddress(){
        return socket.getRemoteSocketAddress();
    }

    public void close() throws IOException{
        out.close();
        in.close();
        socket.close();
    }
}
