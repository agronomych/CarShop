package ru.Agronomych.model;

import java.util.ArrayList;

/**
 * Представление сущности Менеджер в системе
 */
public class ManagerModel extends Human implements Identified<Long>{

    private Long id;
    private ArrayList<ContractModel> contracts;

    public ArrayList<ContractModel> getContracts() {
        return contracts;
    }
    public void setContracts(ArrayList<ContractModel> contracts) {
        this.contracts = contracts;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
