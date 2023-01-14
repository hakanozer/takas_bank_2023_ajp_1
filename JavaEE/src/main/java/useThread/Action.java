package useThread;

public class Action implements Runnable {

    String imagePath  = "";
    Action( String imagePath ) {
        this.imagePath = imagePath;
    }

    @Override
    public void run() {
        for(int i = 0; i< 10; i++ ) {
            if (false) break;
            try {
                Thread.sleep(1000);
                System.out.println( Thread.currentThread().getName() );
            }catch (Exception ex)  {};
            System.out.println("Upload : " + imagePath);
        }
    }

}
