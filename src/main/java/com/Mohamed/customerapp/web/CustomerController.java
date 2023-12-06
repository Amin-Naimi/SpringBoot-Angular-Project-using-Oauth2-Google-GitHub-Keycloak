package com.Mohamed.customerapp.web;

import com.Mohamed.customerapp.entities.Customer;
import com.Mohamed.customerapp.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepository customerRepository;

    @GetMapping("/customers")
    public String customers(Model model){
        List<Customer> customerList = customerRepository.findAll();
        model.addAttribute("customers",customerList);
        return "customers";
    }
    @GetMapping("/products")
    public String products(Model model){
        return "products";
    }

    // L'objet de spring security (authentication) qui contient la session, les inforamtions de l'utilisateur authentifier
    @GetMapping("/auth")
    public Authentication authentication(Authentication authentication){
        return authentication;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

}
