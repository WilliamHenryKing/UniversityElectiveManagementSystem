package za.ac.cput.elective.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.elective.entity.Mark;
import za.ac.cput.elective.factory.MarkFactory;
import za.ac.cput.elective.service.impl.MarkServiceImpl;

import java.util.*;

@RestController
@RequestMapping("/mark")
public class MarkController
{
    @Autowired
    private MarkServiceImpl markService;

    @PostMapping("/create")
    public Mark create(@RequestBody Mark mark) {

        Mark mar = MarkFactory.createMark(mark.getMarksID());

        return markService.create(mark);
    }

    @GetMapping("/read/{markID}")
    public Mark read(@PathVariable String markID)
    {
        return markService.read(markID);
    }

    @GetMapping("/update")
    public Mark update(@RequestBody Mark m)
    {
        return markService.update(m);
    }

    @GetMapping("/all")
    public Set<Mark> getAll()
    {
        return markService.getAll();
    }

    @DeleteMapping("/delete/{markID}")
    public boolean delete(@PathVariable String markID)
    {
        return markService.delete(markID);
    }
}

