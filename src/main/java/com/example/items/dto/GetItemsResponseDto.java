package com.example.items.dto;

import lombok.Value;

import java.util.List;

@Value
public class GetItemsResponseDto {
    List<ItemDto> items;
}
