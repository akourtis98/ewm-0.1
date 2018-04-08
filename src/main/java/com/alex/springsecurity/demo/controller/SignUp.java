/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.springsecurity.demo.controller;

import com.alex.springsecurity.demo.entities.Authorities;
import com.alex.springsecurity.demo.entities.User;
import com.alex.springsecurity.demo.service.AuthoritiesService;
import com.alex.springsecurity.demo.service.UserService;
import javax.validation.Valid;
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
 * @author alexkourtis11    @Column(name="username")
    @NotNull(message="is required")
    @Size(min=1, message="is required")
    @Id
    private String username;
 */
@Controller
@RequestMapping("/user")
public class SignUp {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private AuthoritiesService authoritiesService;
    
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
            userService.saveUser(new User(user.getUsername() ,"{noop}"+user.getPassword(), 1));
            authoritiesService.AuthoServ(new Authorities(user.getUsername() , "ROLE_USER"));
            return "successignup";
        }
    }
}

