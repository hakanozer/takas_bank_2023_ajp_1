package Java8;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class MainJava {
    public static void main(String[] args) {

        Result result = new Result();
        List<User> ls = result.data();

        long start = System.currentTimeMillis();
        ls.stream().forEach( item -> {
            try {
                Thread.sleep(1);
            }catch (Exception ex) {}
            System.out.println(item.getName());
        });


        ls
        .stream()
        .filter(item -> item.isStatus() == true)
        .forEach( item -> {
            System.out.println( item.getUid() + " " + item.isStatus() + " " + item.getName());
        });

        long end = System.currentTimeMillis();
        long bettween = end - start;
        System.out.println( "bettween : " + bettween );

        LocalDateTime local = LocalDateTime.now();
        System.out.println( local.getDayOfYear() );

        String stDate = "2023-01-14T08:56:43Z";
        Date date = new Date();
        date.setYear(1938);
        System.out.println("Date : " + date);
        System.out.println("Time : " + date.getTime());


    }
}
