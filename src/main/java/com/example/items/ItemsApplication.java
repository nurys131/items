package com.example.items;

import com.example.items.model.Item;
import com.example.items.model.User;
import com.example.items.service.ItemService;
import com.example.items.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

@SpringBootApplication
public class ItemsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItemsApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner runner(UserService userService, ItemService itemService) {
        return args -> {
            UUID uuid1 = UUID.randomUUID();
            UUID uuid2 = UUID.randomUUID();
            userService.saveUser(new User(uuid1, "adam", "adam"));
            userService.saveUser(new User(uuid2, "john", "1234"));

            itemService.saveItem(new Item(UUID.randomUUID(), uuid1, "maka"));
            itemService.saveItem(new Item(UUID.randomUUID(), uuid1, "kawior"));
            itemService.saveItem(new Item(UUID.randomUUID(), uuid2, "jajka"));
        };
    }
}
