/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.springsecurity.demo.dao;

import java.util.List;

/**
 *
 * @author alexkourtis11
 */
public interface AuthoritiesDAO {
    
    public void saveAuthorities(Authorities authorities);

    public void deleteAuthority(String username);
}