package com.javarush.games.snake;

import com.javarush.engine.cell.*;

public class GameObject {
    public int x;
    public int y;
    public int size;
    public Color color;


    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
