/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.springsecurity.demo.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author alexkourtis11
 */
@Repository
public class UsersDAOImpl implements UsersDAO {

    @Autowired(required=true)
    private SessionFactory sessionFactory;
    
    @Override
    @Transactional
    public void saveUser(User user) {
     
        sessionFactory.getCurrentSession().saveOrUpdate(user);     
        
    }

    @Override
    @Transactional
    public List<User> getUsers() {
               
        List<User> users = sessionFactory.getCurrentSession()
                .createQuery("from User", User.class)
                .getResultList();
               
       return users; 
    }

    @Override
    @Transactional
    public void deleteUser(String username) {
       
        sessionFactory.getCurrentSession()
                .createQuery("delete from User where username=:username")
                .setParameter("username", username)
                .executeUpdate();
    }

    @Override
    @Transactional
    public User getUserData(String username) {
        
       User user = sessionFactory.getCurrentSession().get(User.class, username);

       return user; 
    }

    @Override
    @Transactional
    public List<User> searchUsers(String searchTerm) {
        Session currentSession = sessionFactory.getCurrentSession();
        
        Query q = null;
        
        if (searchTerm != null && searchTerm.trim().length() > 0) {

            q =currentSession.createQuery("from User where lower(username) like :term or lower(password) like :term", User.class);
            q.setParameter("term", "%" + searchTerm.toLowerCase() + "%");

        }
        else {
            q =currentSession.createQuery("from User", User.class);            
        }
        
        List<User> users = q.getResultList();
                      
        return users;     
    }
}