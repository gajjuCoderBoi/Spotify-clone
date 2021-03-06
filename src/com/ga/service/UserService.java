package com.ga.service;

import com.ga.entity.Song;
import com.ga.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    public String signup(User user);
    public String login(User user);
    public User updateUser(User user, Long userId);
    public Long deleteUser(Long userId);
    public List<Song> songList(Long userId);
    public List<Song> addListener(Long userId, Long songId);

    public List<User> listUsers();
}
