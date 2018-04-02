/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.springsecurity.demo.controller;

import com.alex.springsecurity.demo.dao.Products;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author alexkourtis11
 */
@Controller
public class Portfolio {
    
    @RequestMapping("/portfolio")
    public String portfolio(){
        return "portfolio";
    }
    
    @RequestMapping("/products-1")
    public String products1(){
        return "products-1";
    }
    
    
    public static List<Products> query(String arg){
        System.out.println("starting process");
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(com.alex.springsecurity.demo.dao.Products.class)
                .buildSessionFactory();
        
            Session session = factory.getCurrentSession();
            session.beginTransaction();
        
            
            return factory.getCurrentSession().createQuery("from Products " + arg).list();
    }
}