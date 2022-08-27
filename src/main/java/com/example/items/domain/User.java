package com.example.items.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class User {
    @Id
    private UUID id;
    private String login;
    private String password;

}