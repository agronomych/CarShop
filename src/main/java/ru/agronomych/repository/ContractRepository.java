package ru.agronomych.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.agronomych.domain.Contract;

/**
 * Интерфейс для работы со Spring JPA с сущностью контракт
 */
@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
}
