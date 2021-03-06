package com.example.Entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;


@Entity
public class Contact  implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "contact", cascade = CascadeType.REMOVE)
    private Collection<AdresseMail> adresseMail;

    @ManyToMany
    @JoinTable(
            name="ADRESSE_CONTACT",
            joinColumns=@JoinColumn(name="id_contact"),
            inverseJoinColumns = @JoinColumn(name = "id_adresse"))
    private Collection<AdressePostale> adresses;

    protected Contact() {}

    public Contact(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s', adresseMail = '%s']",
                id, firstName, lastName, adresseMail, adresses);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public Collection<AdresseMail> getAdresseMail() {
        return adresseMail;
    }
}