package ru.agronomych.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.agronomych.domain.Client;

/**
 * Интерфейс для работы со Spring JPA с сущностью клиент
 */
@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
}
