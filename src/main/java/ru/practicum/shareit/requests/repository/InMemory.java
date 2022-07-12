package ru.practicum.shareit.requests.repository;

import lombok.AllArgsConstructor;
import ru.practicum.shareit.id.IdGenerator;
import ru.practicum.shareit.requests.model.ItemRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class InMemory implements ItemRequestRepository {

    private final Map<Integer, ItemRequest> repository;

    private final IdGenerator idGenerator;

    @Override
    public List<ItemRequest> findAll() {
        return new ArrayList<>(repository.values());
    }

    @Override
    public ItemRequest getById(Integer id) {
        return repository.get(id);
    }

    @Override
    public ItemRequest add(ItemRequest itemRequest) {
        itemRequest.setId(idGenerator.getNextIdCount());
        repository.put(itemRequest.getId(), itemRequest);
        return itemRequest;
    }

    @Override
    public ItemRequest change(ItemRequest itemRequest) {
        repository.put(itemRequest.getId(), itemRequest);
        return itemRequest;
    }

    @Override
    public ItemRequest deleteById(Integer id) {
        return repository.remove(id);
    }
}
