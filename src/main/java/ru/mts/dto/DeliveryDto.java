package ru.mts.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import ru.mts.entities.components.CourierType;

import java.time.Duration;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@Accessors(chain = true)
public class DeliveryDto {

    private UUID orderId;
    private Map<Integer, String> order;
    private Duration duration;
    private CourierType courierType;
}
