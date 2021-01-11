package ru.agronomych.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.agronomych.controller.dto.ClientDTO;
import ru.agronomych.domain.Client;
import ru.agronomych.repository.ClientRepository;

import java.util.LinkedList;
import java.util.List;

import static ru.agronomych.controller.dto.converters.ClientDTOConverter.*;

@Service(value = "clientService")
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional
    @Override
    public void add(ClientDTO client) {
        clientRepository.save(fromDTO(client));
    }

    @Transactional
    @Override
    public List<ClientDTO> getAll() {
        List<Client> list = clientRepository.findAll();
        List<ClientDTO> listDTO = new LinkedList<>();
        for(Client client:list){
            listDTO.add(toDTO(client));
        }
        return listDTO;
    }

    @Transactional
    @Override
    public ClientDTO getById(Long id) {
        return toDTO(clientRepository.getOne(id));
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void update(ClientDTO client) {
        clientRepository.save(fromDTO(client));
    }

    @Transactional
    @Override
    public List<Long> getIDs() {
        List<Long> list = new LinkedList<>();
        for(Client client:clientRepository.findAll()){
            list.add(client.getId());
        }
        return list;
    }
}
