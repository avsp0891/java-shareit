package ru.practicum.shareit.booking.dto;

import ru.practicum.shareit.booking.model.Booking;

import javax.validation.constraints.NotNull;

public class BookingMapper {

    public static BookingDto toBookingDto(@NotNull Booking booking) {
        return new BookingDto(
                booking.getId(),
                booking.getStart(),
                booking.getEnd(),
                booking.getItem(),
                booking.getBooker(),
                booking.getStatus()
        );
    }

    public static Booking toBooking(@NotNull BookingDto bookingDto) {
        return new Booking(
                bookingDto.getId(),
                bookingDto.getStart(),
                bookingDto.getEnd(),
                bookingDto.getItem(),
                bookingDto.getBooker(),
                bookingDto.getStatus()
        );
    }
}
