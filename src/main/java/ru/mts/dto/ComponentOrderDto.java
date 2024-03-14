package ru.mts.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import ru.mts.entities.components.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Accessors(chain = true)
public class ComponentOrderDto {

    private UUID orderId;
    private Component component;
    private LocalDateTime time;
}
