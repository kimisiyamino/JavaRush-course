package com.javarush.games.snake;

import com.javarush.engine.cell.*;

public class Text extends GameObject{
    private String TEXT = "";

    public Color backColor;

    public Text(String text) {
        this(text, 0,0);
    }

    public Text(String text, int x, int y) {
        this(text, x, y, Color.BLACK);
    }

    public Text(String text, int x, int y, Color color) {
        this(text, x, y, color, SnakeGame.backgroundColor);
    }

    public Text(String text, int x, int y, Color color, Color backColor) {
        this(text, x, y, color, backColor, 75);
    }

    public Text(String text, int x, int y, Color color, Color backColor, int size) {
        super(x, y, color, size);
        this.backColor = backColor;
        this.TEXT = text;
    }

    public void draw(Game game)
    {
        game.setCellValueEx(x, y, backColor, TEXT, color, size);
    }
}
