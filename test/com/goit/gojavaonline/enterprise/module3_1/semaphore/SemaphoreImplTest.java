package com.goit.gojavaonline.enterprise.module3_1.semaphore;

import org.junit.Test;

public class SemaphoreImplTest {
    private static SemaphoreImpl semaphore;

    @Test
    public void testAcquire() throws Exception {
        int threads = 3;
        semaphore = new SemaphoreImpl(1);

        for (int i = 0; i < threads; i++) {
            new Thread(new WorkerForAcquire()).start();
        }

        while (WorkerForAcquire.counter < threads) {
            Thread.sleep(3000);
        }
    }

    static class WorkerForAcquire implements Runnable {
        public static int counter = 0;

        @Override
        public void run() {
            try {
                semaphore.acquire();
                Thread.sleep(1000);
                semaphore.release();
                counter++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    @Test
    public void testParametrizedAcquire() throws Exception {
        int threads  =3;
        semaphore = new SemaphoreImpl(5);

        for (int i = 0; i < threads; i++) {
            new Thread(new WorkerForParametrizedAcquire()).start();
        }

        while (WorkerForParametrizedAcquire.counter < threads)
            Thread.sleep(3000);
    }

    static class WorkerForParametrizedAcquire implements Runnable {
        public static int counter = 0;
        private int acquireToDo = 5;

        @Override
        public void run() {
            try {
                semaphore.acquire(acquireToDo);
                Thread.sleep(3000);
                semaphore.release(acquireToDo);
                counter++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}