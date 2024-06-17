/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.bancodojorge.apirest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Euler
 */
@RestController()
public class HomeController {
    
    @RequestMapping(value = "/home", method = {RequestMethod.POST,RequestMethod.GET})
    public String home()
    {
        return "Home";
    }
}
