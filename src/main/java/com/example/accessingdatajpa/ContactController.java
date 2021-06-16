package com.example.accessingdatajpa;

import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller
public class ContactController implements WebMvcConfigurer {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private AdresseMailRepository adresseMailRepository;

    @GetMapping("/")
    public String home()
    {
        System.out.println(contactRepository.findById(6));
        return "home";
    }

    @GetMapping("/allContact")
    public String allContact(Model model){

        model.addAttribute("contacts", contactRepository.findAll());

        return "allContact";
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/result").setViewName("result");
    }

    @GetMapping("/add")
    public String showForm(contactForm addContactForm) {
        return "form";
    }

    @PostMapping("/add")
    public String checkPersonInfo(@Valid contactForm addContactForm, BindingResult bindingResult, @ModelAttribute Contact contact, Model model) {

        if (bindingResult.hasErrors()) {
            return "form";
        }

        model.addAttribute("contact",contact);

        contactRepository.save(contact);

        return "result";
    }

    @GetMapping("/delete/{id}")
    public String deleteid(@PathVariable Long id){

        contactRepository.deleteById(id);

        return "deleteid";

    }


    @GetMapping("/delete")
    public String delete(Model model){

        model.addAttribute("contacts", contactRepository.findAll());

        return "delete";

    }

    @GetMapping("/edit/{id}")
    public String editid(@PathVariable Long id, Model model){

        model.addAttribute("contact", contactRepository.findById(id));

        return "editid";

    }


    @GetMapping("/edit")
    public String edit(Model model){

        model.addAttribute("contacts", contactRepository.findAll());

        return "edit";

    }

    @PostMapping("/edit")
    public String submitEdit(@ModelAttribute Contact contact, Model model){

        contactRepository.save(contact);

        model.addAttribute("contacts", contactRepository.findAll());

        return "edit";

    }

    @GetMapping("/addEmail/{id}")
    public String addEmailForm(adresseMailForm adresseMail, Model model, @PathVariable Long id){

        model.addAttribute("contactID",id);

        return "addEmail";
    }

    @PostMapping("/addEmail/{id}")
    public String addEmailPost(@ModelAttribute AdresseMail adresseMail, @PathVariable Long id){

        adresseMail.setContact(contactRepository.findById(id).get());

        adresseMailRepository.save(adresseMail);

        return "edit";
    }
}
