/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.springsecurity.demo.controller;

import com.alex.springsecurity.demo.dao.Products;
import com.alex.springsecurity.demo.dao.ProductsDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author alexkourtis11
 */
@Controller
@RequestMapping("/panel")
public class Panel {
    
    @Autowired
    private ProductsDAO productsDAO;
     
    @RequestMapping("/list")
    public String panel(Model model){
      
        List<Products> products = productsDAO.getProducts();
        
        model.addAttribute("products", products);
                     
        return "panel";
    }  
}