/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.springsecurity.demo.dao;

import com.alex.springsecurity.demo.entities.Products;
import com.alex.springsecurity.demo.entities.ShoppingCart;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author alexkourtis11
 */
@Repository
public class ProductsDAOImpl  implements ProductsDAO{
    
    @Autowired(required=true)
    private SessionFactory sessionFactory;
    
    @Override
    public List<Products> getProducts() {
              
       return sessionFactory.openSession()
                .createQuery("from Products", Products.class)
                .getResultList(); 
    }

    @Override
    @Transactional
    public Products getProduct(int id) {
        
        return sessionFactory
                .getCurrentSession()
                .get(Products.class, id);
    }
    
    @Override
    @Transactional
    public void saveProduct(Products product) {
        
        sessionFactory.getCurrentSession().saveOrUpdate(product);
        
    }
    
    @Override
    @Transactional
    public void deleteProd(int id){
        
        sessionFactory.getCurrentSession()
                .createQuery("delete from Products where id=:id")
                .setParameter("id", id).executeUpdate();
        
    }

    @Override
    @Transactional
    public List<Products> searchProducts(String searchTerm) {
        Session currentSession = sessionFactory.getCurrentSession();
        
        Query q = null;
        
        if (searchTerm != null && searchTerm.trim().length() > 0) {

            q =currentSession.createQuery("from Products where lower(title) like :term or lower(category) like :term", Products.class);
            q.setParameter("term", "%" + searchTerm.toLowerCase() + "%");

        }
        else {
            q =currentSession.createQuery("from Products", Products.class);            
        }
        
        List<Products> products = q.getResultList();
                      
        return products;      
    }

    @Override
    @Transactional
    public void addToCart(ShoppingCart cart) {
        
        sessionFactory.getCurrentSession().saveOrUpdate(cart);
        
    }  

    @Override
    @Transactional
    public List<ShoppingCart> getProductsFromCart(String username) {
        
         List<ShoppingCart> products = sessionFactory.openSession()
                .createQuery("from ShoppingCart where user like :username", ShoppingCart.class)
                .setParameter("username", username)
                .getResultList();
         
        return products;
    }
    
    @Override
    @Transactional
    public void deleteProdFromCart(int id, String username) {
        sessionFactory.getCurrentSession()
                .createQuery("delete from ShoppingCart where id=:id and user like :username")
                .setParameter("id", id)
                .setParameter("username", username)
                .executeUpdate();
    }
    @Override
    @Transactional
    public void deleteProdFromCart2(int id, String username) {
        sessionFactory.getCurrentSession()
                .createQuery("delete from ShoppingCart where product=:id and user like :username")
                .setParameter("id", id)
                .setParameter("username", username)
                .executeUpdate();
    }
    @Override
    @Transactional
    public List<Products> getQuantityOfProd(int id, String username) {
        return sessionFactory.getCurrentSession()
                .createQuery("from ShoppingCart where product=:id and user like :username")
                .setCacheable(true)
                .setParameter("id", id)
                .setParameter("username", username)
                .list();
    }
}