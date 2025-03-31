package com.example.springApplication.entity;

import lombok.Data;

@Data
public class Contact {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
