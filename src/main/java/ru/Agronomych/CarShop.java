package ru.Agronomych;

/**
 * CarShop - главный класс приложения
 *
 * @author Anton_Suryapin
 */

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import ru.Agronomych.config.SpringConfig;
import ru.Agronomych.model.CarModel;
import ru.Agronomych.model.ClientModel;
import ru.Agronomych.model.ContractModel;
import ru.Agronomych.model.ManagerModel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import ru.Agronomych.service.interfaces.CarService;
import ru.Agronomych.service.interfaces.ClientService;
import ru.Agronomych.service.interfaces.ContractService;
import ru.Agronomych.service.interfaces.ManagerService;

import java.util.HashMap;

import static ru.Agronomych.utils.Utils.*;

@Component

public class CarShop {

    public static void main(String[] args) {

        ApplicationContext context =
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
        System.out.println();

        Gson gson = new Gson();

        for (CarModel car:carService.getAllCars().values()) {
            System.out.println(gson.toJson(car));
        }

        for (ClientModel client:clientService.getAllClients().values()) {
            System.out.println(gson.toJson(client));
        }

        for (ManagerModel manager:managerService.getAllManagers().values()) {
            System.out.println(gson.toJson(manager));
        }

        for (ContractModel contract:contractService.getAllContracts().values()) {
            System.out.println(gson.toJson(contract));
        }
    }

}
