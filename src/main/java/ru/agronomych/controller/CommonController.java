package ru.agronomych.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.agronomych.controller.dto.services.CarDTOService;
import ru.agronomych.controller.dto.services.ClientDTOService;
import ru.agronomych.controller.dto.services.ContractDTOService;
import ru.agronomych.controller.dto.services.ManagerDTOService;

@RestController
@RequestMapping(value = "/common")
public class CommonController {

    @Autowired
    private CarDTOService carDTOService;
    @Autowired
    private ClientDTOService clientDTOService;
    @Autowired
    private ManagerDTOService managerDTOService;
    @Autowired
    private ContractDTOService contractDTOService;

    @GetMapping(value = "/loadAll")
    public void loadAll(){
        carDTOService.load();
        clientDTOService.load();
        managerDTOService.load();
        contractDTOService.load();
    }
}
