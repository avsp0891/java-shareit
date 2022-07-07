package ru.practicum.shareit.booking.repository;

import ru.practicum.shareit.booking.model.Booking;

import java.util.List;

public interface BookingRepository {

    List<Booking> findAll();

    Booking getById(Integer id);

    Booking add(Booking booking);

    Booking change(Booking booking);

    Booking deleteById(Integer id);
}
