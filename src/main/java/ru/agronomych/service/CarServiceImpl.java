package ru.agronomych.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.agronomych.controller.dto.CarDTO;
import ru.agronomych.dao.CarDAO;
import ru.agronomych.model.Car;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static ru.agronomych.controller.dto.converters.CarDTOConverter.*;

@Service(value = "carService")
public class CarServiceImpl implements CarService {

    private CarDAO carDAO;

    public CarServiceImpl(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @Transactional
    @Override
    public void add(CarDTO car) {
        carDAO.save(fromDTO(car));
    }

    @Transactional
    @Override
    public List<CarDTO> getAll() {
        List<Car> list = carDAO.getAll();
        List<CarDTO> listDTO = new LinkedList<>();
        for(Car car:list){
            listDTO.add(toDTO(car));
        }
        return listDTO;
    }

    @Transactional
    @Override
    public CarDTO getById(String id) {
        return toDTO(carDAO.getByPK(id));
    }

    @Transactional
    @Override
    public void deleteById(String id) {
        carDAO.deleteByPK(id);
    }

    @Transactional
    @Override
    public void update(CarDTO car) {
        carDAO.update(fromDTO(car));
    }

    @Transactional
    @Override
    public List<String> getIDs() {
        List<String> list = new LinkedList<>();
        for(Car car:carDAO.getAll()){
            list.add(car.getId());
        }
        return list;
    }
}
