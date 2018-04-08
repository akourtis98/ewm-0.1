/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.springsecurity.demo.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/** 
 *
 * @author alexkourtis11
 */
@Entity
@Table(name="users")
public class User implements Serializable {
    
    @Column(name="username")
    @Id
    @NotNull(message="is required")
    @Size(min=1, message="is required")
    private String username;
    
    @Column(name="enabled")
    private int enabled;
    
    @Column(name="password")
    @NotNull(message="is required")
    @Size(min=1, message="is required")
    private String password;

    public User(){}

    public User(String username, String password, int enabled){
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }
     
    public User(String password, int enabled){
        this.password = password;
        this.enabled = enabled;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
}