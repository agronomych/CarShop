package ru.agronomych.controller.dto.services;

import java.util.HashMap;

public interface DTOService<DTO,Model,PK>{

    public Model fromDTO(DTO carData);

    public DTO toDTO(Model car);

    public void add(DTO car);

    public DTO get(PK id);

    public HashMap<PK,DTO> getAll();

    public void delete(PK id);

    public void update(DTO body);

    public String save();

    public String load();

}
