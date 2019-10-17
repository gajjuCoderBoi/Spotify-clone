package com.ga.controller;

import com.ga.entity.JwtResponse;
import com.ga.entity.Song;
import com.ga.entity.User;
import com.ga.service.SongService;
import com.ga.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    SongService songService;

//    @PreAuthorize("hasRole('ADMIN')")
//    @GetMapping("/list")
//    public List<User> listUsers() {
//        return userService.listUsers();
//    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user) {
        return ResponseEntity.ok(new JwtResponse(userService.signup(user)));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        return ResponseEntity.ok(new JwtResponse(userService.login(user)));
    }

    @PutMapping("/{userId}")
    public User updateUser(@RequestBody User user, @PathVariable(value = "userId") Long userId) {
        return userService.updateUser(user, userId); }

    @DeleteMapping("/{userId}")
    public User deleteUser(@PathVariable(value = "userId") Long userId) {
        return userService.deleteUser(userId);
    }

    @GetMapping("/{userId}/songs")
    public List<Song> getUserSongs(@PathVariable(value = "userId") Long userId) {
        return userService.songList(userId);
    }

    @PutMapping("/{userId}/addsong/{songId}")
    public List<Song> addUserSong(
            @PathVariable(value = "userId") Long userId,
            @PathVariable(value = "songId") Long songId)
    {
        return userService.addListener(userId, songId);
    }


}
