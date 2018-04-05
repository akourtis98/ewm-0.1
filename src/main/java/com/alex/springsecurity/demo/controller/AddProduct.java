/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.springsecurity.demo.controller;

import com.alex.springsecurity.demo.dao.Products;
import com.alex.springsecurity.demo.service.ProductService;
import javax.validation.Valid;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @Autowired
    private ProductService productService;
    
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
            productService.saveProduct(Products);
            return "successproduct";
        }
    }
}

