package Java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Result {

    Random random = new Random();

    public List<User> data() {
        List<User> ls = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            User u = new User();
            u.setName("Name : " + i);
            u.setUid(i);
            int ri = random.nextInt(2);
            u.setStatus( ri == 1 ? true : false );
            ls.add(u);
        }
        return ls;
    }
}
