package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.model.Car;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

//@Repository
@Component
public class UserDaoImp implements UserDao{
    private static Long USER_COUNT = 0L;


    private List<User> users;

    public UserDaoImp() {
        this.users = new ArrayList<>();

        users.add(new User(++USER_COUNT,"Name1", "Surname1", "email1@test.com"));
        users.add(new User(++USER_COUNT,"Name2", "Surname2", "email2@test.com"));
        users.add(new User(++USER_COUNT,"Name3", "Surname3", "email3@test.com"));
        users.add(new User(++USER_COUNT,"Name4", "Surname4", "email4@test.com"));
        users.add(new User(++USER_COUNT,"Name5", "Surname5", "email5@test.com"));
    }

    @Override
    public void add(User user) {

    }

    @Override
    public User getById(Long id) {
        return users.stream().filter(e->e.getId() == id).findAny().orElse(null);
    }

    @Override
    public List<User> listUsers() {
        return users;
    }

    @Override
    public void save(User user) {
        user.setId(++USER_COUNT);
        users.add(user);
    }
}
