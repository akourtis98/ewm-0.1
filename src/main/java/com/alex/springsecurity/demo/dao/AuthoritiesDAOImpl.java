/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.springsecurity.demo.dao;

import com.alex.springsecurity.demo.entities.Authorities;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author alexkourtis11
 */
@Repository
public class AuthoritiesDAOImpl implements AuthoritiesDAO {
 
    @Autowired(required=true)
    private SessionFactory sessionFactory;
    
    @Override
    @Transactional
    public void saveAuthorities(Authorities authorities) {   
        
        sessionFactory.getCurrentSession().saveOrUpdate(authorities);   
        
    }

    @Override
    @Transactional
    public void deleteAuthority(String username) {  
        
        sessionFactory
                .getCurrentSession()
                .createQuery("delete from Authorities where username=:username")
                .setParameter("username", username)
                .executeUpdate();
        
    }
}