package com.example.restwashingmachine.repository;

import com.example.restwashingmachine.model.WashingMachine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MachineRepository extends JpaRepository <WashingMachine, Integer> {

    // не работает
    //List<WashingMachine> findName(String Name);

}
