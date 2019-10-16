package com.ga.service;

import com.ga.dao.UserDao;
import com.ga.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public User signup(User user) {
        return userDao.signup(user);
    }

    @Override
    public User login(User user) {
        return userDao.login(user);
    }

    @Override
    public User updateUser(User user, Long userId) {
        return userDao.updateUser(user, userId);
    }

    @Override
    public User deleteUser(Long userId) {
        return userDao.deleteUser(userId);
    }


}
