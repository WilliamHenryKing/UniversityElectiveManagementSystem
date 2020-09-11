package za.ac.cput.elective.service.impl;

/**
 * @author @Wasiem Cassiem
 * Desc: This is a Class: MarkServiceImpl.java
 * Date: 6 September 2020
 **/

import za.ac.cput.elective.entity.Mark;
import za.ac.cput.elective.repository.MarkRepository;
import za.ac.cput.elective.repository.impl.MarkRepositoryImpl;
import za.ac.cput.elective.service.MarkService;

import java.util.Set;

public class MarkServiceImpl implements MarkService
{
    private static MarkService service = null;
    private MarkRepository repository;

    private MarkServiceImpl()
    {
        this.repository = MarkRepositoryImpl.getRepository();
    }

    public static MarkService getService()
    {
        if (service == null) service = new MarkServiceImpl();
        return service;
    }

    @Override
    public Set<Mark> getAll()
    {
        return this.repository.getAll();
    }

    @Override
    public Mark create(Mark mark)
    {
        return this.repository.create(mark);
    }

    @Override
    public Mark read(String s)
    {
        return this.repository.read(s);
    }

    @Override
    public Mark update(Mark mark)
    {
        return this.repository.update(mark);
    }

    @Override
    public boolean delete(String s)
    {
        return this.repository.delete(s);
    }
}
