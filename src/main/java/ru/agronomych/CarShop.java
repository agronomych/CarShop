package ru.agronomych;

/**
 * CarShop - главный класс приложения
 *
 * @author Anton_Suryapin
 */

import com.google.gson.Gson;
import ru.agronomych.config.SpringConfig;
import ru.agronomych.model.CarModel;
import ru.agronomych.model.ClientModel;
import ru.agronomych.model.ContractModel;
import ru.agronomych.model.ManagerModel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import ru.agronomych.service.interfaces.CarService;
import ru.agronomych.service.interfaces.ClientService;
import ru.agronomych.service.interfaces.ContractService;
import ru.agronomych.service.interfaces.ManagerService;

import java.util.HashMap;

import static ru.agronomych.utils.Utils.*;

@Component

public class CarShop {

    public static void main(String[] args) {

        /*ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        CarService carService = (CarService) context.getBean("CarService");
        ClientService clientService = (ClientService) context.getBean("ClientService");
        ManagerService managerService = (ManagerService) context.getBean("ManagerService");
        ContractService contractService = (ContractService) context.getBean("ContractService");

        HashMap map = loadCars();
        carService.addAllCars(map);
        map = loadManagers();
        managerService.addAllManagers(map);
        map = loadClients();
        clientService.addAllClients(map);
        map = loadContracts(managerService.getAllManagers(),clientService.getAllClients(),carService.getAllCars());
        contractService.addAllContracts(map);

        System.out.println();
        System.out.println("Данные по организации " + managerService.getOrgName());
        System.out.println();*/

    }

}
