//package za.ac.cput.elective.repository.impl;

//* @author: Shane  Mapasie, GitHub: SPMapasie216182425
//* Desc: ElectiveRepository implementing from the Interface Repository.
//* Date: 29th August 2020

import org.junit.Test;
import za.ac.cput.elective.entity.Elective;
import za.ac.cput.elective.factory.ElectiveFactory;
import za.ac.cput.elective.repository.ElectiveRepository;

import java.util.UUID;

import static org.junit.Assert.*;

/*public class ElectiveRepositoryImplTest {
    private ElectiveRepository repository = new ElectiveRepositoryImpl();

    private Elective elective = ElectiveFactory.createElective((long) 000111, "E-Commerce");

    @Test
    public void create() {
        Elective created = repository.create(elective);
        assertEquals(elective.getElectName()
                        //+elective.getElectCode()
                        +elective.getElectDesc(),
                created.getElectName()
                        //+elective.getElectCode()
                        +elective.getElectDesc());
    }
    @Test
    public void read() {
        Elective read = repository.read(elective.getElectCode()+UUID.randomUUID().toString()
                +elective.getElectName()
                +elective.getElectDesc());
                System.out.println(read);
    }
    @Test
    public void update() {
        Elective updated = new Elective.Builder()
                .copy(elective)
                .setElectName("C++")
                .build();
        updated = repository.update(updated);
        System.out.println(updated);
    }
    @Test
    public void delete() {
        repository.delete(elective.getElectCode()
                +elective.getElectName()
                +elective.getElectDesc());
    }
    @Test
    public void getAll() {
        System.out.println(repository.getAll());
    }
}*/