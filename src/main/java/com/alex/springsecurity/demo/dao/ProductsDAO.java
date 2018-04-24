    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.springsecurity.demo.dao;

import com.alex.springsecurity.demo.entities.Products;
import com.alex.springsecurity.demo.entities.ShoppingCart;
import java.util.List;

/**
 *
 * @author alexkourtis11
 */
public interface ProductsDAO{

    public void deleteProd(int id);
    
    public List<Products> getProducts();
    
    public Products getProduct(int id);

    public void saveProduct(Products product);

    public List<Products> searchProducts(String searchTerm);

    public void addToCart(ShoppingCart cart);

    public List<ShoppingCart> getProductsFromCart(String username);

    public void deleteProdFromCart(int id, String username);   

    public List<Products> getProductsFiltered(String category, String order);
}
