package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class BotClient extends Client {

    public class BotSocketThread extends Client.SocketThread{
//        @Override
//        public void run() {
//        }

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
            if(message.contains(":")) {
                String[] nameAndDate = message.split(":");
                boolean isFind = false;
                String pattern = "";
                switch (nameAndDate[1].trim()) {
                    case "дата":
                        pattern = "d.MM.YYYY";
                        isFind = true;
                        break;
                    case "день":
                        pattern = "d";
                        isFind = true;
                        break;
                    case "месяц":
                        pattern = "MMMM";
                        isFind = true;
                        break;
                    case "год":
                        pattern = "YYYY";
                        isFind = true;
                        break;
                    case "время":
                        pattern = "H:mm:ss";
                        isFind = true;
                        break;
                    case "час":
                        pattern = "H";
                        isFind = true;
                        break;
                    case "минуты":
                        pattern = "m";
                        isFind = true;
                        break;
                    case "секунды":
                        pattern = "s";
                        isFind = true;
                        break;
                }

                if (isFind) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                    Calendar calendar = Calendar.getInstance();
                    message = "Информация для " + nameAndDate[0] + ": " + simpleDateFormat.format(calendar.getTime());
                    sendTextMessage(message);
                }
            }
        }
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole(){
        return false;
    }

    @Override
    protected String getUserName(){
        return "date_bot_" + (int)(Math.random() * 100);
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}
