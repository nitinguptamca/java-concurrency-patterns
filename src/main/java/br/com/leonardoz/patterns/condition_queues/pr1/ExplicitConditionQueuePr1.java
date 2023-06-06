package br.com.leonardoz.patterns.condition_queues.pr1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExplicitConditionQueuePr1 {

    private static final int LIMIT = 5;
    private int messageCount = 0;
    private Lock lock = new ReentrantLock();
    private Condition limitReachedCondition = lock.newCondition();
    private Condition limitUnreachedCondition = lock.newCondition();

    public void stopMessages() throws InterruptedException {

    }

    public void printMessages(String message) throws InterruptedException {
        lock.lock();
        try {
            while (messageCount < LIMIT) {
                limitReachedCondition.await();
            }
            System.err.println("Limit reached. Wait 2s");
            Thread.sleep(2000);
            messageCount = 0;
            limitUnreachedCondition.signalAll();
        }finally {
            limitReachedCondition.signalAll();
        }
    }


    public static void main(String[] args) {

    }
}
