package ru.mts.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Accessors(chain = true)
public class ClientOrderDto {

    private UUID orderId;
    private LocalDateTime time;
    private boolean isCompleted;
}
