package ru.agronomych.controller.dto.converters;

import ru.agronomych.controller.dto.ClientDTO;
import ru.agronomych.model.Client;

/**
 * класс для конвертации DTO <-> Model сущности Клиент
 */

public class ClientDTOConverter{

    /**
     * Конвертация из DTO объекта в модель, храняющуюся в бд
     * @param clientDTO данные клиента ДТО
     * @return - возвращает объект клиента
     */
    public static Client fromDTO(ClientDTO clientDTO){
        Client client = new Client();
        client.setId((clientDTO.getId()));
        client.setLastName(clientDTO.getLastName());
        client.setName(clientDTO.getName());
        client.setPatronymic(clientDTO.getPatronymic());
        client.setPassport(clientDTO.getPassport());
        return client;
    }

    /**
     * Конвертация из модели, хранящейся в бд, в DTO объект
     * @param client - объект клиент
     * @return - ДТО объект клиента
     */
    public static ClientDTO toDTO(Client client){
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(client.getId());
        clientDTO.setLastName(client.getLastName());
        clientDTO.setName(client.getName());
        clientDTO.setPatronymic(client.getPatronymic());
        clientDTO.setPassport(client.getPassport());
        return clientDTO;
    }
}
