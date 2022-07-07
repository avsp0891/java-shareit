package ru.practicum.shareit.booking.dto;

import lombok.Data;
import ru.practicum.shareit.booking.model.Status;

import java.time.LocalDate;

@Data
public class BookingDto {

    private Integer id;
    private LocalDate start;
    private LocalDate end;
    private Integer item;
    private Integer booker;
    private Status status;

    public BookingDto(Integer id, LocalDate start, LocalDate end, Integer item, Integer booker, Status status) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.item = item;
        this.booker = booker;
        this.status = status;
    }
}