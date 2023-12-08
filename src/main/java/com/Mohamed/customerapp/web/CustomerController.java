package com.Mohamed.customerapp.web;

import com.Mohamed.customerapp.entities.Customer;
import com.Mohamed.customerapp.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
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
    @ResponseBody
    public Authentication authentication(Authentication authentication){
        log.info(authentication.toString());
        return authentication;
    }

    // le "/" ne nessecite pas une authentification
    @GetMapping("/")
    public String index(){
        return "index";
    }

}
