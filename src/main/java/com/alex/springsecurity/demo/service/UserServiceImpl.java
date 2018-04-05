/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.springsecurity.demo.service;

import com.alex.springsecurity.demo.dao.User;
import com.alex.springsecurity.demo.dao.UsersDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author alexkourtis11
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UsersDAO usersDAO;
    
    @Override
    @Transactional
    public void saveProduct(User user) {
        usersDAO.saveProduct(user);
    }

    @Override
    @Transactional
    public List<User> getUsers() {
        return usersDAO.getUsers();
    }

    @Override
    @Transactional
    public void deleteUser(String username) {
        usersDAO.deleteUser(username);
    }
    
}
