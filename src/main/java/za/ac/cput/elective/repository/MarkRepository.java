package za.ac.cput.elective.repository;


import za.ac.cput.elective.entity.Mark;
import java.util.Set;

public interface MarkRepository extends IRepository <Mark, String>
{
    Set<Mark> getAll();
}
