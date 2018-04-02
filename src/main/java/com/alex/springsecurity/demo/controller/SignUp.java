/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.springsecurity.demo.controller;

import com.alex.springsecurity.demo.dao.Authorities;
import com.alex.springsecurity.demo.dao.User;
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
@RequestMapping("/user")
public class SignUp {
    
    @InitBinder
    public void initBinder(WebDataBinder databinder){
        
        StringTrimmerEditor strTrim = new StringTrimmerEditor(true);
        
        databinder.registerCustomEditor(String.class, strTrim);
    }
    
    @RequestMapping("/signup")
    public String signup(Model model){
        
        model.addAttribute("User", new User());
        
        return "signup";
    }
    
    @RequestMapping("/processSignup")
    public String processSignup(
    @Valid @ModelAttribute("User") User user,
    BindingResult res){
        if (res.hasErrors()){
            return "signup";
        }
        else{
            write(user.getUsername(), user.getPassword());
            return "successignup";
        }
    }

    
    
    private static void write(String username, String password){
         // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(com.alex.springsecurity.demo.dao.User.class)
                .addAnnotatedClass(com.alex.springsecurity.demo.dao.Authorities.class)
                .buildSessionFactory();
        
        // create session@
        Session session = factory.getCurrentSession();
        try{
            
            System.out.println("creating new user");
            User tempUser = new com.alex.springsecurity.demo.dao.User(username ,"{noop}"+password, 1);
            Authorities tempAuthorities= new com.alex.springsecurity.demo.dao.Authorities(username , "ROLE_USER");
            
            session.beginTransaction();
             
            System.out.println("beginning transaction");
            session.save(tempUser);
            
            session.getTransaction().commit();
            
            session = factory.getCurrentSession();
            
            session.beginTransaction();
             
            session.save(tempAuthorities);
            
            session.getTransaction().commit();
              
             }
        finally{
            factory.close();
        }
    }
}

