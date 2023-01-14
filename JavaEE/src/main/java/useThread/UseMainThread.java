package useThread;

public class UseMainThread {
    public static void main(String[] args) throws InterruptedException {

        Action ac1 =  new Action("image-1.jpg");
        Thread th1 = new Thread(ac1, "TH1");

        Action ac2 =  new Action("image-2.jpg");
        Thread th2 = new Thread(ac2, "TH2");

        Action ac3 =  new Action("image-3.jpg");
        Thread th3 = new Thread(ac3, "TH3");

        // Java 8 - Thread
        Runnable runnable = () -> {
            try {
            //System.out.println(th1.getPriority());
            //th1.setPriority(9);

            th1.start();
            th1.join();

            //System.out.println(th2.getPriority());
            //th2.setPriority(8);

            th2.start();
            th2.join();

            //System.out.println(th3.getPriority());
            //th3.setPriority(7);

            th3.start();
            th3.join();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread th = new Thread(runnable, "TH Runnable");
        th.start();
        th.join();

        System.out.println("This Line Call");
    }
}
