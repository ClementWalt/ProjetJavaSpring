package com.example.Form;

import com.example.Entities.Contact;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

public class adresseMailForm {

    @NotNull
    private Long id;

    @Column(name = "EMAIL", unique = true)
    private String email;

    @NotNull
    private Contact contact;


    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
