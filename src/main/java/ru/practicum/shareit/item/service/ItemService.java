package ru.practicum.shareit.item.service;

import ru.practicum.shareit.item.dto.ItemDto;
import ru.practicum.shareit.item.model.Item;

import java.util.List;

public interface ItemService {

    List<ItemDto> findAllByUserId(Integer userId);

    ItemDto findById(Integer id);

    List<ItemDto> search(String text);

    ItemDto add(Integer userId, Item item);

    ItemDto change(Integer userId, Integer itemId, Item item);

    ItemDto deleteById(Integer userId, Integer id);
}