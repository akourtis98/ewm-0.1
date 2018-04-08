/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.springsecurity.demo.dao;

import com.alex.springsecurity.demo.entities.User;
import java.util.List;

/**
 *
 * @author alexkourtis11
 */
public interface UsersDAO {
    
    public void saveUser(User user);

    public List<User> getUsers();

    public void deleteUser(String username);

    public User getUserData(String username);

    public List<User> searchUsers(String searchTerm);
}
