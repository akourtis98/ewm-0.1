/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.springsecurity.demo.service;

import com.alex.springsecurity.demo.dao.Products;
import java.util.List;

/**
 *
 * @author alexkourtis11
 */
public interface ProductService {
    
    public List<Products> getProducts();

    public Products getProduct(int id);

    public void saveProduct(Products product);
    
}
