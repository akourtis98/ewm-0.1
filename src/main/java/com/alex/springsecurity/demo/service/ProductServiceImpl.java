/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.springsecurity.demo.service;

import com.alex.springsecurity.demo.entities.Products;
import com.alex.springsecurity.demo.dao.ProductsDAO;
import com.alex.springsecurity.demo.entities.ShoppingCart;
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

    @Override
    @Transactional
    public Products getProduct(int id) {
       return productsDAO.getProduct(id);
    }
    
    @Override
    @Transactional
    public void saveProduct(Products product) {
        
        productsDAO.saveProduct(product);
    }

    @Override
    @Transactional
    public void deleteProd(int id) {
         productsDAO.deleteProd(id);
    }

    @Override
    @Transactional
    public List<Products> searchProducts(String searchTerm) {
        return productsDAO.searchProducts(searchTerm);
    }

    @Override
    @Transactional
    public void addToCart(ShoppingCart cart) {
        productsDAO.addToCart(cart);
    }

    @Override
    @Transactional
    public List<ShoppingCart> getProductsFromCart(String username) {
        return productsDAO.getProductsFromCart(username);
    }

    @Override
    @Transactional
    public void deleteProdFromCart(int id, String username) {
        productsDAO.deleteProdFromCart(id, username);
    }

    @Override
    @Transactional
    public List<Products> getProductsFiltered(String category, String order) {
        return productsDAO.getProductsFiltered(category, order);
    }
}