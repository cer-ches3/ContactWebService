package com.example.springApplication.service;

import com.example.springApplication.entity.Contact;
import com.example.springApplication.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;

    @Override
    public List<Contact> findAll() {
        log.debug("Call ContactServiceImpl -> findAll");
        return contactRepository.findAll();
    }

    @Override
    public Contact findById(long id) {
        log.debug("Call ContactServiceImpl -> findById {}", id);
        return contactRepository.findById(id).orElse(null);
    }

    @Override
    public Contact add(Contact contact) {
        log.debug("Call ContactServiceImpl -> add {}", contact);
        return contactRepository.add(contact);
    }

    @Override
    public Contact edit(Contact contact) {
        log.debug("Call ContactServiceImpl -> edit {}", contact);
        return contactRepository.edit(contact);
    }

    @Override
    public void deleteById(long id) {
        log.debug("Call ContactServiceImpl -> delete {}", id);
        contactRepository.deleteById(id);
    }
}
