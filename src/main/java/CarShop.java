import com.google.gson.Gson;
import dao.interfaces.CarDAO;
import model.CarModel;
import model.ClientModel;
import model.ContractModel;
import model.ManagerModel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.implementation.CarServiceImpl;
import service.interfaces.CarService;
import service.interfaces.ClientService;
import service.interfaces.ContractService;
import service.interfaces.ManagerService;
import utils.*;

import java.util.Collection;
import java.util.HashMap;

import static utils.utils.*;

public class CarShop {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-context.xml");

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
