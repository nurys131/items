package com.example.items.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
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