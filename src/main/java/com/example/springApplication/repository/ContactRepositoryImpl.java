package com.example.springApplication.repository;

import com.example.springApplication.entity.Contact;
import com.example.springApplication.exception.ContactNotFoundException;
import com.example.springApplication.mapper.ContactRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.ArgumentPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ContactRepositoryImpl implements ContactRepository{
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Contact> findAll() {
        log.debug("Call DBContactRepository -> findAll");

        String sql = "select * from contact";

        return jdbcTemplate.query(sql, new ContactRowMapper());
    }

    @Override
    public Optional<Contact> findById(long id) {
        log.debug("Call DBContactRepository -> findById {}", id);

        String sql = "select * from contact where id = ?";
        Contact contact = DataAccessUtils.singleResult(
                jdbcTemplate.query(
                        sql,
                        new ArgumentPreparedStatementSetter(new Object[] {id}),
                        new RowMapperResultSetExtractor<>(new ContactRowMapper())
                )
        );

        return Optional.ofNullable(contact);
    }

    @Override
    public Contact add(Contact contact) {
        log.debug("Call DBContactRepository -> add {}", contact);

        contact.setId(System.currentTimeMillis());
        String sql = "insert into contact (id, first_name, last_name, email, phone) values (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, contact.getId(), contact.getFirstName(), contact.getLastName(), contact.getEmail(), contact.getPhone());
        return contact;
    }

    @Override
    public Contact edit(Contact contact) {
        log.debug("Call DBContactRepository -> edit {}", contact);

        Contact existedContact = findById(contact.getId()).orElse(null);
        if (existedContact != null) {
            String sql = "update contact set first_name = ?, last_name = ?, email = ?, phone = ? where id = ?";
            jdbcTemplate.update(sql, contact.getFirstName(), contact.getLastName(), contact.getEmail(), contact.getPhone(), contact.getId());
            return contact;
        }

        log.warn("Contact with ID: {} not found!", contact.getId());
        throw new ContactNotFoundException("Contact for update not found: ID " + contact.getId());
    }

    @Override
    public void deleteById(long id) {
        log.debug("Call DBContactRepository -> deleteById {}", id);

        String sql = "delete from contact where id = ?";
        jdbcTemplate.update(sql, id);
    }
}
