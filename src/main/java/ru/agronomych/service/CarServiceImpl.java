package ru.agronomych.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.agronomych.controller.dto.CarDTO;
import ru.agronomych.domain.Car;
import ru.agronomych.repository.CarRepository;

import java.util.LinkedList;
import java.util.List;

import static ru.agronomych.controller.dto.converters.CarDTOConverter.*;

@Service(value = "carService")
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Transactional
    @Override
    public void add(CarDTO car) {
        carRepository.save(fromDTO(car));
    }

    @Transactional
    @Override
    public List<CarDTO> getAll() {
        List<Car> list = carRepository.findAll();
        List<CarDTO> listDTO = new LinkedList<>();
        for(Car car:list){
            listDTO.add(toDTO(car));
        }
        return listDTO;
    }

    @Transactional
    @Override
    public CarDTO getById(String id) {
        return toDTO(carRepository.getOne(id));
    }

    @Transactional
    @Override
    public void deleteById(String id) {
        carRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void update(CarDTO car) {
        carRepository.save(fromDTO(car));
    }

    @Transactional
    @Override
    public List<String> getIDs() {
        List<String> list = new LinkedList<>();
        for(Car car:carRepository.findAll()){
            list.add(car.getId());
        }
        return list;
    }
}
