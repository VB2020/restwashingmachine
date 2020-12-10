package com.example.restwashingmachine.service;

import com.example.restwashingmachine.model.WashingMachine;
import com.example.restwashingmachine.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachineService {

    private final MachineRepository machineRepository;

    @Autowired
    public MachineService(MachineRepository machineRepository)
    {
        this.machineRepository = machineRepository;
    }

    public List<WashingMachine> findAll()
    {
        return machineRepository.findAll();
    }

    public WashingMachine SaveNewMachine (WashingMachine washingMachine)
    {
        return machineRepository.save(washingMachine);
    }


}
