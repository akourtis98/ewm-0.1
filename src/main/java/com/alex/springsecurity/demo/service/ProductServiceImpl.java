/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.springsecurity.demo.service;

import com.alex.springsecurity.demo.dao.Products;
import com.alex.springsecurity.demo.dao.ProductsDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author alexkourtis11
 */
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductsDAO productsDAO;
      
    @Override
    @Transactional
    public List<Products> getProducts() {
        return productsDAO.getProducts();
    }

    public Products getProduct(int id) {
       return productsDAO.getProduct(id);
    }

    public void saveProduct(Products product) {
        
        productsDAO.saveProduct(product);
    }
}