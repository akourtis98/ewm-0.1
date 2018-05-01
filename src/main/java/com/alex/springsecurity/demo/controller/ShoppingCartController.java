/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.springsecurity.demo.controller;

import com.alex.springsecurity.demo.entities.ShoppingCart;
import com.alex.springsecurity.demo.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author alexkourtis11
 */
@Controller
@RequestMapping("/shoppingcart")
public class ShoppingCartController {
    
    @Autowired
    private ProductService productService;
    
    @RequestMapping("/list")
    public String panel(Model model){
      
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        
        List<ShoppingCart> products = productService.getProductsFromCart(username);
        
        model.addAttribute("products", products);
                     
        return "ShoppingCart/cart-panel";
    } 

    @GetMapping("/deleteProductFromCart")
    public String delFormCart(@RequestParam("id") int id){
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        
        productService.deleteProdFromCart(id, username);
        
        return "redirect:/ShoppingCart/shoppingcart/list";
    }         
}
