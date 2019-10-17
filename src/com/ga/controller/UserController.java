package com.ga.controller;

import com.ga.entity.Song;
import com.ga.entity.User;
import com.ga.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public User signup(@RequestBody User user) {
        return userService.signup(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return userService.login(user);
    }

    @PutMapping("/{userId}")
    public User updateUser(@RequestBody User user, @RequestAttribute("userId") Long userId) {
        return userService.updateUser(user, userId); }

    @DeleteMapping("/{userId}")
    public User deleteuser(@RequestAttribute("userId") Long userId) {
        return userService.deleteUser(userId);
    }

    @GetMapping("/{userId}/songs")
    public List<Song> getUserSongs(@RequestAttribute("userId") Long userId) {
        return userService.songList(userId);
    }


}
