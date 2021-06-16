package com.example.accessingdatajpa;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ADRESSE_MAIL", uniqueConstraints = @UniqueConstraint(columnNames = {"email"}))
public class AdresseMail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "email", unique = true, nullable = false)
    private String email;


    @ManyToOne
    @JoinColumn(name="contact_id")
    private Contact contact;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "AdresseMail{" +
                "email='" + email + '\'' +
                '}';
    }
}
