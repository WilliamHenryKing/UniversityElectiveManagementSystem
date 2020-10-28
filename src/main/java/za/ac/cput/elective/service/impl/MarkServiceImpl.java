package za.ac.cput.elective.service.impl;

/**
 * @author @Wasiem Cassiem
 * Desc: This is a Class: MarkServiceImpl.java
 * Date: 6 September 2020
 **/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.elective.entity.Mark;
import za.ac.cput.elective.repository.MarkRepository;
import za.ac.cput.elective.service.MarkService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MarkServiceImpl implements MarkService
{
    @Autowired
    private MarkRepository repository;


    @Override
    public Set<Mark> getAll()
    {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Mark create(Mark mark)
    {
        return this.repository.save(mark);
    }

    @Override
    public Mark read(String s)
    {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public Mark update(Mark mark)
    {
        if (this.repository.existsById(mark.getMarksID()))
        {
            return this.repository.save(mark);
        }
            return null;
    }

    @Override
    public boolean delete(String s)
    {
        this.repository.deleteById(s);
        if (this.repository.existsById(s))
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
