package ru.practicum.shareit.item.exceptions;

public class AccessIsDeniedException extends  RuntimeException {

    public AccessIsDeniedException(String s) {
        super(s);
    }
}
