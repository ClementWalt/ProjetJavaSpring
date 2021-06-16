package com.example.accessingdatajpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Controller
public class AddContactController implements WebMvcConfigurer {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/result").setViewName("result");
    }

    @GetMapping("/add")
    public String showForm(AddContactForm addContactForm) {
        return "form";
    }

    @PostMapping("/add")
    public String checkPersonInfo(@Valid AddContactForm addContactForm, BindingResult bindingResult, @ModelAttribute Contact contact, Model model) {

        if (bindingResult.hasErrors()) {
            return "form";
        }

        model.addAttribute("contact",contact);

        contactRepository.save(contact);

        return "result";
    }

    @GetMapping("/delete/{id}")

    public String delete(@PathVariable Long id){

        contactRepository.deleteById(id);

        return "delete";

    }

}