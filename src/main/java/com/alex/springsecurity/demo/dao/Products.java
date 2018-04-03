/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.springsecurity.demo.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author alexkourtis11
 */
@Entity
@Table(name="products")
public class Products implements Serializable {
    
    public Products(){}
    
    public Products(String title, String category) {
        this.title = title;
        this.category = category;
    }
    
    public Products(List<Products> Products){
        this.list = Products;
    }
    
    @Transient
    private List<Products> list;

    
    
    @Id
    @Column(name="id")
    private int id;
    
    @Column(name="title")
    @NotNull(message="is required")
    @Size(min=1, message="is required")
    private String title;
    
    @Column(name="category")
    @NotNull(message="is required")
    @Size(min=1, message="is required")
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @Column(name="enabled")
    @Transient
    private int enabled;
    
    @Column(name="price")
    @Transient
    private int price;
    
    @Column(name="description")
    @Transient
    private String description;
    
     
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}