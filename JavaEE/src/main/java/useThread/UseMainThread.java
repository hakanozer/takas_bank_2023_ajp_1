package useThread;

public class UseMainThread {
    public static void main(String[] args) {

        Action ac1 =  new Action("image-1.jpg");
        Thread th1 = new Thread(ac1);

        Action ac2 =  new Action("image-2.jpg");
        Thread th2 = new Thread(ac2);

        Action ac3 =  new Action("image-3.jpg");
        Thread th3 = new Thread(ac3);

        System.out.println(th1.getPriority());
        th1.setPriority(9);
        th1.start();

        System.out.println(th2.getPriority());
        th2.setPriority(8);
        th2.start();

        System.out.println(th3.getPriority());
        th3.setPriority(7);
        th3.start();


        System.out.println("This Line Call");
    }
}
