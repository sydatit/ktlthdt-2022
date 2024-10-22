package prepare.interview.ioc;

import java.util.Random;

public class MySQLUserRepository {

    public String getById(int id) {
        Random random = new Random();
        return random.nextInt(20) + "";
    }
}
