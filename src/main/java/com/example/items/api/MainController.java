package com.example.items.api;

import com.example.items.dto.GetItemsResponseDto;
import com.example.items.dto.ItemDto;
import com.example.items.model.User;
import com.example.items.service.ItemService;
import com.example.items.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController @RequiredArgsConstructor
public class MainController {
    private final UserService userService;
    private final ItemService itemService;

    @GetMapping("/hello")
    public String hello () {
        return ResponseEntity.ok("Hello!").toString();
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> listUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/register")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/register").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

//    @PostMapping("/items")
//    public ResponseEntity<Item> addItemForUser(@RequestBody Item item) {
//        return ResponseEntity.ok().body(itemService.saveItem(item));
//    }

//    @GetMapping("/items")
//    public ResponseEntity<List<Item>> userItems() {
////        return ResponseEntity.ok().body(itemService.getItems());
//        return null;
//    }

    @GetMapping("/items")
    public GetItemsResponseDto getItems() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUser(auth.getName());
        return itemService.getUserItems(user.getId());
    }

    @GetMapping("/allitems")
    public List<ItemDto> getAllItems() {
        return itemService.getAllItems();
    }

}
