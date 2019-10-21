package com.ga.dao;

import com.ga.entity.Song;
import com.ga.entity.User;

import java.util.List;

public interface UserDao {
    public User signup(User user);
    public User login(User user);
    public User updateUser(User user, Long userId);
    public User deleteUser(Long userId);
    public User getUserByUsername(String username);
    public User getUserById(long userId);
    List<Song> addListener(Long userId, Long songId);

    public List<User> listUsers();
}
