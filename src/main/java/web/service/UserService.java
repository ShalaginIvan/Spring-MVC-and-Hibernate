package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    public User getById(Long id);

    List<User> getAll();

    public void save (User user);

    public void update(User user);

    public void delete(Long id);
}

