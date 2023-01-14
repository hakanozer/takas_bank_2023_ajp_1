package useSynchronized;

public class MainApp {

    static int total = 0;

    public static void main(String[] args) {

        Customer c1 = new Customer(1000);
        Customer c2 = new Customer(-200);
        Customer c3 = new Customer(100);
        Customer c4 = new Customer(-400);

        new Thread(c1, "th-1").start();
        new Thread(c2, "th-2").start();
        new Thread(c3, "th-3").start();
        new Thread(c4, "th-4").start();

        System.out.println("This Line Call");

    }

    synchronized public static void call( int amount, String threadName ) {
        total = total + amount;
        System.out.println(threadName + " - Total : " + total);
    }
}
