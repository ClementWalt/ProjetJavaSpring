package com.example.accessingdatajpa;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class contactForm {
    @NotNull
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public void String (String lastName) {
        this.lastName = lastName;
    }

    public void setId(Long id){this.id = id;}
    public Long getId(){return this.id;}

    public String toString() {
        return "Contact(Prénom: " + this.firstName + ", Nom: " + this.lastName + ")";
    }
}