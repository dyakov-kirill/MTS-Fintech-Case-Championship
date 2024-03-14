package ru.mts.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.mts.entities.ClientOrder;

import java.util.UUID;

public interface ClientOrderRepository extends CrudRepository<ClientOrder, UUID> {
}
