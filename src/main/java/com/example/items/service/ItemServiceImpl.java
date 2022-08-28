package com.example.items.service;

import com.example.items.dto.GetItemsResponseDto;
import com.example.items.dto.ItemDto;
import com.example.items.model.Item;
import com.example.items.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service @RequiredArgsConstructor @Transactional @Slf4j
//@Transactional
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    @Override
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public GetItemsResponseDto getUserItems(UUID userId) {
        return new GetItemsResponseDto(getAllItems().stream()
                .filter(i -> i.getOwner() == userId)
                .collect(Collectors.toList()));
    }

    @Override
    public List<ItemDto> getAllItems() {
        List<ItemDto> itemsDto = new ArrayList<>();
        List<Item> items = itemRepository.findAll();
        items.forEach(i -> itemsDto.add(new ItemDto(i.getOwner(), i.getName())));

        return itemsDto;
    }


}
