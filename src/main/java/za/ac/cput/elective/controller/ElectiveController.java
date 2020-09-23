package za.ac.cput.elective.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.elective.entity.Elective;
import za.ac.cput.elective.factory.ElectiveFactory;
import za.ac.cput.elective.service.impl.ElectiveServiceImpl;

import java.util.*;

@RestController
@RequestMapping("/elective")
public class ElectiveController {

    @Autowired
    private ElectiveServiceImpl electiveService;

    @PostMapping("/create")
    public Elective create(@RequestBody Elective elective) {

        Elective elect = ElectiveFactory.createElective(
                elective.getElectName(),
                elective.getElectDesc());
        return electiveService.create(elect);
    }

    @GetMapping("/read/{electName}")
    public Elective read(@PathVariable String electName) {
        return electiveService.read(electName);
    }

    @GetMapping("/update")
    public Elective update(@RequestBody Elective elect) {
        return electiveService.update(elect);
    }

    @GetMapping("/all")
    public Set<Elective> getAll() {
        return electiveService.getAll();
    }

    @DeleteMapping("/delete/{electName}")
    public boolean delete(@PathVariable String electName) {
        return electiveService.delete(electName);
    }
}
