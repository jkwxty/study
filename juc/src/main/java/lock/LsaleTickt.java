package lock;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Tickt{

    private int count=300;

    private final Lock lock=new ReentrantLock();

    public void sale(){
        lock.lock();

        try{
            if(count>0){
                count--;
                System.out.println(Thread.currentThread().getName()+"卖出1张，剩余"+count);
            }
        }finally {
            lock.unlock();
        }
    }
}

public class LsaleTickt {

    public static void main(String[] args) {
        Tickt tickets = new Tickt();
        new Thread(()->{
            for (int i = 0; i < 300; i++) {
                tickets.sale();
            }
        },"aa").start();

        new Thread(()->{
            for (int i = 0; i < 300; i++) {
                tickets.sale();
            }
        },"bb").start();

    }
}
