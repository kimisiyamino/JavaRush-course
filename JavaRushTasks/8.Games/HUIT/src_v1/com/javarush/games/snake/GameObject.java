package com.javarush.games.snake;

import com.javarush.engine.cell.*;

public abstract class GameObject {
    public int x;
    public int y;
    public int size;
    public Color color;


    public GameObject(int x, int y) {
        this(x, y, Color.WHITE);
    }

    public GameObject(int x, int y, Color color) {
        this(x, y, color, 75);
    }

    public GameObject(int x, int y, Color color, int size) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.size = size;
    }

    abstract public void draw(Game game);
}
