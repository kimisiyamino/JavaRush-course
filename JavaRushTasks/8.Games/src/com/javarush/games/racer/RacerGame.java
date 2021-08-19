package com.javarush.games.racer;

import com.javarush.engine.cell.*;

public class RacerGame extends Game{
    
    public final static int WIDTH = 64;
    public final static int HEIGHT = 64;
    
    @Override
    public void initialize(){
        setScreenSize(WIDTH, HEIGHT);
        showGrid(false);
    }
}