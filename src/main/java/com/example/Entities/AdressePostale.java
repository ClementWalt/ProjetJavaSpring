package com.example.Entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "ADRESSES_POSTALE")
public class AdressePostale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String Adresse;
    private String Complementaire;
    private String Ville;
    private String CodePostal;

    @ManyToMany(mappedBy = "adresses")
    private Collection<Contact> contacts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public String getComplementaire() {
        return Complementaire;
    }

    public void setComplementaire(String complementaire) {
        Complementaire = complementaire;
    }

    public String getVille() {
        return Ville;
    }

    public void setVille(String ville) {
        Ville = ville;
    }

    public String getCodePostal() {
        return CodePostal;
    }

    public void setCodePostal(String codePostal) {
        CodePostal = codePostal;
    }

    @Override
    public String toString() {
        return "AdressePostale{" +
                "Adresse='" + Adresse + '\'' +
                ", Complementaire='" + Complementaire + '\'' +
                ", Ville='" + Ville + '\'' +
                ", CodePostal='" + CodePostal + '\'' +
                '}';
    }
}
