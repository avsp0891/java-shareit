package ru.practicum.shareit.request.dto;


import lombok.AllArgsConstructor;
import ru.practicum.shareit.request.model.ItemRequest;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
public class ItemRequestMapper {


    public static ItemRequestDto toItemRequestDto(@NotNull ItemRequest itemRequest) {
        return new ItemRequestDto(
                itemRequest.getId(),
                itemRequest.getDescription(),
                new ItemRequestDto.User(
                        itemRequest.getRequester().getId(),
                        itemRequest.getRequester().getName()),
                itemRequest.getCreated());

    }

    public static ItemRequest toItemRequest(@NotNull ItemRequestDto requestDto) {
        return new ItemRequest(
                requestDto.getId(),
                requestDto.getDescription(),
                null,
                requestDto.getCreated());
    }


}
