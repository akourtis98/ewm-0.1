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
    public void saveProduct(User user) {
        Session currSess = sessionFactory.getCurrentSession();
     
        currSess.saveOrUpdate(user);     
    }

    @Override
    @Transactional
    public List<User> getUsers() {
        Session currSess = sessionFactory.getCurrentSession();
        
        Query<User> q =
                currSess.createQuery("from User", User.class);
        
        List<User> users = q.getResultList();
               
       return users; 
    }

    @Override
    @Transactional
    public void deleteUser(String username) {
        Session currSess = sessionFactory.getCurrentSession();
        
        Query q =
                currSess.createQuery("delete from User where username=:username");
        
        q.setParameter("username", username);
        
        q.executeUpdate();
    }

    @Override
    @Transactional
    public User getUserData(String username) {
        Session currSess = sessionFactory.getCurrentSession();
        
       User user = currSess.get(User.class, username);

       return user; 
    }
}