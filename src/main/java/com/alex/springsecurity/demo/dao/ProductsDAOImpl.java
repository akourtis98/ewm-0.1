/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.springsecurity.demo.dao;

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
    @Transactional
    public List<Products> getProducts() {
        
        Session currentSession = sessionFactory.openSession();
        
        Query<Products> q = currentSession.createQuery("from Products", Products.class);
        
        List<Products> products = q.getResultList();
        
        for (Products p : products ){
            System.out.println("HERE IT IS " + p);
        }
        
       return products; 
    }
    
}
