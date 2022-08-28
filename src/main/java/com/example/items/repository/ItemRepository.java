package com.example.items.repository;

import com.example.items.model.Item;
import com.example.items.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ItemRepository extends JpaRepository<Item, UUID> {
//    Optional<Item> findById(UUID id);
//    Optional<Item> findByUser(User user);
}
