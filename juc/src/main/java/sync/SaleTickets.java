package sync;

/**
 *
 * @author JiangKangWei
 * @create 2022/10/10 14:20
 */
public class SaleTickets {



    public static void main(String[] args) {
        Tickets tickets = new Tickets();
        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                tickets.sale();
            }
        },"aa").start();

        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                tickets.sale();
            }
        },"bb").start();


    }

}

class Tickets{
    private int count=30;

    public synchronized void sale(){
        if(count>0){
            count--;
            System.out.println(Thread.currentThread().getName()+"卖出1张，剩余"+count);
        }
    }
}
