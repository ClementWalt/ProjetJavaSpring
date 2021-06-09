package com.example.accessingdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/allContact")
    public String allContact(Model model){

        model.addAttribute("contacts", contactRepository.findAll());

        return "allContact";
    }

}
