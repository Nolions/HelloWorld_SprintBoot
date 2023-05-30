package com.nolions.hellowordsprintboot.model;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String username;
    private Integer age;
    private String email;
}
