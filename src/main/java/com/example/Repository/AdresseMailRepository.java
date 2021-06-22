package com.example.Repository;

import com.example.Entities.AdresseMail;
import org.springframework.data.repository.CrudRepository;

public interface AdresseMailRepository extends CrudRepository<AdresseMail, Long> {

    AdresseMail findById(long id);

    boolean existsAdresseMailByEmail(String email);
}