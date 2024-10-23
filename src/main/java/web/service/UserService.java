package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    void add(User user);

    public User getById(Long id);

    List<User> listUsers();

    public void save (User user);

    public void update(User user);

    public void delete(Long id);
}

