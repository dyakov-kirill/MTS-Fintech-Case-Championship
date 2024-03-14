package ru.mts.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@Accessors(chain = true)
public class ClientOrderDto {

    private UUID orderId;
    private Map<Integer, String> order;
    private LocalDateTime time;
    private boolean isCompleted;
}
