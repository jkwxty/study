package callable;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.ReentrantLock;

class ThreadDemo implements Callable{

    @Override
    public Object call() throws Exception {
        return null;
    }
}

public class Demo1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CountDownLatch countDownLatch = new CountDownLatch(3);
//        FutureTask<Integer> futureTask = new FutureTask<>(()->{
//            int j=8;
//            for (int i = 0; i < j; i++) {
//                Thread.sleep(500);
//                countDownLatch.countDown();
//                j--;
//            }
//            System.out.println("1111");
//            return j;
//        });
//        futureTask.run();
//        countDownLatch.await();
//        System.out.println("结束");
//        Integer integer = futureTask.get();
//        System.out.println(integer);



//        HashMap<String, String> map = new HashMap<>();
//        for (int i = 0; i < 6; i++) {
//            int finalI = i;
//            FutureTask<String> vFutureTask = new FutureTask<>(() -> {
//                if(finalI /2 ==0){
//                    Thread.sleep(500);
//                }
//                return "线程执行完成，返回结果true";
//            });
//            new Thread(vFutureTask,"i").start();
//            map.put(String.valueOf(i), vFutureTask.get());
//        }
//
//        System.out.println(JSON.toJSONString(map));


    }


}
