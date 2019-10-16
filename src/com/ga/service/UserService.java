package com.ga.service;

import com.ga.entity.User;

public interface UserService {
    public User signup(User user);
    public User login(User user);
    public User updateUser(User user, Long userId);
    public User deleteUser(Long userId);

}
