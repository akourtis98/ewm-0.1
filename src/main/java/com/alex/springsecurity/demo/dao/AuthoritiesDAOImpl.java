/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.springsecurity.demo.dao;

import org.hibernate.Session;
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
        Session currSess = sessionFactory.getCurrentSession();
     
        currSess.saveOrUpdate(authorities);     
    }
}
