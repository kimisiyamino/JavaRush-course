package com.javarush.games.snake;

import com.javarush.engine.cell.*;


public class SnakeGame extends Game {

    public static final int WIDTH = 100;
    public static final int HEIGHT = 100;
    public int gameSpeed = 100;
    public static Color backgroundColor = Color.ANTIQUEWHITE;
    private static final int GOAL = 1000;

    private boolean isGameStopped;

    private Snake snake;
    private Apple apple;
    private int score;
    private int turnDelay;


    @Override
    public void initialize()
    {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    @Override
    public void onTurn(int step)
    {
        if(!snake.isAlive){
            gameOver();
        }
        if(snake.getLength() > GOAL){
            win();
        }
        snake.move(apple);
        if(!apple.isAlive){
            score+=5;
            setScore(score);
            turnDelay-=10;
            setTurnTimer(turnDelay);
            createNewApple();
        }
        drawScene();
    }

    private void createGame()
    {
        Snake snake = new Snake(WIDTH/2, HEIGHT/2);
        this.snake = snake;
        createNewApple();
        turnDelay = gameSpeed;
        setTurnTimer(turnDelay);
        isGameStopped = false;
        score = 0;
        setScore(score);
        drawScene();
    }

    private void drawScene()
    {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                setCellValueEx(x, y, backgroundColor, "");
            }
        }
        snake.draw(this);
        apple.draw(this);
    }

    private void gameOver(){
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.BLACK, "GAME OVER", Color.WHITE, 100);
    }

    private void win(){
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.BLACK, "WIN", Color.PINK, 200);
    }


    @Override
    public void onKeyPress(Key key)
    {
        if(key == Key.SPACE && isGameStopped){
            createGame();
        }

        Direction direction = snake.getDirection();

        if(direction == Direction.UP || direction == Direction.DOWN){
            switch (key) {
                case LEFT:
                    snake.setDirection(Direction.LEFT);
                    break;
                case RIGHT:
                    snake.setDirection(Direction.RIGHT);
                    break;
            }
        }else if (direction == Direction.LEFT || direction == Direction.RIGHT){
            switch (key) {
                case UP:
                    snake.setDirection(Direction.UP);
                    break;
                case DOWN:
                    snake.setDirection(Direction.DOWN);
                    break;
            }
        }


    }

    private void createNewApple(){
        do{
            apple = new Apple(getRandomNumber(WIDTH), getRandomNumber(HEIGHT));
        } while(snake.checkCollision(apple));
    }
}
