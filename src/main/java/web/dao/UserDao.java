package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    public User getById(Long id);

    public List<User> listUsers();

    public void save (User user);

    public void update(User user);

    public void delete(Long id);
}
