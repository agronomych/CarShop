package ru.agronomych.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.agronomych.domain.Manager;

/**
 * Интерфейс для работы со Spring JPA с сущностью менеджер
 */
@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
