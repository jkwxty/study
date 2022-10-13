package lock;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Share{
    private int i=0;

    private final Lock lock=new ReentrantLock();
    private final Condition condition = lock.newCondition();
    public void add() throws InterruptedException {
        lock.lock();
        try{
            while (i==1){
                condition.await();
            }
            i++;
            System.out.println(Thread.currentThread().getName()+"::"+i);
            condition.signalAll();
        }finally {
            lock.unlock();
        }

    }

    public void redu() throws InterruptedException {
        lock.lock();
        try{
            while (i==0){
                condition.await();
            }
            i--;
            System.out.println(Thread.currentThread().getName()+"::"+i);
            condition.signalAll();
        }finally {
            lock.unlock();
        }

    }
}

public class ThreadDemo1 {

    public static void main(String[] args) {
        Share share = new Share();
        // 测试
        new Thread(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    share.add();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"aa").start();

        new Thread(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    share.redu();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"bb").start();

        new Thread(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    share.add();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"cc").start();


        new Thread(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    share.redu();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"dd").start();
    }
}
