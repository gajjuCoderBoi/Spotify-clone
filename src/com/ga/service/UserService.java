package com.ga.service;

import com.ga.entity.Song;
import com.ga.entity.User;

import java.util.List;

public interface UserService {
    public User signup(User user);
    public User login(User user);
    public User updateUser(User user, Long userId);
    public User deleteUser(Long userId);
    public List<Song> songList(Long userId);
    public List<Song> addListener(Long userId, Long songId);
}
