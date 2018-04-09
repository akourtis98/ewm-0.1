/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.springsecurity.demo.controller;

import com.alex.springsecurity.demo.entities.*;
import com.alex.springsecurity.demo.service.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author alexkourtis11
 */
@Controller
public class Portfolio {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private ProductService productService;
    
    @RequestMapping("/portfolio")
    public String portfolio(Model model){
      
        List<Products> products = productService.getProducts();
        
        model.addAttribute("products", products);
        
        return "portfolio";
    }
    
    @RequestMapping("/products-1")
    public String products1(){
        return "products-1";
    }
    
    @RequestMapping("/AddToCartLink")
    public String addToCart(@RequestParam("id") int id){
          
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        
        productService.addToCart(new ShoppingCart(id, username));
         
        return "redirect:/portfolio";
    }
}