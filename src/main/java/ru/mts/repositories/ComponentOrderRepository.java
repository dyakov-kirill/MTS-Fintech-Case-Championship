package ru.mts.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.mts.entities.ComponentOrder;

import java.util.UUID;

public interface ComponentOrderRepository extends CrudRepository<ComponentOrder, UUID> {
}
