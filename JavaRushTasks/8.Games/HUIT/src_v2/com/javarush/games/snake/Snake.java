package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    private List<GameObject> snakeParts;

    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";

    public boolean isAlive = true;

    private Direction direction = Direction.LEFT;

    private Color snakeColor;

    public Snake(int x, int y) {
        snakeParts = new ArrayList<>();
        snakeParts.add(new GameObject(x, y));
        snakeParts.add(new GameObject(x+1, y));
        //snakeParts.add(new GameObject(x+2, y));
        //snakeParts.add(new GameObject(x+3, y));
    }

    public int getLength(){
        return snakeParts.size();
    }

    public void move(Apple apple)
    {
        GameObject snakeNewHead = createNewHead();
        if(checkCollision(snakeNewHead) || snakeNewHead.x <= -1 || snakeNewHead.x >= SnakeGame.WIDTH || snakeNewHead.y <= -1 || snakeNewHead.y >= SnakeGame.HEIGHT)
        {
            isAlive = false;
        }
        else
        {
            if(snakeNewHead.x == apple.x && snakeNewHead.y == apple.y){
                apple.isAlive = false;
            }else{
                removeTail();
            }
            snakeParts.add(0, snakeNewHead);
        }


    }

    public void removeTail()
    {
        snakeParts.remove(snakeParts.size()-1);
    }

    public GameObject createNewHead()
    {
        GameObject snakeHead = snakeParts.get(0);

        switch (direction)
        {
            case UP:
                return new GameObject(snakeHead.x, snakeHead.y-1);
            case DOWN:
                return new GameObject(snakeHead.x, snakeHead.y+1);
            case LEFT:
                return new GameObject(snakeHead.x-1, snakeHead.y);
            case RIGHT:
                return new GameObject(snakeHead.x+1, snakeHead.y);
            default:
                return new GameObject(0,0);
        }
    }

    public void draw(Game game)
    {
        snakeColor =  isAlive ? snakeColor = Color.GREEN: Color.RED;

        game.setCellValueEx(snakeParts.get(0).x, snakeParts.get(0).y, Color.NONE, HEAD_SIGN, snakeColor,75);
        for (int i = 1; i < snakeParts.size(); i++)
        {
            game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y, Color.NONE, BODY_SIGN, snakeColor, 75);
        }
    }

    public void setDirection(Direction direction)
    {
        if(this.direction == Direction.LEFT && snakeParts.get(0).x == snakeParts.get(1).x){
            return;
        }
        if(this.direction == Direction.RIGHT && snakeParts.get(0).x == snakeParts.get(1).x){
            return;
        }
        if(this.direction == Direction.UP && snakeParts.get(0).y == snakeParts.get(1).y){
            return;
        }
        if(this.direction == Direction.DOWN && snakeParts.get(0).y == snakeParts.get(1).y){
            return;
        }
        this.direction = direction;
    }

    public boolean checkCollision(GameObject gameObject){
        for(GameObject snakePart : snakeParts){
            if(snakePart.x == gameObject.x && snakePart.y == gameObject.y){
                return true;
            }
        }
        return false;
    }


    public Direction getDirection() {
        return direction;
    }
}
