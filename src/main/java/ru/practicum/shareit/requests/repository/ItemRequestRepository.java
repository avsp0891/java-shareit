package ru.practicum.shareit.requests.repository;

import ru.practicum.shareit.requests.model.ItemRequest;

import java.util.List;

public interface ItemRequestRepository {

    List<ItemRequest> findAll();

    ItemRequest getById(Integer id);

    ItemRequest add(ItemRequest itemRequest);

    ItemRequest change(ItemRequest itemRequest);

    ItemRequest deleteById(Integer id);
}
