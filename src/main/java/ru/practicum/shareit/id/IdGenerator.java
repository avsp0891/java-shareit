package ru.practicum.shareit.id;

import org.springframework.stereotype.Component;

@Component
public class IdGenerator {
    private Integer idCount;

    public IdGenerator() {
        this.idCount = 1;
    }

    public Integer getNextIdCount() {
        return idCount++;
    }
}
