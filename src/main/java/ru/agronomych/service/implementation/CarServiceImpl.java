package ru.agronomych.service.implementation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.agronomych.controller.dto.CarDTO;
import ru.agronomych.dao.interfaces.CarDAO;
import ru.agronomych.model.Car;
import ru.agronomych.service.interfaces.CarService;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static ru.agronomych.controller.dto.converters.CarDTOConverter.*;

@Service(value = "CarService")
@PropertySource(value = {"classpath:application.properties"})
public class CarServiceImpl implements CarService {

    @Value("${data.path}")
    private String dbPath;
    @Value("${data.cars}")
    private String filename;

    private CarDAO carDAO;

    public CarServiceImpl(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @Override
    public void add(CarDTO car) {
        carDAO.save(fromDTO(car));
    }

    @Override
    public void addAll(List<CarDTO> list) {
        HashMap<String,Car> map = new HashMap<>();
        for(CarDTO car:list){
            map.put(car.getId(),fromDTO(car));
        }
        carDAO.addAll(map);
    }

    @Override
    public List<CarDTO> getAll() {
        HashMap<String,Car> map = (HashMap<String,Car>)carDAO.getAll();
        List<CarDTO> list = new LinkedList<>();
        for(Car car:map.values()){
            list.add(toDTO(car));
        }
        return list;
    }

    @Override
    public CarDTO getById(String id) {
        return toDTO(carDAO.getByPK(id));
    }

    @Override
    public void deleteById(String id) {
        carDAO.deleteByPK(id);
    }

    @Override
    public void update(CarDTO car) {
        carDAO.update(fromDTO(car));
    }

    @Override
    public List<String> getIDs() {
        List<String> list = new LinkedList<>();
        for(Car car:carDAO.getAll().values()){
            list.add(car.getId());
        }
        return list;
    }
}
