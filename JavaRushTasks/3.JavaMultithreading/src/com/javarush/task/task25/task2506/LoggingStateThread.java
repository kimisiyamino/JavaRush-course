package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private Thread thread;

    public LoggingStateThread(Thread thread){
        this.thread = thread;
        setDaemon(true);
    }

    @Override
    public void run(){
        String state = thread.getState().name();
        System.out.println(state);
        while(true) {
            String state2 = thread.getState().name();
            if(state2.equals("TERMINATED")){
                System.out.println(state2);
                break;
            }else if(!state.equals(state2)){
                state = state2;
                System.out.println(state2);
            }
        }
    }
}
