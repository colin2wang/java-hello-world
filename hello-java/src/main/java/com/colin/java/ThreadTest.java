package com.colin.java;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyThread extends Thread {

    private ThreadLocal<String> tName = new ThreadLocal<>();
    private ThreadLocal<Integer> tCount = new ThreadLocal<>();
    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        tName.set(Thread.currentThread().getName());
        tCount.set(0);

        for (int i = 0; i < 5; i++) {
            System.out.println(String.format("%s : %s", tName.get(), tCount.get()));

            lock.lock();
            tCount.set(tCount.get() + 1);
            lock.unlock();
        }
    }
}

public class ThreadTest {

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            new MyThread().start();
        }
    }
}
