package com.ga.dao;

import com.ga.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public User signup(User user) {
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            session.save(user);

            session.getTransaction().commit();
        } finally {
            session.close();
        }

        return user;
    }

    @Override
    public User login(User user) {
        Session session = sessionFactory.getCurrentSession();
        User savedUser;

        try {
            session.beginTransaction();
            savedUser = (User) session.createQuery("FROM User u WHERE u.username = '" +
                    user.getPassword() + "'").getSingleResult();

        } finally {
            session.close();
        }

        return savedUser;
    }

    @Override
    public User updateUser(User user, Long userId) {
        User savedUser = null;

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            savedUser = session.get(User.class, userId);
            savedUser.setPassword(user.getPassword());

            session.update(savedUser);

            session.getTransaction().commit();
        } finally {
            session.close();
        }

        return savedUser;
    }

    @Override
    public User deleteUser(Long userId) {
        User deleteUser = null;
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            deleteUser = session.get(User.class, userId);
            session.delete(deleteUser);

            session.getTransaction().commit();

        } finally {
            session.close();
        }

        return deleteUser;
    }

    @Override
    public User getUserByUsername(String username) {
        User savedUser = null;

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            savedUser = (User) session.createQuery("FROM User u where u.username='" + username + "'").getSingleResult();

        } finally {
            session.close();
        }

        return savedUser;
    }

    @Override
    public User getUserById(long userId) {
        User savedUser = null;

        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();

            savedUser = session.get(User.class, userId);


        } finally {

            session.close();

        }

        return savedUser;
    }
}
