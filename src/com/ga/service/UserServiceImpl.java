package com.ga.service;

import com.ga.config.JwtUtil;
import com.ga.dao.UserDao;
import com.ga.entity.Song;
import com.ga.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    JwtUtil jwtUtil;

    @Override
    public String signup(User user) {
        user.setPassword(bCryptEncoder.encode(user.getPassword()));

        if(userDao.signup(user).getUserId()!= null){
            UserDetails userDetails = loadUserByUsername(user.getUsername());

            return jwtUtil.generateToken(userDetails);
        }
        return null;
    }

    @Override
    public String login(User user) {
        User foundUser = userDao.login(user);

        if(foundUser != null &&
        foundUser.getUserId()!= null && bCryptEncoder.matches(user.getPassword(), foundUser.getPassword())){
            UserDetails userDetails = loadUserByUsername(user.getUsername());
            return jwtUtil.generateToken(userDetails);
        }
        return null;
    }

    @Override
    public User updateUser(User user, Long userId) {
        return userDao.updateUser(user, userId);
    }

    @Override
    public User deleteUser(Long userId) {
        return userDao.deleteUser(userId);
    }

    @Override
    public List<Song> songList(Long userId) {
        return userDao.getUserById(userId).getSongs();
    }

    @Override
    public List<Song> addListener(Long userId, Long songId) {
        return userDao.addListener(userId, songId);
    }


    @Autowired
    @Qualifier("encoder")
    PasswordEncoder bCryptEncoder;



    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.getUserByUsername(s);
        if(user == null) throw new UsernameNotFoundException("Username not found");
        return new org.springframework.security.core.userdetails.User(user.getUsername(), bCryptEncoder.encode(user.getPassword()), true, true, true, true, getGrantedAuthority(user));
    }

    private List<GrantedAuthority> getGrantedAuthority(User user) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        grantedAuthorities.add(new SimpleGrantedAuthority("ADMIN"));

        return grantedAuthorities;
    }
}
