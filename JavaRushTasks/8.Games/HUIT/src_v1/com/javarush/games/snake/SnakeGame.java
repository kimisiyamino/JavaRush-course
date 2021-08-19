package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.*;

public class SnakeGame extends Game {

    public static final int WIDTH = 10;
    public static final int HEIGHT = 10;

    public static Color backgroundColor = Color.ANTIQUEWHITE;

    public List<Apple> apples;
    public List<GameObject> objects;


    @Override
    public void initialize()
    {
        apples = new ArrayList<>();
        objects = new ArrayList<>();

        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createGame()
    {
        drawScene();

        Apple apple1 = new Apple(7,7);
        Apple apple2 = new Apple(6,7, Color.BLACK);
        Apple apple3 = new Apple(5,7, Color.WHITE, Color.WHEAT);
        Apple apple4 = new Apple(4,7, Color.WHITESMOKE, Color.RED, 10);
        Apple apple5 = new Apple(3,7, Color.ROSYBROWN, Color.ROYALBLUE, 10);
        Apple apple6 = new Apple(2,7, Color.TAN, Color.TEAL, 50);
        Apple apple7 = new Apple(1,7, Color.THISTLE, Color.TOMATO, 30);

        Text text1 = new Text("Hi");
        Text text2 = new Text("10", 1, 6);
        Text text3 = new Text("1", 1, 5, Color.TRANSPARENT);
        Text text4 = new Text("2", 1, 4, Color.TURQUOISE, Color.PALETURQUOISE);
        Text text5 = new Text("3", 1, 3, Color.YELLOW, Color.LAVENDERBLUSH, 10);
        Text text6 = new Text("4", 1, 2, Color.GOLD, Color.CHOCOLATE, 50);
        Text text7 = new Text("5", 1, 1, Color.YELLOWGREEN, Color.INDIANRED, 25);


        Collections.addAll(objects, apple1, apple2, apple3, apple4, apple5, apple6,apple7, text1, text2, text3, text4, text5, text6, text7);

        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).draw(this);
        }
    }

    private void drawScene()
    {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                setCellColor(x, y, backgroundColor);
            }
        }
    }
}
