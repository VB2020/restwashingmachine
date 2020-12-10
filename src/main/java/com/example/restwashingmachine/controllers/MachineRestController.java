package com.example.restwashingmachine.controllers;
import com.example.restwashingmachine.model.WashingMachine;
import com.example.restwashingmachine.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/REST_API/WashingMachines")
public class MachineRestController
{
    @Autowired
    private MachineRepository machineRepository;

    @GetMapping("")
    public ModelAndView empty()
    {
        ModelAndView page_in_browser = new ModelAndView();
        page_in_browser.setViewName("empty");
        return page_in_browser;
    }

    @GetMapping("/add")
    public ModelAndView main (Map<String, Object> model)
    {
        //взять стиралку из репозитория
        Iterable<WashingMachine> washingMachines = machineRepository.findAll();
        //положили ее в модель и теперь пользователь может ее брать
        model.put("WashingMachines", washingMachines);
        ModelAndView page_in_browser = new ModelAndView();
        page_in_browser.setViewName("main");
        return page_in_browser;
    }

    @PostMapping("/add")
    public ModelAndView AddMachine (@RequestParam String machine_name, Map<String, Object> model)
    {
        WashingMachine washingMachine = new WashingMachine(machine_name);
        machineRepository.save(washingMachine);
        //взять стиралку из репозитория
        Iterable<WashingMachine> washingMachines = machineRepository.findAll();
        //положили ее в модель и теперь пользователь может ее брать
        model.put("WashingMachines", washingMachines);
        ModelAndView page_in_browser = new ModelAndView();
        page_in_browser.setViewName("main");
        return page_in_browser;
    }


    // не работает
    @PostMapping("/FIND")
    public ModelAndView FIND (@RequestParam String FIND, Map<String, Object> model)
    {
        // List наследуется от Iterable
        Iterable<WashingMachine> washingMachines;
        // !FIND.isEmpty() - не пустой поиск
        if (FIND != null && !FIND.isEmpty())
        {
           //washingMachines = machineRepository.findName(FIND); // возврашает List

        }
        // а если пустой поиск, то:
        else {
            washingMachines = machineRepository.findAll(); // возвращает Iterable
        }
        //model.put("WashingMachines", washingMachines);
        ModelAndView page_in_browser = new ModelAndView();
        page_in_browser.setViewName("find");
        return page_in_browser;
    }


}