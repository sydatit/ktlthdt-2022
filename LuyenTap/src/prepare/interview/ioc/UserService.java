package prepare.interview.ioc;

public class UserService {
    private MySQLUserRepository mySQLUserRepository;

    public UserService() {
        this.mySQLUserRepository = new MySQLUserRepository();
    }

    public String getById(int id) {
        return this.mySQLUserRepository.getById(id);
    }
}
