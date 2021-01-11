package ru.agronomych.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.agronomych.domain.Car;

/**
 * Интерфейс для работы со Spring JPA с сущностью автомобиль
 */
@Repository
public interface CarRepository extends JpaRepository<Car, String> {
}
