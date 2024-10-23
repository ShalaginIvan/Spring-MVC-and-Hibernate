package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

//    @Transactional
//    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public User getById(Long id) {
        return userDao.getById(id);
    }

    //    @Transactional(readOnly = true)
//    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    public void save(User user) { userDao.save(user); }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

}