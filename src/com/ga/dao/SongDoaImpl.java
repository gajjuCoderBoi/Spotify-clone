package com.ga.dao;

import com.ga.entity.Song;
import com.ga.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SongDoaImpl implements SongDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Song> songList() {
        List<Song> songs = null;
        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            songs = session.createQuery("FROM Song").getResultList();
        }finally {
            session.close();
        }
        return songs;
    }

    @Override
    public Song createSong(Song song) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.save(song);
            session.getTransaction().commit();
        }finally {
            session.close();
        }
        return song;
    }

    @Override
    public Song updateSong(Song song, Long songId) {
        Song savedSong = null;
        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();
            savedSong = session.get(Song.class, songId);
            savedSong.setName(song.getName());
            savedSong.setLength(song.getLength());
            session.update(song);
            session.getTransaction().commit();
        }finally {
            session.close();
        }
        return song;
    }

    @Override
    public long deleteSong(Long songId) {
        Song savedSong = null;
        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            savedSong = session.get(Song.class, songId);
            session.delete(savedSong);
            session.getTransaction().commit();
        }finally {
            session.close();
        }
        return savedSong.getSongId();
    }

    @Override
    public List<User> listeners(Long songId) {
        List<User> users= null;
        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            users = session.get(Song.class, songId).getUsers();
        }finally {
            session.close();
        }
        return users;
    }
}
