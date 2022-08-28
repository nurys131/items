package com.example.items.service;

import com.example.items.dto.GetItemsResponseDto;
import com.example.items.dto.ItemDto;
import com.example.items.model.Item;

import java.util.List;
import java.util.UUID;

public interface ItemService {
    Item saveItem(Item item);
    GetItemsResponseDto getUserItems(UUID userId);
    List<ItemDto> getAllItems();
}
