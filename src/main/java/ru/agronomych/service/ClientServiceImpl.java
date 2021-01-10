package ru.agronomych.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.agronomych.controller.dto.ClientDTO;
import ru.agronomych.dao.ClientDAO;
import ru.agronomych.model.Client;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static ru.agronomych.controller.dto.converters.ClientDTOConverter.*;

@Service(value = "clientService")
public class ClientServiceImpl implements ClientService {

    private ClientDAO clientDAO;

    public ClientServiceImpl(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @Transactional
    @Override
    public void add(ClientDTO client) {
        clientDAO.save(fromDTO(client));
    }

    @Transactional
    @Override
    public List<ClientDTO> getAll() {
        List<Client> list = clientDAO.getAll();
        List<ClientDTO> listDTO = new LinkedList<>();
        for(Client client:list){
            listDTO.add(toDTO(client));
        }
        return listDTO;
    }

    @Transactional
    @Override
    public ClientDTO getById(Long id) {
        return toDTO(clientDAO.getByPK(id));
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        clientDAO.deleteByPK(id);
    }

    @Transactional
    @Override
    public void update(ClientDTO client) {
        clientDAO.update(fromDTO(client));
    }

    @Transactional
    @Override
    public List<Long> getIDs() {
        List<Long> list = new LinkedList<>();
        for(Client client:clientDAO.getAll()){
            list.add(client.getId());
        }
        return list;
    }
}
