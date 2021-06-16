package com.example.accessingdatajpa;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdresseMailRepository extends CrudRepository<AdresseMail, Long> {

    AdresseMail findById(long id);
}