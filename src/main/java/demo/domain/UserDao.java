package demo.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDao {

    public List<User> findAll() {
        ArrayList<User> users = new ArrayList<User>();
        User a = new User("Abderrazak", "1234");
        users.add(a);
        users.add(a);
        users.add(a);
        users.add(a);
        users.add(a);
        users.add(a);
        return users;
    }
}
