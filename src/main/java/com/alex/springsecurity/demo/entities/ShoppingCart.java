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
@Table(name="shopping_cart_product")
public class ShoppingCart implements Serializable{

    @Column(name="id")
    @Id
    private int id;
    
    @Column(name="productId")
    private int product;
    
    @Column(name="username")
    private String user;
    
    @Column(name="productName")
    private String productName;
    
    @Column(name="priceOfProduct")
    private int price;
    
    @Column(name="categoryOfProduct")
    private String categoryOfProduct;
    
    public int getPrice() {
        return price;
    }

    public String getCategoryOfProduct() {
        return categoryOfProduct;
    }

    public void setCategoryOfProduct(String categoryOfProduct) {
        this.categoryOfProduct = categoryOfProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public ShoppingCart(){};
    
    public ShoppingCart(int product, String user, String prodName) {
        this.product = product;
        this.user = user;
        this.productName = prodName;
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
