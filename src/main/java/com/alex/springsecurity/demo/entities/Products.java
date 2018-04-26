/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.springsecurity.demo.entities;

import com.alex.springsecurity.demo.dao.*;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Column(name="title")
    @NotNull(message="is required")
    @Size(min=1, message="is required")
    private String title;
    
    @Column(name="category")
    @NotNull(message="is required")
    @Size(min=1, message="is required")
    private String category;

    @Column(name="enabled")
    private int enabled;
    
    @Column(name="price")
    private int price;
    
    @Column(name="description")
    private String description;   
    
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

    @Override
    public String toString() {
        return "Products{" + "id=" + id + ", title=" + title + ", category=" + category + ", enabled=" + enabled + ", price=" + price + ", description=" + description + '}';
    }
}
