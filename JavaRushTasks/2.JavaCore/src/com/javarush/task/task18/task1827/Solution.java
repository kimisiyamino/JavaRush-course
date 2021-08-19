package com.javarush.task.task18.task1827;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* 
Прайсы
*/

public class Solution {

    List<Order> orders = new LinkedList<>();

    public int getMaxId() {
        int max = 0;
        for (Order o : orders)
            if (o.id > max)
                max = o.id;

        return max;
    }

    public int getLen(String line){
        if(line.length() >= 50){
            return Integer.parseInt(line.substring(46, 50).trim());
        }

        switch(line.length()){
            case 47: return Integer.parseInt(line.substring(46, 47).trim());
            case 48: return Integer.parseInt(line.substring(46, 48).trim());
            case 49: return Integer.parseInt(line.substring(46, 49).trim());
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        new Solution().go(args);
    }

    public void go(String[] args) throws Exception {
        String parametr = "";
        String productName = "";
        double price = 0.0f;
        int quantity = 0;


        //int id=0;

        if(args.length == 4){
            parametr= args[0];
            productName= args[1];
            price= Double.parseDouble(args[2]);
            quantity= Integer.parseInt(args[3]);
        }
//        }else{
//            parametr = "-c";
//            productName = "virusnyayayayayayaayayayyayayayyyayaTROYANNNHAHAHAHAHAAHAHA";
//            price = 9999999.999999f;
//            quantity = 1234;
//        }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        //String fileName = "D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1827\\file";

        BufferedReader filereader = new BufferedReader(new FileReader(fileName));
        while(filereader.ready()){

            String line = filereader.readLine();
            System.out.println(line + "  =LEN()=" + line.length());

            int id_ = Integer.parseInt(line.substring(0, 8).trim());
            System.out.println("id- " + id_);
            String name_ = line.substring(8, 38).trim();
            System.out.println("name_- " + name_);
            double price_ = Double.parseDouble(line.substring(38, 46).trim());
            System.out.println("price_- " + price_);

            int quantity_ = getLen(line);

            System.out.println("quantity_- " + quantity_);


            orders.add(new Order(name_, id_, price_, quantity_));
        }

        filereader.close();

        if(parametr.equals("-c")){
            orders.add(new Order(productName, getMaxId()+1, price, quantity));

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
            for(Order o : orders){
                bufferedWriter.write(o.toString()+System.lineSeparator());
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        }
    }

    public class Order implements Comparable<Order>{
        Integer id;
        String name;
        double price;
        int quantity;

        public Order(String name, int id, double price, int quantity) {
            if(name.length()>30){
                name=name.substring(29);
            }
            this.name = name;
            this.id = id;
            this.price = price;

            Integer a = quantity;
            System.out.println(a + " " + a.toString().length());
            if(a.toString().length() > 4){
                quantity = Integer.parseInt(a.toString().substring(0,4));
            }
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return String.format("%-8d%-30s%-8s%-4d", id, name, price, quantity);
        }

        @Override
        public int compareTo(Order o) {
            return id > o.id ? 1 : id == o.id ? 0 : -1;
        }
    }
}
