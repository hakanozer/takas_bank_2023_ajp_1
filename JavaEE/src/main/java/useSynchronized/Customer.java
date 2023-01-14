package useSynchronized;

public class Customer implements Runnable {

    int total = 0;
    public Customer(int total) {
        this.total = total;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        }catch (Exception ex) {}
        MainApp.call(total, Thread.currentThread().getName() );
    }



}
