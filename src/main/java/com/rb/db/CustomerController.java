package com.rb.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {


    @Autowired
    CustomerRepository customerRepository ;


    @GetMapping("/customers")
    public String customerList(Model model){

        model.addAttribute("customers", customerRepository.findAll());


        return "mainPage";
    }


}
