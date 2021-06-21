package com.example.Repository;

import java.util.List;

import com.example.Entities.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Long> {

    List<Contact> findByLastName(String lastName);

    Contact findById(long id);
}