package com.javarush.games.snake;

import com.javarush.engine.cell.*;


public class Apple extends GameObject {

    private static final String APPLE_SIGN = "\uD83C\uDF4E";

    public Color backColor;

    public Apple(int x, int y) {
        this(x, y, Color.RED);
    }

    public Apple(int x, int y, Color color) {
        this(x, y, color, SnakeGame.backgroundColor);
    }

    public Apple(int x, int y, Color color, Color backColor) {
        this(x, y, color, backColor, 75);
    }

    public Apple(int x, int y, Color color, Color backColor, int size) {
        super(x, y, color, size);
        this.backColor = backColor;

    }

    public void draw(Game game)
    {
        game.setCellValueEx(x, y, backColor, APPLE_SIGN, color, size);
    }
}
