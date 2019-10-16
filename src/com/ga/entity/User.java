package com.ga.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(unique = true, nullable = false)
    private String username;

    @Column (nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY, cascade ={CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "user_song",
        joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "song_id")}
    )
    private List<Song> songs;

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}