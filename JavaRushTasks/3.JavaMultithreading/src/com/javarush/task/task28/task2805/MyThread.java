package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    private static volatile AtomicInteger atomicInteger = new AtomicInteger(0);

    private void currentPrior() {
        synchronized (this) {
            int i = atomicInteger.incrementAndGet();
            if (i > MAX_PRIORITY) {
                atomicInteger.set(0);
                i = atomicInteger.incrementAndGet();
            }

            if (getThreadGroup().getName().equals("main")) {
                setPriority(i);

            } else {
                if (getThreadGroup().getMaxPriority() > i) {
                    setPriority(i);
                }else{
                    setPriority(getThreadGroup().getMaxPriority());
                }
            }
        }
    }

    public MyThread() {
        currentPrior();
    }

    public MyThread(Runnable target) {
        super(target);
        currentPrior();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        currentPrior();

    }

    public MyThread(String name) {
        super(name);
        currentPrior();

    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        currentPrior();

    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        currentPrior();

    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        currentPrior();

    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        currentPrior();

    }
}
