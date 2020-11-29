package ru.agronomych.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.agronomych.service.interfaces.CarService;
import ru.agronomych.service.interfaces.ClientService;
import ru.agronomych.service.interfaces.ContractService;
import ru.agronomych.service.interfaces.ManagerService;

/**
 * Контроллер для обработки запросов /common - общие запросы
 */
@RestController
@RequestMapping(value = "/common")
public class CommonController {

    private CarService carService;
    private ClientService clientService;
    private ManagerService managerService;
    private ContractService contractService;

    public CommonController(CarService carService,
                            ClientService clientService,
                            ContractService contractService,
                            ManagerService managerService){
        this.carService = carService;
        this.clientService = clientService;
        this.contractService = contractService;
        this.managerService = managerService;
    }

    @GetMapping(value = "/loadAll")
    public void loadAll(){
        carService.load();
        clientService.load();
        managerService.load();
        contractService.load();
    }

    @GetMapping(value = "/saveAll")
    public void saveAll(){
        carService.save();
        clientService.save();
        managerService.save();
        contractService.save();
    }
}
