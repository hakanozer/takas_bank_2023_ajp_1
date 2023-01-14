package useExecuters;

import java.sql.SQLException;
import java.util.Random;
import java.util.concurrent.*;

public class MainExecuters {
    public static void main(String[] args) throws Exception {


        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Random random = new Random();
                try {
                    Thread.sleep(3000);
                }catch (Exception ex) {}
                return random.nextInt(1000);
            }
        });
        System.out.println("Step -1");
        executorService.shutdown();
        System.out.println("Step -2");
        int end  = future.get(4000, TimeUnit.MILLISECONDS);
        System.out.println("Step -3");
        System.out.println("End : " + end);

    }
}
