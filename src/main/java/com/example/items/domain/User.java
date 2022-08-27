package com.example.items.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class User {
    @Id
    private UUID id;
    private String login;
    private String password;
}
