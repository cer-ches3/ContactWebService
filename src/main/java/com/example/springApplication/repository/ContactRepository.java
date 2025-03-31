package com.example.springApplication.repository;

import com.example.springApplication.entity.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactRepository {
    List<Contact> findAll();
    Optional<Contact> findById(long id);
    Contact add(Contact contact);
    Contact edit(Contact contact);
    void deleteById(long id);
}
