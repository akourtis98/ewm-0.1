/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.springsecurity.demo.controller;

import com.alex.springsecurity.demo.dao.Products;
import com.alex.springsecurity.demo.dao.User;
import com.alex.springsecurity.demo.service.AuthoritiesService;
import com.alex.springsecurity.demo.service.ProductService;
import com.alex.springsecurity.demo.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    
    @Autowired
    private AuthoritiesService authoritiesService;
    
    @Autowired
    private UserService userService;
    
    @RequestMapping("/list")
    public String panel(Model model){
      
        List<Products> products = productService.getProducts();
        
        model.addAttribute("products", products);
                     
        return "panel";
    }  
    @RequestMapping("/list-users")
    public String panelUsers(Model model){
      
        List<User> users = userService.getUsers();    
        model.addAttribute("users", users);
        
        return "panel-users";
    }  
    
    @PostMapping("/saveCustomer")
    public String save(@ModelAttribute("Products")Products product){
        
        productService.saveProduct(product);
        
        return "redirect:/panel/list";
    }  
            
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("User")User user){
        
        userService.saveProduct(user);
        
        return "redirect:/panel/list-users";
    }
    
    @RequestMapping(value="search", method = RequestMethod.POST)
    public String searchProducts(@RequestParam("searchTerm") String searchTerm,
                                    Model theModel) {
        
    List<Products> products = productService.searchProducts(searchTerm);
                
        theModel.addAttribute("products", products);
       
        return "list-results";
    }
            
    @RequestMapping(value="search-users", method = RequestMethod.POST)
    public String searchUsers(@RequestParam("username") String searchTerm,
                                    Model theModel) {
  
        List<User> users = userService.searchUsers(searchTerm);
              
        theModel.addAttribute("users", users);
        
        return "list-results-uers";
    }
    
    @GetMapping("/updateProduct")
    public String showFormUpd(@RequestParam("id") int id,
            Model model){
        
        Products prod = productService.getProduct(id);
        
        model.addAttribute("Products", prod);
                
        return "productform";
    } 
    
    @GetMapping("/updateUser")
    public String updateUser(@RequestParam("username") String username,
            Model model){
        
        User User = userService.getUserData(username);
        
        model.addAttribute("User", User);
                
        return "userForm";
    }  
    
    @GetMapping("/deleteUser")
    public String delFormUpd1(@RequestParam("username") String username){
        
        authoritiesService.deleteAuthority(username);
        userService.deleteUser(username);
        
        return "redirect:/panel/list-users";
    } 
    
    @GetMapping("/deleteProduct")
    public String delFormUpd(@RequestParam("id") int id){
        
        productService.deleteProd(id);
        
        return "redirect:/panel/list";
    } 
}