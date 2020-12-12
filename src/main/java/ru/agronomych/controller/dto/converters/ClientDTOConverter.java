package ru.agronomych.controller.dto.converters;

import org.springframework.context.annotation.PropertySource;
import ru.agronomych.controller.dto.ClientDTO;
import ru.agronomych.model.Client;

/**
 * класс для конвертации DTO <-> Model сущности Клиент
 */

@PropertySource(value = {"classpath:application.properties"})
public class ClientDTOConverter{

    /**
     * Конвертация из DTO объекта в модель, храняющуюся в бд
     * @param clientDTO
     * @return
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
     * @param client
     * @return
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
