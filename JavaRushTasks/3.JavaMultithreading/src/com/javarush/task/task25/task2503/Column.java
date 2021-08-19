package com.javarush.task.task25.task2503;

import java.lang.reflect.Array;
import java.util.*;

public enum Column implements Columnable{
    Customer("Customer"),
    BankName("Bank Name"),
    AccountNumber("Account Number"),
    Amount("Available Amount");
    
    private String columnName;

    private static int[] realOrder;

    private Column(String columnName) {
        this.columnName = columnName;
    }

    /**
     * Задает новый порядок отображения колонок, который хранится в массиве realOrder.
     * realOrder[индекс в энуме] = порядок отображения; -1, если колонка не отображается.
     *
     * @param newOrder новая последовательность колонок, в которой они будут отображаться в таблице
     * @throws IllegalArgumentException при дубликате колонки
     */
    public static void configureColumns(Column... newOrder) {

        realOrder = new int[values().length];
        for (Column column : values()) {
            realOrder[column.ordinal()] = -1;
            boolean isFound = false;

            for (int i = 0; i < newOrder.length; i++) {
                if (column == newOrder[i]) {
                    if (isFound) {
                        throw new IllegalArgumentException("Column '" + column.columnName + "' is already configured.");
                    }
                    realOrder[column.ordinal()] = i;
                    isFound = true;
                }
            }
        }
    }

    /**
     * Вычисляет и возвращает список отображаемых колонок в сконфигурированом порядке (см. метод configureColumns)
     * Используется поле realOrder.
     *
     * @return список колонок
     */
    public static List<Column> getVisibleColumns() {
        List<Column> result = new LinkedList<>();
        Map<Integer, Column> res = new TreeMap<>();

        for (int i = 0; i < realOrder.length; i++){
            switch (realOrder[i]){
                case -1: break;
                case 0:
                case 3:
                case 2:
                case 1: res.put(realOrder[i], values()[i]); break;
            }
        }

        for(Map.Entry<Integer, Column> m : res.entrySet()){
            result.add(Column.valueOf(m.getValue().name()));
        }

        return result;
    }
    
    
    /**
     * @return полное имя колонки
     */
    @Override
    public String getColumnName(){
        return columnName;
    }

    /**
     * Возвращает true, если колонка видимая, иначе false
     */
    @Override
    public boolean isShown(){
        return realOrder[ordinal()] != -1;
    }

    /**
     * Скрывает колонку - маркирует колонку -1 в массиве realOrder.
     * Сдвигает индексы отображаемых колонок, которые идут после скрытой
     */
    @Override
    public void hide(){
        realOrder[ordinal()] = -1;

        ArrayList<Column> columns = new ArrayList<>();
        Map<Integer, Column> res = new TreeMap<>();

        for (int i = 0; i < realOrder.length; i++){
            switch (realOrder[i]){
                case -1: break;
                case 0:
                case 3:
                case 2:
                case 1: res.put(realOrder[i], values()[i]); break;
            }
        }

        for(Map.Entry<Integer, Column> m : res.entrySet()){
            columns.add(Column.valueOf(m.getValue().name()));
        }

        Column[] columns1 = new Column[columns.size()];
        for (int i = 0; i < columns1.length; i++) {
            columns1[i] = columns.get(i);
        }

        configureColumns(columns1);
    }
}
