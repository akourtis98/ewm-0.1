/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.springsecurity.demo.dao;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/** 
 *
 * @author alexkourtis11
 */
@Entity
@Table(name="authorities")
public class Authorities implements Serializable {
    
    @Column(name="username")
    @Id
    private String username;
    
    @Column(name="authority")
    private String authority;

    public Authorities(){}

    public Authorities (String username, String authority){
        this.username = username;
        this.authority = authority;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}