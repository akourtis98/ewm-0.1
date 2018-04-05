/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.springsecurity.demo.service;

import com.alex.springsecurity.demo.dao.Authorities;
import com.alex.springsecurity.demo.dao.AuthoritiesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alexkourtis11
 */
@Service
public class AuthoritiesServiceImpl implements AuthoritiesService{
    
    @Autowired
    private AuthoritiesDAO authoritiesDAO;

    public void AuthoServ(Authorities authorities) {
        
        authoritiesDAO.saveAuthorities(authorities);
    }
}
