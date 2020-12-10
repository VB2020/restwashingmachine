package com.example.restwashingmachine.controllers;
import com.example.restwashingmachine.model.WashingMachine;
import com.example.restwashingmachine.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;

@Controller
@RequestMapping("/SimpleController")
public class SimpleController
{
    @Autowired
    private MachineRepository machineRepository;

    @GetMapping("")
    public String empty()
    {
        return "empty1";
    }

    @GetMapping("/add")
    public String main (Map<String, Object> model)
    {
        //взять стиралку из репозитория
        Iterable<WashingMachine> washingMachines = machineRepository.findAll();
        //положили ее в модель и теперь пользователь может ее брать
        model.put("WashingMachines", washingMachines);
        return "main";
    }

    @PostMapping("/add")
    public String AddMachine (@RequestParam String machine_name, Map<String, Object> model)
    {
        WashingMachine washingMachine = new WashingMachine(machine_name);
        machineRepository.save(washingMachine);
        //взять стиралку из репозитория
        Iterable<WashingMachine> washingMachines = machineRepository.findAll();
        //положили ее в модель и теперь пользователь может ее брать
        model.put("WashingMachines", washingMachines);
        return "main";
    }
}