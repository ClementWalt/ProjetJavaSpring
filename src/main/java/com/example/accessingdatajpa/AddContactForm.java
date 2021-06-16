package com.example.accessingdatajpa;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddContactForm {

    @NotNull
    @Size(min=2, max=30)
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

    public String toString() {
        return "Contact(Prénom: " + this.firstName + ", Nom: " + this.lastName + ")";
    }
}