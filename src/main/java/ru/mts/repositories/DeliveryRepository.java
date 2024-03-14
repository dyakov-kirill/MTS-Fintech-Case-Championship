package ru.mts.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.mts.entities.Delivery;

import java.util.UUID;

public interface DeliveryRepository extends CrudRepository<Delivery, UUID> {
}
