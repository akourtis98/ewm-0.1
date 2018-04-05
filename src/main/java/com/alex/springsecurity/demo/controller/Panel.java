/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.springsecurity.demo.controller;

import com.alex.springsecurity.demo.dao.Products;
import com.alex.springsecurity.demo.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author alexkourtis11
 */
@Controller
@RequestMapping("/panel")
public class Panel {
    
    @Autowired
    private ProductService productService;
    
    @RequestMapping("/list")
    public String panel(Model model){
      
        List<Products> products = productService.getProducts();
        
        model.addAttribute("products", products);
                     
        return "panel";
    }  
    
    @PostMapping("/saveCustomer")
    public String save(@ModelAttribute("Products")Products product){
        
        productService.saveProduct(product);
        
        return "redirect:/panel/list";
    }
    
    @GetMapping("/updateProduct")
    public String showFormUpd(@RequestParam("id") int id,
            Model model){
        
        Products prod = productService.getProduct(id);
        
        model.addAttribute("Products", prod);
                
        return "productform";
    }  
    
    @GetMapping("/deleteProduct")
    public String delFormUpd(@RequestParam("id") int id){
        
        productService.deleteProd(id);
        
        return "redirect:/panel/list";
    } 
}