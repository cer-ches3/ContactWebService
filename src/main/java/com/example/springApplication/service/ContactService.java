package com.example.springApplication.service;

import com.example.springApplication.entity.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> findAll();
    Contact findById(long id);
    Contact add(Contact contact);
    Contact edit(Contact contact);
    void deleteById(long id);
}
