package ru.mts.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import ru.mts.entities.components.CourierType;

import java.time.Duration;
import java.util.UUID;

@Getter
@Setter
@Accessors(chain = true)
public class DeliveryDto {

    private UUID orderId;
    private Duration duration;
    private CourierType courierType;
}
