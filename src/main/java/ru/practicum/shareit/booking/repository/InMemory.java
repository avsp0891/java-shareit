package ru.practicum.shareit.booking.repository;

import lombok.AllArgsConstructor;
import ru.practicum.shareit.booking.model.Booking;
import ru.practicum.shareit.id.IdGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class InMemory implements BookingRepository {

    private final Map<Integer, Booking> repository;

    private final IdGenerator idGenerator;

    @Override
    public List<Booking> findAll() {
        return new ArrayList<>(repository.values());
    }

    @Override
    public Booking getById(Integer id) {
        return repository.get(id);
    }

    @Override
    public Booking add(Booking booking) {
        booking.setId(idGenerator.getNextIdCount());
        repository.put(booking.getId(), booking);
        return booking;
    }

    @Override
    public Booking change(Booking booking) {
        repository.put(booking.getId(), booking);
        return booking;
    }

    @Override
    public Booking deleteById(Integer id) {
        return repository.remove(id);
    }
}
