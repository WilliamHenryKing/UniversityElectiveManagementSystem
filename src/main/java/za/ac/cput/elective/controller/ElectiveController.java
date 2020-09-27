package za.ac.cput.elective.controller;
/**
 *  @author: Shane Mapasie
 *  Desc: Spring Boot controller for Elective to access the ElectiveService method 'CRUD'
 *  Date: 22st September 2020
 */
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

    @RequestMapping(value = "/create", method = {RequestMethod.POST})
    public Elective create(@RequestBody Elective elective) {

        Elective elect = ElectiveFactory.createElective(elective.getElectName(),
                elective.getElectDesc());

        return electiveService.create(elect);
    }

    @RequestMapping(value = "/read/{name}",
            method = {RequestMethod.GET})
    public Elective read(@PathVariable String name){
        return electiveService.read(name);
    }

    @RequestMapping(value = "/modify/{name}/{desc}", method = {RequestMethod.PATCH})
    public Elective modify(@PathVariable String name,
                           @PathVariable String desc, Elective elective){
        if (name.equalsIgnoreCase(elective.getElectName())
                && elective.getElectDesc() <> null){
            elective = ElectiveFactory.createElective(elective.getElectName()+
                    elective.getElectDesc(), desc);
        }

        return electiveService.update(elective);
    }

    @RequestMapping(value = "/displayAll", method = {RequestMethod.GET})
    public Set<Elective> displayAll(){
        return electiveService.getAll();
    }

    @RequestMapping(value = "/delete/{name}/{desc}",
            method = {RequestMethod.DELETE})
    public boolean delete(@PathVariable String name,
                          @PathVariable String desc, Elective elective){
        if (name.equalsIgnoreCase(elective.getElectName()) && elective.getElectDesc() <> null){
            elective = ElectiveFactory.createElective(elective.getElectName()
                    + elective.getElectDesc(), desc);
        }

        return electiveService.delete(desc);
    }
    }

