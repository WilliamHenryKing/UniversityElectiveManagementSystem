package za.ac.cput.elective.repository.impl;

/**
 * @author @Wasiem Cassiem
 * Desc: implementing the mark repo
 * Date: 2020/08/29
 **/


import za.ac.cput.elective.entity.Mark;
import za.ac.cput.elective.repository.MarkRepository;
import java.util.HashSet;
import java.util.Set;

public class MarkRepositoryImpl implements MarkRepository
{
    private static MarkRepository repository = null;
    private Set<Mark> markDB;

    private MarkRepositoryImpl() {
        this.markDB = new HashSet<>();
    }


    public static MarkRepository getRepository()
    {
        if(repository == null) repository = new MarkRepositoryImpl();
        return repository;
    }

    @Override
    public Mark create(Mark mark) {
        this.markDB.add(mark);
        return mark;
    }

    @Override
    public Mark read(String id) {
        Mark mark = this.markDB.stream().filter(m -> m.getMarksID().trim().equalsIgnoreCase(id)).findAny()
                .orElse(null);
        return mark;
    }

    @Override
    public Mark update(Mark mark) {
        boolean deleteMark = delete(mark.getMarksID());
        if (deleteMark) {
            this.markDB.add(mark);
            return mark;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Mark mark = read(id);
        if(mark != null){
            this.markDB.remove(mark);
            return true;
        }
        return false;
    }

    @Override
    public Set<Mark> getAll() {
        return this.markDB;
    }
}

