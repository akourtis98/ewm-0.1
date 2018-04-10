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

/**
 *
 * @author alexkourtis11
 */
@Entity
@Table(name="shopping_cart")
public class ShoppingCart implements Serializable{

    @Column(name="id")
    @Id
    private int id;
    
    @Column(name="product")
    private int product;
    
    @Column(name="user")
    private String user;
     
    public ShoppingCart(){}
    
    public ShoppingCart(int product, String user) {
        this.product = product;
        this.user = user;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
}
