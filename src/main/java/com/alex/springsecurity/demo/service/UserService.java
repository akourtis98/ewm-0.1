/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.springsecurity.demo.service;

import com.alex.springsecurity.demo.dao.User;
import java.util.List;

/**
 *
 * @author alexkourtis11
 */
public interface UserService {
    
    public void saveProduct(User user);

    public List<User> getUsers();

    public void deleteUser(String username);

    public User getUserData(String username);
}
