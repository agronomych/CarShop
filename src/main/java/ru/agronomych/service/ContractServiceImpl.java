package ru.agronomych.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.agronomych.controller.dto.ContractDTO;
import ru.agronomych.controller.dto.converters.ContractDTOConverter;
import ru.agronomych.domain.Contract;
import ru.agronomych.repository.ContractRepository;

import java.util.LinkedList;
import java.util.List;

@Service(value = "contractService")
public class ContractServiceImpl implements ContractService {

    private ContractRepository contractRepository;

    public ContractServiceImpl(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Transactional
    @Override
    public void add(ContractDTO contract) {
        contractRepository.save(
                ContractDTOConverter.fromDTO(contract,
                        contract.getCarId(),
                        contract.getClientId(),
                        contract.getManagerId()));
    }

    @Transactional
    @Override
    public List<ContractDTO> getAll() {
        List<Contract> list = contractRepository.findAll();
        List<ContractDTO> listDTO = new LinkedList<>();
        for(Contract contract:list){
            listDTO.add(ContractDTOConverter.toDTO(contract,
                    contract.getCar(),
                    contract.getClient(),
                    contract.getManager()));
        }
        return listDTO;
    }

    @Transactional
    @Override
    public ContractDTO getById(Long id) {
        Contract contract = contractRepository.getOne(id);
        return ContractDTOConverter.toDTO(contract,
                contract.getCar(),
                contract.getClient(),
                contract.getManager());
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        contractRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void update(ContractDTO contract) {
        contractRepository.save(ContractDTOConverter.fromDTO(contract,
                contract.getCarId(),
                contract.getClientId(),
                contract.getManagerId()));
    }

    @Transactional
    @Override
    public List<Long> getIDs() {
        List<Long> list = new LinkedList<>();
        for(Contract contract:contractRepository.findAll()){
            list.add(contract.getId());
        }
        return list;
    }

}