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
public class ProductsPage {
    
    @Autowired 
    private ProductService productService;

    @RequestMapping("/products")
    public String productsDefault(Model model){
      
        List<Products> products = productService.getProducts();
        
        model.addAttribute("products", products);
        
        return "Products/products";
    }
    
    @RequestMapping("/products/filter")
    public String products(@RequestParam("category") String category, @RequestParam("order") String order, Model model){
        
        List<Products> products = productService.getProductsFiltered(category, order);
        
        model.addAttribute("products", products);
        
        return "Products/products";
    }
    
    @RequestMapping("/AddToCartLink")
    public String addToCart(@RequestParam("id") int id, @RequestParam("prodName") String prodName)
    {      
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        
        productService.addToCart(new ShoppingCart(id, username, prodName));
        
        return "redirect:/products";
    }
}