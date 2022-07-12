package ru.practicum.shareit.requests.exceptions;

public class RequestsNotFoundException extends RuntimeException {

    public RequestsNotFoundException(String s) {
        super(s);
    }
}
