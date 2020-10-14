package com.colin.java;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeTest {

    private static Integer integer = 0;
    private static Integer lInteger = 0;
    private static final AtomicInteger atomicInteger = new AtomicInteger(0);
    private static final Lock lock = new ReentrantLock();

    private static final int THREAD_NUM = 6;

    public static void main(String[] args) throws InterruptedException {

        final CountDownLatch countDownLatch = new CountDownLatch(THREAD_NUM * 3);

        for (int i = 0; i < THREAD_NUM * 3; i++) {
            final int idx = i;
            new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
                    switch (idx % 3) {
                        case 0:
                            integer++;
                            break;
                        case 1:
                            atomicInteger.getAndIncrement();
                            break;
                        case 2:
                            lock.lock();
                            lInteger++;
                            lock.unlock();
                            break;
                    }
                }
                countDownLatch.countDown();
            }).start();
        }

        countDownLatch.await();
        System.out.println(integer);
        System.out.println(lInteger);
        System.out.println(atomicInteger.get());
    }
}
