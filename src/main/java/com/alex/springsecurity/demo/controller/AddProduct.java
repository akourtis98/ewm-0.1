/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.springsecurity.demo.controller;

import com.alex.springsecurity.demo.dao.Products;
import javax.validation.Valid;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author alexkourtis11
 */
@Controller
@RequestMapping("/add-product")
public class AddProduct {
    
    @InitBinder
    public void initBinder(WebDataBinder databinder){
        
        StringTrimmerEditor strTrim = new StringTrimmerEditor(true);
        
        databinder.registerCustomEditor(String.class, strTrim);
    }
    
    @RequestMapping("/product")
    public String signup(Model model){
        
        model.addAttribute("Products", new Products());
        
        return "addProductPage";
    }
    
    @RequestMapping("/processProduct")
    public String processSignup(
    @Valid @ModelAttribute("Products") Products Products,
    BindingResult res){
        if (res.hasErrors()){
            return "addProductPage";
        }
        else{
            write(Products.getTitle(), Products.getCategory());
            return "successproduct";
        }
    }

    
    
    private static void write(String title, String category){
         // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(com.alex.springsecurity.demo.dao.Products.class)
                .buildSessionFactory();
        
        // create session@
        Session session = factory.getCurrentSession();
        try{
            
            System.out.println("creating new product");
            Products tempProducts = new com.alex.springsecurity.demo.dao.Products(title, category);
            
            session.beginTransaction();
             
            System.out.println("beginning transaction");
            session.save(tempProducts);
            
            session.getTransaction().commit();              
            }
        finally{
            factory.close();
        }
    }
}

