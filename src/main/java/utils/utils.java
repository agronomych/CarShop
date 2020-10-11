package utils;

import com.google.gson.Gson;
import model.CarModel;
import model.ClientModel;
import model.ContractModel;
import model.ManagerModel;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class  utils {

    /* вспомогательный класс для загрузки данных из файлов: clients.txt,cars.txt,contracts.txt,managers.txt*/
    private static  ArrayList<String> loadStrings(String filename){
        ArrayList<String> strings = new ArrayList<>();
        try {
            InputStream stream = utils.class.getResourceAsStream(filename);
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

            String s;
            while ((s = reader.readLine()) != null){
                strings.add(s);
            }
        }
        catch (Exception e){
            System.out.println(e.getStackTrace());
        };
        return strings;
    }

    public static HashMap<String,CarModel> loadCars(){
        HashMap<String,CarModel> map = new HashMap<>();
        Gson gson = new Gson();
        CarModel car = new CarModel();
        ArrayList<String> loadedCars = loadStrings("/cars.txt");
        for (String s:loadedCars) {
            car = gson.fromJson(s,CarModel.class);
            map.put(car.getId(),car);
        }
        return map;
    };

    public static HashMap<Long, ManagerModel> loadManagers(){
        HashMap<Long, ManagerModel> map = new HashMap<>();
        Gson gson = new Gson();
        ManagerModel manager = new  ManagerModel();
        ArrayList<String> loadedManagers = loadStrings("/managers.txt");
        for (String s:loadedManagers) {
            manager = gson.fromJson(s, ManagerModel.class);
            map.put(manager.getId(),manager);
        }
        return map;
    };

    public static HashMap<Long, ContractModel> loadContracts(HashMap<Long,ManagerModel> managers,
                                                               HashMap<String,ClientModel> clients,
                                                               HashMap<String,CarModel> cars){
        HashMap<Long,ContractModel> map = new HashMap<>();
        Gson gson = new Gson();
        ArrayList<String> loadedContracts = loadStrings("/contracts.txt");
        for (String s:loadedContracts) {
            ContractPreLoad preContract = new ContractPreLoad();
            ContractModel contract = new ContractModel();
            preContract = gson.fromJson(s, ContractPreLoad.class);
            contract.setSum(preContract.getSum());
            contract.setId(preContract.getId());
            contract.setDate(preContract.getDate());
            contract.setManager(managers.get(preContract.getManager()));
            contract.setClient(clients.get(preContract.getClient()));
            contract.setCar(cars.get(preContract.getCar()));
            map.put(contract.getId(),contract);
        }
        return map;
    };

    public static HashMap<String, ClientModel> loadClients(){
        HashMap<String, ClientModel> map = new HashMap<>();
        Gson gson = new Gson();
        ClientModel client = new ClientModel();
        ArrayList<String> loadedClients = loadStrings("/clients.txt");
        for (String s:loadedClients) {
            client = gson.fromJson(s, ClientModel.class);
            map.put(client.getId(),client);
        }
        return map;
    };
}
